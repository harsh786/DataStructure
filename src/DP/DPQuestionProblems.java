package DP;

class DP
{
     public static void FindMaxLengthPalindromicSubstring(String str)
     {
    	int len= str.length();
    	 boolean table[][]=new boolean[len][len];
    	 int MaxLength=1;
    	 int low=1, high=1;
    	 for(int i=0;i<len;i++)
    	 {
    		 table[i][i]=true;
    		 
    	 }
    	 
    	 for(int i=0;i<len-1;i++)
    	 {
    		 if(str.charAt(i)==str.charAt(i+1))
    		 {
    			 table[i][i+1]=true;
    			 MaxLength=2;
    			 low=i;
    			 high=i+1;
    		 }
    		 
    	 }
    	 
    	 for(int k=2;k<len;k++)
    	 {
    		
    		 for(int j=0;j+k<len;j++)	 
    		 {
    			 
    			 if(str.charAt(j)==str.charAt(j+k) && table[j+1][j+k-1]==true)
        		 {
        			 table[j][j+k]=true;
        			 MaxLength=k+1;
        			 low=j;
        			 high=j+k;
        		 }
    		 }

    	 }
    	 System.out.println("Maxlength palidrmic subtsring:"+MaxLength+" ----Low,high:"+low +":"+ high);
    	 
     }
	
}

public class DPQuestionProblems {
	public DPQuestionProblems()
	{
		DP.FindMaxLengthPalindromicSubstring("ACbbCA");
	}
}
