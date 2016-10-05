package game;

import java.util.LinkedList;

public class BreadCrumb {

	 @SuppressWarnings("unchecked")
	static LinkedList<Location> breadtrail = new LinkedList();

	public static void drop(Location dest) {
		// TODO Auto-generated method stub
			BreadCrumb.breadtrail.addFirst(dest);
		return;
	}

	
 
}
