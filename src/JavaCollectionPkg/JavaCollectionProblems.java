package JavaCollectionPkg;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;
import java.util.TreeMap;

class JavaCollectionsList {
    public void ListInterfaceArrayList() {
        // It is implemented by ArrayList,LinkedList,Vector
        // Stack extends Vector then
        ArrayList<Integer> ArrayListObj = new ArrayList<Integer>();
        ArrayListObj.add(5);
        ArrayListObj.add(0, 10);
        ArrayListObj.get(1);
        ArrayListObj.isEmpty();
        ArrayListObj.contains(new Integer(5));
        ArrayListObj.toArray();
        /*
         * ArrayListObj.sort(new Comparator<T>() {
         * 
         * @Override public int compare(T o1, T o2) { // TODO Auto-generated method stub return 0; }
         * });
         */
        ArrayListObj.lastIndexOf(new Integer(5));
        ArrayListObj.equals(new ArrayList<Integer>());
        ArrayListObj.remove(new Integer(5));
        // ArrayListObj.r
        // ArrayListObj.remove(0);
        ArrayListObj.indexOf(new Integer(5));
        ArrayListObj.size();

        for (Integer integer : ArrayListObj) {
            System.out.println(integer);
        }
        ArrayListObj.clone();// shallow copy
        ArrayListObj.clear();


        ArrayListObj.sort(new Comparator<Integer>() {

            @Override
            public int compare(Integer arg0, Integer arg1) {
                // TODO Auto-generated method stub
                return 0;
            }


        });
    }

    public void ListInterfaceLinkedList() {
        // use linked list as queue,stack list for all of thing
        // and use same above method of arraylist also,thse are additional
        // methods
        // it is aslo inherit from dequeue which is inherit from queue
        LinkedList<Integer> LinkedListObj = new LinkedList<Integer>();
        // ArrayDeque<Integer> LinkedListObj = new ArrayDeque<Integer>();

        LinkedListObj.addFirst(new Integer(5));
        LinkedListObj.addLast(new Integer(10));
        LinkedListObj.get(new Integer(10));
        LinkedListObj.getFirst();// error
        LinkedListObj.getLast();
        LinkedListObj.peek();
        LinkedListObj.peekFirst();
        LinkedListObj.peekLast();// only get elemnet
        LinkedListObj.poll();// remove andd get element
        LinkedListObj.pollFirst();
        LinkedListObj.pollLast();
        LinkedListObj.push(new Integer(15));
        LinkedListObj.pop();
        LinkedListObj.remove();
        LinkedListObj.removeFirst();// error
        LinkedListObj.removeLast();
        LinkedListObj.removeFirstOccurrence(new Integer(10));
        LinkedListObj.removeLastOccurrence(new Integer(10));

    }

    public void ListInterfaceVector() {
        // use linked list as queue,stack list for all of thing
        // and use same above method of arraylist also,thse are additional
        // methods
        Vector<Integer> VectorObj = new Vector<Integer>();
        VectorObj.add(5);
        VectorObj.add(0, 10);
        VectorObj.get(1);
        VectorObj.isEmpty();
        VectorObj.contains(new Integer(5));
        VectorObj.toArray();
        /*
         * ArrayListObj.sort(new Comparator<T>() {
         * 
         * @Override public int compare(T o1, T o2) { // TODO Auto-generated method stub return 0; }
         * });
         */
        VectorObj.lastIndexOf(new Integer(5));
        VectorObj.equals(new ArrayList<Integer>());
        VectorObj.remove(new Integer(5));
        // ArrayListObj.remove(0);
        VectorObj.indexOf(new Integer(5));
        VectorObj.size();

        for (Integer integer : VectorObj) {
            System.out.println(integer);
        }
        VectorObj.clone();// shallow copy
        VectorObj.clear();

    }

    public void ListInterfaceStack() {
        Stack<Integer> StackObj = new Stack<Integer>();
        StackObj.push(new Integer(5));
        StackObj.pop();
        StackObj.peek();
        StackObj.isEmpty();
        StackObj.size();
        StackObj.clear();


    }

}


class PriorityQueueComparartor implements Comparator<Integer> {
    @Override
    public int compare(Integer arg0, Integer arg1) {
        return Integer.compare(arg1, arg0);
    }
}


// For complex object as key
class Employee {
    private int EmployeeCode;

    public int getEmployeeCode() {
        return EmployeeCode;
    }

    public void setEmployeeCode(int employeeCode) {
        EmployeeCode = employeeCode;
    }

    // Depends only on account number
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + EmployeeCode;
        return result;
    }

    // Compare only account numbers
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (EmployeeCode != other.EmployeeCode)
            return false;
        return true;
    }
}


class JavaCollectionsQueue {
    public void QueueInterfacePriorityQueue() {
        // it is inherit from queue
        // PriorityQueue<Integer> PriorityQueueObj = new PriorityQueue<Integer>(new
        // PriorityQueueComparartor());
        // PriorityQueue<Integer> PriorityQueueObj = new PriorityQueue<Integer>(new
        // Comparator<Integer>()
        /*
         * {
         * 
         * @Override public int compare(Integer arg0, Integer arg1) { return Integer.compare(arg1,
         * arg0); }
         * 
         * });
         */
        PriorityQueue<Integer> PriorityQueueObj =
                new PriorityQueue<Integer>((x, y) -> Integer.compare(y, x));
        PriorityQueueObj.add(10);
        PriorityQueueObj.add(9);
        PriorityQueueObj.add(5);
        PriorityQueueObj.add(8);
        PriorityQueueObj.add(7);
        PriorityQueueObj.add(6);
        for (Integer object : PriorityQueueObj) {
            System.out.print(object + " ");
        }
        PriorityQueueObj.comparator();
        System.out.println("after");
        PriorityQueueObj.peek();
        PriorityQueueObj.poll();
        PriorityQueueObj.remove(4);

        for (Integer object : PriorityQueueObj) {
            System.out.print(object + " ");
        }
    }

