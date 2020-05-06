package translators;

import core.Trifid_Cipher;
import key.Key;

public class Encrypter extends Trifid_Cipher{

	private static Key key;
	
	public static boolean encrypt(String message) {
		if(message == null || message.isEmpty()) return false;
		key = new Key();
		
		try {
			message = cleanMessage(message);
			
			int[][] chart = toChart(message);
			String[] nums = twoD_arr_to_string(chart).split(" ");
			MESSAGE = finalMessage(nums);
			
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private static String finalMessage(String[] arr) {
		String Final = "";
		for(int i = 0; i < arr.length; i++) {
			String temp = ""; 
			temp += key.getKeyByValue(arr[i]);
			Final += temp.charAt(1);
		}
		return Final;
	}
	
	private static final String cleanMessage(String message) {
		if(message == null || message.isEmpty()) return null;
		String temp = "";
		for(char c : message.toCharArray()) {
			if ((c >= 97 && c < 123) || c == '.'){
				temp += c;
			}
		}
		return temp;
	}
	
	private static int[][] toChart(String message) {
		int[][] temp = new int[3][message.length()];
				
		for(int i = 0; i < message.length(); i++) {//gotta love nested for loops
			for(int j = 0; j < temp.length; j++) {
				temp[j][i] = Integer.parseInt(key.getValueByKey(message.charAt(i)).charAt(j) + "");
			}
		}
		
		return temp;
	}
	
	private static String twoD_arr_to_string(int[][] chart) {
		
		String temp = "";
		
		int ctr = 0;
		
		for(int i = 0; i < chart.length; i++) {
			for(int j = 0; j < chart[0].length; j++) {
				if(ctr % 3 == 0 && ctr != 0) {
					temp+=' ';
				}
				temp+=chart[i][j];
				ctr++;
			}
		}
		return temp;
	}
	
}
