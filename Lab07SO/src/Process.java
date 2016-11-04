import java.util.Scanner;

public class Process {

	public int max[], allocation[], need[], request[];
	static Scanner entry = new Scanner(System.in);
	
	/*Each array has the quantity of instances
	 * of each resource, so their size are 
	 * the quantity of resources entered*/
	public Process(int resources){
		max = new int[resources];
		allocation = new int[resources];
		need = new int[resources];
		request = new int[resources];
	}
	
	/* Fill the need array with the condition need = max - allocation
	 * 
	 */
	public void FillNeed(){
		for(int j=0; j<need.length; j++){
		
			// need = max-allocation
			need[j] = max[j]-allocation[j];
			
		}
	}
}
