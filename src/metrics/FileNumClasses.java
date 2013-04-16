package metrics;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class FileNumClasses {

    private Util util = new Util();
    private String line;
    private int num = 0;
    private BufferedReader br;

    public String getNameConstructs(String filename) {
        File f = new File(filename);
        String[] namefile = f.getName().split(".java");
        return namefile[0];
    }

    public boolean isFunction(String line, String path) {
        return (line.contains("void") || line.contains("{") && line.contains("(") && !line.contains("class") && !line.contains(getNameConstructs(path))) ? true : false;
    }

    public boolean isLineSpaceBlank(String line) {
        for (int i = 0; i < line.length(); i++) {
            if (isCharNotBlank(line, i)) {
                return false;
            }
        }
        return true;
    }

    public int numLinesEffectives(String file) throws IOException {
        num = 0;
        br = util.getBufferTextLines(file);
        while ((line = br.readLine()) != null) {
            if(!line.trim().equals("")){
                num++;
            }
        }
        return num;
    }

    public int numLines(String file) throws IOException {
        num = 0;
        br = util.getBufferTextLines(file);
        while ((line = br.readLine()) != null) {
            num++;
        }
        return num;
    }

    public int getFunctions(String file) throws IOException {
        num = 0;
        br = util.getBufferTextLines(file);
        while ((line = br.readLine()) != null) {
            num = countLines(file, num);
        }
        return num;
    }

    private int countLines(String file, int num) {
        if (isFunction(line, file)) {
            num++;
        }
        return num;
    }

    private boolean isCharNotBlank(String line, int i) {
        return (line.charAt(i) != ' ') ? true : false;
    }
}
