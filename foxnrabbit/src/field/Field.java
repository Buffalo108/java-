//定义场地类:Field类,用于存储动物的位置和操作它们

//属性：长、宽、cell二维数组；
//构造方法：生成指定大小cell二维数组；
//简单方法：获取长、宽、指定cell;
//获取周围细胞方法：输入现在细胞坐标，返回周围细胞数组；
//获取周围空cell数组：输入现在细胞坐标，返回空cell坐标数组；
//在周围空cell里放置一个cell:
//输入现在细胞坐标 和 放入的cell；返回是否成功放入cell进field；
//根据坐标删除cell：输入坐标，删除cell(置field数组指空)，返回删除；
//根据细胞删除cell：输入细胞，细胞删除(此处可以优化)；
//clear方法：删除所有细胞；
//move方法：细胞移动；


//包和导入
package field;

import java.util.ArrayList;

import cell.Cell;

public class Field {
//  这段代码没用到过
//	private static final Location[] adjacent = {
//			new Location(-1,-1),new Location(-1,0),new Location(-1,1),
//			new Location(0,-1) ,new Location(0,0) ,new Location(0,-1), 
//			new Location(1,-1) ,new Location(1,-1),new Location(1,-1),
//	};
	private int width;//网格的宽度和高度
	private int height;
	private Cell[][] field;

//构造函数	
	//初始化网格的宽度和高度，并创建一个 height 行 width 列的二维数组 field。
	public Field(int width, int height){
		this.height = height;
		this.width = width;
		field = new Cell[height][width];
	}
	
//基本访问方法	
	public int getWidth(){ return width; }
	public int getHeight(){ return height; }
	
//获取特定位置的单元格	
	public Cell get(int row, int col){
		return field[row][col];
	}
	
//获取邻居单元格
	public Cell[] getNeighbour(int row, int col) {
		ArrayList<Cell> list = new ArrayList<Cell>();
		for( int i = -1; i<2; i++ ) {
			for( int j = -1; j<2; j++ ) {
				int r = row+i;
				int c = col+j;
				if( r>-1 && r<height && c>-1 && c<width && !(r == row && c == col)) {
					list.add(field[r][c]);
				}
			}
		}
		return list.toArray(new Cell[list.size()]);
	}
	
//获取空的邻居位置
	public Location[] getFreeNeighbour(int row, int col) {   
		ArrayList<Location> list = new ArrayList<Location>();
		for( int i = -1; i<2; i++ ) {
			for( int j = -1; j<2; j++ ) {
				int r = row+i;
				int c = col+j;
				if( r>-1 && r<height && c>-1 && c<width && field[r][c] == null ) {
					list.add(new Location(r, c));
				}
			}
		}
		return list.toArray(new Location[list.size()]);
	}
	
//随机放置单元格在空邻居位置	
	//移除指定位置的单元格并返回它
	public boolean placeRandomAdj( int row, int col, Cell cell ){//当前cell的信息 （行，列，要放置的单元格对象）  
		boolean ret = false;//初始化返回值ret，表示默认情况下没有成功放置单元格
		Location[] FreeAdj = getFreeNeighbour(row, col);//获取空邻居位置
		if( FreeAdj.length > 0 ){//检查是否有空邻居
			//随机选择一个空邻居位置并放置单元格
			int idx = (int)(Math.random()*FreeAdj.length);
			//Math.random() 生成一个 0 到 1 之间的随机数，并将其乘以 FreeAdj 数组的长度，得到一个随机索引 idx
			field[FreeAdj[idx].getRow()][FreeAdj[idx].getCol()] = cell;
			//通过 FreeAdj[idx] 获取随机选择的空邻居位置的 Location 对象
			ret = true;
		}
		return ret;
	}
	
//移除单元格
	//将指定位置的单元格移动到新的位置，并清除原位置的单元格
	public Cell remove( int row, int col ){
		Cell ret = field[row][col];
		field[row][col] = null;
		return ret;
	}
	//方法遍历网格，移除指定的单元格
	public void remove( Cell cell ){
		for( int row = 0; row < height; row++ ){
			for( int col = 0; col <width; col++ ){
				if( field[row][col] == cell ){
					field[row][col] = null;
					break;
				}
			}
		}
	}
	
//清空网格	
	public void clear(){
		for( int i = 0; i < height; i++){
			for( int j = 0; j < width; j++){
				field[i][j] = null;
			}
		}
	}

//移动单元格	
	public void move(int row, int col, Location loc){
		field[loc.getRow()][loc.getCol()] = field[row][col];
		remove(row,col);
	}
	
//放置单元格
	public Cell place(int row, int col, Cell c) {
		Cell ret = field[row][col];
		field[row][col] = c;
		return ret;
	}
}


