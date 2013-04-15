package metrics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileNumClasses {

    private String[] listWords;
    private Util util = new Util();

    public int getFileClass(String file) throws IOException {
        int num = 0;
        BufferedReader br = util.getBufferTextLines(file);
        String linea;
        while ((linea = br.readLine()) != null) {
            if (linea.contains("class")) {
                num++;
            }
        }
        return num;
    }

    public int getFileImports(String file) throws IOException {
        int num = 0;
        BufferedReader br = util.getBufferTextLines(file);
        String linea;
        while ((linea = br.readLine()) != null) {
            if (linea.contains("import")) {
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

    public int getFunctions(String file) throws IOException {
        int num = 0;
        BufferedReader br = util.getBufferTextLines(file);
        String linea;
        while ((linea = br.readLine()) != null) {
            if (isFunction(linea)) {
                num++;
            }
        }
        return num;
    }
}
