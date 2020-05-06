package translators;

import core.Trifid_Cipher;
import key.Key;

public class Decrypter extends Trifid_Cipher{

	private static Key key;
	
	public static boolean decrypt(String message) {
		if(message == null || message.isEmpty()) return false;
		try {
			key = new Key();
			
			int[][] chart = quickChart(message.toLowerCase());
			
			MESSAGE = chartToDecrypted(chart);
			
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private static String chartToDecrypted(int[][] chart) {
		String final_ = "";
		for(int i = 0; i < chart[0].length; i++) {
			String temp = "";
			for(int j = 0; j < chart.length; j++) {
				temp += chart[j][i];
			}
			String temp1 = "";
			temp1 += key.getKeyByValue(temp);
			final_ += temp1.charAt(1);
		}
		return final_;
	}
	
	private static int[][] quickChart(String str) {
		String temp = "";
		for(char c : str.toCharArray()) {
			temp+=key.getValueByKey(c);
		}
		String[] numChart = new String[3];
		numChart[0] = temp.substring(0, temp.length() / 3);
		numChart[1] = temp.substring(temp.length() / 3, 2 * (temp.length() / 3));
		numChart[2] = temp.substring(2 * (temp.length() / 3));
		
		char[][] quick = new char[3][numChart[0].length()];
		for(int i = 0; i < quick.length; i++) {
			quick[i] = numChart[i].toCharArray();
		}
		
		int[][] fullChart = new int[3][numChart[0].length()];
		for(int i = 0; i < fullChart.length; i++) {
			for(int j = 0; j < fullChart[0].length; j++) {
				fullChart[i][j] = quick[i][j] - (int)'0';
			}
		}
		
		return fullChart;
	}
	
}
