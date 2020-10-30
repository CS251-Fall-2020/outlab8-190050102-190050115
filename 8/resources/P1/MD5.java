import java.io.*;
import java.util.Scanner; 
import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 

// Java program to calculate MD5 hash value 
public class MD5 { 
	public static String getMd5(String input) 
	{ 
		try { 

			// Static getInstance method is called with hashing MD5 
			MessageDigest md = MessageDigest.getInstance("MD5"); 

			// digest() method is called to calculate message digest 
			// of an input digest() return array of byte 
			byte[] messageDigest = md.digest(input.getBytes()); 

			// Convert byte array into signum representation 
			BigInteger no = new BigInteger(1, messageDigest); 

			// Convert message digest into hex value 
			String hashtext = no.toString(16); 
			while (hashtext.length() < 32) { 
				hashtext = "0" + hashtext; 
			} 
			return hashtext; 
		} 

		// For specifying wrong message digest algorithms 
		catch (NoSuchAlgorithmException e) { 
			throw new RuntimeException(e); 
		}
	}

	// Driver code 
	public static void main(String args[]) throws Exception
	{ 
        Scanner read = new Scanner (new File("MD5sums"));
        read.useDelimiter("\n");
        String line;

        while (read.hasNext())
        {
            line = read.nextLine();
            String words[] = line.split("\t-\t");
            if(getMd5(words[0]).equals(words[1])){
                System.out.println("verified");
            }else{
                System.out.println("not verified");
            }
        }
        read.close();
    } 
}

