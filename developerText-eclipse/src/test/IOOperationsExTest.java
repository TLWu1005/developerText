package test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import util.IOOperationsEx;

public class IOOperationsExTest {
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testprintComparator() throws IOException{
        String FILE_1 =
                "C:\\Users\\Œ‚ÃÏ¡ÿ\\Desktop\\workspace\\developerText-eclipse\\example\\text";

        String FILE_2 =
                "C:\\Users\\Œ‚ÃÏ¡ÿ\\Desktop\\workspace\\developerText-eclipse\\example\\text.txt";
        
        IOOperationsEx.printComparator(FILE_1, FILE_2);
	}

}
