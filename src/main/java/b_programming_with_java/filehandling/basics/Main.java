package b_programming_with_java.filehandling.basics;



/*
 * @Project Name: amazon-software-developer
 * @Author: Okechukwu Bright Onwumere
 * @Created: 11-Nov-24
 */


import java.io.*;

public class Main {

    public static void main(String[] args) {
        File myfile = new File("src/main/java/b_programming_with_java/filehandling/file.txt");

        if (myfile.exists()) {
            System.out.println("File exists");
        }
        else {
            System.out.println("File does not exist");
        }

        try(FileInputStream inputStream = new FileInputStream(myfile); BufferedReader inputStreamBR = new BufferedReader(new FileReader(myfile))) {
            byte[] fileContentsAsBytes = inputStream.readAllBytes();
            for (byte fileContentsAsByte : fileContentsAsBytes) {
                System.out.println((char) fileContentsAsByte);
            }
            System.out.println("**************************");
            int character;
            while ((character = inputStreamBR.read()) != -1) {
                System.out.print((char) character);
            }

        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("File Not Found!");
        } catch (IOException ioException) {
            System.err.println(ioException.getMessage());
        }
    }
}
