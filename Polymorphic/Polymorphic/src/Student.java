
public class Student extends Person {

	private int score;

	public Student(String name) {
		super(name);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public void run() {
		System.out.println("Studetn " + this.getName() + " is running!");
	}

}
