import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

//Wit Sampson
// Data Created: 10/19/2018
//The purpose of this class is to give movement to the game
public class Movement {
	String objectMoving;
	int x = 0;
	int y = 0;
	EventHandler<? super KeyEvent> move;
	
	public Movement(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void move(KeyEvent event) {
		KeyCode myCode = event.getCode();
		if(myCode == KeyCode.A)
		{
			x-=10;
			this.x = x;
			
		}
		else if(myCode == KeyCode.D)
		{
			x+=10;
			this.setX(x);
			
		}
		else if(myCode == KeyCode.S)
		{
			y+=10;
			this.setY(y);
			
		}
		else if(myCode == KeyCode.W)
		{
			y-=10;
			this.setY(y);
			
		}
	
	}
	
	
}
