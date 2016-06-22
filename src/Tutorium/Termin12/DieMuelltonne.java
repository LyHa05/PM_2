package Tutorium.Termin12;

public class DieMuelltonne {
	public static void main(String[] args){
        try {
        	System.out.println(addE(Integer.MAX_VALUE, Integer.MAX_VALUE));}
        catch(Exception e) {
        	System.out.printf("Overflow hat statt gefunden!");
        }
        
        try {
        	System.out.println(subE(Integer.MAX_VALUE, Integer.MAX_VALUE));}
        catch(Exception e) {
        	System.out.printf("Overflow hat statt gefunden!");
        }
	}
	
	
    public static int addE(int x, int y) throws Exception {
    	return Math.addExact(x, y);
    }
    
    public static int subE(int x, int y) throws Exception {
    	return Math.subtractExact(x, y);
    }
}
