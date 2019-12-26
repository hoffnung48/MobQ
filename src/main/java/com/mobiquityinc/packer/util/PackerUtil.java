package com.mobiquityinc.packer.util;

public class PackerUtil {

	public String getPackage(Float weight, Float[][] packages) {
		
		String val = "x";
		String max = ""; 
		while (!val.isEmpty()) {
			val = val.replace(",","");
			weight = max.isEmpty() ? weight : weight - packages[Integer.valueOf(val)-1][1];
			val = getMaxValuePackage(weight, packages);
			max += val; 
		}
		
		return max.isEmpty() ? "" : max.substring(0,max.length()-1);
	}
	
	private String getMaxValuePackage(Float weight,Float[][] packages) {
		
		Float[] aux = {0f,0f,0f};
		
		for(Float[] val : packages ) {	
			if(val[1] < weight && val[2] > aux[2]) {
				aux = val;
			}else if(val[1] < weight && Float.compare(val[2],aux[2]) == 0) {
				aux = val[1] < aux[1] ? val : aux;
			}
		}		
		
		if(aux[0] != 0f) {
		  packages[Math.round(aux[0] -1)][2] = 0f;
		  return Math.round(aux[0]) + ",";
		}else{
			return "";
		}
	}

	
}
