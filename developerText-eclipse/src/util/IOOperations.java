package util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileSystemUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOCase;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.comparator.NameFileComparator;
import org.apache.commons.io.comparator.SizeFileComparator;
import org.apache.commons.io.input.TeeInputStream;
import org.apache.commons.io.input.XmlStreamReader;
import org.apache.commons.io.output.TeeOutputStream;

public class IOOperations {

    public static void main(String[] args) throws IOException {
        UtilityExample.runExample();

        InputExample.runExample();

        OutputExample.runExample();

        ComparatorExample.runExample();
    }
    
    public static void Utility(String EXAMPLE_TXT_PATH, String PARENT_DIR) throws IOException{
        
        System.out.println("Utility Classes example...");

        // FilenameUtils

        System.out.println("Full path of exampleTxt: " +
                FilenameUtils.getFullPath(EXAMPLE_TXT_PATH));

        System.out.println("Full name of exampleTxt: " +
                FilenameUtils.getName(EXAMPLE_TXT_PATH));

        System.out.println("Extension of exampleTxt: " +
                FilenameUtils.getExtension(EXAMPLE_TXT_PATH));

        System.out.println("Base name of exampleTxt: " +
                FilenameUtils.getBaseName(EXAMPLE_TXT_PATH));

        // FileUtils

        File exampleFile = FileUtils.getFile(EXAMPLE_TXT_PATH);
        LineIterator iter = FileUtils.lineIterator(exampleFile);

        System.out.println("Contents of exampleTxt...");
        while (iter.hasNext()) {
            System.out.println("t" + iter.next());
        }
        iter.close();

        File parent = FileUtils.getFile(PARENT_DIR);
        System.out.println("Parent directory contains exampleTxt file: " +
                FileUtils.directoryContains(parent, exampleFile));

        // IOCase

        final String str1 = "This is a new String.";
        final String str2 = "This is another new String, yes!";

        System.out.println("Ends with string (case sensitive): " +
                IOCase.SENSITIVE.checkEndsWith(str1, "string."));
        System.out.println("Ends with string (case insensitive): " +
                IOCase.INSENSITIVE.checkEndsWith(str1, "string."));

        System.out.println("String equality: " +
                IOCase.SENSITIVE.checkEquals(str1, str2));

        // FileSystemUtils
        System.out.println("Free disk space (in KB): " + FileSystemUtils.freeSpaceKb("C:"));
        System.out.println("Free disk space (in MB): " + FileSystemUtils.freeSpaceKb("C:") / 1024);
    }
    
    public static void Input(String XML_PATH, String INPUT) throws IOException{
    	
        System.out.println("Input example...");
        XmlStreamReader xmlReader = null;
        TeeInputStream tee = null;
        
        try {

        // XmlStreamReader

        File xml = FileUtils.getFile(XML_PATH);

        xmlReader = new XmlStreamReader(xml);
        System.out.println("XML encoding: " + xmlReader.getEncoding());

        // TeeInputStream

        ByteArrayInputStream in = new ByteArrayInputStream(INPUT.getBytes("US-ASCII"));
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        tee = new TeeInputStream(in, out, true);
        tee.read(new byte[INPUT.length()]);

        System.out.println("Output stream: " + out.toString());
        } catch (IOException e) {
        	e.printStackTrace();
        } finally {
        	try { xmlReader.close(); }
        	catch (IOException e) { e.printStackTrace(); }

        	try { tee.close(); }
        	catch (IOException e) { e.printStackTrace(); }
        }
    }
    
    public static void Output(String INPUT) throws IOException{
    	//final String INPUT = "This should go to the output.";
    	
        System.out.println("Output example...");
        TeeInputStream teeIn = null;
        TeeOutputStream teeOut = null;

        try {

            // TeeOutputStream

            ByteArrayInputStream in = new ByteArrayInputStream(INPUT.getBytes("US-ASCII"));
            ByteArrayOutputStream out1 = new ByteArrayOutputStream();
            ByteArrayOutputStream out2 = new ByteArrayOutputStream();

            teeOut = new TeeOutputStream(out1, out2);
            teeIn = new TeeInputStream(in, teeOut, true);
            teeIn.read(new byte[INPUT.length()]);

            System.out.println("Output stream 1: " + out1.toString());
            System.out.println("Output stream 2: " + out2.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert teeIn != null;
                teeIn.close(); }
            catch (IOException e) { e.printStackTrace(); }
        }
    }
    
    public static boolean Comparator(File file1, File file2) throws IOException{
    	//return 0 if the first file's lastmodified date/time is less than the second, 
    	//zero if the lastmodified date/time are the same and 1 if the first files 
    	//lastmodified date/time is greater than the second file.
        
        System.out.println("Comparator example...");
        
        LastModifiedFileComparator lastModified = new LastModifiedFileComparator();
        
        if (lastModified.compare(file1, file2) < 0) {//There is the error if (lastModified.compare(file1, file2) > 0)
            return true;
        } else {

            return false;
        }
    }
    
    public static void printComparator(String FILE_1, String FILE_2) throws IOException{   	
        File file1 = FileUtils.getFile(FILE_1);
        File file2 = FileUtils.getFile(FILE_2);
        
    	if(Comparator(file1, file2)) {
    		System.out.println("File " + file1.getName() + " was modified last because...");
            System.out.println("t"+ file1.getName() + " last modified on: " + new Date(file1.lastModified()));
            System.out.println("t"+ file2.getName() + " last modified on: " + new Date(file2.lastModified()));
    	} else {
    		System.out.println("File " + file2.getName() + " was modified last because...");
            System.out.println("t"+ file1.getName() + " last modified on: " + new Date(file1.lastModified()));
            System.out.println("t"+ file2.getName() + " last modified on: " + new Date(file2.lastModified()));
    	}
    }
}
