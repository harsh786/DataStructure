package StringOperationPkg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

class TrieNode {

	TrieNode ChildNode[];
	boolean IsEnd;

	TrieNode() {

		this.ChildNode = new TrieNode[26];
		this.IsEnd = false;

	}

}

class TrieSearch {
	public TrieNode StartNode;

	public void Insert(String word) {

		TrieNode temp = null;

		if (StartNode == null) {
			StartNode = new TrieNode();

		}

		temp = StartNode;
		for (int i = 0; i < word.length(); i++) {

			if (temp.ChildNode[word.charAt(i) - 97] == null) {
				temp.ChildNode[word.charAt(i) - 97] = new TrieNode();
			}

			temp = temp.ChildNode[word.charAt(i) - 97];

		}
		temp.IsEnd = true;
	}

	public boolean Search(String Word) {
		TrieNode TempNode = StartNode;
		if (TempNode == null) {
			return false;

		}
		int i;
		for (i = 0; i < Word.length(); i++) {
			if (TempNode == null) {
				return false;
			}
			TempNode = TempNode.ChildNode[Word.charAt(i) - 97];

		}
		if (i == Word.length()) {
			if (TempNode == null) {
				return false;
			}
			return TempNode.IsEnd;

		}
		return false;
	}
	
	
	public void  PrintAllTrie(TrieNode start,String Output)
	{
		if(start.IsEnd)
		{
			System.out.println(Output);
			
		}
		
		for(int i=0;i<26;i++)	
		{
			if(start.ChildNode[i]!=null)
			{
			   char ch=(char) (i+97);
				PrintAllTrie(start.ChildNode[i], Output+ch);
			}
			
		}
	}
			
}

class TernaryNode {
	public char data;
	public TernaryNode left;
	public TernaryNode right;
	public TernaryNode equal;
	public boolean IsEnd;

	TernaryNode(char ch) {
		data = ch;
		left = null;
		right = null;
		equal = null;

	}

}

class TernarySearchQuest {
	TernaryNode r = null;

	public TernaryNode InsertNodeInernaryTree(TernaryNode root, String input, int postion) {
		if (root == null) {
			root = new TernaryNode(input.charAt(postion));
			if (r == null) {
				this.r = root;

			}
		}

		if (root.data > input.charAt(postion)) {
			root.left = InsertNodeInernaryTree(root.left, input, postion);
		} else if (root.data < input.charAt(postion)) {
			root.right = InsertNodeInernaryTree(root.right, input, postion);
		} else {
			if (input.length() == postion + 1) {
				root.IsEnd = true;
			} else {
				root.equal = InsertNodeInernaryTree(root.equal, input, postion + 1);
			}
		}
		return root;
	}

	public boolean SearchWordInTernary(TernaryNode root, String input, int position) {
		if (root == null) {
			return false;
		}

		if (root.data > input.charAt(position)) {
			return SearchWordInTernary(root.left, input, position);
		} else if (root.data < input.charAt(position)) {
			return SearchWordInTernary(root.right, input, position);
		} else {
			if (input.length() == position + 1) {
				if (root.IsEnd) {
					return true;

				} else {
					return false;
				}
			} else {
				return SearchWordInTernary(root.equal, input, position + 1);
			}

		}

	}

	public void PrintAllTernaryTreeInSortedOrder(TernaryNode root, String buffer, int position) {
		if (root == null) {
			return;
		} else {
			PrintAllTernaryTreeInSortedOrder(root.left, buffer, position);
			buffer = buffer + root.data;
			if (root.IsEnd) {
				System.out.println(buffer);

			}
			PrintAllTernaryTreeInSortedOrder(root.equal, buffer, position);
			PrintAllTernaryTreeInSortedOrder(root.right, buffer, position);
		}

	}
}

class StringProblems {
	static void FindPatternInPermutationSubstring(String Pattern, String Text) {

		Map<Character, Integer> mpPattern = new HashMap<Character, Integer>();
		Map<Character, Integer> mpText = new HashMap<Character, Integer>();
		for (int i = 0; i < Pattern.length(); i++) {
			if (!mpPattern.containsKey(Pattern.charAt(i))) {
				mpPattern.put(Pattern.charAt(i), 1);
			} else {
				mpPattern.put(Pattern.charAt(i), (Integer) mpPattern.get(Pattern.charAt(i)) + 1);
			}

			if (!mpText.containsKey(Text.charAt(i))) {
				mpText.put(Text.charAt(i), 1);
			} else {
				mpText.put(Text.charAt(i), (Integer) mpText.get(Text.charAt(i)) + 1);
			}

		}
		if (Compare(mpText, mpPattern)) {
			System.out.println("Find pattern at:" + 0);

		}
		for (int i = Pattern.length(); i < Text.length(); i++) {
			int val = mpText.get(Text.charAt(i - Pattern.length())) - 1;
			if (val == 0) {
				mpText.remove(Text.charAt(i - Pattern.length()));
			} else {
				mpText.put(Text.charAt(i - Pattern.length()), val);
			}

			if (!mpText.containsKey(Text.charAt(i))) {
				mpText.put(Text.charAt(i), 1);
			} else {
				mpText.put(Text.charAt(i), (Integer) mpText.get(Text.charAt(i)) + 1);
			}
			if (Compare(mpText, mpPattern)) {
				System.out.println("Find pattern at:" + (Integer) (i - Pattern.length() + 1));

			}
		}
	}

