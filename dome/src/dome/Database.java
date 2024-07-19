package dome;

import java.util.ArrayList;

public class Database {
//	定义了类型为ArrayList<CD>的变量listCD，并将其初始化为一个新的ArrayList对象，该对象将用于存储CD类型的对象
//	private ArrayList<CD> listCD = new ArrayList<CD>();
//	private ArrayList<DVD> listDVD = new ArrayList<DVD>();
	private ArrayList<Item> listItem = new ArrayList<Item>();
	
//	包裹配合add函数
	// 将传入的CD对象cd添加到listCD列表中
//	public void add(CD cd) {
//		listCD.add(cd);
//	}
//	public void add(DVD dvd) {
//		listDVD.add(dvd);
//	}
	public void add(Item item) {
		listItem.add(item);
	}
	
//	函数的重载CD、DVD
	
//	有add就有list
//	public void list() {
//		// 遍历listCD中的每个CD对象
//		for ( CD cd : listCD ) {
//		// 调用当前CD对象的print方法
//			cd.print();
//		}
//		for ( DVD dvd : listDVD ) {
//			dvd.print();
//		}
//	}
	public void list() {
		for ( Item item : listItem ) {
			item.print();
			System.out.println( );
		}
	}
	
	public static void main(String[] args) {
//		Object o = new Object();
//		o.
//		String s = "hello";
//		s = "bye";
//		测试
		Database db = new Database();
		db.add(new CD("abc", "abc", 4, 60, "..."));
		db.add(new CD("def", "def", 4, 60, "..."));
		db.add(new DVD("vvv", "aaa", 60, "..."));
		db.add(new MP3("ddd", 70, true, "...", "..."));
		db.list();
	}

}

