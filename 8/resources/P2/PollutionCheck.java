import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class PollutionCheck{


	public static void main(String[] arg){

		try{
		List <Vehicle> list=new ArrayList<Vehicle>();
		String line;

		File myobj = new File(arg[0]);
		Scanner read = new Scanner(myobj);
		while(read.hasNextLine()){

			line = read.nextLine();
			String word[] = line.split(",");
			for (int i = 0; i < word.length; i++)
    			word[i] = word[i].trim();

			if(word[3].equals("Car")){
				Vehicle myv = new Car(word[0],word[1],word[2]);
				// System.out.println("idhar");
				list.add(myv);
			}	
			else if(word[3].equals("Truck")){
				Vehicle myv = new Truck(word[0],word[1],word[2]);
				list.add(myv);
			}
		}
		read.close();

		myobj = new File(arg[1]);
		read = new Scanner(myobj);
		while(read.hasNextLine()){

			line  = read.nextLine();
			// System.out.println(list);
			String word[] = line.trim().split(",");
			for (int i = 0; i < word.length; i++)
    			word[i] = word[i].trim();

			for(Vehicle v:list){
				//System.out.println(v.getregNo());
				if(v.getregNo().equals(word[0])){
					v.setvalues(Double.parseDouble(word[1]),Double.parseDouble(word[2]),Double.parseDouble(word[3]));
				}
			}
		}

		myobj = new File(arg[2]);
		read = new Scanner(myobj);
		while(read.hasNextLine()){
			line  = read.nextLine();
			String word[] = line.split(" ");
			for (int i = 0; i < word.length; i++)
    			word[i] = word[i].trim();

			boolean k = true;

			for(Vehicle v:list){
				if(v.getregNo().equals(word[0])){
					v.checkPollutionStatus();
					System.out.println(v.getpollutionStatus());
					k = false;
				}
			}

			if(k){
				System.out.println("NOT REGISTERED");
			}
		}
	}
	catch(FileNotFoundException e){
		System.out.println("Error: File not found");
	}

	}
}