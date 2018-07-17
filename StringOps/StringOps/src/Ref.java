
public class Ref {

	public static void main(String[] args) {
		String s = "hello";
		System.out.println(s); // hello
		String t = s;
		System.out.println(t); // hello
		s = "world";
		System.out.println(s); // world
		System.out.println(t); // hello
	}
}
