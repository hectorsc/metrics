/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metrics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Jorge
 */
public class Util {

    public Util() {
    }

    public String[] getWords(String line) {
        String[] w = line.split(" ");//[pal1,pal2,pal3]
        String[] words = new String[w.length];
        for(int i=0;i<w.length;i++){
            if(!" ".equals(w[i])){
               words[i] = w[i];
            }
        }
        return words;
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

    public int getFilePattern(String file, String pattern) throws IOException {
        int num = 0;
        BufferedReader br = getBufferTextLines(file);
        String linea;
        while ((linea = br.readLine()) != null) {
            if (linea.contains(pattern)) {
                num++;
            }
        }
        return num;
    }
}
