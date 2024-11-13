package b_programming_with_java.filehandling.filewriter;



/*
 * @Project Name: amazon-software-developer
 * @Author: Okechukwu Bright Onwumere
 * @Created: 13-Nov-24
 */


import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class SafeLogger {

    public static void main(String[] args) {

        Path filePath = Path.of("user_activity.log");
        String newLog = "User updated profile at " + System.currentTimeMillis() + "\n";
        try(FileChannel channel = FileChannel.open(filePath, StandardOpenOption.WRITE, StandardOpenOption.APPEND)){
            //Lock the file exclusively
            FileLock lock = channel.lock();
            try{
                //Convert the log entry to a ByteBuffer
                ByteBuffer byteBuffer = ByteBuffer.wrap(newLog.getBytes());
                //Write the buffer to the file
                while (byteBuffer.hasRemaining()){
                    channel.write(byteBuffer);
                }
                System.out.println("Log entry added with safe concurrent access");
            }
            finally {
                //Release the lock
                lock.release();
            }
        }
        catch (IOException e){
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
