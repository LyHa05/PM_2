package Tutorium.Termin12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DieNichtSoSpecialMuelltonne {
	
	public static int modulo(int zahl1, int zahl2){
		int ergebnis = 0;
		
		if(zahl1 < 0){
			ergebnis = (Math.abs(zahl1))%zahl2;
			return (ergebnis*(-1));
		} else{
			return zahl1%zahl2;
		}
	}
	
	public static double calculate(char op, double z1, double z2){
		
		if(op == '+' || op == '-' || op == '*' || op == '/'){
			switch (op) {
				case '+':	return (z1+z2);
				case '-':	return (z1-z2);
				case '*':	return (z1*z2);
				case '/':	return (z1/z2);
			}
		}
		
		return Double.NaN;
	}
	
	public static int findMax(int[][] matrix){
		int xLength = matrix.length;
		int yLength = matrix[0].length;
		int maxValue = 0;
		
		for(int y = 0; y < yLength; y++){
			for(int x = 0; x < xLength; x++){
				if(maxValue < matrix[y][x]){
					maxValue = matrix[y][x];
				}
			}
		}
		
		return maxValue;
	}
	
	public static int findMinProduct(Map<Integer, Integer> zahlen){
		int produkt = Integer.MAX_VALUE;
		
		for(Map.Entry<Integer, Integer> element : zahlen.entrySet()){
			if(produkt > ((element.getValue())*(element.getKey()))){
				produkt = (element.getValue())*(element.getKey());
			}
		}
		
		return produkt;
	}
	
	public static boolean anyEquals(Map<String, String> map, String needle){
		for(Map.Entry<String, String> element : map.entrySet()){
			if(needle == element.getValue() || needle == element.getKey()){
				return true;
			}
		}
		
		return false;
	}
	
	public static Map<Integer, List<Integer>> sortByModuloValue(List<Integer> zahlen, int modulo){
		Map<Integer, List<Integer>> hashMap = new HashMap<>();
		
		for(Integer element : zahlen){
			Integer tempKey = element%modulo;
			
			if(hashMap.containsKey(tempKey)){
				hashMap.get(tempKey).add(element);
			} else {
				hashMap.put(tempKey, new ArrayList<Integer>());
				hashMap.get(tempKey).add(element);
			}
		}
		
		return hashMap;
	}
}



