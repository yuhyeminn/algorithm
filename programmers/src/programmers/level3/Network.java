package programmers.level3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 네트워크
 * 
 * [문제]
 * 네트워크란 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태를 의미합니다. 
 * 예를 들어, 컴퓨터 A와 컴퓨터 B가 직접적으로 연결되어있고, 컴퓨터 B와 컴퓨터 C가 직접적으로 연결되어 있을 때 컴퓨터 A와 컴퓨터 C도 간접적으로 연결되어 정보를 교환할 수 있습니다. 따라서 컴퓨터 A, B, C는 모두 같은 네트워크 상에 있다고 할 수 있습니다.
 * 컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때, 네트워크의 개수를 return 하도록 solution 함수를 작성하시오.
 * 
 * [제한사항]
 * 컴퓨터의 개수 n은 1 이상 200 이하인 자연수입니다.
 * 각 컴퓨터는 0부터 n-1인 정수로 표현합니다.
 * i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j]를 1로 표현합니다.
 * computer[i][i]는 항상 1입니다.
 * 
 * ** 인접행렬로 데이터가 주어졌으니,, 인접행렬로 풀어보자
 * ** solution 1 - bfs 사용. 하지만 이 문제는 dfs로 푸는게 맞는 듯
 * ** solution 2 - dfs 사용
 */
public class Network {
	
	public static void main(String args[]) {
		int computers[][] = {{1,1,0}, {1,1,0}, {0,0,1}};
		int n = 3;
		
		System.out.println(solution2(n, computers));
	}
	
	//////////////////////////////////////////////
	
	public static int solution2(int n, int[][] computers) {
		int answer = 0;
		
		boolean visited[] = new boolean[n];
		
		for(int i=0;i<n;i++) {
			if(!visited[i]) {
				dfs(i, computers, visited);
				answer++;
			}
		}
		return answer;
	}
	
	public static void dfs(int n, int computers[][], boolean visited[]) {
		visited[n] = true;
		
		for(int i=0;i<computers.length;i++) {
			if(computers[n][i] == 1 && !visited[i]) {
				dfs(i, computers, visited);
			}
		}
	}
	
	//////////////////////////////////////////////
	
	public static int solution1(int n, int[][] computers) {
	    int answer = 0;
	    
	    boolean visited[] = new boolean[n];
	    
	    for(int i=0;i<n;i++) {
	    	for(int j=0;j<n;j++) {
	    		if(computers[i][j] == 1 && visited[j] == false) {
	    			answer++;
	    			bfs(j, computers, visited);
	    		}
	    	}
	    }
	    
	    return answer;
	}
	
	public static void bfs(int n, int computers[][], boolean visited[]) {
		Queue<Integer> q = new LinkedList<>(); 
		
		q.add(n);
		visited[n] = true;
		
		while(!q.isEmpty()) {
			int current = q.poll();
			//연결되어있는 컴퓨터 q에 넣기
			for(int i=0;i<computers.length;i++) {
				if(computers[current][i] == 1 && visited[i] == false) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}
	
}
