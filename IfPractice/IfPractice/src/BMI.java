import java.util.Scanner;

public class BMI {

	/**
	 * BMI = 体重(kg)除以身高(m)的平方
	 * 
	 * 过轻：低于18.5
	 * 正常：18.5-25
	 * 过重：25-28
	 * 肥胖：28-32
	 * 非常肥胖：高于32
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Height (m): ");
		double height = scanner.nextDouble();
		System.out.print("Weight (kg): ");
		double weight = scanner.nextDouble();
		// FIXME:
		double bmi = 0;
		// TODO: 打印BMI值及结果
	}

}
