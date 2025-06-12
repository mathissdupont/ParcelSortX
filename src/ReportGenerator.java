import java.io.FileWriter; //raporu dosyaya yazmak için 
import java.io.IOException;//dosya işlemlerindeki hatalar için 
import java.util.*;//diğer sınıflar için 

public class ReportGenerator {

    private ParcelTracker parcelTracker;
    private DestinationSorter destinationSorter;

    public ReportGenerator(ParcelTracker tracker, DestinationSorter sorter) {
        this.parcelTracker = tracker; // kargo durumunu takip eder
        this.destinationSorter = sorter; //şehirlere göre sıralama 
    }

    public void generateReport(String filename, int totalTicks) {
        try (FileWriter writer = new FileWriter(filename)) {//dosyayı kapatır

            // rapor başlığı
            writer.write("=== ParcelSortX Simulation Report ===\n");
            writer.write("Generated on: " + new Date() + "\n\n");

            // 1. Simulation Overview
            writer.write(">> Simulation Overview\n");
            writer.write("Total Ticks Executed: " + totalTicks + "\n");//çalıştıgı zamn 
            writer.write("Total Parcels Generated: " + parcelTracker.getTotalParcels() + "\n\n");//oluşturulan toplam kargo

            // 2. Parcel Statistics
            writer.write(">> Parcel Statistics\n");
            writer.write("Total Dispatched Parcels: " + parcelTracker.getStatusCount("Dispatched") + "\n");//giden kargolar
            writer.write("Total Returned Parcels: " + parcelTracker.getStatusCount("Returned") + "\n");//iade edilen kargolar
            writer.write("Remaining in Queue/BST/Stack: " +
                    parcelTracker.getUnfinishedParcelCount() + "\n\n");// işlenmemiş kargoalr

            // 3. Destination Metrics
            writer.write(">> Destination Metrics\n");
            Map<String, Integer> cityCounts = destinationSorter.getCityParcelCounts();// her şehre giden kargo sayısı
            String maxCity = null;
            int maxCount = 0;

            for (Map.Entry<String, Integer> entry : cityCounts.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + " parcels\n");
                if (entry.getValue() > maxCount) {
                    maxCount = entry.getValue();//en cok kargo giden 
                    maxCity = entry.getKey();
                }
            }

            writer.write("Most Frequently Targeted Destination: " + maxCity + "\n\n");// En çok kargo gönderilen şehir.

            // 4. Timing and Delay Metrics
            writer.write(">> Timing and Delay Metrics\n");
            double avgTime = parcelTracker.getAverageProcessingTime();//kargo başına ortalama işlem süresi
            writer.write("Average Parcel Processing Time: " + String.format("%.2f", avgTime) + " ticks\n");

            Parcel delayed = parcelTracker.getLongestDelayedParcel();//en fazla geciken kargonun ıd 
            if (delayed != null) {
                int delay = parcelTracker.getDelay(delayed.getParcelID());
                writer.write("Parcel with Longest Delay: " + delayed.getParcelID() + " (" + delay + " ticks)\n");
            }

            writer.write("Parcels Returned More Than Once: " +
                    parcelTracker.countParcelsReturnedMoreThanOnce() + "\n\n");//birden fazla iade edilen kargolar

            // 5. Data Structure Stats (varsayım olarak sabit değerler koyulabilir)
            writer.write(">> Data Structure Stats\n");
            writer.write("Hash Table Load Factor: " + String.format("%.2f", parcelTracker.getLoadFactor()) + "\n");//Hash tablosunun doluluk oranı
            writer.write("Final BST Height: " + destinationSorter.getHeight() + "\n");//Ağaç veri yapısının yüksekliği
            writer.write("Total Unique Cities: " + cityCounts.size() + "\n");//Benzersiz şehir sayısı

            writer.write("\n=== End of Report ===\n");

        } catch (IOException e) {
            System.err.println("Rapor oluşturulurken hata oluştu: " + e.getMessage());//dosya yazma hataalrını bastırır.
        }
    }
}
//önce raporu pdfe göre yazdırdık
// bağımlı sınıflardan istatistik aldık
//metric hesabı - ortalama süre, gecikme, şehir dağılımı gibi karmaşık metrikler
// dosya yazma hatalarına karşı..