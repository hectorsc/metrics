package metrics;

import java.io.BufferedReader;
import java.io.IOException;

public class FileNumClasses {

    private FileConstructsParams fileconstruct = new FileConstructsParams();
    private String[] listWords;
    private Util util = new Util();
    private String line;

    public boolean isFunction(String line, String path) {
        if (line.contains("void")) {
            return true;
        } else {
            if (line.contains("{")) {
                if (!fileconstruct.isConstruct(line, path)) {
                    if (!line.contains("class")) {
                        System.out.println(line);
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
    }

    public int numLinesEffectives(String file) throws IOException {
        int num = 0;
        BufferedReader br = util.getBufferTextLines(file);
        while ((line = br.readLine()) != null) {
            if (line.length() != 0) {
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
