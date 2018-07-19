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
	
}

public class LinkedListOperation
{
	
	public void PerformOperation()
	{
		
		LinkedList ObjLinkedList=new LinkedList();
		ObjLinkedList.InsertNodeBegin(6);
		ObjLinkedList.InsertNodeBegin(5);
		ObjLinkedList.InsertNodeBegin(4);
		ObjLinkedList.InsertNodeBegin(3);
		ObjLinkedList.InsertNodeBegin(2);
		ObjLinkedList.InsertNodeBegin(1);
		ObjLinkedList.Display(ObjLinkedList.StartNode);
		//ObjLinkedList.ReverseLinkedList();
		ObjLinkedList.Palindrome();
	}
	
}
