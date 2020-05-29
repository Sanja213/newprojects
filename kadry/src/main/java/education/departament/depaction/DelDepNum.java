package education.departament.depaction;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import education.departament.Departament;
import education.departament.ListDepartament;
import education.worker.worceraction.WorkAddList;

public class DelDepNum {
	public static void delDepNum(ArrayList<Departament> list,HttpServletRequest req) throws NumberFormatException{
		int temp=-1;
		int r=WorkAddList.numToNum(req);
		for(int i=0;i<list.size();i++) {
		if(r==list.get(i).getId()) temp=i;
		}
		if(temp>=0 &&temp<=list.size()) list.remove(temp);
		}
	}


