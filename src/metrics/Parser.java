package metrics;

import java.io.File;

public class Parser {
    public static void main(String[] args) {
        NumsFiles filenumclass = new NumsFiles();
        //File f = new File("/Users/gloriav/NetBeansProjects/Tree");
        File f = new File("D:\\JAD\\Docs\\Proyectos\\JAVA\\NetBeans\\PractHPS");
        int num = filenumclass.listNumFiles(f, 0);
        System.out.println(num);
    }
}
