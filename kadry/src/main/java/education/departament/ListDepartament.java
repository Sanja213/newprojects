package education.departament;

import java.util.ArrayList;

public class ListDepartament {
public static ArrayList<Departament> dep = new ArrayList<>();
static {
	dep.add(new Departament(0,"Склад","Иванов"));
	dep.add(new Departament(1,"Производство1","Александров"));
	dep.add(new Departament(2,"Производство2","Семенов"));
	dep.add(new Departament(3,"Офис","Инокентьев"));
}
}