    public void QueueInterfacePriorityArrayQueue() {
        // it is same as linkedlist
        ArrayDeque<Integer> ArrayDequeObj = new ArrayDeque<Integer>();


    }
}



class JavaCollectionsSet {
    public void SetInterfaceHashSet() {
        // it inherits from set interface which is inherit from collection
        // since it inherits from collection it implememnted its method only
        HashSet<Integer> HashSetObj = new HashSet<Integer>();
        HashSetObj.add(new Integer(10));
        HashSetObj.isEmpty();
        HashSetObj.contains(new Integer(10));
        HashSetObj.size();
        HashSetObj.remove(new Integer(10));



    }

    public void SetInterfaceLinkedHashSet() {
        // it inherits from set interface which is inherit from collection
        // since it inherits from collection it implememnted its method only
        // same as hashset
        LinkedHashSet<Integer> LinkedHashSetObj = new LinkedHashSet<Integer>();

        // LinkedHashSetObj.

    }

    public void SetInterfaceTreeSet() {
        // it inherits from soredset interface which is inherit from set
        // interface
        //
        TreeSet<Integer> TreeSetObj = new TreeSet<Integer>(new PriorityQueueComparartor());
        TreeSetObj.add(new Integer(15));
        TreeSetObj.add(new Integer(17));
        TreeSetObj.add(new Integer(11));
        TreeSetObj.add(new Integer(11));
        TreeSetObj.add(new Integer(11));
        TreeSetObj.add(new Integer(12));
        TreeSetObj.add(new Integer(13));

        System.out.print("TreeSet" + " " + TreeSetObj.pollFirst());
        System.out.print("TreeSet" + " " + TreeSetObj.pollLast());
        TreeSetObj.first();
        TreeSetObj.last();// error


        // TreeSetObj.

        for (Integer integer : TreeSetObj) {
            System.out.print(integer + " ");
        }
    }

}


class JavaCollectionsHashMap {
    public void HashMapInterface() {
        // maintains not order nut linkedhashmap maintains order it contains
        // atmost one null key
        HashMap<Integer, Integer> HashMapObj = new HashMap<Integer, Integer>();
        HashMapObj.put(1, 10);
        HashMapObj.put(2, 10);
        HashMapObj.put(3, 10);
        HashMapObj.put(4, 10);
        HashMapObj.containsKey(1);
        HashMapObj.containsValue(10);
        HashMapObj.isEmpty();
        HashMapObj.size();
        HashMapObj.remove(1);
        HashMapObj.remove(1, 10);
        // HashMapObj.
        Set<Integer> ob = HashMapObj.keySet();
        Collection<Integer> ob1 = HashMapObj.values();

        for (Map.Entry en : HashMapObj.entrySet()) {
            System.out.println(
                    en.getKey() + "--" + en.getValue() + "--" + HashMapObj.get(en.getKey()));

        }
        for (Integer i : ob) {

        }
    }

    public void LinkedHashMapInterface() {
        // maintains not order nut linkedhashmap maintains order it contains
        // atmost one null key
        // maintains insertion order
    }

    public void TreeMapInterface() {
        // maintains sorted order
        // not contain one null key
        TreeMap<Integer, Integer> TreeMapObj =
                new TreeMap<Integer, Integer>(new PriorityQueueComparartor());
        TreeMapObj.put(1, 10);
        TreeMapObj.put(2, 10);
        TreeMapObj.put(3, 10);
        TreeMapObj.put(4, 10);
        TreeMapObj.pollFirstEntry();
        TreeMapObj.pollLastEntry();

        for (Map.Entry en : TreeMapObj.entrySet()) {
            System.out.println(en.getKey() + "--" + en.getValue());

        }
    }
}


class JavaCollections {
    public void CollectionsMethods() {
        List<Integer> ls = new ArrayList<Integer>();
        Collections.max(ls);


    }

}


public class JavaCollectionProblems {
    public JavaCollectionProblems() {
        // JavaCollectionsList ObjJavaCollectionsList=new JavaCollectionsList();
        // ObjJavaCollectionsList.ListInterfaceArrayList();
        // JavaCollectionsQueue ObjJavaCollectionsQueue=new
        // JavaCollectionsQueue();
        // ObjJavaCollectionsQueue.QueueInterfacePriorityQueue();
        // JavaCollectionsSet ObjJavaCollectionsSet=new JavaCollectionsSet();
        // ObjJavaCollectionsSet.SetInterfaceTreeSet();
        JavaCollectionsHashMap ObjJavaCollectionsHashMap = new JavaCollectionsHashMap();
        // ObjJavaCollectionsHashMap.HashMapInterface();
        ObjJavaCollectionsHashMap.TreeMapInterface();



    }

}
