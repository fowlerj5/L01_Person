import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String firstName;
        String lastName;
        String IDnum;
        String title;
        int YOB;
        String fullName;
        boolean yn = true;
        ArrayList <String>recs = new ArrayList<>();
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\PersonTestData.csv");

        do{
            IDnum = SafeInput.getNonZeroLenString(in, "ID");
            firstName = SafeInput.getNonZeroLenString(in, "First name");
            lastName = SafeInput.getNonZeroLenString(in, "Last name");
            title = SafeInput.getNonZeroLenString(in, "Title");
            YOB = SafeInput.getRangedInt(in, "Birth year", 1940, 2000);
            Person p = new Person(IDnum, firstName, lastName, title, YOB);
            recs.add(p.toCSVDataRecord());
            yn = SafeInput.getYNConfirm(in, "Are there more records to enter?");
        }while(yn);
        try{
            OutputStream out =
                new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                new BufferedWriter(new OutputStreamWriter(out));
            for(String rec : recs){
                writer.write(rec, 0, rec.length());
                writer.newLine();
            }
            writer.close();
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}