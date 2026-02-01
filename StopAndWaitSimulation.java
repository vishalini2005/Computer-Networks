import java.util.Random;
import java.util.Scanner;

public class StopAndWaitSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter number of frames to send: ");
        int totalFrames = scanner.nextInt();

        for (int frame = 1; frame <= totalFrames; ) {
            System.out.println("Sending frame " + frame + "...");

            // Simulate ACK loss with 30% probability
            boolean ackReceived = random.nextInt(10) >= 3;

            if (ackReceived) {
                System.out.println("ACK received for frame " + frame);
                frame++; // Move to next frame
            } else {
                System.out.println("ACK lost! Resending frame " + frame);
                // Frame is resent, so don't increment
            }

            // Simulate transmission delay
            try {
                Thread.sleep(1000); // 1 second delay
            } catch (InterruptedException e) {
                System.out.println("Transmission interrupted.");
            }
        }

        System.out.println("All frames sent successfully!");
        scanner.close();
    }
}