import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner; 
import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException;
import java.util.*; 

public class GUI{
	static File globf;

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

	public static void main(String[] args){
		JFrame f = new JFrame();
		JButton b = new JButton("Select File");
		b.setBounds(130,100,100,40);
		JButton p = new JButton("Process");
		p.setBounds(130,200,100,40);
		
	
		//final File globf;
		
		final List <String> ans=new ArrayList<String>();
		final List <String> que= new ArrayList<String>();

		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JFileChooser jfc = new JFileChooser(".");

        		int returnValue = jfc.showOpenDialog(null);
        

		        if (returnValue == JFileChooser.APPROVE_OPTION) {
		            final File selectedFile = jfc.getSelectedFile();
		            globf = selectedFile;
		            System.out.println(selectedFile.getAbsolutePath());
		        }
			}
		});

		p.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					Scanner read = new Scanner (globf);
				

        		read.useDelimiter("\n");
        		String line;
        		while (read.hasNext())
		        {
		            line = read.nextLine();
		            String words[] = line.split("\t-\t");
		            if(getMd5(words[0]).equals(words[1])){
		           		que.add(words[0]);
		                ans.add("verified");
		            }else{
		            	que.add(words[0]);
		                ans.add("not verified");
		            }
		        }
		        read.close();

		        int size = que.size();

		        String[][] data = new String[size][2];

		        for(int i=0;i<size;i++){
		        	data[i][0] = que.get(i);
		        	data[i][1] = ans.get(i);
		        }

		        JFrame f1 = new JFrame();
		        f1.setTitle("Table");



		        JTable t;
		        

				String[] col = {"Plain-text","Result"};
				t = new JTable(data,col);
				t.setBounds(30,40,200,300);

				JScrollPane sp = new JScrollPane(t);
				f1.add(sp);
				f1.setSize(500,200);
				f1.setVisible(true);

				}
				catch (FileNotFoundException e1) { 
					System.out.println("ERROR");
				}


			}
		});



		f.add(b);
		f.add(p);

		f.setSize(400,500);
		f.setLayout(null);
		f.setVisible(true); 
	}
}