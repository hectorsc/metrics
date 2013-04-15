package metrics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileNumClasses {

    private String[] listWords;

    public int getFileClass(String file) throws IOException {
        int num = 0;
        BufferedReader br = getBufferTextLines(file);
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
        BufferedReader br = getBufferTextLines(file);
        String linea;
        while ((linea = br.readLine()) != null) {
            if (linea.contains("import")) {
                num++;
            }
        }
        return num;
    }

    public String[] getWords(String line) {
        String[] words = line.split(" ");//[pal1,pal2,pal3]
        return words;
    }

    public boolean isFunction(String line) {
        listWords = getWords(line);
        if (listWords.length != 0) {
            if (line.contains("public") || line.contains("private") || line.contains("protected") && line.contains("{")) {
                return true;
            }
            return false;
        }
        return false;
    }

    public BufferedReader getBufferTextLines(String file) throws IOException {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        archivo = new File(file);
        fr = new FileReader(archivo);
        br = new BufferedReader(fr);
        return br;
    }

    public int getFunctions(String file) throws IOException {
        int num = 0;
        BufferedReader br = getBufferTextLines(file);
        String linea;
        while ((linea = br.readLine()) != null) {
            if (isFunction(linea)) {
                num++;
            }
        }
        return num;
    }
}
