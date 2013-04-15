package metrics;

import java.io.BufferedReader;
import java.io.IOException;

public class FileNumClasses {

        private String[] listWords;
    private Util util = new Util();
    private String line;

    public int getFileClass(String file) throws IOException {
        int num = 0;
        BufferedReader br = util.getBufferTextLines(file);
        while ((line = br.readLine()) != null) {
            if (line.contains("class")) {
                num++;
            }
        }
        return num;
    }

    public boolean isFunction(String line) {
        listWords = util.getWords(line);
        if (listWords.length != 0) {
            if (line.contains("public") || line.contains("private") || line.contains("protected") && line.contains("{")) {
                return true;
            }
            return false;
        }
        return false;
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
            if (isFunction(line)) {
                num++;
            }
        }
        return num;
    }
}
