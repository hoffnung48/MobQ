package com.mobiquityinc.packer;

import java.util.HashMap;
import java.util.Map.Entry;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.packer.util.FileReader;
import com.mobiquityinc.packer.util.PackerUtil;

public class Packer {

	public static String pack(String filePath) throws APIException{
		
		if(filePath == null || filePath.isEmpty()) {
			throw new APIException("path is not informed");
		}
		
		FileReader reader = new FileReader();
		HashMap<Float,Float[][]> values =  reader.readFile(filePath);
		
		PackerUtil util = new  PackerUtil();
		String result = "";
		for(Entry<Float, Float[][]> entry: values.entrySet()) {
			result += util.getPackage(entry.getKey(), entry.getValue()) + "\n";
		}
		
		return result;
	}

}
