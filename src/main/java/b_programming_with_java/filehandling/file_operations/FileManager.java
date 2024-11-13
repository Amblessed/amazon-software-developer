package b_programming_with_java.filehandling.file_operations;



/*
 * @Project Name: amazon-software-developer
 * @Author: Okechukwu Bright Onwumere
 * @Created: 13-Nov-24
 */


import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class FileManager {

    public static String createFileUpload(String directory, String filename){
        File file = new File(directory, filename);
        try{
            if(file.createNewFile()){
                return "File created successfully: " + file.getAbsolutePath();
            }
            else{
                return "File already exists: " + file.getAbsolutePath();
            }
        }
        catch(IOException e){
            return "An error occurred while creating the file: " + e.getMessage();
        }
    }


    public static void createFile(String filePath){
        Path path = Paths.get(filePath);
        try{
            Files.createFile(path);
            System.out.println("File created successfully: " + path);
        }
        catch(FileAlreadyExistsException e){
            System.out.println("FileAlreadyExistsException: " + e.getMessage());
        }
        catch(AccessDeniedException e){
            System.out.println("Unable to create the file. AccessDeniedException: " + e.getMessage());
        }
        catch(IOException e){
            System.out.println("IOException: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }


    public static void deleteTempFile(String filePath){
        File tempfile = new File(filePath);
        if(tempfile.exists()){
            if(tempfile.delete()){
                System.out.println("File deleted successfully: " + tempfile.getAbsolutePath());
            }
            else{
                System.out.println("File could not be deleted: " + tempfile.getAbsolutePath());
            }
        }
        else{
            System.out.println("File not found deleted: " + tempfile.getAbsolutePath());
        }
    }

    public static void deleteFile(String filePath){
        Path path = Paths.get(filePath);
        try{
            Files.delete(path);
            System.out.println("File deleted successfully: " + path);
        }
        catch(NoSuchFileException e){
            System.out.println("NoSuchFileException: " + e.getMessage());
        }
        catch(AccessDeniedException e){
            System.out.println("Unable to delete the file. AccessDeniedException: " + e.getMessage());
        }
        catch(IOException e){
            System.out.println("IOException: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }


    public static void renameFile(String oldNamePath, String newNamePath){
        File oldFile = new File(oldNamePath);
        File newFile = new File(newNamePath);
        try{
            if(!oldFile.exists()){
                System.out.println("File does not exist: " + oldFile.getAbsolutePath());
                return;
            }
            if(newFile.exists()){
                System.out.println("File already exists: " + newFile.getAbsolutePath());
                return;
            }

            if(oldFile.renameTo(newFile)){
                System.out.println("File renamed successfully: " + newFile.getAbsolutePath());
            }
            else {
                System.out.println("File could not be renamed");
            }
        }
        catch(SecurityException e){
            System.out.println("An error occurred while renaming the file: " + e.getMessage());
        }
    }

    public static void renameFileNIO(String oldFilePath, String newFilePath){
        Path oldPath = Paths.get(oldFilePath);
        Path newPath = Paths.get(newFilePath);

        try{
            Files.move(oldPath, newPath);
            System.out.println("File renamed successfully: " + oldFilePath + " -> " + newFilePath);
        }
        catch(NoSuchFileException e){
            System.out.println("NoSuchFileException: " + e.getMessage());
        }
        catch(IOException e){
            System.out.println("IOException: " + e.getMessage());
        }
    }

    public static void copyFileNIO(String sourcePath, String targetPath){
        Path source = Paths.get(sourcePath);
        Path target = Paths.get(targetPath);

        try{
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied successfully: " + sourcePath + " -> " + targetPath);
        }
        catch(NoSuchFileException e){
            System.out.println("NoSuchFileException: " + e.getMessage());
        }
        catch(FileAlreadyExistsException e){
            System.out.println("FileAlreadyExistsException: " + e.getMessage());
        }
        catch(IOException e){
            System.out.println("IOException: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
