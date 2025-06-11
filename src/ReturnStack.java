public class ReturnStack {

    // stack yapısı (Parcel tutcak)
    private class Node {
        Parcel data;
        Node next;

        public Node(Parcel data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;
    private int size;

    // stack createleyici
    public ReturnStack() {
        this.top = null;
        this.size = 0;
    }

    // stacke eleman ekleme fnksiyonu
    public void push(Parcel parcel) {
        Node newNode = new Node(parcel);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // stackten eleman çkrma fnksiyonu
    public Parcel pop() {
        if (isEmpty()) return null;

        Parcel popped = top.data;
        top = top.next;
        size--;
        return popped;
    }

    // en üsttkki elemanı gösterir
    public Parcel peek() {
        return isEmpty() ? null : top.data;
    }

    // boş?
    public boolean isEmpty() {
        return top == null;
    }

    // boyut?
    public int size() {
        return size;
    }

    // Debug
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = top;
        while (current != null) {
            sb.append("-> ParcelID: ").append(current.data.getParcelID()).append("\n");
            current = current.next;
        }
        return sb.toString();
    }
}
