package ArrayPkg;

import java.util.Arrays;

class SortingTechnique {
	// public int arr[];
	public void MergeSort(int arr[], int low, int high) {
		if (low < high) {
			int mid = (high + low) / 2;
			MergeSort(arr, low, mid);
			MergeSort(arr, mid + 1, high);
			Merge(arr, low, mid, high);
			
			//Arrays.sort

		}

	}

	private void Merge(int[] arr, int low, int mid, int high) {
		int leftArrSize = mid - low + 1;
		int RightArrSize = high - mid;

		int leftarr[] = new int[leftArrSize];
		int rightarr[] = new int[RightArrSize];
		int k = low;
		int m = mid + 1;
		int l = 0, r = 0;
		for (int i = 0; i < leftarr.length; i++) {
			leftarr[i] = arr[k];
			k++;

		}
		for (int i = 0; i < rightarr.length; i++) {
			rightarr[i] = arr[m];
			m++;

		}
		int p = low;
		while (l < leftArrSize && r < RightArrSize) {
			if (leftarr[l] <= rightarr[r]) {
				arr[p] = leftarr[l];
				l++;

			} else {
				arr[p] = rightarr[r];
				r++;
			}
			p++;

		}
		while (l < leftArrSize) {
			arr[p] = leftarr[l];
			l++;
			p++;

		}
		while (r < RightArrSize) {
			arr[p] = rightarr[r];
			r++;
			p++;

		}

	}

	public void QuickSort(int arr[], int low, int high) {
		if (low < high) {
			int Pivot = Partion(arr, low, high);
			QuickSort(arr, low, Pivot - 1);
			QuickSort(arr, Pivot + 1, high);
		}

	}

	private int Partion(int[] arr, int low, int high) {
		int pivotele = arr[high];
		int l = low - 1;
		int i = low;
		for (; i <= high - 1; i++) {
			if (arr[i] <= pivotele) {
				l++;
				int temp = arr[i];
				arr[i] = arr[l];
				arr[l] = temp;
			}

		}
		l++;
		int temp = arr[high];
		arr[high] = arr[l];
		arr[l] = temp;
		return l;

	}

	public void HeapSort(int[] arr, int low, int high) {
		for (int i = (low + high) / 2; i >= 0; i--) {
			Minheapify(arr, low, high, i);
		}
		System.out.println(arr);
	}

	private void Minheapify(int[] arr, int low, int high, int i) {

		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int min = i;
		if (left <= high && arr[left] < arr[min]) {
			min = left;

		}
		if (right <= high && arr[right] < arr[min]) {
			min = right;
		}
		if (i != min) {
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
			Minheapify(arr, low, high, min);

		}

	}

	private void swap(int arr[],int start,int end)
	{
		while(start<end)
		{
			int x=arr[start];
			arr[start]=arr[end];
			arr[end]=x;
			start++;
			end--;
			
		}
		
	}
	public void ReversalBlockAlgo(int arr[],int size)
	{
		System.out.println("Reversaal block");
		swap(arr,0,size-1);
		swap(arr,size,arr.length-1);
		swap(arr,0,arr.length-1);
		
		//Arrays.asList(arr).stream().forEach(n->System.out.println(n));
		for(int x: arr)
		{
			System.out.print(x +" ");
		}
	}
 
	
	public boolean FindElementInRotatedSortedArray(int a[],int key)
	{
		System.out.print("FindElementInRotatedSortedArray" +" ");
	  int low=0;
	  int high=a.length-1;
	  
	  
		while(low<=high)
		{
			int mid=(high + low) / 2;
			if(a[mid]==key)
			{
				System.out.println("exists");
				return true;
			}
			if(a[low]<a[mid])
			{
				if(a[low]<=key && a[mid]>key)
				{
					high=mid-1;
					//Arrays.binarySearch(a, low, mid-1, key);
				}
				else
				{
					low=mid+1;
				    
				}
				
			}
			else
			{
				if(a[mid]<key && a[high]>=key)
				{
					low=mid+1;
					//Arrays.binarySearch(a, low, mid-1, key);
				}
				else
				{
					
					high=mid-1; 
				}
				
				
				
			}
			
			
			
		}
		System.out.println("Not exists");
		
		return false;
		
	}
}

public class Sorting {
	public Sorting() {
		SortingTechnique ObjSortingTechnique = new SortingTechnique();
		int arr[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		// ObjSortingTechnique.arr=arr;
		ObjSortingTechnique.MergeSort(arr, 0, arr.length - 1);
		//System.out.println(arr);
		int arr1[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		ObjSortingTechnique.QuickSort(arr1, 0, arr1.length - 1);
		//System.out.println(arr1);
		int arr2[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		ObjSortingTechnique.HeapSort(arr2, 0, arr2.length - 1);
	///System.out.println(arr2);
		
		//ObjSortingTechnique.ReversalBlockAlgo(new int[]{1,2,3,4,5,6,7},2);
		//ObjSortingTechnique.FindElementInRotatedSortedArray(new int[]{3,4,5,6,7,8,9,1,2},1 );
		ObjSortingTechnique.FindElementInRotatedSortedArray(new int[]{8,9,1,2,3,4,5,6,7},1 );
	}

private void ReversalBlockAlgo(int[] is, int i) {
		// TODO Auto-generated method stub
		
	}
}
