import java.util.Scanner;

class Leaky {
    public static void Lb(int[] packets, int capacity, int rate) {
        int n = packets.length;
        int rem = 0; // Remaining packets in the bucket

        for (int i = 0; i < n; i++) {
            int arrived = packets[i];
            int accepted = 0;
            int sent = 0;
            int dropped = 0;

            // Check if the packet can be added to the bucket
            if (rem + arrived <= capacity) {
                accepted = arrived;
            } else {
                accepted = capacity - rem;
                dropped = arrived - accepted; // Overflow packets
            }

            // Update remaining packets in the bucket
            rem += accepted;

            // Calculate how many packets can be sent
            sent = Math.min(rem, rate);
            rem -= sent;

            // Print the statistics
            System.out.printf("%d\t\t%d\t\t%d\t\t\t\t%d\t\t%d%n", 
                i + 1, arrived, accepted, sent, rem);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input bucket capacity
        System.out.println("Enter bucket capacity:");
        int capacity = sc.nextInt();

        // Input fixed rate
        System.out.println("Enter fixed output rate:");
        int rate = sc.nextInt();

        // Input number of packets
        System.out.println("Enter the number of packets:");
        int n = sc.nextInt();

        // Input packet sizes
        int[] packets = new int[n];
        System.out.println("Enter the size of each packet:");
        for (int i = 0; i < n; i++) {
            packets[i] = sc.nextInt();
        }

        // Display statistics
        System.out.println("\nStatistics:");
        System.out.println("Time\t\tPacket Size\tAccepted by Bucket\tSent\t\tRemaining");
        Lb(packets, capacity, rate);

        sc.close();
    }
}
