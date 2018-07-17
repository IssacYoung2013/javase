
public class Main {

	public static void main(String[] args) {
		int[] ns1 = new int[5]; // { 0, 0, 0, 0, 0 }
		int[] ns2 = new int[] { 1, 3, 5, 7, 9 };
		int[] ns3 = { 2, 4, 6, 8, 10 };
		int[] ns4 = ns3;
		System.out.println("ns1.length: " + ns1.length);
		System.out.println("ns2.length: " + ns2.length);
		System.out.println("ns3.length: " + ns3.length);
		// 现在ns3和ns4指向同一个数组:
		System.out.println("ns3[1]: " + ns3[1]);
		ns3[1] = 999;
		System.out.println("ns4[1]: " + ns4[1]);
		// 把ns3指向一个新数组:
		ns3 = new int[] { 1, 2, 3 };
		ns3[1] = 888;
		System.out.println("ns4[1]: " + ns4[1]);
		// String数组:
		String[] strs = { "Abc", "Xyz", "123" };
		strs[1] = "Hello";
	}

}
