import java.util.Scanner;

class Token {
    public static void Tb(int[] packets, int capacity, int tokenRate, int outputRate) {
        int n = packets.length;
        int tokens = 0;  // Number of tokens in the bucket
        int currentBucketSize = 0;  // Current capacity of the bucket

        for (int i = 0; i < n; i++) {
            int arrived = packets[i];
            int accepted = 0;
            int sent = 0;
            int dropped = 0;

            // Generate tokens for this time unit
            tokens = Math.min(capacity, tokens + tokenRate);

            // Calculate how many packets can be accepted
            if (tokens >= arrived) {
                accepted = arrived;
                tokens -= accepted;  // Deduct tokens used to send packets
            } else {
                accepted = tokens;
                dropped = arrived - accepted;  // Dropped packets due to insufficient tokens
                tokens = 0;  // All tokens are used up
            }

            // Calculate how many packets can be sent
            sent = Math.min(accepted, outputRate);  // Sent packets based on output rate
            currentBucketSize = Math.min(capacity, currentBucketSize + accepted - sent);

            // Print the statistics for each time step
            System.out.printf("%d\t\t%d\t\t%d\t\t%d\t\t%d\t\t%d%n", 
                i + 1, arrived, accepted, sent, dropped, currentBucketSize);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input token bucket capacity
        System.out.println("Enter token bucket capacity:");
        int capacity = sc.nextInt();

        // Input token generation rate
        System.out.println("Enter token generation rate (tokens per second):");
        int tokenRate = sc.nextInt();

        // Input output rate
        System.out.println("Enter fixed output rate (packets per second):");
        int outputRate = sc.nextInt();

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
        System.out.println("Time\t\tPacket Size\tAccepted by Bucket\tSent\t\tDropped\tRemaining");
        Tb(packets, capacity, tokenRate, outputRate);

        sc.close();
    }
}
