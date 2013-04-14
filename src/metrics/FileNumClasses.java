package metrics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileNumClasses {
    
    private int josejuan;

    public int getFileClass(String file) throws IOException {
        int num = 0;
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
            archivo = new File(file);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            CharSequence chars = "class";
            while ((linea = br.readLine()) != null) {
                if (linea.contains(chars)) {
                    num++;
                }
            }

        return num;
    }
}
