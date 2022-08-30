public class Main {
    public static void main(String[] args) {
        Fighter marc = new Fighter("Hinata-chan" , 15 , 100, 90, 15, 10,20);
        Fighter alex = new Fighter("Kageyama-kun" , 10 , 95, 100, 20,10,20);
        Ring r = new Ring(marc,alex , 90 , 100);
        r.run();
    }
}