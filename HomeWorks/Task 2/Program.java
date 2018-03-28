import java.util.Scanner;

class Program{
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		
		while (true){
			System.out.println("MENU:");
			System.out.println("1. Show in range");
			System.out.println("2. Sum of numbers");
			System.out.println("3. Sum of digits");
			System.out.println("4. Exit");
			
			int command = scanner.nextInt();
			
			switch(command) {
				case 1: {
					System.out.println("Vvedite 2 chisla:");
					int a = scanner.nextInt();
					int b = scanner.nextInt();
					//String s = "";
					if (a <= b) {
							for (int i = a; i <= b; i++) {
								if (i % 2 == 0) {
								//	s = i + " ";
									System.out.print(i + " ");
								}
							}
					}
					else {
							for (int i = a; i >= b; i--) {
								if (i % 2 == 0) {
								//	s = i + " ";
									System.out.print(i + " ");
								}
							}
					}
					System.out.println("");
					break;
				}
				case 2:{
					System.out.println("Vvedite chislo slagaemih:");
					int n = scanner.nextInt();
					int sum = 0;
					int[] a = new int[n];
					
					for (int i = 0; i < n; i++){
						a[i] = scanner.nextInt();
					}
					
					for (int i = 0; i < n; i++){
						//int a = scanner.nextInt();
						sum = sum + a[i];
					}
					System.out.println(sum);
					break;
				}
				case 3:{
					int suma = 0;
					System.out.println("Vvedite chislo:");
					int d = scanner.nextInt();
					String s = Integer.toString(d);
					char[] a = s.toCharArray();
					//System.out.println(s.length());
										
					for (int i = 0; i < s.length(); i++){
//						System.out.println(Character.getNumericValue(a[i]));
						suma = suma + Character.getNumericValue(a[i]);
					}
					System.out.println(suma);
					break;
				}
				default: {
					System.exit(0);
					break;
				}
			}
		}
	}
}