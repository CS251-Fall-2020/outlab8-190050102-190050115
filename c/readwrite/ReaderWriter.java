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
        if(idx < inp.size()){
            if(isWriter){
                try{
                    ptree.write(inp.get(idx));
                } catch (Exception ex){
                    System.out.println(ex);
                }
            }else{
                try{
                    ptree.read(inp.get(idx));
                } catch (Exception ex){
                    System.out.println(ex);
                }
            }
            idx++;
        }
    }

}