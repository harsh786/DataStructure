import java.util.*;
import java.util.Collections;
import java.util.SortedMap;
import java.util.SortedSet;

public class JavaCollections {

    public static void ArrayListFunc()
    {
        List<Integer>ob=new ArrayList<Integer>();

        ob.add(6);///////2

        ob.size();
        ob.get(0);
        ob.isEmpty();
        ob.contains(6);
        ob.clear();
        ob.add(0, 7);
        ob.toArray();
        ob.remove(6);
        ob.indexOf(7);
        ob.lastIndexOf(7);
        ob.sort((x,y)->Integer.compare(x, y));
        ob.remove(new Integer(7));
        //System.out.println(ob.contains(new Integer(6)));
        
        
    }
    
    public static void LinkedListFunc()
    {
        
        List<Integer>ob=new LinkedList<Integer>();
        ob.add(6);
        ob.size();
        ob.get(0);
        ob.isEmpty();
        ob.contains(6);
        ob.clear();
        ob.add(0, 7);
        ob.toArray();
        ob.remove(6);
        ob.indexOf(7);
        ob.lastIndexOf(7);
        ob.sort((x,y)->Integer.compare(x, y));
        ob.remove(new Integer(7));
        ob.equals(new ArrayList<Integer>());
        
        LinkedList<Integer>ob1=new LinkedList<Integer>();
        
        ob1.addFirst(new Integer(6));
        ob1.addLast(new Integer(6));
        ob1.removeFirst();//exception return element and remove
        ob1.removeLast();//exception return element and remove
        ob1.removeLastOccurrence(new Integer(6));//true
        ob1.getFirst();
        ob1.getFirst();//exception and get only
        ob1.peek();
        ob1.peekFirst();//only get if not present give null
        ob1.peekLast();
        ob1.pollFirst();//return null and remove
        ob1.pollLast();//return null and remove
        
        
        //ob.containsAll());
        
    }
    
    public  static void StackOperation()
    {
        Stack<Integer> ob=new Stack<Integer>();
        //all lsit opertaton
        
        ob.push(new Integer(6));
        ob.pop();//empty stack exception
        ob.peek();//empty stack exception
        
    }
    
    public  static void HashMapOperation()
    {
        Map<Integer,Integer> ob=new HashMap<Integer,Integer>();
        //all lsit opertaton
        
        ob.put(10, 10);
        ob.putIfAbsent(20, 10);//null
        ob.get(10);//null
        ob.getOrDefault(10, 1);
        ob.containsKey(10);
        ob.containsValue(10);
        ob.values();
        ob.keySet();
        ob.remove(7);//null
        ob.replace(10, 5);//null if no key is present
        ob.replace(10, 5, 33);//null if no key is present
        //ob.compute();
        //ob.computeIfAbsent((, mappingFunction);
        //ob.computeIfPresent(key, remappingFunction)
        
    }
    
    public  static void LinkedHashMapOperation()
    {
        LinkedHashMap<Integer,Integer> ob=new LinkedHashMap<Integer,Integer>();
        //all lsit opertaton
        
        ob.put(10, 10);
        ob.putIfAbsent(20, 10);//null
        ob.get(10);//null
        ob.getOrDefault(10, 1);
        ob.containsKey(10);
        ob.containsValue(10);
        ob.values();
        ob.keySet();
        ob.remove(7);//null
        ob.replace(10, 5);//null if no key is present
        ob.replace(10, 5, 33);//null if no key is present
        //ob.compute();
        //ob.computeIfAbsent((, mappingFunction);
        //ob.computeIfPresent(key, remappingFunction)
        
        for(Map.Entry<Integer, Integer> o :ob.entrySet())
        {
            System.out.println(o.getValue()+""+o.getKey());
        }
        
    }
    
    public static void TreeHashMapOperation()
    {
        TreeMap<Integer, Integer> ob=new TreeMap<Integer, Integer>((x,y)->Integer.compare(x, y));
        ob.firstEntry();//least value key
        ob.firstKey();//least value key
        ob.floorEntry(7);
        ob.floorKey(7);
        ob.pollFirstEntry();
        ob.pollLastEntry();
        ob.lastEntry();
        ob.lastKey();
      
        //more
        
    }
    public static void SetOperation()
    {
        //same as list
        HashSet<Integer>ob=new HashSet<Integer>();
        LinkedHashSet<Integer>ob1=new LinkedHashSet<Integer>();
        
        TreeSet<Integer> ob2=new TreeSet<Integer>();
        ob2.first();
        ob2.last();
        ob2.floor(7);
        ob2.ceiling(5);
        ob2.pollFirst();
        ob2.pollLast();
        
        
    }
    
    public static void CollectionOperation()
    {
        //same as lsit
        SortedMap<Integer,Integer> ob=Collections.emptySortedMap();
        SortedSet<Integer> ob1=Collections.emptySortedSet();
        
    }
    
    public static void NormalOperation()
    {
        String ob=new String();
        StringBuilder Ob1=new StringBuilder();
       
        //Arrays.
        
    }
}
