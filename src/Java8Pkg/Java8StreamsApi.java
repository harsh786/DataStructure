package Java8Pkg;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
class Person {
	
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name;
    }
}
  enum Gender {
    MALE, FEMALE
  }
class Employee {
	 

	  private long id;
	  private String name;
	  private Gender gender;
	  private LocalDate dob;
	  private double income;

	  public Employee(long id, String name, Gender gender, LocalDate dob,
	      double income) {
	    this.id = id;
	    this.name = name;
	    this.gender = gender;
	    this.dob = dob;
	    this.income = income;
	  
	  }
	  public Gender getGender() {
	    return gender;
	  }
	  public static List<Employee> persons() {
		  
	    Employee p1 = new Employee(1, "Jake", Gender.MALE, LocalDate.of(1971,
	        Month.JANUARY, 1), 2343.0);
	    Employee p2 = new Employee(2, "Jack", Gender.MALE, LocalDate.of(1972,
	        Month.JULY, 21), 7100.0);
	    Employee p3 = new Employee(3, "Jane", Gender.FEMALE, LocalDate.of(1973,
	        Month.MAY, 29), 5455.0);
	    Employee p4 = new Employee(4, "Jode", Gender.MALE, LocalDate.of(1974,
	        Month.OCTOBER, 16), 1800.0);
	    Employee p5 = new Employee(5, "Jeny", Gender.FEMALE, LocalDate.of(1975,
	        Month.DECEMBER, 13), 1234.0);
	    Employee p6 = new Employee(6, "Jason", Gender.MALE, LocalDate.of(1976,
	        Month.JUNE, 9), 3211.0);

	    List<Employee> persons = Arrays.asList(p1, p2, p3, p4, p5, p6);

	    return persons;
	  }
	}
	

public class Java8StreamsApi {
	@SuppressWarnings("unchecked")
public Java8StreamsApi()
	{
		
		
		
		
		List<Person> lspersons =
			    Arrays.asList(
				        new Person("Max", 18),
				        new Person("Peter", 23),
				        new Person("Pamela", 23),
				        new Person("David", 12)
			        );
		
		lspersons.stream().filter(x->x.name.equals("Max"));
		lspersons.stream().distinct();
		lspersons.stream().count();
		lspersons.stream().toArray();
		lspersons.stream().allMatch(x->x.name.length()>4);
		lspersons.stream().anyMatch(x->x.age>18);
		lspersons.stream().mapToInt(x->x.age*x.age).forEach(System.out::print);;
		lspersons.stream().flatMapToDouble(n->DoubleStream.of( Double.parseDouble("1")));
		
		Long a= 1L;
		Double b=1.0;
		
		Float c= 1.0F;
		
		
		
		Collections.sort(new ArrayList<Integer>(), (t1,t2)->{ return Integer.compare(t2, t1);});;
		
		List<String>lsNames=Arrays.asList("harsh","gauri","khushboo","jasvi","harsh","gauri","khushboo","khushboo");
		List<Integer>lsi=Arrays.asList(1,2,3);
		lsi.stream().mapToInt(x->x.intValue()).sum();
	//	lsNames.stream().
		lsNames.stream().filter(x->x.length()>=5).mapToInt(x->x.length()*2).forEach(n->System.out.println(n));
		//Collectors.t
	//	System.out.println(lsNames.stream().count());
		//lsNames.stream().filter(x->x.endsWith("i")).distinct().forEach(n->System.out.println(n));
		//lsNames.stream().filter(x->x.length()>=5).forEach(n->System.out.println(n));
		//lsNames.stream().sorted((x,y)->y.compareTo(x)).forEach(n->System.out.println(n));
		List<String>ls=lsNames.stream().sorted((x,y)->y.compareTo(x)).collect(Collectors.toList()); 
		//ls.forEach(n->System.out.println(n));
/*	Map<String,Long>map=	lsNames.stream().collect(Collectors.groupingBy(x->x,Collectors.counting()));
	map.forEach((k,v)->System.out.println(k+"----"+v));
	
	map.entrySet().stream()
	.filter(x->x.getKey()=="khushboo").collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()))
	.forEach((k,v)->System.out.println(k+"----"+v));
	
	lsNames.stream().collect(Collectors.groupingBy(x->x)).forEach((k,v)->System.out.println(k+"----"));
	
	String n=map.entrySet().stream()
	.filter(x->x.getValue()==3).map(x->x.getKey()).collect(Collectors.joining());
	System.out.println("Unique");
	lsNames.stream().collect(Collectors.toSet()).forEach(k->System.out.println(k));
	System.out.println("printing dictionary");
	lsNames.stream().distinct(). collect(Collectors.toMap(Function.identity(),String::length)).forEach((k,v)->System.out.println(k+"----"+v));
	System.out.println("printing ");
	lsNames.stream().distinct(). collect(Collectors.toMap(x->x,y->y)).forEach((k,v)->System.out.println(k+"----"+v));
	int nj=(int) lsNames.stream().distinct().collect(Collectors.summingInt(n1->n1.length()));
	System.out.println("sum:"+nj);
	System.out.println("printing ");*/
		
		List<Person> persons =
			    Arrays.asList(
			        new Person("Max", 18),
			        new Person("Peter", 23),
			        new Person("Pamela", 23),
			        new Person("David", 12));
		
	
			    persons
			        .stream()
			        .filter(p -> p.name.startsWith("P"))
			        .collect(Collectors.toList()).forEach(x->System.out.println(x.age));
			    Map<Gender, Long> countByGender  = Employee.persons()
			            .stream()
			            .collect(Collectors.groupingByConcurrent(x->x.getGender(), Collectors.counting())); 
			        System.out.println(countByGender);
	}
	
}
