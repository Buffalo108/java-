package dome;

public class DVD extends Item{
//	private String title;
	private String director;
//	private int playingTime;
//	private boolean gotIt = false;
//	private String comment;

	public DVD(String title, String director, int playingTime, String comment) {
		super(title, playingTime, false, comment);
//		super(playingTime);
		this.director = director;
//		super(comment);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void print() {
		// TODO Auto-generated method stub
		System.out.print("DVD:");
		super.print();
		System.out.print(":"+director);
		
	}

}
