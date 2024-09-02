//定义视图类:View类,用于绘制场地及其上的动物。
//继承自JPanel面板
//重写的方法：paint，设置刚好的尺寸；

//View 类负责绘制狐狸和兔子生态系统的图形界面。
//继承自 JPanel，用于绘制网格和每个 Cell 对象。
//构造函数初始化场地对象。
//重写 paint 方法绘制网格和动物。
//重写 getPreferredSize 方法设置面板的首选大小

//包声明和导入
package field;
//导入所需的类，涉及图形绘制和面板
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

import cell.Cell;

//类声明
public class View extends JPanel{//声明一个名为 View 的公共类，继承自 JPanel
	private static final long serialVersionUID = -2417015700213488315L;//用于序列化的版本标识符
	private static final int GRID_SIZE = 16;//定义每个网格的大小为 16 像素
	private Field thefield;
	
    //构造函数，接受一个 Field 对象并初始化 thefield 变量
	public View (Field field){
		thefield = field;
	}
	
//重写的 paint 方法	
	@Override
	public void paint( Graphics g ){//重写 JPanel 的 paint 方法，用于自定义绘制内容
		super.paint(g);//调用父类的 paint 方法，确保面板正确重绘
		g.setColor(Color.gray);//设置绘制颜色为灰色
		//使用双重循环绘制网格线,第一组循环绘制水平线,第二组循环绘制垂直线
		for( int row = 0; row < thefield.getHeight(); row++ ){
			g.drawLine(0, row*GRID_SIZE, thefield.getWidth()*GRID_SIZE, row*GRID_SIZE);
		}
		for( int col = 0; col < thefield.getHeight(); col++ ){
			g.drawLine(col*GRID_SIZE, 0, col*GRID_SIZE, thefield.getHeight()*GRID_SIZE);
		}
		//再次使用双重循环遍历场地的每个位置,如果当前位置有 Cell 对象，则调用其 draw 方法绘制
		for( int row = 0; row < thefield.getHeight(); row++){
			for( int col = 0; col < thefield.getWidth(); col++){
				Cell cell = thefield.get(row, col);
				if( cell != null ){
					cell.draw( g, col*GRID_SIZE, row*GRID_SIZE, GRID_SIZE);
				}
			}
		}
	}
	
//重写的 getPreferredSize 方法	
	@Override
	public Dimension getPreferredSize(){//重写 JPanel 的 getPreferredSize 方法，返回首选大小。
		return new Dimension(thefield.getWidth()*GRID_SIZE+1, thefield.getHeight()*GRID_SIZE+1);
	}//返回一个 Dimension 对象，表示面板的首选大小为场地的宽度和高度乘以网格大小
	
}
