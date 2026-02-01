import java.util.Random;
import java.util.Scanner;

public class SlidingWindowSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter total number of frames to send: ");
        int totalFrames = scanner.nextInt();

        System.out.print("Enter window size: ");
        int windowSize = scanner.nextInt();

        int base = 0;

        while (base < totalFrames) {
            int end = Math.min(base + windowSize, totalFrames);
            System.out.println("\nSending frames " + base + " to " + (end - 1));

            boolean errorOccurred = false;
            for (int i = base; i < end; i++) {
                System.out.println("Sending frame " + i);
                boolean ackReceived = random.nextInt(10) >= 2; // 80% chance of success

                if (ackReceived) {
                    System.out.println("ACK received for frame " + i);
                } else {
                    System.out.println("Frame " + i + " lost! Resending from frame " + i);
                    base = i; // Go back to the lost frame
                    errorOccurred = true;
                    break;
                }
            }
            if (!errorOccurred) {
                base = end; // Slide window forward
            }

            try {
                Thread.sleep(1000); // Simulate delay
            } catch (InterruptedException e) {
                System.out.println("Transmission interrupted.");
            }
        }

        System.out.println("\nAll frames sent successfully!");
        scanner.close();
    }
}