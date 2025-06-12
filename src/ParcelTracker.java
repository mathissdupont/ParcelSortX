public class ParcelTracker {

    private class Entry {
        String key; // parcelID
        ParcelRecord value;
        Entry next;

        public Entry(String key, ParcelRecord value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private Entry[] table;
    private int size;

    public ParcelTracker(int capacity) {
        table = new Entry[capacity];
        size = capacity;
    }

    private int hash(String key) {
        return Math.abs(key.hashCode()) % size;
    }

    public boolean exists(String parcelID) {
        int index = hash(parcelID);
        Entry current = table[index];
        while (current != null) {
            if (current.key.equals(parcelID)) return true;
            current = current.next;
        }
        return false;
    }

    public void insert(String parcelID, Parcel parcel) {
        if (exists(parcelID)) return;
        int index = hash(parcelID);
        Entry newEntry = new Entry(parcelID, new ParcelRecord(parcel));
        newEntry.next = table[index];
        table[index] = newEntry;
    }

    public ParcelRecord get(String parcelID) {
        int index = hash(parcelID);
        Entry current = table[index];
        while (current != null) {
            if (current.key.equals(parcelID)) return current.value;
            current = current.next;
        }
        return null;
    }

    public void updateStatus(String parcelID, Parcel.Status newStatus) {
        ParcelRecord record = get(parcelID);
        if (record != null) {
            record.updateStatus(newStatus);
        }
    }

    public void markDispatched(String parcelID, int tick) {
        ParcelRecord record = get(parcelID);
        if (record != null) {
            record.markDispatched(tick);
        }
    }

    public void incrementReturnCount(String parcelID) {
        ParcelRecord record = get(parcelID);
        if (record != null) {
            record.incrementReturn();
        }
    }
}
