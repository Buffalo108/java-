package dome;

public class CD extends Item {
	private String artist;
	private int numofTracks;
	

//	创建构造函数——运用工具批量初始化Source - Generate Constructor using Fields
public CD(String title, String artist, int numofTracks, int playingTime, String comment) {
//	在item里对title赋完初始值，回到括号把title传进去 super() → super(title)
	super(title, playingTime, false, comment);
//	this.title = title;
	this.artist = artist;
	this.numofTracks = numofTracks;
//	this.playingTime = playingTime;
//	got it已经初始化过了
//	this.comment = comment;
}

	@Override
public String toString() {
	return "CD [artist=" + artist + ", numofTracks=" + numofTracks + ", toString()=" + super.toString() + "]";
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CD cd = new CD("a","b",2,2,"...");
		CD cd1 = new CD("a","b",2,2,"...");
		System.out.println(cd.equals(cd1));
////		cd.print();
////		aa是字符串的形式，若使aa和cd相加，则应先使cd变成字符串
//		String s ="aa"+cd;
//		System.out.println(s);
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		CD cc = (CD)obj;
		return artist.equals(cc.artist);
	}

//	public void print() {
//		System.out.print("CD:");
//		super.print();
//		System.out.print(":"+artist);
//	}


}
