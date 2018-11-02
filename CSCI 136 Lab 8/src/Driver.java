import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Driver extends Application {
	TextField txt;
	Text text1;
	ImageView myImageView;
	ImageView itemImageView1;
	ImageView itemImageView2;
	ImageView itemImageView3;
	ImageView itemImageView4;
	ImageView itemImageView5;
	int x = 0, y = 0;
	KeyCode move;
	Movement movement = new Movement(x,y);
	String imagePath;
	
	Random myRand = new Random();
	int randomX;
	int randomY;
	int numberItems = 5;
	
	Items coin = new Items ("file:src/coin.jpg", numberItems, randomX, randomY);
	
	ArrayList items = new ArrayList<Items>();
	
	public void addItem(Items item) {
		if (item == null) {
			throw new IllegalArgumentException();
		}
		items.add(item);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
		
	}

	@Override
	public void start(Stage PrimaryStage) throws Exception {
		// TODO Auto-generated method stub
		Text text = new Text("WELCOME TO MY GAME");
		text.setFont(Font.font(40));
		text.setLayoutX(35);
		text.setLayoutY(100);
		
		txt = new TextField("ENTER YOUR NAME");
		txt.setLayoutX(175);
		txt.setLayoutY(350);
		
		Button button = new Button("START GAME");
		button.setLayoutX(200);
		button.setLayoutY(250);
		button.setOnAction(this::startGame);
		
		
		
		
		Group root = new Group(text,button,txt);
		Scene scene = new Scene(root,500,500,Color.WHITE);
		PrimaryStage.setTitle("Game");
		PrimaryStage.setScene(scene);
		PrimaryStage.show();
		
	}
	
	public void startGame(ActionEvent args) {
		
		Image image1 = new Image("file:src/hero.png");
		myImageView = new ImageView(image1);
		myImageView.setFitWidth(50);
		myImageView.setFitHeight(50);
		myImageView.setX(x);
		myImageView.setY(y);
		
		for (int i = 0 ; i< items.length; i++) {
			Image coinImage = new Image(coin.getImagePath());
			itemImageView1 = new ImageView(coinImage);
			itemImageView1.setFitWidth(25);
			itemImageView1.setFitHeight(25);
			itemImageView1.setX(x);
			itemImageView1.setY(y);
			
		}
				
		
		
	/*	
			Random myRand = new Random();
			x = myRand.nextInt(500);
			y = myRand.nextInt(500);
			Image item1 = new Image("file:src/coin.jpg");
			itemImageView1 = new ImageView(item1);
			itemImageView1.setFitWidth(25);
			itemImageView1.setFitHeight(25);
			itemImageView1.setX(x);
			itemImageView1.setY(y);
			
			
			
			
			x = myRand.nextInt(500);
			y = myRand.nextInt(500);
			itemImageView2 = new ImageView(item1);
			itemImageView2.setFitWidth(25);
			itemImageView2.setFitHeight(25);
			itemImageView2.setX(x);
			itemImageView2.setY(y);

			x = myRand.nextInt(500);
			y = myRand.nextInt(500);
			itemImageView3 = new ImageView(item1);
			itemImageView3.setFitWidth(25);
			itemImageView3.setFitHeight(25);
			itemImageView3.setX(x);
			itemImageView3.setY(y);

			x = myRand.nextInt(500);
			y = myRand.nextInt(500);
			itemImageView4 = new ImageView(item1);
			itemImageView4.setFitWidth(25);
			itemImageView4.setFitHeight(25);
			itemImageView4.setX(x);
			itemImageView4.setY(y);

			x = myRand.nextInt(500);
			y = myRand.nextInt(500);
			itemImageView5 = new ImageView(item1);
			itemImageView5.setFitWidth(25);
			itemImageView5.setFitHeight(25);
			itemImageView5.setX(x);
			itemImageView5.setY(y);
			
		x=0;
		y=0;
*/		
		int itemCollected = 0;
		String name = txt.getText();
		
		playerOne pOne = new playerOne(name,itemCollected);
		
		
		text1 = new Text();
		text1.setText(pOne.getPlayerName());
		
		
		Group root2 = new Group(myImageView,text1,itemImageView1,itemImageView2,itemImageView3,itemImageView4,itemImageView5);
		Scene scene2 = new Scene(root2,500,500,Color.WHITE);
		scene2.setOnKeyPressed(movement.move);
		myImageView.setX(movement.getX());
		myImageView.setY(movement.getY());
		text1.setX(x);
		text1.setY(y);
		scene2.setOnKeyPressed(this::listenUp);
		scene2.setOnKeyReleased(this::listenUp);
		
		Stage SecondaryStage = new Stage();
		SecondaryStage.setScene(scene2);
		SecondaryStage.show();
	}
	
	public void listenUp(KeyEvent event)
	{
		
		myImageView.setX(movement.getX());
		myImageView.setY(movement.getY());
		
		
		/*KeyCode myCode = event.getCode();
		if(myCode == KeyCode.A)
		{
			x-=10;
			
		}
		else if(myCode == KeyCode.D)
		{
			x+=10;
			
		}
		else if(myCode == KeyCode.S)
		{
			y+=10;
			
		}
		else if(myCode == KeyCode.W)
		{
			y-=10;
			
		}
	

		myImageView.setX(movement.getX());
		myImageView.setY(movement.getY());
		text1.setX(x);
		text1.setY(y);*/
		
		
	}
	private boolean areRectsColliding(int r1TopLeftX, int r1BottomRightX,int r1TopLeftY, 
			int r1BottomRightY,int r2TopLeftX,int r2BottomRightX, int r2TopLeftY, int r2BottomRightY)
			{
			if (r1TopLeftX < r2BottomRightX && r1BottomRightX >
			r2TopLeftX&& r1TopLeftY < r2BottomRightY && r1BottomRightY >
			r2TopLeftY) 
			{
			return true;
			}
			else
			{
			return false;
			}
			}

	

}
