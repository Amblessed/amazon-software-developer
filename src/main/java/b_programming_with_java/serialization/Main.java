package b_programming_with_java.serialization;



/*
 * @Project Name: amazon-software-developer
 * @Author: Okechukwu Bright Onwumere
 * @Created: 13-Nov-24
 */


import java.io.*;

public class Main {

    public static void main(String[] args) {
        Player player = new Player("GameMaster13", 7, 2120, "password");
        try(FileOutputStream fileOutputStream = new FileOutputStream("player.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeObject(player);
            System.out.println("Player object serialized and saved to player.ser");
        }
        catch (FileNotFoundException e) {
            System.err.println("File Not Found");
        }
        catch(IOException ioException){
            System.err.println("IO Error: " + ioException.getMessage());
        }


        Player restoredPlayer;
        try(FileInputStream fileInputStream = new FileInputStream("player.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
            Object restoredObject = objectInputStream.readObject();
            restoredPlayer = (Player) restoredObject;
            System.out.println("Restored Object = " + restoredObject);
            System.out.println("Restored Player = " + restoredPlayer);
        }
        catch (FileNotFoundException e) {
            System.err.println("File Not Found");
        }
        catch(IOException | ClassNotFoundException ioException){
            System.err.println(ioException.getMessage());
        }
    }
}
