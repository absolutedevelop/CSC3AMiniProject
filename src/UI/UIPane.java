package UI;
import javafx.scene.layout.StackPane;


public class UIPane extends StackPane{

	private int width;
	private int height;

	public UIPane(int width,int height){
		this.width = width;
		this.height = height;
	}

	public int getPaneWidth(){
		return this.width;
	}

	public int getPaneHeight(){
		return this.height;
	}

}