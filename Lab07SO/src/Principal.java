import java.util.Scanner;

public class Principal {
	
	public static Process[] processes; //List of processes
	public static Resources resources; //Variable that keep the instances of the resources
	static int totalResources; //Total of resources entered
	static int totalProcesses; //Total of processes entered
	static Scanner entry = new Scanner(System.in);
	static boolean result;
	
	public static boolean Detection(){
		
		boolean finish[] = new boolean[totalProcesses];
		boolean secure;
		int finished =0, iterations=0;
		
		for(int i=0; i<totalProcesses; i++){
			secure = true;
			for(int j = 0; j<totalResources; j++){
				if(processes[i].allocation[j]!=0) //if it is allocating any resource than it is not safe to finish yet
					secure = false;
			}
			
			if(secure)
				finish[i]=true; // if is not allocating any resource, can be finished
			else
				finish[i]=false; //else it will be verified
			
		}
	        
		
		/*Makes step 2 of the algorithm 
		 * until all of the processes are finished(safe) or
		 * made iterations for all processes and not all are finished(not safe)
		 */
		do{
			for (int i=0; i<totalProcesses; i++){
	            secure = true;
	            if(!finish[i]){
	            	
	                for(int j=0; j<totalResources; j++){
	                    if(processes[i].request[j]>resources.available[j]) //if doesn't fit the condition request<=available
	                       secure=false; //then the process is not secure to finish now
	                }
	                
	                if(secure){
	                	for(int j=0; j<totalProcesses; j++)
	                		resources.available[j] = resources.available[j] + processes[i].allocation[j];
	                	finished++;
	                	finish[i]=true;
	                }	       
	            }
	        }
			iterations++;
		}while(finished<totalProcesses  && iterations<=totalProcesses);
		
		if(finished<totalProcesses){//if not all processes were finished
			for(int i=0; i<totalProcesses;i++){
				if(!finish[i])
					System.out.println("Process "+i+" is in deadlock");
			}
			return false; //then not safe
		}
        return true; //if all processes were finished, it's safe
	}
	

	
	public static void main(String args[]){
		
		
		totalResources=3;
		totalProcesses=3;
		
		processes = new Process[totalProcesses];
		resources = new Resources(totalResources);
		for(int i=0; i<totalProcesses; i++)
			processes[i] = new Process(totalResources);
		
		resources.available = new int[]{0, 2, 4};
		
		processes[0].allocation = new int[] {3, 1, 0};
		processes[1].allocation = new int[] {7, 0, 1};
		processes[2].allocation = new int[] {0, 2, 2};
		
		processes[0].max = new int[] {7, 5, 7};
		processes[1].max = new int[] {7, 1, 1};
		processes[2].max = new int[] {10, 4, 3};
		
		processes[0].FillNeed();
		processes[1].FillNeed();
		processes[2].FillNeed();
		
		processes[0].request = new int[] {4, 3, 5};
		processes[1].request = new int[] {0, 1, 0};
		processes[2].request = new int[] {7, 2, 1};
		
		result= Detection();
		
		if(result)
			System.out.println("It's safe!! UHUUUUU");
		else
			System.out.println("It's NOT safe!! RUUUUUN");
		
			
	}
}
