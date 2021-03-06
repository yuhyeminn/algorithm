package algorithm.sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/**
 * 삽입정렬(Insertion Sort)
 * - 각 숫자를 적절한 위치에 삽입하는 정렬 알고리즘
 * - 데이터가 거의 정렬된 상태일 경우 가장 효율적
 * - 시간복잡도 : O(N^2)
 */
public class InsertionSort {
	public static void main(String[] args) {
		InsertionSort i = new InsertionSort();
		//오름차순 정렬
		int[] arr = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
		System.out.println("result : " + Arrays.toString(i.sort(arr)));
	}
	
	public int[] sort(int arr[]) {
		
		int temp = 0;
		int k = 0;
		/* 동빈나 ver
		int j = 0;
		for(int i=0;i<arr.length-1;i++) {
			j = i;
			while(arr[j] > arr[j+1]) {
				temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = temp;
				j--;
			}
		}
		*/
		
		for(int i=0;i<arr.length;i++) {
			k = i;
			for(int j=i-1; j >= 0; j--) {
	            if(arr[k] < arr[j]) {
	            	temp = arr[k];
	 				arr[k] = arr[j];
	 				arr[j] = temp;
	                k = j;
	            }
	        }
		}
		return arr;
	}
	
	/*LinkedList로 구현한 경우*/
	public static List<Integer> sort2(List<Integer> input) {
	    LinkedList<Integer> list = new LinkedList<Integer>(input);
	 
	    for(int i = 0 ; i < list.size() ; i++) {
	        for(int j = i ; j < list.size() ; j++) {
	            if(list.get(i) > list.get(j)) {
	                Integer temp = list.remove(j);
	                list.add(i, temp);
	            }
	        }
	    }
	    return list;
	}
}
