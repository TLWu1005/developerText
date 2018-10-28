package JustTest;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class TestFileUtils {
    public static void main(String[] args) {
        File file=new File("text.txt");
        File filex=new File("text_new.txt");
        try {
            String input=FileUtils.readFileToString(file, "UTF-8");
            System.out.println(input);
            FileUtils.copyFile(file, filex);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
