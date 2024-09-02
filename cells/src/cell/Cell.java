package cell;

import java.awt.Graphics;
 
public class Cell {
	private boolean alive = false;
	
	public void die() { alive = false; }//死方法，调用会把alive设置成false
	public void reborn() { alive = true; }//活方法，调用会把alive设置成true
	public boolean isAlive() { return alive; }//查询死活的方法
//	{ return alive; }：这是方法的主体，由大括号{}包围。在这个例子中，方法体只有一行代码，即return alive;
//	alive是一个布尔类型的变量，在die函数和reborn函数中定义，false和true
	public void draw(Graphics g, int x, int y, int size) {
		g.drawRect(x, y, size, size);                                                                                                                                       
		if ( alive ) {
//			drawRect画个方框,如果是alive的情况,方框是要被填起来的
			g.fillRect(x, y, size, size);
		}
	}
}
