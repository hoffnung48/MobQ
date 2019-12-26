package com.mobiquityinc.packer.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

import com.mobiquityinc.exception.APIException;

public class FileReader {

	public HashMap<Float, Float[][]> readFile(String path){
		
		BufferedReader reader;
		HashMap<Float, Float[][]> result;
		
		try {
			List<String> lines = Files.readAllLines(Paths.get(path),Charset.forName("UTF-8"));
			result = new HashMap<Float, Float[][]>();
			for(String line : lines) {
			
				result.put(Float.valueOf(line.split(":")[0].replace(" ", "")), getValues(line.split(":")[1]));
			}
		} catch (IOException e) {
			throw new APIException(e.getMessage());
		}
		
		return result;
		
	}

	private Float[][] getValues(String packages) {
		
		String[] values = packages.replace("(", "").replace(")","").replace("€", "").split(" ");
		
		Float[][] result= new Float[values.length-1][3];
		
		for(int i = 1; i < values.length; i++) {
			result[i-1][0] = Float.valueOf(values[i].split(",")[0]);
			result[i-1][1] = Float.valueOf(values[i].split(",")[1]);
			result[i-1][2] = Float.valueOf(values[i].split(",")[2]);
		}
			
		return result;
	}
}
