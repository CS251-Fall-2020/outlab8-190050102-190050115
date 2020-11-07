/*
DO NOT MODIFY THE CODE STUB
NO NEED TO DEFINE main()
*/

import java.util.*;

class StreamingApp
{
	public static Map<String, ArrayList<String> > getFavouriteGenres(Map<String, ArrayList<String> > userMovies, Map<String, ArrayList<String> > movieGenres)
	{
		Map<String, String> genre = new HashMap<String, String>();
		Map<String, ArrayList<String>> temp = new HashMap<String, ArrayList<String>>();
		Iterator<Map.Entry<String, ArrayList<String>>> itr = movieGenres.entrySet().iterator(); 
          
        while(itr.hasNext()){
			Map.Entry<String, ArrayList<String>> entry = itr.next();
			for(int i=0; i<entry.getValue().size(); i++){
				genre.put(entry.getValue().get(i), entry.getKey());
			}
		}

		System.out.println(genre);
		// System.out.println(genre.get("The Conjuring"));

		itr = userMovies.entrySet().iterator();
		while(itr.hasNext()){
			Map.Entry<String, ArrayList<String>> entry = itr.next();
			ArrayList <String> mov = new ArrayList<String>();
			temp.put(entry.getKey(), mov);
			for(int i=0; i<entry.getValue().size(); i++){
				System.out.println(entry.getValue().get(i));
				System.out.println(genre.get(entry.getValue().get(i)));
				temp.get(entry.getKey()).add(genre.get(entry.getValue().get(i)));
			}
		}
		

		return temp;
	}

	public static void main(String Args[]) throws Exception {
		Map<String, ArrayList<String>> userMovies = new HashMap<String, ArrayList<String>>();
		Map<String, ArrayList<String>> movieGenres = new HashMap<String, ArrayList<String>>();

		ArrayList  <String> mov = new ArrayList<String>( Arrays.asList("The Conjuring", "Shoah", "The Purge", "13th", "The Dictator") );
		userMovies.put("David", mov);
		mov = new ArrayList<String>(Arrays.asList("The Matrix", "Captain America: Civil War", "John Wick") );
		userMovies.put("Emma", mov);

		mov = new ArrayList<String>(Arrays.asList("The Conjuring", "The Purge") );
		movieGenres.put("Horror", mov);
		mov = new ArrayList<String>(Arrays.asList("john Wick") );
		movieGenres.put("Action", mov);
		mov = new ArrayList<String>(Arrays.asList("Shoah", "13th") );
		movieGenres.put("Documentary", mov);
		mov = new ArrayList<String>(Arrays.asList("The Matrix", "Captain America: Civil War") );
		movieGenres.put("Science Fiction", mov);
		mov = new ArrayList<String>(Arrays.asList("The Dictator") );
		movieGenres.put("Comedy", mov);

		
		System.out.println(getFavouriteGenres(userMovies, movieGenres));
	}
}