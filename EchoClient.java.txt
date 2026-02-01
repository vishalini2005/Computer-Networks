import java.io.*;
import java.net.*;
public class EchoClient 
{
    public static void main(String[] args) 
    {
        String hostname = "localhost";  // server IP or hostname
        int port = 12345;
        try (Socket socket = new Socket(hostname, port);
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true))
        {

            System.out.println("Connected to echo server. Type messages (type 'exit' to quit):");

            String message;
            while ((message = userInput.readLine()) != null)
            {
                out.println(message);  // send to server
                String response = in.readLine();  // read echoed message
                System.out.println("Echo from server: " + response);

                if ("exit".equalsIgnoreCase(message))
                {
                    break;
                }
            }

        } 
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}