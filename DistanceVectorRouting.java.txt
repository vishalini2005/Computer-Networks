import java.util.Scanner;
public class DistanceVectorRouting 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();
        int[][] cost = new int[n][n];
        int[][] dist = new int[n][n];
        System.out.println("Enter cost matrix (use 999 for infinity):");
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                cost[i][j] = sc.nextInt();
                dist[i][j] = cost[i][j];
            }
        }
        // Distance Vector Algorithm
        for (int k = 0; k < n; k++) 
        {
            for (int i = 0; i < n; i++) 
            {
                for (int j = 0; j < n; j++) 
                {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) 
                    {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        // Display routing table
        System.out.println("\nFinal Distance Vector Table:");
        for (int i = 0; i < n; i++) {
            System.out.println("Router " + i + ":");
            for (int j = 0; j < n; j++) 
            {
                System.out.println("  To node " + j + " = " + dist[i][j]);
            }
            System.out.println();
        }
        sc.close();
    }
}