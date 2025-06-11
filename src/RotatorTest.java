//TerminalRotator.java dosyasının testi
public class RotatorTest {

    public static void main(String[] args) {
        TerminalRotator rotator = new TerminalRotator();

        // config.txt içeriği (şehir listesi) ortak görevdir
        String[] cities = {"Istanbul", "Ankara", "Izmir", "Bursa"};

        rotator.initializeFromCityList(cities);

        System.out.println("Initial Terminal: " + rotator.getActiveTerminal()); // istanbul

        rotator.advanceTerminal();
        System.out.println("Next: " + rotator.getActiveTerminal()); // ankara

        rotator.advanceTerminal();
        System.out.println("Next: " + rotator.getActiveTerminal()); // izmir

        rotator.advanceTerminal();
        System.out.println("Next: " + rotator.getActiveTerminal()); // bursa

        rotator.advanceTerminal();
        System.out.println("Loop Back to: " + rotator.getActiveTerminal()); // istanbul

        // printTerminalOrder() test ve debug amaçlıdır
        System.out.print("Full order: ");
        rotator.printTerminalOrder();
    }
}
