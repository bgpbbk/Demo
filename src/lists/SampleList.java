package lists;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class SampleList {

	public static void main(String[] args) {
		
		List<String> lstr=new ArrayList<String>();
		ListIterator<String>lsit=null;
		
		//adding to list
		lstr.add("raju");
		lstr.add("jogi");
		lstr.add("gopi");
		lstr.add("hari");
		System.out.println(lstr);
		
		
		System.out.println(lstr.get(1));
		
		System.out.println(lstr.indexOf("gopi"));  
		
		//System.out.println(lstr.remove(1));  
		
		System.out.println(lstr.remove("jogi")); 
		
		System.out.println(lstr);
		
		lsit=lstr.listIterator();
		System.out.println("Elements in forward direction");
		while(lsit.hasNext()){
			System.out.println(lsit.next());
		}
		
		System.out.println("Elements in Backward Direction");
		while(lsit.hasPrevious()){
			System.out.println(lsit.previous()); 
		}

	}

}
