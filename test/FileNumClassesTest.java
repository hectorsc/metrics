
import java.io.IOException;
import org.junit.Test;
import metrics.FileNumClasses;

public class FileNumClassesTest {

    @Test
    public void testNumClasses() throws IOException {
        FileNumClasses file = new FileNumClasses();
        int num = file.getFileClass("/Users/gloriav/NetBeansProjects/Tree/src/evaluator/calculator/constants/constant.java");
        System.out.println("Numero de Clases del fichero: " + num);

    }
}
