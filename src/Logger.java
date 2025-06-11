import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class Logger {

    private FileWriter logFile;

    public Logger(String filename) {
        try {
            logFile = new FileWriter(filename, false); // üstüne yaz
        } catch (IOException e) {
            System.err.println("Log dosyası açılamadı: " + e.getMessage());
        }
    }

    public void logTickHeader(int tick) {
        logLine("\n[Tick " + tick + "]");
    }

    public void logNewParcels(List<Parcel> parcels) {
        if (parcels == null || parcels.isEmpty()) return;
        StringBuilder sb = new StringBuilder("New Parcels: ");
        for (Parcel p : parcels) {
            // Parcel sınıfını fatmanur yazcak verdiği isme göre değiştirmek gerekiyo
            sb.append(p.getParcelID())
              .append(" to ")
              .append(p.getDestinationCity())
              .append(" (Priority ")
              .append(p.getPriority())
              .append("), ");
        }
        logLine(sb.toString().replaceAll(", $", ""));
    }

    public void logQueueSize(int size) {
        logLine("Queue Size: " + size);
    }

    public void logSortedParcels(List<Parcel> sorted) {
        if (sorted == null || sorted.isEmpty()) return;
        StringBuilder sb = new StringBuilder("Sorted to BST: ");
        for (Parcel p : sorted) {
            sb.append(p.getParcelID()).append(", ");
        }
        logLine(sb.toString().replaceAll(", $", ""));
    }

    public void logDispatch(String parcelID, String city, boolean success) {
        if (success) {
            logLine("Dispatched: " + parcelID + " to " + city + " -> Success");
        } else {
            logLine("Dispatch Failed: " + parcelID + " to " + city + " -> Returned");
        }
    }

    public void logReturned(String parcelID) {
        logLine("Returned: " + parcelID + " -> Pushed to ReturnStack");
    }

    public void logTerminal(String city) {
        logLine("Active Terminal: " + city);
    }

    public void logStackSize(int size) {
        logLine("ReturnStack Size: " + size);
    }

    public void logBSTCityCounts(String summaryLine) {
        // Örn: "BST City Counts: İstanbul=3, Ankara=1, İzmir=2"
        logLine(summaryLine);
    }

    public void close() {
        try {
            if (logFile != null) logFile.close();
        } catch (IOException e) {
            System.err.println("Log dosyası kapatılamadı.");
        }
    }

    private void logLine(String text) {
        try {
            logFile.write(text + "\n");
            logFile.flush(); 
        } catch (IOException e) {
            System.err.println("Log yazım hatası: " + e.getMessage());
        }
    }
}
