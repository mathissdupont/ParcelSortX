public class ParcelTest {
    public static void main(String[] args) {
        // Parcel oluşturulması testi
        Parcel p = new Parcel("1", "Istanbul", 2, "Medium", 10);


        // Getters testi
        assert p.getParcelID().equals("1") : "Parcel ID should be '1'";
        assert p.getDestinationCity().equals("Istanbul") : "Destination should be Istanbul";
        assert p.getPriority() == 2 : "Priority should be 2";
        assert p.getSize().equals("Medium") : "Size should be Medium";
        assert p.getArrivalTick() == 10 : "ArrivalTick should be 10";
        assert p.getStatus() == Parcel.Status.InQueue : "Initial status should be InQueue";

        // Setters testi
        p.setPriority(5);
        assert p.getPriority() == 5 : "Priority should be updated to 5";

        p.setDestinationCity("Ankara");
        assert p.getDestinationCity().equals("Ankara") : "Destination should be Ankara";

        p.setSize("Large");
        assert p.getSize().equals("Large") : "Size should be Large";

        p.setStatus(Parcel.Status.Dispatched);
        assert p.getStatus() == Parcel.Status.Dispatched : "Status should be Dispatched";

        // toString() testi 
        System.out.println(p.toString());

        System.out.println("Tüm testler başarıyla geçti.");
    }
}
