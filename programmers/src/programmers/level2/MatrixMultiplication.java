package programmers.level2;

import java.util.Arrays;

/**
 * 행렬의 곱셈
 * 
 * [문제] 2차원 행렬 arr1과 arr2를 입력받아, arr1에 arr2를 곱한 결과를 반환하는 함수, solution을 완성해주세요.
 * 
 * [제한사항] 행렬 arr1, arr2의 행과 열의 길이는 2 이상 100 이하입니다. 행렬 arr1, arr2의 원소는 -10 이상 20
 * 이하인 자연수입니다. 곱할 수 있는 배열만 주어집니다.
 *
 */
public class MatrixMultiplication {

	public static void main(String[] args) {
		int[][] arr1 = { { 1, 4 }, { 3, 2 }, { 4, 1 } };
		int[][] arr2 = { { 3, 3 }, { 3, 3 } };
		
		int result[][] = solution(arr1, arr2);
		for(int i=0;i<result.length;i++) {
			System.out.println(Arrays.toString(result[i]));
		}
	}

	public static int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr2[0].length];

		//왼쪽 행렬의 열 == 오른쪽 행렬의 행
		//arr1[0].length == arr2.length
		for(int i=0;i<arr1.length;i++) {
			for(int j=0;j<arr2[0].length;j++) {
				int sum = 0;
				for(int k=0;k<arr1[0].length;k++) {
					int num = arr1[i][k];
					sum += (num * arr2[k][j]);
				}
				answer[i][j] = sum;
			}
		}
		return answer;
	}

}
