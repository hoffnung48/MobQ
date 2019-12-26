package com.mobiquityinc.packer;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.mobiquityinc.exception.APIException;

@RunWith(MockitoJUnitRunner.class)
public class PackerTest {
	
	@Test
	public void packtest() {
		String result = Packer.pack("src/test/resources/testFile.txt");
		
		assertNotNull(result);
	}
	
	@Test(expected=APIException.class)
	public void packtestException() {
		Packer.pack("");
	}
	
	@Test(expected=APIException.class)
	public void packtestExceptionNull() {
		Packer.pack(null);
	}

}
