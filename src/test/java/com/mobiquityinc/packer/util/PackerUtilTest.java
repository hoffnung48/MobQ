package com.mobiquityinc.packer.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PackerUtilTest {

	private PackerUtil packer = new PackerUtil();
	
	@Test
	public void getPackageNoValues() {
		
		Float[][] values = new Float[1][3];
		values[0][0] = 1f;
		values[0][1] = 15.3f;
		values[0][2] = 34f;
		
		String max = packer.getPackage(8f,values);
		
		assertNotNull(max);
		assertTrue(max.isEmpty());
	}
	
	@Test
	public void getPackageOneValue() {
		
		Float[][] values = new Float[6][3];
		values[0][0] = 1f;
		values[0][1] = 53.38f;
		values[0][2] = 45f;
		
		values[1][0] = 2f;
		values[1][1] = 88.62f;
		values[1][2] = 98f;
		
		values[2][0] = 3f;
		values[2][1] = 78.48f;
		values[2][2] = 3f;
		
		values[3][0] = 4f;
		values[3][1] = 72.30f;
		values[3][2] = 76f;
		
		values[4][0] = 5f;
		values[4][1] = 30.18f;
		values[4][2] = 9f;
		
		values[5][0] = 6f;
		values[5][1] = 46.34f;
		values[5][2] = 48f;
		
		String max = packer.getPackage(81f,values);
		
		assertNotNull(max);
		assertTrue(max.equals("4"));
	}
	
	@Test
	public void getPackageTwoValue() {
		
		/*
		75 : (1,85.31,€29) (2,14.55,€74) (3,3.98,€16) (4,26.24,€55) (5,63.69,€52) 
		(6,76.25,€75) (7,60.02,€74) (8,93.18,€35) (9,89.95,€78)
		56 : (1,90.72,€13) (2,33.80,€40) (3,43.15,€10) (4,37.97,€16) (5,46.81,€36) 
		(6,48.77,€79) (7,81.80,€45) (8,19.36,€79) (9,6.76,€64)*/
		
		Float[][] values = new Float[9][3];
		values[0][0] = 1f;
		values[0][1] = 85.31f;
		values[0][2] = 29f;
		
		values[1][0] = 2f;
		values[1][1] = 14.55f;
		values[1][2] = 74f;
		
		values[2][0] = 3f;
		values[2][1] = 3.98f;
		values[2][2] = 16f;
		
		values[3][0] = 4f;
		values[3][1] = 26.24f;
		values[3][2] = 55f;
		
		values[4][0] = 5f;
		values[4][1] = 63.69f;
		values[4][2] = 52f;
		
		values[5][0] = 6f;
		values[5][1] = 76.25f;
		values[5][2] = 75f;
		
		values[6][0] = 7f;
		values[6][1] = 60.02f;
		values[6][2] = 74f;
		
		values[7][0] = 8f;
		values[7][1] = 93.18f;
		values[7][2] = 35f;
		
		values[8][0] = 9f;
		values[8][1] = 89.95f;
		values[8][2] = 78f;
		
		String max = packer.getPackage(75f,values);
		
		assertNotNull(max);
		assertTrue(max.equals("2,7"));
	}
	
	@Test
	public void getPackageSameMoney() {
				
		Float[][] values = new Float[9][3];
		values[0][0] = 1f;
		values[0][1] = 90.72f;
		values[0][2] = 13f;
		
		values[1][0] = 2f;
		values[1][1] = 33.80f;
		values[1][2] = 40f;
		
		values[2][0] = 3f;
		values[2][1] = 43.15f;
		values[2][2] = 10f;
		
		values[3][0] = 4f;
		values[3][1] = 37.97f;
		values[3][2] = 16f;
		
		values[4][0] = 5f;
		values[4][1] = 46.81f;
		values[4][2] = 36f;
		
		values[5][0] = 6f;
		values[5][1] = 48.77f;
		values[5][2] = 79f;
		
		values[6][0] = 7f;
		values[6][1] = 81.80f;
		values[6][2] = 45f;
		
		values[7][0] = 8f;
		values[7][1] = 19.36f;
		values[7][2] = 79f;
		
		values[8][0] = 9f;
		values[8][1] = 6.76f;
		values[8][2] = 74f;
		
		String max = packer.getPackage(56f,values);
		
		assertNotNull(max);
		assertTrue(max.equals("8,9"));
	}
}
