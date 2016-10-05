package game;

import java.util.ArrayList;

public class Item {
	public class LimitedUseItem {

	}
	String name;
	String Description;
	int points;
	Boolean isdiscovered;
	
	public Item(String name, String Description,int points, Boolean isdiscovered) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.Description=Description;
		this.points = points;
		this.isdiscovered=isdiscovered;
	}
	
	public String getName (){
	return this.name;
	}
	static void take(String[] input, ArrayList<Item> inventory, Player p1) {
		if (input[1].equals(p1.current.inv.name) && p1.current.inv.isdiscovered == true){ 
						System.out.println(p1.current.inv.name+" has been added to inventory"); 
						p1.Addscore(p1.current.inv.points);
		inventory.add(p1.current.inv);p1.current.inv=null;
		}
		else{System.out.println("that isnt here, keep looking or check your spelling");}
		
	}


	public static void drop(String[] input, ArrayList<Item> inv, Player p1) {
		// TODO Auto-generated method stub
		if(p1.current.inv==null){
			System.out.println("find somewhere else to put that");
			}
		else{
			for(int i=0;i<inv.size();i++){
				if (input[1].equals(inv.get(i).name)){
					System.out.println(inv.get(i)+" is now in the "+p1.current.name);
					p1.current.inv=inv.get(i);
					inv.remove(i);
				}
			}
		}
	}
}