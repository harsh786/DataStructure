package Java8Pkg;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

class EmployeeComparator implements Comparator<TestEmployee>
{

	@Override
	public int compare(TestEmployee o1, TestEmployee o2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
class EmployeeComparable implements Comparable<TestEmployee>
{

	@Override
	public int compareTo(TestEmployee o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
class TestEmployee  implements Comparable<TestEmployee>{

	
	  public static enum Gender {
	    MALE, FEMALE
	  }

	  private long id;
	  private String name;
	  private Gender gender;
	  private LocalDate dob;
	  private double income;

	  public TestEmployee(long id, String name, Gender gender, LocalDate dob,
	      double income) {
	    this.id = id;
	    this.name = name;
	    this.gender = gender;
	    this.dob = dob;
	    this.income = income;
	  }

	  public long getId() {
	    return id;
	  }

	  public void setId(long id) {
	    this.id = id;
	  }

	  public String getName() {
	    return name;
	  }

	  public void setName(String name) {
	    this.name = name;
	  }

	  public Gender getGender() {
	    return gender;
	  }

	  public boolean isMale() {
	    return this.gender == Gender.MALE;
	  }

	  public boolean isFemale() {
	    return this.gender == Gender.FEMALE;
	  }

	  public void setGender(Gender gender) {
	    this.gender = gender;
	  }

	  public LocalDate getDob() {
	    return dob;
	  }

	  public void setDob(LocalDate dob) {
	    this.dob = dob;
	  }

	  public double getIncome() {
	    return income;
	  }

	  public void setIncome(double income) {
	    this.income = income;
	  }
	  public static List<TestEmployee> persons() {
		    TestEmployee p1 = new TestEmployee(1, "Jake", Gender.MALE, LocalDate.of(1971,
		        Month.JANUARY, 1), 2343.0);
		    TestEmployee p2 = new TestEmployee(2, "Jack", Gender.MALE, LocalDate.of(1972,
		        Month.JULY, 21), 7100.0);
		    TestEmployee p3 = new TestEmployee(3, "Jane", Gender.FEMALE, LocalDate.of(1973,
		        Month.MAY, 29), 5455.0);
		    TestEmployee p4 = new TestEmployee(4, "Jode", Gender.MALE, LocalDate.of(1974,
		        Month.OCTOBER, 16), 1800.0);
		    TestEmployee p5 = new TestEmployee(5, "Jeny", Gender.FEMALE, LocalDate.of(1975,
		        Month.DECEMBER, 13), 1234.0);
		    TestEmployee p6 = new TestEmployee(6, "Jason", Gender.MALE, LocalDate.of(1976,
		        Month.JUNE, 9), 3211.0);

		    List<TestEmployee> persons = Arrays.asList(p1, p2, p3, p4, p5, p6);
		    return persons;
		  }
	  
	  @Override
		public int compareTo(TestEmployee o) {
			// TODO Auto-generated method stub
			return Double.compare(this.getIncome(),o.getIncome());
		}

}
class Java8operations
{
	public void Perform()
	{
		//CollectionUtils
		/*
		 * Lamda expession comparator
		 * 
		 */
		List<TestEmployee>ls=TestEmployee.persons();
		ls.sort((E1,E2)->
		{
			return Long.compare(E1.getId(), E2.getId());
		
	    });
		
		for (TestEmployee employee : ls) {
			
		}
		
		ls.forEach(x->System.out.println(x));
		Collections.sort(ls, (e1,e2)->{return e1.getName().compareTo(e2.getName());});
		
		ls.forEach(item->{
			if("Jason".equals(item.getName())){
				System.out.println(item);
			}
		});
		Optional<TestEmployee>op=	ls.stream().findFirst();
		if(op.isPresent())
		{
			System.out.println(op.get());
		}
		
		/*
		 * Filter, map, collect
		 * 
		 */
		
		List<String>lsnames=ls.stream().filter(x->x.getName().equals("Jason")).map(x->x.getName()).collect(Collectors.toList());
		ls.stream().filter(x->x.getName().equals("Jason")).skip(1).allMatch(x->x.getId()==1);
		ls.stream().filter(x->x.getName().equals("Jason")).skip(1).anyMatch(x->x.getId()==1);
		op=ls.stream().findFirst();
		op=ls.stream().findAny();
		ls.stream().noneMatch(x->x.getId()==1);
		Comparator<TestEmployee> TestEmpCmparator=(e1,e2)->{return e1.getName().compareTo(e2.getName());};
		ls.stream().sorted().min(TestEmpCmparator);
		ls.stream().max(TestEmpCmparator);
		ls.stream().mapToDouble(x->{return x.getIncome();});
		ls.stream().map(x->{return x.getIncome();});
		ls.stream().collect(Collectors.toMap(TestEmployee::getId, y->y));
		ls.stream().collect(Collectors.toMap(TestEmployee::getId,  Function.identity()));
		ls.stream().collect(Collectors.toMap(x->x,y->y));
	}
}



public class Java8Practice {

	
	
	public Java8Practice()
	{
		
	}
}
