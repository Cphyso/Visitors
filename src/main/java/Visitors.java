

import java.io.*;
import java.util.Scanner;
import java.util.logging.Logger;

public class Visitors {
    public static Logger logg = Logger.getLogger(Visitors.class.getName());

    String full_name;
    int age;
    String dateOfVisit;
    String timeOfVisit;
    String comments;
    String assistedBy;


    public Visitors(String nameAndSurname, int visitorsAge, String visitDate, String timeIn, String opinion, String helped){
        this.full_name = nameAndSurname;
        this.age = visitorsAge;
        this.dateOfVisit = visitDate;
        this.timeOfVisit = timeIn;
        this.comments = opinion;
        this.assistedBy = helped;

    }



    public  void save(){
        String fileName = "visitor_" + full_name + ".txt";
        String nameOfFile = fileName.replace(" ","_").toLowerCase();

        try {
            FileWriter myWriter = new FileWriter(nameOfFile);
            myWriter.write(this.full_name +"\n" + age + "\n"+ dateOfVisit+ "\n" + timeOfVisit+ "\n" + comments+ "\n" + assistedBy);
            myWriter.close();
            logg.info("Visitor info successfully saved");
            System.out.println("Saved visitor's info.");
        } catch (IOException e) {
            logg.warning("Couldn't create file!");
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public void load(){
        String fileName = "visitor_" + full_name + ".txt";
        String nameOfFile = fileName.replace(" ","_").toLowerCase();

        try {
            File myObj = new File(nameOfFile);
            Scanner readFile = new Scanner(myObj);
            while (readFile.hasNextLine()) {
                String visitorData = readFile.nextLine();
                logg.info("Visitor info");
                System.out.println(visitorData);
            }
            readFile.close();
        } catch (FileNotFoundException e) {
            logg.warning("Couldn't read file!");
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
