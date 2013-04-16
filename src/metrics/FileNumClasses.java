package metrics;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class FileNumClasses {

    private Util util = new Util();
    private String line;
    private int num = 0;
    private BufferedReader br;
    private String[] patterns = {"for", "while", "switch", "if", "catch"};

    public String getNameConstructs(String filename) {
        File f = new File(filename);
        String[] namefile = f.getName().split(".java");
        return namefile[0];
    }

    public boolean isConditionType(String line) {
        for (String pattern : patterns) {
            if (line.contains(pattern)) {
                return true;
            }
        }
        return false;
    }

    public boolean isFunction(String line) {
        if (!isConditionType(line)) {
            if (line.contains("{") && line.contains("(")) {
                return true;
            }
            return false;
        }
        return false;

    }

    public String getNameMethod(String line) {
        String name = "";
  
        boolean flag = false;
        if (isFunction(line)) {
            int i = line.length() - 1;
            while (i >= 0) {
                if (line.charAt(i) == '(') {
                    i--;
                   flag = true;
                }
                if(flag == true){
                    name = name.concat(Character.toString(line.charAt(i)));
                }
                if(line.charAt(i) == ' '){
                    flag = false;
                }
                i--;
            }
        }
        StringBuilder names=new StringBuilder(name);
        return names.reverse().toString();
    }
    
    //ksdksjdkssdsc
    

    public String[] getWords(String line) {
        String[] words = line.split(" ");
        for (String word : words) {
            System.out.println(word);
        }
        return words;
    }

    public int numLinesEffectives(String file) throws IOException {
        num = 0;
        br = util.getBufferTextLines(file);
        while ((line = br.readLine()) != null) {
            if (!line.trim().equals("")) {
                num++;
            }
        }
        return num;
    }

    public int numLines(String file) throws IOException {
        num = 0;
        br = util.getBufferTextLines(file);
        while ((line = br.readLine()) != null) {
            num++;
        }
        return num;
    }

    public int getFunctions(String file) throws IOException {
        num = 0;
        br = util.getBufferTextLines(file);
        while ((line = br.readLine()) != null) {
            num = countLines(file, num);
        }
        return num;
    }

    private int countLines(String file, int num) {
        if (isFunction(line)) {

            System.out.println(getNameMethod(line));
            num++;
        }
        return num;
    }
}
