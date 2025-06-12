public class QueueTest {
    public static void main(String[] args) {

        ArrivalBuffer queue = new ArrivalBuffer(2);

        Parcel p1 = new Parcel("P1", "Istanbul", 1, "Small", 0);
        Parcel p2 = new Parcel("P2", "Ankara", 2, "Medium", 1);
        Parcel p3 = new Parcel("P3", "Izmir", 3, "Large", 2);

        System.out.println("== Test 1: Enqueue p1, p2 ==");
        queue.enqueue(p1);
        queue.enqueue(p2);
        System.out.println("Expected size: 2 | Actual size: " + queue.size());

        System.out.println("== Test 2: Enqueue p3 (overflow test) ==");
        queue.enqueue(p3); 

        System.out.println("== Test 3: Peek ==");
        Parcel peeked = queue.peek();
        System.out.println("Peeked parcel: " + peeked);

        System.out.println("== Test 4: Dequeue ==");
        Parcel dequeued = queue.dequeue();
        System.out.println("Dequeued parcel: " + dequeued);

        System.out.println("== Test 5: Queue size ==");
        System.out.println("Expected size: 1 | Actual size: " + queue.size());

        System.out.println("== Test 6: isFull & isEmpty ==");
        System.out.println("isFull(): " + queue.isFull());
        System.out.println("isEmpty(): " + queue.isEmpty());

        queue.dequeue(); 
        System.out.println("== Test 7: isEmpty() after final dequeue ==");
        System.out.println("isEmpty(): " + queue.isEmpty());
    }
}
