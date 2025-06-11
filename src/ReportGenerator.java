import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
//bu sınıf rapor yazar
public class ReportGenerator {

    public void generateReport(SimulationMetrics metrics, String filename) {//metrics simülasyon istatistikleri için, filename rapor dosyası adı için 
        //dosya yazma işlemleri
        //hatalı dosya yazımı programı durudrmasın diye try catch
        //hatalı dosya yazımı programı durudrmasın, dosya kapalılmasın diye try catch
        (Destinationsorter.java, ReportGenerator.java, BSTTest.java ve SimulationTest.java eklendi)
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("=== ParcelSortX Final Report ===\n");
            writer.write("Total Ticks: " + metrics.totalTicks + "\n");
            writer.write("Total Parcels Generated: " + metrics.totalParcels + "\n");
            writer.write("Dispatched Parcels: " + metrics.dispatched + "\n");
            writer.write("Returned Parcels: " + metrics.returned + "\n");

            writer.write("\n-- City Parcel Counts --\n");
            for (Map.Entry<String, Integer> entry : metrics.cityParcelCounts.entrySet()) { // hangi şehre kaç kargo gitmiş- Map
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }

            writer.write("\nAverage Processing Time: " + metrics.avgDelay + " ticks\n");
            writer.write("Max Queue Size: " + metrics.maxQueueSize + "\n");
            writer.write("Final BST Height: " + metrics.bstHeight + "\n");

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();// hatayı bastır
        }
    }
}
