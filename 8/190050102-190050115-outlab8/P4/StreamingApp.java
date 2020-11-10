/*
DO NOT MODIFY THE CODE STUB
NO NEED TO DEFINE main()
*/

import java.util.*;

class StreamingApp
{
	public static Map<String, ArrayList<String> > getFavouriteGenres(Map<String, ArrayList<String> > userMovies, Map<String, ArrayList<String> > movieGenres)
	{
		
		// WRITE YOUR CODE HERE
		Map<String,String> genremov = new HashMap<String,String>();
		for(Map.Entry< String,ArrayList<String> > mg:movieGenres.entrySet()){
			ArrayList<String> k = mg.getValue();
			for(String mov:k){
				genremov.put(mov,mg.getKey());
			}
		}

		//System.out.println(Arrays.asList(genremov));


		Map< String,ArrayList<String> > usergenre = new HashMap< String,ArrayList<String> >();

		for(Map.Entry< String,ArrayList<String> > um:userMovies.entrySet()){
			ArrayList<String> k = um.getValue();
			ArrayList<String> p = new ArrayList<String>();

			Map<String,Integer> cval = new HashMap<String,Integer>();

			Integer maxval =0;

			for(String mov:k){
				cval.merge(genremov.get(mov),1,Integer::sum);
				if(maxval < cval.get(genremov.get(mov))){
					maxval = cval.get(genremov.get(mov));
				}
			}
			// System.out.println("----");
			//System.out.println(Arrays.asList(cval));
			//Integer maxval = Collections.max(cval.values());

			for(Map.Entry< String,Integer > cv:cval.entrySet()){
				if(cv.getValue() == maxval){
					p.add(cv.getKey());
				}
			}

			usergenre.put(um.getKey(),p);
		}

		return usergenre; 

	}

	
}