//Wit Sampson
// Data Created: 10/19/2018
// The purpose of this class is to put the player into the game, the one that is being played by the user
public class playerOne {
	private String playerName;
	private String imagePath;
	private int itemCollected;
	
	
	public playerOne(String playerName,int itemCollected){
		this.playerName = playerName;
		this.itemCollected = itemCollected;
	}
	
	public String getImagePath() {
		return imagePath;
	}

	/*public void Movement() {
		Movement move = new Movement(50,50);
	}*/
	
	public int collectingItems(int itemCollected) {
		return 0;
	}
	
	public String getPlayerName() {
		return playerName;
	}
}
