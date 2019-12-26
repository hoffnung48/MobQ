package com.mobiquityinc.packer.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.mobiquityinc.exception.APIException;

import jdk.Exported;

@RunWith(MockitoJUnitRunner.class)
public class FileReaderTest {

	private FileReader reader = new FileReader();
	
	@Test
	public void readFile(){
		HashMap<Float, Float[][]> result = reader.readFile("src/test/resources/testFile.txt");
		
		assertNotNull(result);
		assertEquals(4, result.size());
	}
	
	@Test(expected = APIException.class )
	public void readFileBadPath(){
		reader.readFile("/test/resources/testFile.txt");
	}

}
