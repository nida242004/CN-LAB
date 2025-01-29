import java.util.*;

public class red{
	private static double calculateDropProb(int currqlen, int qsize, double maxprob,double minprob, int tresh){
		double slope = (maxprob - minprob)/(qsize - tresh);
		return minprob + slope * (currqlen - tresh);
	}
	
	private static void sim(int maxpack, int qsize, double maxprob, double minprob, int tresh){
		Random rand = new Random(System.currentTimeMillis());
		int qlen = 0;
		for(int i=0; i<maxpack; i++){
			double dropProb = calculateDropProb(qlen, qsize, maxprob, minprob, tresh);
			double x = rand.nextDouble();
			System.out.println(x);
			if(qlen >= tresh &&  x < dropProb){
				
				System.out.println("packets dropped");
			}else{
				System.out.println("packets accepted"+(i+1));
				qlen++;
			}
		}
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the max no of packets:");
		int maxpack = sc.nextInt();
		System.out.println("ENter the queue size");
		int qsize = sc.nextInt();
		System.out.println("Enter the max prob");
		double maxprob =  sc.nextDouble();
		System.out.println("enter the min prob");
		double minprob = sc.nextDouble();
		System.out.println("Enter the treshold val:");
		int tresh = sc.nextInt();
		sim(maxpack, qsize, maxprob, minprob, tresh);
	}
	
}
