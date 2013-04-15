package metrics;

import java.io.BufferedReader;
import java.io.IOException;

public class FileNumClasses {

    private String[] listWords;
    private Util util = new Util();
    private String line;

    public boolean isTypeReturn(String line) {
        switch (line) {
            case "int":
                return true;

            case "double":
                return true;

            case "boolean":
                return true;

            default:
                return false;
        }
    }

    public boolean isFunction(String line) {
        if (line.contains("void")) {
            return true;
        }
        listWords = util.getWords(line);
        if (listWords.length != 0) {
            if ("public".equals(listWords[0]) || "private".equals(listWords[0]) || "protected".equals(listWords[0])) {
                if (isTypeReturn(listWords[1])) {
                    return true;
                }
                return false;
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
