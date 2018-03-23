import java.util.Scanner;

class Program {
	public static void main(String args[]) {
		
		System.out.println("Vvedite chislo ot 0 do 255:");
		
		Scanner scanner = new Scanner(System.in);
		
		int number = scanner.nextInt();
		
		int res8 = number % 2;
		int res7 = number / 2 % 2;
		int res6 = number / 4 % 2;
		int res5 = number / 8 % 2;
		int res4 = number / 16 % 2;
		int res3 = number / 32 % 2;
		int res2 = number / 64 % 2;
		int res1 = number / 128;
		
/*		System.out.println(number);*/
		System.out.println(number+" (10) -> (2): "+res1+""+res2+""+res3+""+res4+""+res5+""+res6+""+res7+""+res8);
/*		System.out.println(res8);
		System.out.println(res7);
		System.out.println(res6);
		System.out.println(res5);
		System.out.println(res4);
		System.out.println(res3);
		System.out.println(res2);*/
	}
}