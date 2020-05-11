import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	static ArrayList<ArrayList<Integer>> distanceFromOrigin;
	
	
	public static void main(String[] args) {
		System.out.println(solution(19, 36));
	}
	
	public static int solution(int src, int dest) {
		
		distanceFromOrigin = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < 8; i++) {
			distanceFromOrigin.add(new ArrayList<Integer>());
			for (int j = 0; j < 8; j++) {
				distanceFromOrigin.get(i).add(64);
			}
		}
		
		calcDistance();
		
		
		int srcXCoord = src % 8;
		int srcYCoord = src / 8;
		int destXCoord = dest % 8;
		int destYCoord = dest / 8;
		
		int answer = distanceFromOrigin.get(Math.abs(srcYCoord - destYCoord))
				.get(Math.abs(srcXCoord - destXCoord));
		return answer;
		
	}

	private static void calcDistance() {
		distanceFromOrigin.get(0).set(0, 0);
		
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		
		int yMoves[] = {2,2,-2,-2,1,1,-1,-1};
		int xMoves[] = {-1, 1, 1, -1, 2, -2, 2, -2};
		
		
		while (!q.isEmpty()) {
			int spot = q.poll();
			
			int x = spot % 8;
			int y = spot / 8;
			
			
			for (int i = 0; i < 8; i++) {
				int xx = x + xMoves[i];
				int yy = y + yMoves[i];
				
				if (xx >= 0 && yy >= 0 && xx < 8 && yy < 8 &&
						distanceFromOrigin.get(yy).get(xx) == 64) {
					q.add(8 * yy + xx);
					int val = distanceFromOrigin.get(yy).get(xx);
					int possible = 1 + distanceFromOrigin.get(y).get(x);
					
					distanceFromOrigin.get(yy).set(xx, Math.min(val, possible));
				}
			}
			
		}
		
	}

}
