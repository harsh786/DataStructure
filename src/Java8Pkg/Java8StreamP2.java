package Java8Pkg;

import java.util.*;
import java.util.stream.Collectors;

public class Java8StreamP2 {





    static int differentTeams(String skills) {

        int result=0;
        HashMap<Character,Integer>map=new HashMap<>();
        map.put('p',0);
        map.put('c',0);
        map.put('m',0);
        map.put('b',0);
        map.put('z',0);

        for(int i=0;i<skills.length();i++)
        {
            if(map.containsKey(skills.charAt(i)))
            {
                map.put(skills.charAt(i),map.get(skills.charAt(i))+1);
            }

        }

        int min=Integer.MAX_VALUE;
        for(int v:map.values())
        {
                if(v<min)
                {
                    min=v;

                }
        }
        result=min;
        return result;
    }

    public static void main(String args[])
    {

        System.out.println("REsult is:"+differentTeams("pcmbzpcmbzz"));
       /* System.out.println("TEST");

        Integer a[]=new Integer[4];
        List<Integer> ls1= Arrays.asList(100,2,3,41);
        List<Integer>ls3=new ArrayList<>(new HashSet<>());
        Set<Integer>s1=new HashSet<>(new ArrayList<>());
        List<Integer> ls= Arrays.asList(a);
        ls.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return 0;
            }
        });

        ls1.sort((x,y)-> Integer.compare(x,y));
        ls1.forEach(x->System.out.println(x));
       ls1.stream().filter(x->x.equals(1)).collect(Collectors.toList());
        ls1.forEach(x->System.out.println(x));

        Map<Integer,Integer>map=new HashMap<>();
        for(Map.Entry<Integer,Integer>entry:map.entrySet())
        {


        }

        TreeMap<Integer,Integer>mp=new TreeMap<>();
        mp.pollFirstEntry();
*/






    }
}
