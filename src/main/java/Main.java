public class Main {
    public static void main(String[] args) {
       Visitors visitors  = new Visitors("Sadio Mane",25,"15/01/2019","15;15","I need to finish my degree","Msizi");
       visitors.save();
       visitors.load();
    }
}
