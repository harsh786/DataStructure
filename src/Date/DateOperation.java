package Date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class DateOperation {

    public static void main(String args[]){

       // Date ob=new Date('12','23','2018');
        LocalDateTime dateTime =LocalDateTime.now();
        LocalDate date=LocalDate.now();
        LocalTime time=LocalTime.now();

        System.out.println("TIme is :"+time);
        System.out.println("date is :"+date);

        Set<Integer>set=new HashSet<>();
        Set<Integer>treeset=new TreeSet<>();



    }
}
