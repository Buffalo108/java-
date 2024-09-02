//用于定位，返回所要cell位置
package field;
//Location 类是一个简单的数据容器类，用于存储一个位置的行和列信息
public class Location{
	private int row;
	private int col;
	
	public Location( int row, int col ){
		this.col = col;
		this.row = row;
	}
	
//	Getter方法,方法 getRow() 和 getCol()，用于获取行和列的值
	public int getRow(){
		return row;
	}
	public int getCol() {
		return col;
	}
}
