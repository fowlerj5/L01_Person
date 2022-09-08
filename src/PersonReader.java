import javax.swing.*;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Calendar;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonReader {
    public static void main(String[] args){
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";
        ArrayList<Person>people = new ArrayList<>();

        try
        {
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);
            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();
                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));
                System.out.printf("%-20s","ID#");
                System.out.printf("%-20s","Firstname");
                System.out.printf("%-20s","Lastname");
                System.out.printf("%-20s","Title");
                System.out.printf("%-20s","YOB");
                System.out.println();
                for (int i = 0; i < 100; i++){
                    System.out.print("=");
                }
                System.out.println();
                String[] arrOfRec;
                while(reader.ready())
                {
                    rec = reader.readLine();
                    arrOfRec = rec.split(", ");
                    Person p = new Person(arrOfRec[0], arrOfRec[1], arrOfRec[2], arrOfRec[3], Integer.parseInt(arrOfRec[4]));
                    people.add(p);
                    System.out.printf("%-20s", p.getIDnum());
                    System.out.printf("%-20s", p.getFirstName());
                    System.out.printf("%-20s", p.getLastName());
                    System.out.printf("%-20s", p.getTitle());
                    System.out.printf("%-20s", p.getYOB());
                    System.out.println();
                }
                reader.close();
                System.out.println("\n\nData file read!");
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!!!");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}