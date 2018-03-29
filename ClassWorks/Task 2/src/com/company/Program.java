package com.company;

public class Program {

    public static void main(String[] args) {
	    int a[] = {5,7,9,11,4,6,8};

	    int n = 4;

	    for (int i = n-1; i <= a.length - 2; i++) {
	        a [i] = a [i+1];
        }

        a[a.length - 1] = 0;

        for (int i = 0; i <= a.length - 1; i++) {
            System.out.print(a[i] +" ");
        }

        System.out.println();

        int b[] = {8,6,4,11,9,7,5,0};

        int d = b.length / 2;

        int x;

        for (int i = 0; i <= d-1; i++){
            x = b[b.length - 1 - i];
            b[b.length - 1 - i] = b[i];
            b[i] = x;
        }

        for (int i = 0; i <= b.length - 1; i++) {
            System.out.print(b[i] +" ");
        }
    }
}
