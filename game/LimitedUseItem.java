package game;

import java.util.ArrayList;

public class LimitedUseItem extends Item{

	int uses;

	public LimitedUseItem(String name, String Description, int points, Boolean isdiscovered, int uses) {
		super(name, Description, points, isdiscovered);
		// TODO Auto-generated constructor stub
		this.uses=uses;
	}
	public void Used(int uses, ArrayList<Item> inventory, Item target){
		if(uses>=1){
		uses=uses-1;
		}
		else{
			inventory.remove(target);
		}
	}

}
