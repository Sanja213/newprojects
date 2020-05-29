package education.worker;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import education.worker.worceraction.WorkAddList;


public class DelWorker {
public static void delWorker(ArrayList<Worker> list,HttpServletRequest req) {
	int r=-1;
	r=WorkAddList.numToNum(req);
	if(r>=0) {
		int temp=-1;
	for(int i =0;i<list.size();i++) {
		if(list.get(i).getId()==r) temp=i;
	}
	if(temp>=0) list.remove(temp);
}
}
}
