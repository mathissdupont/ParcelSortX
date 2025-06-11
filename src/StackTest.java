//ReturnStack.java dosyasının testi
public class StackTest {

    public static void main(String[] args) {
        ReturnStack stack = new ReturnStack();

        // Parcel sınıfı fatmanur oluşturcak bu yüzden Parcel sınıfına ne isim verirse ona göre 
        // değiştirmek gerekiyor.
        Parcel p1 = new Parcel("P001", "Istanbul", 3, "Medium", 1);
        Parcel p2 = new Parcel("P002", "Ankara", 2, "Small", 2);
        Parcel p3 = new Parcel("P003", "Izmir", 1, "Large", 3);

        System.out.println("Initial isEmpty(): " + stack.isEmpty()); // true
        stack.push(p1);
        stack.push(p2);
        stack.push(p3);

        System.out.println("After 3 pushes, size(): " + stack.size()); // 3
        System.out.println("Top of stack: " + stack.peek().getParcelID()); // P003

        Parcel popped = stack.pop();
        System.out.println("Popped: " + popped.getParcelID()); // P003
        System.out.println("New top: " + stack.peek().getParcelID()); // P002
        System.out.println("New size(): " + stack.size()); // 2

        System.out.println("isEmpty(): " + stack.isEmpty()); // false
    }
}
