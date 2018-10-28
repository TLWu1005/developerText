package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import util.IOOperations;

public class IOOperationsTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUtility() throws IOException {
		String EXAMPLE_TXT_PATH =
                "C:\\Users\\Œ‚ÃÏ¡ÿ\\Desktop\\workspace\\developerText-eclipse\\example\\text.txt";

        String PARENT_DIR =
                "C:\\Users\\Œ‚ÃÏ¡ÿ\\Desktop\\workspace\\developerText-eclipse\\example";
        IOOperations.Utility(EXAMPLE_TXT_PATH, PARENT_DIR);
	}

	@Test
	public void testInput() throws IOException {
    	String XML_PATH =
                "C:\\Users\\Œ‚ÃÏ¡ÿ\\Desktop\\workspace\\developerText-eclipse\\example\\textXML.xml";
    	
    	String INPUT = "This should go to the output.";
    	IOOperations.Input(XML_PATH, INPUT);
	}

	@Test
	public void testOutput() throws IOException {
		String INPUT = "This should go to the output.";
		IOOperations.Output(INPUT);
	}

	@Test
	public void testComparator() throws IOException {
        String FILE_1 =
                "C:\\Users\\Œ‚ÃÏ¡ÿ\\Desktop\\workspace\\developerText-eclipse\\example\\text";

        String FILE_2 =
                "C:\\Users\\Œ‚ÃÏ¡ÿ\\Desktop\\workspace\\developerText-eclipse\\example\\text.txt";
        
        File file1 = FileUtils.getFile(FILE_1);
        File file2 = FileUtils.getFile(FILE_2);
        
        assertEquals(1,  IOOperations.Comparator(file1, file2));//error
	}

}
