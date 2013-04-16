package metrics;

import java.io.File;
import java.io.IOException;

public class Parser {

    public static void main(String[] args) throws IOException {
        String path = "/Users/gloriav/NetBeansProjects/Tree/src/evaluator/calculators/CoreNumberCalculator.java";
        NumsFiles filenumclass = new NumsFiles();
        FileNumClasses fi = new FileNumClasses();
        File f = new File("/Users/gloriav/NetBeansProjects/Tree");
        //File f = new File("D:\\JAD\\Docs\\Proyectos\\JAVA\\NetBeans\\PractHPS");
        int num = filenumclass.listNumFiles(f, 0);
        int numlines = fi.numLines(path);
        int numlinesefectives = fi.numLinesEffectives(path);
        int numFunctions = fi.getFunctions(path);
        System.out.println(num);
        System.out.println("Numero lineas efectivas: " + numlinesefectives);
        System.out.println("Numero lineas: " + numlines);
        System.out.println("Numero de funciones: " + numFunctions);
    }
}
