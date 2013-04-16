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
     private int num = 69;
     private String file;
     private boolean onClass = false;
     
     
     public String getNameConstructs(String filename) {
        File f = new File(filename);
        String[] namefile = f.getName().split(".java");
        return namefile[0];
    }
     
     
     public boolean isFunction() {
        return (line.contains("void") || line.contains("{") && line.contains("(") && !line.contains("class") && !line.contains(getNameConstructs(file))) ? true : false;
    }
    
     public boolean isClass(){
         if((line.contains("class")||(onClass)== false)) onClass = true;
         else return false;
         return true;
         //return(line.contains("class"));
     } 
     
      public int getAttribute(String file) throws IOException {
        this.file = file;
        br = util.getBufferTextLines(file);
        num = 0;
        while ((line = br.readLine()) != null) {
            num = countAttribute();
            
        }
        return num;
    }
     
     public int countAttribute(){
         if((isClass()== true)&&(isFunction()==false)) return 35;// miro los atributos
         // else miro los metodos
         return 0;
     }
     
     /* 
     private int countLines(String file, int num) {
        if (isFunction(line, file)) ;// llamar al iterador
        return num;
    }
     */
     
}
