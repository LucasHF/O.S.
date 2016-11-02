import java.util.Scanner;

public class Security {
	
	public static Process[] processes; //List of processes
	public static Resources resources; //Variable that keep the instances of the resources
	static int totalResources; //Total of resources entered
	static int totalProcesses; //Total of processes entered
	static Scanner entry = new Scanner(System.in);
	static boolean result;
	
	public static boolean Safety(){
		boolean finish[] = new boolean[totalProcesses];
		boolean secure;
		int finished =0, iterations=0;
		for(int i=0; i<totalProcesses; i++)
	        finish[i] = false;
		
		/*Makes step 2 of the algorithm 
		 * until all of the processes are finished(safe) or
		 * made iterations for all processes and not all are finished(not safe)
		 */
		do{
			for (int i=0; i<totalProcesses; i++){
	            secure = true;
	            if(!finish[i]){
	            	
	                for(int j=0; j<totalResources; j++){
	                    if(processes[i].need[j]>resources.available[j]) //if doesn't fit the condition need<available
	                       secure=false; //then the process is not secure to finish now
	                }
	                
	                if(secure){
	                	for(int j=0; j<totalProcesses; j++)
	                		resources.available[j]=resources.available[j]+processes[i].allocation[j];
	                	finished++;
	                }
	                
	            }
	        }
			iterations++;
		}while(finished<totalProcesses  && iterations<=totalProcesses);
		
		if(finished<totalProcesses)//if not all processes were finished
			return false; //then not safe
		
        return true; //if all processes were finished, it's safe
	}

	public static void main(String args[]){
		
		System.out.println("Enter the number of resources");
		totalResources = entry.nextInt();
		
		System.out.println("Enter the number of processes");
		totalProcesses = entry.nextInt();
		
		resources = new Resources(totalResources); 
		
		processes = new Process[totalProcesses]; // set the size with the number of processes
		
		resources.FillResources(); //set the available instances of each resource
		
		for(int i=0; i<totalProcesses; i++){
			processes[i] = new Process(totalResources); // each process is properly created;
			
			System.out.println("For process "+i+" enter:/n"); //The message connects with the messages on the method bellow 
			processes[i].FillProcess(totalResources);

		}
		
		result=Safety();
		
		if(result)
			System.out.println("It's safe!! UHUUUUU");
		else
			System.out.println("It's NOT safe!! RUUUUUN");
		
			
	}
}
