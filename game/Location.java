package game;

import java.util.ArrayList;

public class Location {
	String description;
	public Item inv;
	public int yc;
	public int xc;
	public String name;

	public Location(String description, Item inv, int xc, int yc, String name) {
		this.name=name;
		this.description = description;
		this.inv= inv;
		this.yc=yc;
		this.xc=xc;
	}

	

	public static void Map(ArrayList<Item>inv) {

		for(int i=0;i<inv.size();i++){
			if (inv.get(i).name.equals("map")){
			System.out.println("Here is where a ASCII version of the map goes");
			return;
			}
		}
				System.out.println("nice try, you dont have the map");
	}
}


	
