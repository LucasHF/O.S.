import java.util.Scanner;

public class Process {

	public int max[], allocation[], need[];
	static Scanner entry = new Scanner(System.in);
	
	/*Each array has the quantity of instances
	 * of each resource, so their size are 
	 * the quantity of resources entered*/
	public Process(int resources){
		max = new int[resources];
		allocation = new int[resources];
		need = new int[resources];
	}
	
	public void FillProcess(int resources){
		for(int j=0; j<resources; j++){
			
			//set the max instances of resource j that the process needs
			System.out.println("The MAX of instances it needs from resource "+j+"/n");
			max[j] = entry.nextInt();
			
			//set the instances of resource j that the process is allocating
			System.out.println("The total of instances of resource "+j+" it is ALLOCATING /n");
			allocation[j] = entry.nextInt();
		
			// need = max-allocation
			need[j] = max[j]-allocation[j];
		}
	}
}
