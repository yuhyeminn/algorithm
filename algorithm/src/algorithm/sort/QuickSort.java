package algorithm.sort;

import java.util.Arrays;

/**
 * 퀵정렬(Quick Sort)
 * - 특정한 값(pivot)을 기준으로 큰 숫자와 작은 숫자를 서로 교환한 뒤에 배열을 반으로 나누는 정렬 알고리즘
 * - 분할 정복 알고리즘
 *   분할 : 정렬할 자료들을 기준값을 중심으로 2개의 부분집합으로 분할
 *   정복 : 기준보다 작은값은 왼쪽, 기준보다 큰 값은 오른쪽 부분집합으로 정렬. 
 *        부분집합의 크기가 1이하가 아니면 순환 호출을 이용하여 다시 분할함
 * - 보통 첫번째 원소를 피봇 값으로 설정.
 * - 평균시간복잡도 : O(NlogN)
 * - 최악시간복잡도 : O(N^2)
 */
public class QuickSort {
	static int[] arr = {3, 7, 8, 1, 5, 9, 6, 10, 2, 4};
	public static void main(String[] args) {
		QuickSort q = new QuickSort();
		
		q.quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	public void quickSort(int[] arr, int start, int end) {
		int q;
	    if( start < end ){
	        q = partition(arr, start, end);
	        quickSort(arr, start, q-1);
	        quickSort(arr, q+1, end);
	    }
	}
	
	public int partition(int arr[], int start, int end) {

		/*int pi = arr[start];*/
		int pi = arr[(start+end)/2]; //중앙값을 기준
		int temp = 0;
		while(start < end) {
			//기준 값보다 큰 값을 만날 때 까지 왼쪽 -> 오른쪽
			while(arr[start] < pi && start < end) {
				start++;
			}
			//기준 값보다 작은 값을 만날 때 까지 오른쪽 -> 왼쪽
			while(arr[end] > pi && start < end) {
				end--;
			}
			if(start < end) {
				temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
			}
		}
		return start;
	}
	
	/* 동빈나 ver
	public void quickSort(int[] arr, int start, int end) {
		int i = start + 1;
		int j = end;
		int temp = 0;
		
		//원소가 1개인 경우
		if(start >= end) {
			return;
		}
		//기준값은 첫번째 원소
		int pi = start;
		while(i <= j) {
			while(i <= end && arr[i] <= arr[pi]) {
				//기준 값보다 큰 값을 만날 때 까지 왼쪽 -> 오른쪽
				i++;
			}
			while(j > start && arr[j] >= arr[pi]) {
				//기준 값보다 작은 값을 만날 때 까지 오른쪽 -> 왼쪽
				j--;
			}
				//i와 j가 엇갈린 상태면 j와 기준값 교체
			if(i > j) {
				temp = arr[j];
				arr[j] = arr[pi];
				arr[pi] = temp;
			}else {
				//엇갈리지 않았을 경우 i와 j를 교체함
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		quickSort(arr, start, j-1);
		quickSort(arr, j+1,end);
	}
	*/
	
}
