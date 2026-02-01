import java.util.Scanner;
public class CRCComputation
{
    static void xorOperation(int[] data, int[] divisor) 
    {
        for (int i = 0; i < divisor.length; i++) 
        {
            data[i] = data[i] ^ divisor[i];
        }
    }
    static int[] calculateCRC(int[] data, int[] divisor) 
    {
        int[] temp = data.clone();
        for (int i = 0; i <= temp.length - divisor.length; i++) 
        {
            if (temp[i] == 1) 
            {
                for (int j = 0; j < divisor.length; j++) 
                {
                    temp[i + j] = temp[i + j] ^ divisor[j];
                }
            }
        }
        return temp;
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of data bits: ");
        int n = sc.nextInt();
        int[] data = new int[n];
        System.out.println("Enter data bits:");
        for (int i = 0; i < n; i++) 
        {
            data[i] = sc.nextInt();
        }
        System.out.print("Enter number of divisor bits: ");
        int m = sc.nextInt();
        int[] divisor = new int[m];
        System.out.println("Enter divisor bits:");
        for (int i = 0; i < m; i++) 
        {
            divisor[i] = sc.nextInt();
        }
        int[] appendedData = new int[n + m - 1];
        for (int i = 0; i < n; i++) 
        {
            appendedData[i] = data[i];
        }
        int[] crcResult = calculateCRC(appendedData, divisor);
        System.out.print("CRC bits: ");
        for (int i = n; i < crcResult.length; i++) 
        {
            System.out.print(crcResult[i] + " ");
        }
        System.out.print("\nTransmitted Data: ");
        for (int i = 0; i < n; i++) 
        {
            System.out.print(data[i] + " ");
        }
        for (int i = n; i < crcResult.length; i++) 
        {
            System.out.print(crcResult[i] + " ");
        }
        sc.close();
    }
}