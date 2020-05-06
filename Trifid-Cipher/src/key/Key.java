package key;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Key {
	
	private Map<Character, String> chart;
	
	public Key() {
		//[layer][column][row]
		chart = new HashMap<>();
		
		int counter = 0;
		
		for(int a = 0; a < 3; a++) { // Layer
			for(int b = 0; b < 3; b++) { // Row
				for(int c = 0; c < 3; c++) { // Column
					
					if(counter == Math.pow(3, 3) - 1) {
						counter = '.' - 'a';
					}
					
					chart.put((char)((int)'a' + counter), a + "" + c + "" + b);
					counter++;
				}
			}
		}
	}
	
	public Set<Character> getKeyByValue(String nums) {
	    return chart.entrySet()
	              .stream()
	              .filter(entry -> Objects.equals(entry.getValue(), nums))
	              .map(Map.Entry::getKey)
	              .collect(Collectors.toSet());
	}
	
	public String getValueByKey(char letter) {
		return chart.get(letter);
	}
	
}

/*  -----------------------------
 * | Layer 0 | Layer 1 | Layer 2 |
 * |         |         |         |
 * |   0 1 2 |   0 1 2 |   0 1 2 |
 * | 0 a b c | 0 j k l | 0 s t u |
 * | 1 d e f | 1 m n o | 1 v w x |
 * | 2 g h i | 2 p q r | 2 y z . |
 * |         |         |         |
 *  -----------------------------
 * 
 * Ex:
 *  ---------
 * |H E L L O| <- Input
 * |---------|
 * |0 0 1|1 1|
 * |1|1 2 2|2|
 * |2 1|0 0 1|
 *  ---------
 *  Output: dnrxd
 */
