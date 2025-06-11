public class TerminalRotator {

    private class Node {
        String cityName;
        Node next;

        public Node(String cityName) {
            this.cityName = cityName;
            this.next = null;
        }
    }

    private Node head;
    private Node current;

    public TerminalRotator() {
        this.head = null;
        this.current = null;
    }

    // şehir listesinden yapıyı oluştur
    public void initializeFromCityList(String[] cityArray) {
        if (cityArray == null || cityArray.length == 0) return;

        head = new Node(cityArray[0]);
        Node temp = head;

        for (int i = 1; i < cityArray.length; i++) {
            temp.next = new Node(cityArray[i]);
            temp = temp.next;
        }

        temp.next = head; // circular yap
        current = head;
    }

    // Bir sonraki terminale geç
    public void advanceTerminal() {
        if (current != null) {
            current = current.next;
        }
    }

    // Şu anki aktif şeyi döndürcek
    public String getActiveTerminal() {
        return current != null ? current.cityName : null;
    }

    // Debug
    public void printTerminalOrder() {
        if (head == null) return;

        Node temp = head;
        do {
            System.out.print(temp.cityName + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to start)");
    }
}
