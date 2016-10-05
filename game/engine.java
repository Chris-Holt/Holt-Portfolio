package game;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import game.Location;
import game.Player;
import game.Item;
import game.BreadCrumb;
public class engine {
	static Scanner keyboard = new Scanner(System.in);

public static void main(String[] args) {    

	System.out.println("hello there, welcome to my game. to begin, type 'help' to see available commands, and 'start' to begin the game.");
	int movesmade=0;

	Location navmatrix[][]={ // make sure that invalid/empty locations are marked by null
					{null,null,null},
			{null,null,null},
			{null,null},
			{null,null},
			{null,null,null,null}
						};
	
	ArrayList<Item> inventory = new ArrayList<Item>();
	inventory.add(list);
	String[] tasks = {};
	Player player1=new Player("Player 1",0, navmatrix[2][2],tasks,inventory);

	
	while(true){
		String[] input = keyboard.nextLine().toLowerCase().split(" ");
		if(movesmade==50){
			endgame(false,"");
		}
		switch(input[0])
			{case "help":help();break;
			case "map": Location.Map(Player.inventory);break;
			case "quit":System.out.println("game over");return;
			case "look":System.out.println(player1.current.description);break;
			case "examine":examine(player1);break;
			case "north":player1.current=move(player1.current.yc-1,player1.current.xc,input,navmatrix, player1, movesmade);break;
			case "south":player1.current=move(player1.current.yc+1,player1.current.xc,input,navmatrix, player1, movesmade);break;
			case "east":player1.current=move(player1.current.yc,player1.current.xc+1,input,navmatrix, player1, movesmade);break;
			case "west":player1.current=move(player1.current.yc,player1.current.xc-1,input,navmatrix, player1, movesmade);break;
			case "use":use(input,Player.inventory,player1, Player.halftask);break;
			case "inv":Player.inv(Player.inventory);break;
			case "take":Item.take(input,Player.inventory, player1);break;
			case "drop":Item.drop(input,Player.inventory,player1);break;
			case "start":intro(player1);break;
			case "back":back(player1, BreadCrumb.breadtrail);break;
			case "talk":talk(player1,Player.havetalked);break;
			default:System.out.println("sorry, but '"+input[0]+"' is an invalid command, type help to see the full list of commands");break;
			}

		}
	}



	private static void back(Player player1, LinkedList<Location> breadtrail) {
	// TODO Auto-generated method stub
		if (breadtrail.isEmpty()||breadtrail.size()<2){
			System.out.println("you dont have any locations in your history");
			return;
		}
		else {
			Location dest = breadtrail.get(1);
			System.out.println("you are now in the "+dest.name);
			player1.current=dest;
			breadtrail.remove(0);
			return;
			}
		}








	private static void intro(Player player1) {
	// TODO Auto-generated method stub
		System.out.println("who are you?");
		String sinput = keyboard.nextLine();
		BreadCrumb.breadtrail.add(player1.current);
		player1.name = sinput;
	System.out.println("you are "+player1.name+" and you have one job:");
	System.out.println("");
	System.out.println("To Save the world!");
	System.out.println("");
	System.out.println("Good Luck");
}



	private static void examine(Player player1) {
		// TODO Auto-generated method stub\
		if(player1.current.inv==null){
			System.out.println("nothing is here");
			return;
		}
		else{System.out.println("there is a "+player1.current.inv.name);
		player1.current.inv.isdiscovered=true;
		}
	}


	private static Location move(int yc, int xc, String[] input, Location[][] navmatrix, Player player1, int movesmade) {
		Location dest=navmatrix[yc][xc];
		if (dest instanceof SecureLocation) {
			if (((SecureLocation)dest).canEnter(player1)==false) {
				dest=null;
				
			}
		}
		if (dest==null){System.out.println("you cant go there, check the map if you've found it");return player1.current;}
		else{System.out.println("you are now in the "+dest.name);movesmade=movesmade+1;BreadCrumb.drop(dest);return dest;}

			}


	// TODO Auto-generated method stub
	

	public static void taskcomplete(Player p1, String task){
		for(int i=0;i<p1.tasksrem;i++){
			if (task.equals(p1.tasks[i])){
				System.out.println("you completed the following task: "+p1.tasks[i]);
				p1.tasks[i]=null;
			}
			if (p1.tasksrem==0){
				endgame(true, null);
			}
		}
	}
	public static void endgame(Boolean win, String failstate) {
		if (win==true){
			System.out.println("You Win!");
		}
		else{
			System.out.println("many have tried before you, yet somehow, you failed the most");
			System.out.println("");
			System.out.println("i have a question though, how on earth did you end up "+failstate+"?");
		}
		System.exit(0);
	}

	private static void help() {
		System.out.println("the following are available commands:");
		System.out.println("");
		System.out.println("help: shows this list ");
		System.out.println("");
		System.out.println("look: describes whats around you");
		System.out.println("");
		System.out.println("inv: lists what is in your inventory of items.");
		System.out.println("");
		System.out.println("use: uses something you have.");
		System.out.println("");
		System.out.println("take: takes something in your current location");
		System.out.println("");
		System.out.println("examine: tells you what items are nearby");
		System.out.println("");
		System.out.println("drop: drops an item in your inventory");
		System.out.println("");
		System.out.println("north, south, east, or west: goes that direction.");
		System.out.println("");
		System.out.println("quit: exits the game loop.");
		
}

	private static void use(String[] input,ArrayList<Item> inv, Player player1, int halftask) {
		if(input.length<2){
			System.out.println("you need to type an items name as well");
			return;
		}
		for(int i=0;i<inv.size();i++){
			if (input[1].equals(inv.get(i).name)){usecase(inv.get(i), player1, input, halftask);}
				}
		
	}


	@SuppressWarnings("static-access")
	private static void usecase(Item target, Player player1, String[] input, int halftask) {
		// TODO Auto-generated method stub
		if(target instanceof LimitedUseItem){
			((LimitedUseItem)target).Used(((LimitedUseItem) target).uses, player1.inventory, target);
		}
		switch(target.getName()){
			//Args for the item you are using
			}
	}
}


