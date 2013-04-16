package metrics;

import java.io.IOException;

public class micosa {

    private Util util = new Util();

    public int getFors(String file) throws IOException {
        return util.getFilePattern(file, "for");
    }

    public int getIfs(String file) throws IOException {
        return util.getFilePattern(file, "if");
    }

    public int getWhiles(String file) throws IOException {
        return util.getFilePattern(file, "while");
    }

    public int getGlobals(String file) throws IOException {
        return util.getFilePattern(file, "global");
    }

    public int getSwitchs(String file) throws IOException {
        return util.getFilePattern(file, "switch");
    }
    
    public int getClass(String file) throws IOException {
        return util.getFilePattern(file, "class");
    }
}
