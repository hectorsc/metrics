/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metrics;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author usuario
 */
public class NumberAttribute {
     private Util util = new Util();
     private BufferedReader br;
     private String line;
     private int num = 0;
     
     public String getNameConstructs(String filename) {
        File f = new File(filename);
        String[] namefile = f.getName().split(".java");
        return namefile[0];
    }
     
     public boolean isFunction(String line, String path) {
        return (line.contains("void") || line.contains("{") && line.contains("(") && !line.contains("class") && !line.contains(getNameConstructs(path))) ? true : false;
    }
     public boolean isClass(){
         return(line.contains("class"));
     } 
     
     public int getFunctions(String file) throws IOException {
        br = util.getBufferTextLines(file);
        while ((line = br.readLine()) != null) {
            num = countLines(file, num);
        }
        return num;
    } 
     
      public int getAttribute(String file) throws IOException {
        br = util.getBufferTextLines(file);
        while ((line = br.readLine()) != null) {
            countAttribute();
        }
        return num;
    }
     
     public void countAttribute(){
         if(isClass()== true) ;
     }
     private int countLines(String file, int num) {
        if (isFunction(line, file)) {
            num++;
        }
        return num;
    }
}
