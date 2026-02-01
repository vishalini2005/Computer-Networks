import java.util.*;
public class BitStuffingUnstuffing
{
    // Bit Stuffing Method
    public static String bitStuff(String data)
    {
        StringBuilder stuffed = new StringBuilder();
        int count = 0;
        for (char bit : data.toCharArray()) {
            stuffed.append(bit);
            if (bit == '1')
            {
                count++;
                if (count == 5)
                {
                    stuffed.append('0');   // Insert stuffed bit
                    count = 0;
                }
            }
            else
            {
                count = 0;
            }
        }
        return stuffed.toString();
    }
    // Bit Unstuffing Method
    public static String bitUnstuff(String stuffedData)
    {
        StringBuilder unstuffed = new StringBuilder();
        int count = 0;
        for (int i = 0; i < stuffedData.length(); i++)
        {
            char bit = stuffedData.charAt(i);
            unstuffed.append(bit);
            if (bit == '1')
            {
                count++;
                if (count == 5)
                {
                    // Skip the stuffed '0'
                    i++;   
                    count = 0;
                }
            }
            else
            {
                count = 0;
            }
        }
        return unstuffed.toString();
    }
    public static void main(String[] args)
    {
        String data = "1111101111110111111101111";
        System.out.println("Original Data     : " + data);
        String stuffed = bitStuff(data);
        System.out.println("Bit Stuffed Data  : " + stuffed);
        String unstuffed = bitUnstuff(stuffed);
        System.out.println("Bit Unstuffed Data: " + unstuffed);
    }
}