	private static boolean Compare(Map<Character, Integer> mpText, Map<Character, Integer> mpPattern) {
		return mpPattern.equals(mpText);

	}

	static void findMaPalindromicSubstring(String str, int low, int high) {
		// String str="abcdcbad";

	}

	static int minCost(String x, String y, int k) {
		int xl = x.length();
		int yl = y.length();
		if (k > xl) {
			return 0;
		}

		String str = lcs(x, y, x.length(), y.length());
		System.out.print("str:" + str);
		int lcslen = str.length();
		System.out.print("lcslen:" + lcslen);

		int change = k - (lcslen - 1);
		System.out.print("change:" + change);
		HashSet<Character> set1 = new HashSet<Character>();
		HashSet<Character> set2 = new HashSet<Character>();
		HashSet<Character> set3 = new HashSet<Character>();

		for (char c : str.toCharArray()) {
			set3.add(c);
		}

		for (char c : x.toCharArray()) {
			if (!set3.contains(c)) {
				set1.add(c);
			}
		}

		for (char c : y.toCharArray()) {
			if (!set3.contains(c)) {
				set2.add(c);
			}
		}

		System.out.print("SET3:" + set3);
		System.out.print("SET1:" + set1);
		System.out.print("SET2:" + set2);

		return 0;
	}

	// Returns length of LCS for X[0..m-1], Y[0..n-1]
	static String lcs(String X, String Y, int m, int n) {

		StringBuilder obj = new StringBuilder();
		String Obj1 = new String();
		Obj1.length();

		int[][] L = new int[m + 1][n + 1];

		// Following steps build L[m+1][n+1] in bottom up fashion. Note
		// that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1]
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					L[i][j] = 0;
				else if (X.charAt(i - 1) == Y.charAt(j - 1))
					L[i][j] = L[i - 1][j - 1] + 1;
				else
					L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
			}
		}

		// Following code is used to print LCS
		int index = L[m][n];
		int temp = index;

		// Create a character array to store the lcs string
		char[] lcs = new char[index + 1];
		lcs[index] = '\0'; // Set the terminating character

		// Start from the right-most-bottom-most corner and
		// one by one store characters in lcs[]
		int i = m, j = n;
		while (i > 0 && j > 0) {
			// If current character in X[] and Y are same, then
			// current character is part of LCS
			if (X.charAt(i - 1) == Y.charAt(j - 1)) {
				// Put current character in result
				lcs[index - 1] = X.charAt(i - 1);

				// reduce values of i, j and index
				i--;
				j--;
				index--;
			}

			// If not same, then find the larger of two and
			// go in the direction of larger value
			else if (L[i - 1][j] > L[i][j - 1])
				i--;
			else
				j--;
		}

		// Print the lcs

		String str = new String();
		for (int k = 0; k <= temp; k++) {
			str = str + lcs[k];
		}
		return str;

		// System.out.print(lcs[k]);

	}

	static boolean IsVowel(char ch) {

		ch = Character.toUpperCase(ch);

		if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
			return true;
		}
		return false;
	}

	static void RemoveSingleVowelsInString(String OldString) {
		StringBuilder NewString = new StringBuilder();
		for (int i = 0; i < OldString.length();) {
			char ch = OldString.charAt(i);
			if (IsVowel(ch)) {
				int j = i + 1;
				while (j < OldString.length() && IsVowel(OldString.charAt(j))) {
					NewString.append(OldString.charAt(j - 1));
					j++;
				}
				if (i + 1 != j) {
					NewString.append(OldString.charAt(j - 1));

				}
				if (j < OldString.length()) {
					NewString.append(OldString.charAt(j));
				}

				i = ++j;
			} else {
				NewString.append(ch);
				i++;
			}

		}
		System.out.println("Vowels removed:" + NewString);

	}

	public void PrintSentenceFromTwoDArray(String array[][], int rowlength, int rowindex, String output) {
		if (rowindex == rowlength) {
			System.out.println(output);
			return;

		} else {
			for (int i = 0; i < array[rowindex].length; i++) {

				PrintSentenceFromTwoDArray(array, rowlength, rowindex + 1, output + array[rowindex][i] + " ");

			}

		}
	}

	public void subsetSum(int arr[],int cureentindex,int endindex,/*int ArrayTobePrinted[]*/ArrayList<Integer>ArrayTobePrinted,int ArrayTobePrintedlength, int currentsum,int targetsum)
	{
				if(currentsum==targetsum)
				{
					for(int i=0;i<ArrayTobePrintedlength;i++)
					{
						//System.out.print(ArrayTobePrinted[i]);
						System.out.print(ArrayTobePrinted.get(i));
					}
					System.out.println();	
				}
				
              for(int j=cureentindex;j<endindex;j++)
              {
            	  if(arr[j]+currentsum<=targetsum)
            	  {
            		  
            		  if(ArrayTobePrinted.size()==ArrayTobePrintedlength)
            		  {
            			  ArrayTobePrinted.add(ArrayTobePrintedlength,arr[j]);
            		  }
            		  else
            		  {
            			  ArrayTobePrinted.set(ArrayTobePrintedlength,arr[j]);
            		  }
            		
            		//  ArrayTobePrinted[ArrayTobePrintedlength]=arr[j];
            		  subsetSum(arr,j,endindex,ArrayTobePrinted,ArrayTobePrintedlength+1,arr[j]+currentsum,targetsum);
            		  
            	  }
              }
              Integer i=(int)"989".charAt(0);
          	//int arr[]=new int[]{1,2,3,4,5};
	}
}

