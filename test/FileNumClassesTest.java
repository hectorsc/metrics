
import java.io.IOException;
import metrics.FileNumClasses;
import org.junit.Test;

public class FileNumClassesTest {

    @Test
    public void testNumClasses() throws IOException {
        FileNumClasses file = new FileNumClasses();
        int num = file.getFileClass("/Users/gloriav/NetBeansProjects/Tree/src/evaluator/calculator/constants/constant.java");
        System.out.println("Numero de clases del fichero: " + num);

    }

    @Test
    public void testNumFunctions() throws IOException {
        FileNumClasses file = new FileNumClasses();
        int num = file.getFunctions("/Users/gloriav/NetBeansProjects/Tree/src/evaluator/calculator/constants/constant.java");
        System.out.println("Numero de funciones del fichero: " + num);

    }

    @Test
    public void testNumImports() throws IOException {
        FileNumClasses file = new FileNumClasses();
        int num = file.getFileImports("/Users/gloriav/NetBeansProjects/Tree/src/evaluator/calculator/constants/constant.java");
        System.out.println("Numero de imports del fichero: " + num);

    }
}
