package util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.comparator.LastModifiedFileComparator;

public class IOOperationsEx extends IOOperations{
    public static boolean Comparator(File file1, File file2) throws IOException{
        
        System.out.println("Comparator example...ex");
        
        LastModifiedFileComparator lastModified = new LastModifiedFileComparator();
        int x = lastModified.compare(file1, file2);
        boolean b;
        
        if (lastModified.compare(file1, file2) < 0) {//There is the error if (lastModified.compare(file1, file2) > 0)           
        	b = true;
        } else {
            b = false;
        }
        
        if(x > 0 && b == true) {
        	System.out.println("printComparator÷–≈–∂œ’˝»∑");
        } else {
        	System.out.println("printComparator≈–∂œ¥ÌŒÛ");
        }
        return b;
    }
}
