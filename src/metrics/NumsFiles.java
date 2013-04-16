package metrics;

import java.io.File;

public class NumsFiles {
    //TODO: Refactoring, Smell,Smell,...
    

  
    public static boolean extension(File dir, String extension) {
        return dir.getName().endsWith(extension);
    }
    
    public static int listNumFiles(File folder, int num) {
        if (!folder.exists()) {
            return num; //TODO:exception
        }
        File[] files = folder.listFiles();
        for (int x = 0; x < files.length; x++) {
            if (files[x].isDirectory()) {
                num = listNumFiles(files[x], num);
            }
            if (extension(files[x], ".java") ) {
                System.out.println(files[x].getName());
                num++;
            }
        }
        return num;
    }
}
