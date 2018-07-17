
public class BitOps {

	public static void main(String[] args) {
		int n1 = 0x03_83_d0_25;
		int n2 = 0x00_00_ff_ff;
		int n3 = n1 & n2; // 0x00_00_d0_25
		int n4 = 0x03_83_d0_25 | 0x00_00_ff_ff; // 0x03_83_ff_ff
		System.out.println(n1);
		System.out.println(n2);
		System.out.println(n3);
		System.out.println(n4);
	}

}
