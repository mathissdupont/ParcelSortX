public class Parcel {
    public enum Status {
        InQueue, Sorted, Dispatched, Returned
    }

    public String parcelID;
    public String destinationCity;
    public int priority;
    public String size;
    public int arrivalTick;
    public Status status;

    public Parcel(String parcelID, String destinationCity, int priority, String size, int arrivalTick) {
        this.parcelID = parcelID;
        this.destinationCity = destinationCity;
        this.priority = priority;
        this.size = size;
        this.arrivalTick = arrivalTick;
        this.status = Status.InQueue;
    }
    //getters
    public String getParcelID() {
        return parcelID;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public int getPriority() {
        return priority;
    }

    public String getSize() {
        return size;
    }

    public int getArrivalTick() {
        return arrivalTick;
    }

    public Status getStatus() {
        return status;
    }

    //setters
    public void setStatus(Status status) {
        this.status = status;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String toString() {
        return "Parcel{" +
                "ID=" + parcelID +
                ", destination='" + destinationCity + '\'' +
                ", priority=" + priority +
                ", size='" + size + '\'' +
                ", arrivalTick=" + arrivalTick +
                ", status=" + status +
                '}';
    }

    
}
