import java.util.ArrayList;
import java.util.List;


public class Node {
	boolean isFin=false;
	int value=99999;
	int x,y;
	
	public Node(int x,int y){
		this.x = x;
		this.y = y;
	}

	public boolean isCoordinate(int x, int y){
		if(this.x == x && this.y == y){
			return true;
		}
		return false;
	}
	
	public void setisfin(){
		isFin=!isFin;
	}
	
	public void setvalue(int a){
		value=a;
	}
	
	public int getValue(){
		return value;
	}

}
