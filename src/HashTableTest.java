public class HashTableTest {
    public static void main(String[] args) {
        ParcelTracker tracker = new ParcelTracker(10); // table size: 10

        Parcel p1 = new Parcel("P1", "Istanbul", 3, "Medium", 5);
        Parcel p2 = new Parcel("P2", "Ankara", 1, "Large", 8);

        System.out.println("== Test 1: Insert and Get ==");
        tracker.insert(p1.getParcelID(), p1);
        tracker.insert(p2.getParcelID(), p2);

        ParcelRecord r1 = tracker.get("P1");
        System.out.println("Record P1: " + r1);

        ParcelRecord r2 = tracker.get("P2");
        System.out.println("Record P2: " + r2);

        System.out.println("== Test 2: Status Update ==");
        tracker.updateStatus("P1", Parcel.Status.Sorted);
        System.out.println("Updated P1: " + tracker.get("P1"));

        System.out.println("== Test 3: Dispatch Tick Set ==");
        tracker.markDispatched("P1", 12);
        System.out.println("Dispatched P1: " + tracker.get("P1"));

        System.out.println("== Test 4: Return Count Increment ==");
        tracker.incrementReturnCount("P2");
        tracker.incrementReturnCount("P2");
        System.out.println("Returned P2: " + tracker.get("P2"));

        System.out.println("== Test 5: Exists Check ==");
        System.out.println("Exists P1? " + tracker.exists("P1")); // true
        System.out.println("Exists PX? " + tracker.exists("PX")); // false
    }
}
