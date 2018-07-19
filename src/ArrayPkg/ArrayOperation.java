package ArrayPkg;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;

class ArrayQuest {
	public void FindUniqueNumbersFromInfiniteSeries() {
		int a[] = new int[] { 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 3, 4 };
		int low = 0;
		int high = a.length - 1;
		ArrayList<Integer> ls = new ArrayList<Integer>();
		FindUniqueNumbers(a, low, high, ls);
		for (Integer integer : ls) {
			System.out.print(integer + " ");
		}

	}

	private void FindUniqueNumbers(int[] a, int low, int high, ArrayList<Integer> ls) {
		if (low <= high) {
			int mid = low + (high - low) / 2;
			if ((a[low] == a[mid]) && a[mid] == a[high]) {
				ls.add(a[low]);
				return;

			} else {
				if (a[low] == a[mid]) {
					ls.add(a[low]);
				} else {

					FindUniqueNumbers(a, low, mid - 1, ls);

				}

				if (a[mid] == a[high]) {
					ls.add(a[high]);
				} else {

					FindUniqueNumbers(a, mid + 1, high, ls);

				}
			}

		}

	}

	static void FindMedian() {
		Random obRandom = new Random();
		/*
		 * PriorityQueue<Integer>MaxP=new PriorityQueue<Integer>(new
		 * Comparator<Integer>() {
		 * 
		 * @Override public int compare(Integer o1, Integer o2) { return
		 * Integer.compare(o2, o1); }
		 * 
		 * });
		 */
		PriorityQueue<Integer> MaxP = new PriorityQueue<Integer>((x, y) -> y.compareTo(x));
		PriorityQueue<Integer> MinP = new PriorityQueue<Integer>();
		int count = 0;
		List<Integer> ls = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			count++;
			int val;
			if (count % 2 != 0) {

				val = i + 4;
				ls.add(val);
			} else {
				val = i + 6;
				ls.add(val);
			}
			// int val=obRandom.nextInt();
			System.out.println("List:" + ls);

			if (count == 1) {//
				MaxP.add(val);

			} else if (count == 2) {
				if (MaxP.peek() <= val) {
					MinP.add(val);
				} else {
					MinP.add(MaxP.poll());
					MaxP.add(val);

				}
			} else {
				if (MaxP.size() == MinP.size()) {
					if (MinP.peek() >= val) {
						MaxP.add(val);
					} else {
						MaxP.add(MinP.poll());
						MinP.add(val);
					}

				} else if (MaxP.size() > MinP.size()) {
					if (MaxP.peek() <= val) {
						MinP.add(val);
					} else if (MaxP.peek() > val) {
						MinP.add(MaxP.poll());
						MaxP.add(val);
					}

				} else if (MaxP.size() < MinP.size()) {
					if (MinP.peek() >= val) {
						MaxP.add(val);
					} else if (MinP.peek() < val) {
						MaxP.add(MinP.poll());
						MinP.add(val);
					}
				}

			}
			System.out.println("MaxP:" + MaxP);
			System.out.println("MinP:" + MinP);
			if (count % 2 != 0) {
				System.out.println("Odd Count meadian:" + MaxP.peek());
			} else {
				System.out.println("Even Count meadian:" + (MaxP.peek() + MinP.peek()) / 2);
			}

		}

	}

	public static void ImplementLRUCache(int arr[], int Cachesize) {
		LinkedList<Integer> LRUQueue = new LinkedList<Integer>();

		for (int i = 0; i < arr.length; i++) {
			if (LRUQueue.size() < Cachesize) {
				LRUQueue.addLast(arr[i]);
			} else {
				if (LRUQueue.contains(arr[i])) {
					LRUQueue.remove(arr[i]);

				} else {
					LRUQueue.removeFirst();

				}
				LRUQueue.addLast(arr[i]);
			}

		}
		System.out.println("Print LRU cache queue whch is first to be remove");
		for (Integer integer : LRUQueue) {
			System.out.print(integer + " ");
		}

	}
 
	public  void MinContinousSumArrayAtMostKSwap(int arr1[],int k)
	{
 	    List<Integer>ls=new ArrayList<Integer>();
 	   
		for(int i=0;i<arr1.length;)
		{
			if(arr1[i]<0)
			{
				int sum=arr1[i];
				int j=i+1;
				while(j<arr1.length && arr1[j]<0)
				{
					sum=sum+arr1[j];
					j++;
				}
				ls.add(sum);
				i=j;
			}
			else
			{
				ls.add(arr1[i]);
				i++;
			}
			
		}
		// System.out.println("MinContinousSumArrayAtMostKSwap is:"+ls);
		 int arr[]=ls.stream().mapToInt(i -> i).toArray();
	    
		int Min=Integer.MAX_VALUE;
		boolean IsNegativPresnt=false;
		int countNegative=0;
		// System.out.println("MinContinousSumArrayAtMostKSwap is:");
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]<0)
			{
				IsNegativPresnt=true;
				countNegative++;
			}
			if(arr[i]<Min)
			{
				Min=arr[i];
			}
			
		}
		if(!IsNegativPresnt ){
		 System.out.println(Min);
			return;
		}
		if(arr.length==countNegative)
		{
			int sum=0;
			for(int i=0;i<arr.length;i++)
			{
				sum=sum+arr[i];
			
				
			}
		 System.out.println(sum);
			return;
		}
		int HeapSize=k+1;
		if(countNegative<HeapSize)
		{
			HeapSize=countNegative;
			
		}
		PriorityQueue<Integer>MaxHeap=new PriorityQueue<Integer>(HeapSize, (x,y)->y.compareTo(x));
		
		for(int i=0;i<HeapSize;i++)
		{
		    
			MaxHeap.add(arr[i]);
		}
		for(int i=HeapSize;i<arr.length;i++)
		{
			if(arr[i]<MaxHeap.peek())
			{
				MaxHeap.poll();
				MaxHeap.add(arr[i]);
				
			}
		}
		int sum=0;
	   for(Integer a :MaxHeap)
	   {
		   sum=sum+a;
	   }
	   System.out.println(sum);
		return;
	}
	
}

public class ArrayOperation {
	public ArrayOperation() {
		ArrayQuest ObjArrayQuest = new ArrayQuest();
		//ObjArrayQuest.FindUniqueNumbersFromInfiniteSeries();
		//ArrayQuest.FindMedian();
		//ArrayQuest.ImplementLRUCache(new int[] { 1, 2, 3, 1, 4, 5 }, 4);
		
		ObjArrayQuest.MinContinousSumArrayAtMostKSwap(new int[]{-32022 ,20379 ,-30669, 22887, -14775, 3680 ,-24775 ,9441, -24917, 8608 ,-4092 ,18081},1);
		// Arrays.sort
		//  Scanner in = new Scanner(System.in);
		//  in.
	       
	}
}
