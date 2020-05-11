import java.util.ArrayList;

public class Solution {

	public static void main(String[] args) {
		int[] result = solution(15324);
		System.out.println(result.toString());

	}

	public static int[] solution(int area) {
        ArrayList<Integer> result = new ArrayList<>();
        
        while(area > 0){
            int value = floorOfSqrt(area);
            result.add(value * value);
            area -= value * value;
        }
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
    private static int floorOfSqrt(int num){
        int answer = 1;
        while (answer * answer < num + 1){
            answer += 1;
        }
        
        return answer - 1;
    }

}
