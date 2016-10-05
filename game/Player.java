package game;
import java.util.ArrayList;
public class Player {
	
	public String name;
	public int tasksrem;
	public String[] tasks;
	int score=0;
	static ArrayList<Item>inventory;
	public Location current;

	public Player(String name, int score, Location current, String[] tasks, ArrayList<Item> inventory) {
		// TODO Auto-generated constructor stub
		this.score=score;
		this.name=name;
		this.current=current;
		this.tasksrem=taskremcalc(tasks);	
		this.tasks=tasks;
		Player.inventory=inventory;
	}

	private int taskremcalc(String[] tsk) {
		// TODO Auto-generated method stub
		for (int i=0;i<tsk.length;i++){
		if (tsk[i]!=null){
			tasksrem=tasksrem+1;
		}
		}
		return tasksrem;
	}

	public void Addscore(int sc){
		this.score=this.score+sc;
		System.out.println(sc+" points! your current score is:"+this.score );
	}
	public static void inv(ArrayList<Item> inv) {
		// TODO Auto-generated method stub
		for(int i=0;i<inv.size();i++){
			System.out.println(inv.get(i).name+" : "+inv.get(i).Description);
			System.out.println("");
		}
	}
}