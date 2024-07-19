package dome;

public class MP3 extends Item{
	private String singer;
	
	public MP3(String title, int playingTime, boolean gotIt, String comment, String singer) {
		super(title, playingTime, gotIt, comment);
		this.singer = singer;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.print("singer:");
		super.print();
		System.out.print(":"+singer);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


}
