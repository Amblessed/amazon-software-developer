package b_programming_with_java.filehandling.filewriter;



/*
 * @Project Name: amazon-software-developer
 * @Author: Okechukwu Bright Onwumere
 * @Created: 13-Nov-24
 */


import java.io.FileWriter;
import java.io.IOException;

public class ActivityLogger {

    public static void main(String[] args) {

        String filePath = "user_activity.log";
        String newLog = "User logged in at " + System.currentTimeMillis() + "\n";

        try(FileWriter fileWriter = new FileWriter(filePath, true)){
            fileWriter.write(newLog);
            System.out.println("Log entry added");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    /*
    * try {
   FileReader reader = new FileReader("EmployeeList.txt");
   int character;

   while ((character = reader.read()) != -1) {
       System.out.print((char) character);
   }
   reader.close();

} catch (IOException e) {
      System.out.println("Exception:" + e.getMessage());;
}
    *
    * */
}
