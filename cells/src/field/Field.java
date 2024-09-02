package field;//Field负责管好数据，里面有一个cell的二维数组，它的任务就是管好这个数组

import java.util.ArrayList;     

import cell.Cell;

public class Field {
	private int width;
	private int height;
//	field里面设置一个cell的二维数组，去做place,get一系列动作
	private Cell[][] field;
	//设置cell单元格的长和宽
	public Field(int width, int height) {
		this.width = width;
		this.height = height;
		field = new Cell[height][width];
	}
	
	public int getWidth() { return width; }//这个方法返回网格的宽度，即网格的列数
	public int getHeight() { return height; }//这个方法返回网格的高度，即网格的行数
	
	public Cell place(int row, int col, Cell o) {
		Cell ret = field[row][col];
		field[row][col] = o;
		return ret;
	}
	//这个方法用于在网格的指定位置放置一个Cell对象。
//	row 和 col 参数分别指定了目标位置的行和列。
//	o 是要放置的Cell对象。
	
	public Cell get(int row, int col) {
		return field[row][col];
	}
	//遍历cell的邻居，九宫格
	public Cell[] getNeighbour(int row, int col) {
		ArrayList<Cell> list = new ArrayList<Cell>();
		for ( int i=-1; i<2; i++ ) {
			for ( int j=-1; j<2; j++ ) {
				int r = row+i;
				int c = col+j;
				if ( r >-1 && r<height && c>-1 && c<width && !(r== row && c == col) ) {
					list.add(field[r][c]);
				}
			}
		}
		return list.toArray(new Cell[list.size()]);
	}
	
	public void clear() {
		for ( int i=0; i<height; i++ ) {
			for ( int j=0; j<width; j++ ) {
				field[i][j] = null;
			}
		}
	}
}
