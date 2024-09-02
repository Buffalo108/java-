package field;
//View知道Field，其中只有一个paint函数
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import cell.Cell;

public class View extends JPanel { //创建图形用户界面
	private static final long serialVersionUID = -5258995676212660595L;//确保在反序列化过程中类的兼容性
	private static final int GRID_SIZE = 16;//GRID_SIZE用来定义某种网格的大小。
	private Field theField;
	
	public View(Field field) {
		theField = field;// 在构造方法中，将传入的field参数赋值给类的字段theField
	}

	@Override
//	override表示继承，也就是说，paint是继承来的，继承自JPanel（Java自带的表示一块画面）
//	每一次窗口要被显示出来时会调用一次paint函数，被调用时会得到一个Graphics对象，这个对象就是要画出来的东西
	public void paint(Graphics g) {
		super.paint(g);
//		去遍历Graphics,找到里面的细胞，如果那个各自内的细胞是存在的就把自己画出来
		for ( int row = 0; row<theField.getHeight(); row++ ) {
			for ( int col = 0; col<theField.getWidth(); col++ ) {
				Cell cell = theField.get(row, col);
				if ( cell != null ) {
					cell.draw(g, col*GRID_SIZE, row*GRID_SIZE, GRID_SIZE);
				}
			}
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(theField.getWidth()*GRID_SIZE+1, theField.getHeight()*GRID_SIZE+1);
	}
//	这段代码初始化了一个10x10的二维网格，并在每个单元格中放置了一个新的Cell对象
	public static void main(String[] args) {
		Field field = new Field(10,10);
		for ( int row = 0; row<field.getHeight(); row++ ) {
			for ( int col = 0; col<field.getWidth(); col++ ) {
				field.place(row, col, new Cell());//在遍历的位置放入cell
			}
		}
		View view = new View(field);
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("Cells");
		frame.add(view);
		frame.pack();
		frame.setVisible(true);
	}

}
