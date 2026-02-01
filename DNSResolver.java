import java.net.InetAddress;
import java.util.Scanner;
public class DNSResolver 
{
    public static void main(String[] args) 
    {
        try 
        {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Host Name: ");
            String host = sc.nextLine();
            InetAddress ip = InetAddress.getByName(host);
            System.out.println("Host Name : " + host);
            System.out.println("IP Address: " + ip.getHostAddress());
            sc.close();
        } 
        catch (Exception e) 
        {
            System.out.println("Unable to resolve host");
        }
    }
}