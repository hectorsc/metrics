package metrics;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class FileNumClasses {

    private Util util = new Util();
    private String line;

    public String getNameConstructs(String filename){
        File f = new File(filename);
        String[] namefile = f.getName().split(".java");
        return namefile[0];
    }
    
    public boolean isFunction(String line, String path) {
        if(line.contains("void") || line.contains("{") && line.contains("(") && !line.contains("class") && !line.contains(getNameConstructs(path))) return true;
        return false;
    }

    public boolean isLineSpaceBlank(String line){
        for(int i=0; i<line.length(); i++){
            if (line.charAt(i) != ' '){
                return false;
            }
        }
        return true;
    }
    
    
    public int numLinesEffectives(String file) throws IOException {
        int num = 0;
        BufferedReader br = util.getBufferTextLines(file);
        while ((line = br.readLine()) != null) {
            if (!(line.isEmpty() || "".equals(line) || " ".equals(line) || "\n".equals(line) || isLineSpaceBlank(line))) {
                num++;
            }
        }
        return num;
    }

    public int numLines(String file) throws IOException {
        int num = 0;
        BufferedReader br = util.getBufferTextLines(file);
        while ((line = br.readLine()) != null) {
            num++;
        }
        return num;
    }

    public int getFunctions(String file) throws IOException {
        int num = 0;
        BufferedReader br = util.getBufferTextLines(file);
        while ((line = br.readLine()) != null) {
            if (isFunction(line, file)) {
                num++;
            }
        }
        return num;
    }
}