public class StringOperation {
	public StringOperation() {
		// StringProblems.minCost("ftashvc","hramhnj",5);
		// StringProblems.RemoveSingleVowelsInString("abcaa");
		// StringProblems.FindPatternInPermutationSubstring("abcd", "ttyybcda");
		//TernarySearchQuest ObjTernarySearchQuest = new TernarySearchQuest();
		// System.out.println("Insert Node in ternary node");
		// ObjTernarySearchQuest.InsertNodeInernaryTree(ObjTernarySearchQuest.r,"ha",0);
		// ObjTernarySearchQuest.InsertNodeInernaryTree(ObjTernarySearchQuest.r,"ham",0);
		// ObjTernarySearchQuest.InsertNodeInernaryTree(ObjTernarySearchQuest.r,"has",0);
		// ObjTernarySearchQuest.InsertNodeInernaryTree(ObjTernarySearchQuest.r,
		// "bat", 0);
		// ObjTernarySearchQuest.InsertNodeInernaryTree(ObjTernarySearchQuest.r,
		// "ban", 0);
		// ObjTernarySearchQuest.InsertNodeInernaryTree(ObjTernarySearchQuest.r,"abc",0);
		// ObjTernarySearchQuest.InsertNodeInernaryTree(ObjTernarySearchQuest.r,"sup",0);
		/*
		 * System.out.println("Search Node in ternary node");
		 * System.out.println(ObjTernarySearchQuest.SearchWordInTernary(
		 * ObjTernarySearchQuest.r, "ha", 0));
		 * System.out.println(ObjTernarySearchQuest.SearchWordInTernary(
		 * ObjTernarySearchQuest.r, "has", 0));
		 * System.out.println("Prints Nodes in ternary node");
		 */
		// ObjTernarySearchQuest.PrintAllTernaryTreeInSortedOrder(ObjTernarySearchQuest.r,
		// "", 0);
	}

	public  void PerformOperation() {
//		StringProblems ObjStringProblems = new StringProblems();
//		String array[][] = { { "we", "I" }, { "love", "like" }, { "program", "coding" } };
//		int row = array.length;
		String Output = "";
	// char ch=	Output.toCharArray();
		//ObjStringProblems.PrintSentenceFromTwoDArray(array, row, 0, Output);

		//TrieSearch ObjTrieSearch = new TrieSearch();
		//ObjTrieSearch.Insert("aab");
	   //ObjTrieSearch.Insert("abcd");
	  // ObjTrieSearch.Insert("abc");
	//	System.out.println(ObjTrieSearch.Search("abcde"));
	 //  ObjTrieSearch.PrintAllTrie(ObjTrieSearch.StartNode, "");
//		int arraytobeprinted[]=new int[100];
//		int arr[]=new int[]{1,2,3,4,5,6,7};
//		int k=10;
//		ObjStringProblems.subsetSum(arr, 0,arr.length, new ArrayList<Integer>()/*arraytobeprinted*/, 0, 0, k);


	}

	public static void main(String args[]){
		callmethod("harsh");

	}
	public  static void callmethod(String name){

		String name1="harsh";
		String name2="har";
		if(name==name1)
		{
			System.out.println("Equal strings");

		}
		if(name1.substring(0,3)==name2)
		{
			System.out.println("Equal strings");
		}
		else
		{
			System.out.println(name1.substring(0,3));
		}

		if(name1.substring(0,3)==name1.substring(0,3))
		{
			System.out.println("Equal strings");
		}
		else
		{
			System.out.println(name1.substring(0,3));
		}
	}

}
