package metrics;

import java.io.BufferedReader;
import java.io.IOException;

public class FileNumClasses {

    private FileConstructsParams fileconstruct = new FileConstructsParams();
    private String[] listWords;
    private Util util = new Util();
    private String line;

    public boolean isFunction(String line, String path) {
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
