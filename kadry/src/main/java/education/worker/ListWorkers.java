package education.worker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import education.departament.ListDepartament;

public class ListWorkers {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
	public static ArrayList<Worker> workers=new ArrayList<>();
    static {
    	workers.add(new Worker(1,"Иван","Иванович","Иванов",(new GregorianCalendar(10, 10, 2008)).getTime(),"Кладовщик",ListDepartament.dep.get(0).getName())); 
    	workers.add(new Worker(2,"Василий","Васильевич","Васильев",new Date(),"Карщик",ListDepartament.dep.get(0).getName())); 
    	workers.add(new Worker(3,"Адрей","Андреевич","Андреев",new Date(),"Комплектовщик",ListDepartament.dep.get(0).getName())); 
    	workers.add(new Worker(4,"Александр","Александрович","Александров",new Date(),"Бригадир",ListDepartament.dep.get(1).getName())); 
    	workers.add(new Worker(5,"Евгений","Евгеньевич","Евгеньев",new Date(),"Рабочий",ListDepartament.dep.get(1).getName())); 
    	workers.add(new Worker(6,"Дмитрий","Дмитриевич","Дмитриев",new Date(),"Разнорабочий",ListDepartament.dep.get(1).getName())); 
    	workers.add(new Worker(7,"Семен","Семенович","Семенов",new Date(),"Бригадир",ListDepartament.dep.get(2).getName())); 
    	workers.add(new Worker(8,"Алексей","Алексеевич","Алексеев",new Date(),"Рабочий",ListDepartament.dep.get(2).getName())); 
    	workers.add(new Worker(9,"Руслан","Русланович","Русланов",new Date(),"Разнорабочий",ListDepartament.dep.get(2).getName())); 
    	workers.add(new Worker(10,"Инокентий","Инокентьевич","Иннокентьев",new Date(),"Директор",ListDepartament.dep.get(3).getName())); 
    	workers.add(new Worker(11,"Зураб","Зурабович","Зурабов",new Date(),"Секретарь",ListDepartament.dep.get(3).getName())); 
    	workers.add(new Worker(12,"Марк","Маркович","Марков",new Date(),"Бухгалтер",ListDepartament.dep.get(3).getName())); 
    }
}
