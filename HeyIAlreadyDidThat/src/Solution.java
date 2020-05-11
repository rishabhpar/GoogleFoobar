import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("210022", 3));
	}

	 public static int solution(String n, int b) {
	        ArrayList<String> idList = new ArrayList<>();
	        
	        while (true) {
	        	char tempArray[] = n.toCharArray(); 
	        	Arrays.sort(tempArray);
	            String y = new String(tempArray);
	            String x = new StringBuilder(new String(tempArray)).reverse().toString();  
	            String z = subtract(x,y,b);
	            
	            while (z.length() != n.length()) {
	            	z = "0" + z;
	            }
	            
	            for (int i = idList.size() - 1; i >= 0; i--) {
	            	if (idList.get(i).compareTo(z) == 0) {
	            		return idList.size() - i;
	            	}
	            }
	            
	            idList.add(z);
	            n = z;
	        }
	    }

	private static String subtract(String x, String y, int b) {
		int zPrime = base2Dec(x,b) - base2Dec(y,b);
		
		return dec2Base(zPrime, b);
	}

	private static String dec2Base(int zPrime, int b) {

		int n = zPrime;
		int q = n;
		int r;
		
		String answer = "";
		while(q != 0){
			r = q % b;
			answer =r + answer;
			q = q / b;
		}
		
		return answer;
	}

	private static int base2Dec(String x, int b) {
		int len = x.length(); 
	    int power = 1;
	    int num = 0;  
	    
	    for (int i = len - 1; i >= 0; i--) { 
	        num += val(x.charAt(i)) * power; 
	        power = power * b; 
	    } 
	  
	    return num; 
	}
	
	static int val(char c) { 
	    if (c >= '0' && c <= '9') 
	        return (c - '0'); 
	    else
	        return (c - 'A' + 10); 
	} 
}
