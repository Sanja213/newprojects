package education.worker;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import education.departament.Departament;
import education.departament.ListDepartament;
import education.worker.worceraction.WorkAddList;

public class ChengePosition {
	public static void chengePosition(ArrayList<Worker> list,HttpServletRequest req) {
		int r=-1;
		int temp2=-1;
		String pos="";
		pos=req.getParameter("position");
		for(String d:ListPosition.positions) {
			if(d.equalsIgnoreCase(pos)) temp2++;
		}
		r=WorkAddList.numToNum(req);
		if(r >= 0 && temp2 >= 0) {
			int temp=-1;
		for(int i =0;i<list.size();i++) {
			if(list.get(i).getId()==r) temp=i;
		}
		if(temp>=0) list.get(temp).setPosition(pos);
	}
	}
}
