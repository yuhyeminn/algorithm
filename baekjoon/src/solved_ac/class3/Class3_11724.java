package solved_ac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 연결 요소의 개수
 * @author hyemin
 *
 */
public class Class3_11724 {

	static int[][] graph;
	static boolean[] visited;
	static int N, M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N+1][N+1];
		visited = new boolean[N+1];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a][b] = graph[b][a] = 1;
		}
		
		int result = 0;
		for(int i=1;i<=N;i++) {
			if(!visited[i]) {
				dfs(i);
				result++;
			}
		}
		
		System.out.println(result);
	}
	
	private static void dfs(int x) {
		visited[x] = true;
		
		for(int i=1;i<=N;i++) {
			if(graph[x][i]==1 && !visited[i]) {
				dfs(i);
			}
		}
	}

}
