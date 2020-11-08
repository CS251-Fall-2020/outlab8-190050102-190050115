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

			Integer maxval = 0;

			for(String mov:k){
				cval.merge(genremov.get(mov),1,Integer::sum);
				// System.out.println(cval.get(genremov).get(mov));
				if(maxval < cval.get(genremov.get(mov))){
					maxval = cval.get(genremov.get(mov));
				}
			}

			for(Map.Entry< String,Integer > cv:cval.entrySet()){
				if(cv.getValue() == maxval){
					p.add(cv.getKey());
				}
			}

			usergenre.put(um.getKey(),p);
		}

		return usergenre; 

	}

	// public static void main(String[] args){
	// 		Map<String,ArrayList<String> > usermov = new HashMap<String,ArrayList<String>>();
	// 		Map<String,ArrayList<String> > movgen = new HashMap<String,ArrayList<String>>();

	// 		ArrayList<String> all = new ArrayList<String>();
	// 		ArrayList<String> alli = new ArrayList<String>();
	// 		all.add("The conjuring");
	// 		all.add("Shoah");
	// 		all.add("The Purge");
	// 		all.add("13th");
	// 		all.add("The Dictator");

	// 		// System.out.println(all);
	// 		usermov.put("David",all);
	// 		// System.out.println(Arrays.asList(usermov));


	// 		ArrayList<String> allo = new ArrayList<String>();
	// 		allo.add("The Matrix");
	// 		allo.add("Captain America: Civil War");
	// 		allo.add("John Wick");

	// 		usermov.put("Emma",allo);

			

	// 		//System.out.println(Arrays.asList(usermov));


	// 		alli.add("The conjuring");
	// 		alli.add("The Purge");

	// 		movgen.put("Horror",alli);

	// 		// System.out.println(Arrays.asList(usermov));
	// 		ArrayList<String> allq = new ArrayList<String>();

	// 		allq.add("John Wick");
	// 		movgen.put("Action",allq);

			

	// 		ArrayList<String> allw = new ArrayList<String>();
	// 		allw.add("Shoah");
	// 		allw.add("13th");
	// 		movgen.put("Documentary",allw);

	// 		ArrayList<String> alle = new ArrayList<String>();
	// 		alle.add("The Matrix");
	// 		alle.add("Captain America: Civil War");
	// 		movgen.put("Science Fiction",alle);

	// 		ArrayList<String> allr = new ArrayList<String>();

	// 		allr.add("The Dictator");
	// 		movgen.put("Comedy",allr);


	// 		// System.out.println(Arrays.asList(movgen));

	// 		Map<String,ArrayList<String> > usergen = new HashMap<String,ArrayList<String>>();

	// 		usergen = getFavouriteGenres(usermov,movgen);

	// 		System.out.println(Arrays.asList(usergen));

	// 		// for(Map.Entry< String,ArrayList<String> > mg:usergen.entrySet()){
	// 		// 	ArrayList<String> k = mg.getValue();
	// 		// 	System.out.println(mg.getKey());

	// 		// 	for(String mov:k){
	// 		// 		System.out.println(mov);			
	// 		// 	}

	// 		// 	System.out.println("-------");
	// 		// }



	// }
}