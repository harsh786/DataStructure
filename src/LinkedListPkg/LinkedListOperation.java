package LinkedListPkg;
class LinkListNode
{
	int data;
	LinkListNode next;
	LinkListNode (int data)
	{
		this.data=data;
		this.next=null;
	}
}


 class LinkedList {
	
	LinkListNode StartNode; 	
	
	public void InsertNodeBegin(int data)
	{
		LinkListNode temp1=new LinkListNode(data) ;
		if(StartNode==null)
		{
			StartNode=temp1;
		}
		else
		{
			LinkListNode temp=StartNode;
			while(temp.next!=null)
			{
				temp=temp.next;
				
			}
			temp.next= temp1;
			
		}
	}
	
	public void Display(LinkListNode Node)
	{
		LinkListNode temp1=Node;
		if(Node==null)
		{
			System.out.println("No node is present");
			return;
		}
		do
		{
			System.out.println(temp1.data+" ");
			temp1=temp1.next;
			
		}while(temp1!=null);
	}
	
	public void ReverseLinkedList()
	{
		LinkListNode current=StartNode,prev=null,nextNode=null;
		while(current!=null)
		{
			nextNode=current.next;
			current.next=prev;
			prev=current;
			current=nextNode;
	
		}
		System.out.println("Reverse Linked");
		Display(prev);
	}
	
	
	public LinkListNode ReverseLinkedList1()
	{
		System.out.println("Print reverse link list node");
		LinkListNode current=StartNode,prev=null,next=null;
		while(current!=null)
		{
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
			
			
		}
		
		return prev;
		
	}
	
	public void Palindrome()
	{
		LinkListNode slow=StartNode,fast=StartNode;
		while(fast!=null && fast.next!=null )
		{
			slow=slow.next;
			fast=fast.next.next;
		}
		
		System.out.println("Linked List middle node:"+slow.data);
		
	}
	
   public void PerformReverseLinkListInKChunks()
   {
	   System.out.println("PerformReverseLinkListInKChunks");
	   Display(ReverseLinkListInKChunks(StartNode,3));
	   
   }
   
   public LinkListNode ReverseLinkListInKChunks(LinkListNode startNode,int k)
   {
	   LinkListNode current=startNode,prev=null,next=null;
	   
	   for(int i=0;i<k&&current!=null;i++) 
	   {
		   next=current.next;
		   current.next=prev;
		   prev=current;
		   current=next;
		   
		   
	   }
	   
	   if(current!=null)
	   {
		   startNode.next=ReverseLinkListInKChunks(current,k);
	   }
	   return prev;
	   
	   
   }
   
   
   public LinkListNode FindNthNodeFromEnd(int k)
   {
	   LinkListNode temp=StartNode,temp1=StartNode;
	   int i=0;
	   while(i<k && temp1!=null)
	   {
		   temp1=temp1.next;
		   i++;
		   
		   
	   }
	   
	   if(i==k&&temp1==null)
	   {
		   System.out.println("NTh node from end is:"+temp.data);
		   return temp;
	   }
	   else if(temp1==null)
	   {
		   System.out.println("NOt valid node");
		   return null;
	   }
	   
	   while(temp1!=null)
	   {
		   temp=temp.next;
		   temp1=temp1.next;
				   
		   
	   }
	   
	   System.out.println("NTh node from end is:"+temp.data);
	   return temp;
	   
   }
   
   
   //Find loop in link list
   //Find start node of loop
   //Find length of loop
   
   public void FindLoopInLinkList() {
	   
	  LinkListNode slow=StartNode,fast=StartNode;
	  //System.out.println("FindLoopInLinkList:"+slow.data);\
	  LinkListNode start=StartNode;
	  
	  boolean findLoop=false;
	  while(slow!=null && fast!=null && fast.next!=null)
	  {
		  slow=slow.next;
		  fast=fast.next.next;
		  if(slow==fast)
		  {
			  findLoop=true;
			  break;
		  }
		  
	  }
	  
	  if(findLoop)
	  {
		  System.out.println("Yes loop in linked list");
		  
		  while(start!=slow)
		  {
			  start=start.next;
			  slow=slow.next;
			  
		  }
		  System.out.println("Start node of loop:"+slow.data);
		  LinkListNode startNodeLoop=slow;
		  int counter=1;
		  slow=slow.next;
		  while(slow!=startNodeLoop)
		  {
			  slow=slow.next;
			  counter++;
			  
		  }
		  System.out.println("Loop Link list length:"+counter);
		  
	  }
	  else
	  {
		  System.out.println("No loop in linked list");
		  
	  }
	  
	  
	   
   }
   
   
   public void FindEvenOrOddNodeInLinkList()
   {
	   
	   LinkListNode fast=StartNode;
	   
	   while(fast!=null && fast.next!=null)
	   {
		   fast=fast.next.next;
		   
	   }
	   if(fast==null)
	   {
		   System.out.println("Even number of node");
		   
	   }
	   else
	   {
		   System.out.println("odd number of node");
	   }
	   
   }
   
  //IP 1-2-3-4-5-6-7-8-9
   //OP-1-9-2-8-3-7-4-6-5
   public void swapNodesInLinkedList() {
	   
	   //Find middle of linked list
	  /* if number of nodes is even then reverse the linked list from that node
	   if node is odd then from that next node reverse the linked list
	   iterate the reverse linked list and add to start node of list*/

   }
   
   
   
   
   
	
}
 
 

public class LinkedListOperation
{
	public LinkedListOperation()
	{
		
	}
	
	public void PerformOperation()
	{
		
		LinkedList ObjLinkedList=new LinkedList();
		
		
		
		
		ObjLinkedList.InsertNodeBegin(1);
		ObjLinkedList.InsertNodeBegin(2);
		ObjLinkedList.InsertNodeBegin(3);
		ObjLinkedList.InsertNodeBegin(4);
		ObjLinkedList.InsertNodeBegin(5);
		ObjLinkedList.InsertNodeBegin(6);
		ObjLinkedList.InsertNodeBegin(7);
		ObjLinkedList.InsertNodeBegin(8);
		ObjLinkedList.InsertNodeBegin(9);
		ObjLinkedList.Display(ObjLinkedList.StartNode);
		/*
		System.out.println("Print reverse link list");
		
		ObjLinkedList.ReverseLinkedList();
		
		ObjLinkedList.Display(ObjLinkedList.ReverseLinkedList1());
		ObjLinkedList.Palindrome();
		ObjLinkedList.PerformReverseLinkListInKChunks();
		
		*/
		
		
		/*
		LinkListNode node1=ObjLinkedList.FindNthNodeFromEnd(1);
		LinkListNode node2=ObjLinkedList.FindNthNodeFromEnd(1);
	
		node2.next=node1;
		System.out.println("Print reverse link list2");
		//ObjLinkedList.Display(ObjLinkedList.StartNode);
		ObjLinkedList.FindLoopInLinkList();
		
		*/
		
		ObjLinkedList.FindEvenOrOddNodeInLinkList();
		
		
	}
	
}
