package game;

public class SecureLocation extends Location {

	Item key;

	public SecureLocation(String description, Item inv, int xc, int yc, String name, RequiredItem key) {
		super(description, inv, xc, yc, name);
		// TODO Auto-generated constructor stub
		this.key=key;
	}
	public boolean canEnter(Player p1){
		if(Player.inventory.contains(this.key)){
			return true;
		}
		else{
			return false;
		}
	}
}
