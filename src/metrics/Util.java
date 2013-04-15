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
    
    public Util(){}
    
    public String[] getWords(String line) {
        String[] words = line.split(" ");//[pal1,pal2,pal3]
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
}
