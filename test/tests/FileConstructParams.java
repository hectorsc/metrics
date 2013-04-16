package tests;

import java.io.IOException;
import metrics.FileNumClasses;
import metrics.micosa;
import org.junit.Test;

public class FileConstructParams {
    micosa file = new micosa();
    @Test
    public void testNumClasses() throws IOException {
       
        int num = file.getClass("D:\\JAD\\Docs\\Proyectos\\JAVA\\NetBeans\\PractHPS\\src\\evaluator\\Calculator.java");
        System.out.println("Numero de clases del fichero: " + num);

    }

    @Test
    public void testNumFunctions() throws IOException {
         
        int num = file.getFunctions("D:\\JAD\\Docs\\Proyectos\\JAVA\\NetBeans\\PractHPS\\src\\evaluator\\Calculator.java");
        System.out.println("Numero de funciones del fichero: " + num);

    }

    @Test
    public void testNumImports() throws IOException {
     
        int num = file.getFileImports("D:\\JAD\\Docs\\Proyectos\\JAVA\\NetBeans\\PractHPS\\src\\evaluator\\Calculator.java");
        System.out.println("Numero de imports del fichero: " + num);

    }
}
