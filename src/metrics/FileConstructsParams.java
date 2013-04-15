package metrics;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class FileConstructsParams {
    
    public FileConstructsParams(){
    }
    
    private String[] listWords;
    private Util util = new Util();
    
    public boolean isConstruct(String line, String path) {
        line.getClass();
        if (line.contains(path.concat("("))) {
            System.out.println(line.contains(path.concat("(")));
            return true;
        }
        return false;
    }
    
    public int getConstrucs(String file) throws IOException {
        int num = 0;
        BufferedReader br = util.getBufferTextLines(file);
        String linea;
        File f = new File(file);
        String[] namefile = f.getName().split(".java");
        String path = namefile[0];
        while ((linea = br.readLine()) != null) {
            if (isConstruct(linea, path)) {
                num++;
            }
        }   
        return num;
    }
    
    public boolean isParam(String line, String path) {
        line.getClass();
        listWords = util.getWords(line);
        for(String pal: listWords)
            System.out.println(pal);
        if (listWords.length != 0) {
            if (line.contains(path.concat("("))) {
                return true;
            }
            return false;
        }
        return false;
    }
    
    public int getParams(String file) throws IOException {
        int num = 0;
        BufferedReader br = util.getBufferTextLines(file);
        String linea;
        File f = new File(file);
        String[] namefile = f.getName().split(".java");
        String path = namefile[0];
        while ((linea = br.readLine()) != null) {
            if (isParam(linea, path)) {
                num++;
            }
        }   
        return num;
    }
    
}
