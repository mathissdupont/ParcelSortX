public class ParcelRecord {
    public Parcel.Status status;
    public int arrivalTick;
    public int dispatchTick;
    public int returnCount;
    public String destinationCity;
    public int priority;
    public String size;

    public ParcelRecord(Parcel parcel) {
        this.status = parcel.getStatus();
        this.arrivalTick = parcel.getArrivalTick();
        this.dispatchTick = -1; // -1 means not dispatched yet
        this.returnCount = 0;
        this.destinationCity = parcel.getDestinationCity();
        this.priority = parcel.getPriority();
        this.size = parcel.getSize();
    }

    public void updateStatus(Parcel.Status newStatus) {
        this.status = newStatus;
    }

    public void markDispatched(int tick) {
        this.dispatchTick = tick;
        this.status = Parcel.Status.Dispatched;
    }

    public void incrementReturn() {
        this.returnCount++;
        this.status = Parcel.Status.Returned;
    }

    @Override
    public String toString() {
        return "Status=" + status +
               ", Arrival=" + arrivalTick +
               ", Dispatch=" + dispatchTick +
               ", Returns=" + returnCount +
               ", City=" + destinationCity +
               ", Priority=" + priority +
               ", Size=" + size;
    }
}
