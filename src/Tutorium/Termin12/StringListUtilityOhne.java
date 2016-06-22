package Tutorium.Termin12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringListUtilityOhne {
	
	public static String shortestString(List<String> sList){
		String tempString = sList.get(0);
		
		for(String element : sList){
			if(tempString.length() >= element.length()){
				tempString = element;
			}
		}
		return tempString;
	}
	
	public static int longestStringLength(List<String> sList){
		int tempLength = sList.get(0).length();
		
		for(String element : sList){
			if(tempLength <= element.length()){
				tempLength = element.length();
			}
		}
		
		return tempLength;
	}
	
	public static int cumulatedlength(List<String> sList){
		int cumuLength = 0;
		
		for(String element : sList){
			cumuLength += element.length();
		}
		
		return cumuLength;
	}
	
	public static List<String> reverseAllStrings(List<String> sList){
		List<String> reverseList = new ArrayList<String>();
		
		for(String element : sList){
			reverseList.add(new StringBuilder(element).reverse().toString());
		}
		
		return reverseList;
	}
	
	public static boolean containsNumber(List<String> sList){
		
		for(String e : sList){
			String tempString = e;
			tempString = tempString.replaceAll("[^\\d.]", "");
			if(tempString.length() == e.length()){
				return true;
			}
		}
		
		return false;
	}
	
	public static Map<Integer, List<String>> groupByLength(List<String> sList){
		Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
		int i;
		
		for(String s : sList){
			i = s.length();
			
			if(!map.containsKey(1)){
				map.put(i,  new ArrayList<String>());
				
				map.get(i).add(s);
			}
		}
		
		return map;
	}
	
	private StringListUtilityOhne(){};
}
