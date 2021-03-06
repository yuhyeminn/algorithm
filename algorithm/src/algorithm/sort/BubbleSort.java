package algorithm.sort;

import java.util.Arrays;

/**
 * 버블정렬(Bubble Sort)
 * - 옆에 있는 값과 비교하여 더 작은 값을 반복적으로 앞으로 보내는 정렬 알고리즘
 * - 가장 비효율적인 정렬 알고리즘
 * - 시간복잡도 : O(N^2)
 */
public class BubbleSort {

	public static void main(String[] args) {
		BubbleSort b = new BubbleSort();
		//오름차순 정렬
		int[] arr = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
		System.out.println("result : " + Arrays.toString(b.sort(arr)));
	}
	
	public int[] sort(int[] arr) {
		int temp = 0;
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length-(i+1);j++) {
				if(arr[j] > arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr;
	}

}
