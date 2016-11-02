import java.util.Scanner;

public class Resources {
	public int available[]; // array with the number of instances of each resource
	static Scanner entry = new Scanner(System.in);
	/*Constructor method with the number
	 * of resources passed as parameter
	 */
	public Resources(int resources){
		available = new int[resources];
	}
	/*
	 * Set the available instances of each resource
	 */
	public void FillResources(){
		for(int j=0; j<available.length; j++){
			System.out.println("How many instances of resource "+j+" are available?/n");
			available[j] = entry.nextInt();
		}
	}
}
