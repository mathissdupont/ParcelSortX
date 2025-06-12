public class ArrivalBuffer {

    private class Node {
        Parcel parcel;
        Node next;

        public Node(Parcel parcel) {
            this.parcel = parcel;
            this.next = null;
        }
    }

    private Node head; 
    private Node tail; 
    private int capacity; 
    private int count; 

    public ArrivalBuffer(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.head = null;
        this.tail = null;
    }

    public boolean enqueue(Parcel parcel) {
        if (isFull()) {
            System.out.println("WARNING: Queue is full. Discarding parcel " +
                    parcel.getParcelID() + " to " + parcel.getDestinationCity());
            return false;
        }

        Node newNode = new Node(parcel);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        count++;
        return true;
    }

    public Parcel dequeue() {
        if (isEmpty()) return null;

        Parcel removedParcel = head.parcel;
        head = head.next;
        count--;

        if (head == null) {
            tail = null;
        }

        return removedParcel;
    }

    public Parcel peek() {
        return isEmpty() ? null : head.parcel;
    }

    public boolean isFull() {
        return count == capacity;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }
}
