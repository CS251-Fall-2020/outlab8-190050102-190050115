package readwrite;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class ReaderWriter implements Runnable {
    ArrayList<Integer> inp;
    ProtectedTree ptree;
    boolean isWriter;
    int idx;

    public ReaderWriter(String _FILENAME, ProtectedTree _ptree, boolean _isWriter){
        ptree = _ptree;
        isWriter = _isWriter;
        inp = new ArrayList<Integer>();
        idx = 0;
        
        File myfile = new File(_FILENAME);
        Scanner sc;
        try {
            sc = new Scanner(myfile);
            while (sc.hasNextLine()){
                String data = sc.nextLine();
                inp.add(Integer.parseInt(data));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        for(int idx=0; idx<inp.size(); idx++){
            if(isWriter == true){
                try{
                    ptree.write(inp.get(idx));
                } catch (Exception ex){
                    System.out.println("Exception" + ex);
                }
            }else{
                try{
                    ptree.read(inp.get(idx));
                } catch (Exception ex){
                    System.out.println("Exception" + ex);
                }
            }
        }
    }

}