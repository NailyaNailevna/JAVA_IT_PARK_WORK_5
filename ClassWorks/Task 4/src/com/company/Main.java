package com.company;

public class Main {

    public static void main(String[] args) {
	    char text[] = "hello how are you damirll".toCharArray();
	    int ar[] = new int[26];

	    for (int i = 0; i <= text.length - 1; i++){
	        if (text[i] != ' ') {
                //ar[(int) text[i] - 97] = ar[(int) text[i] - 97] + 1;
                int textInd = text[i] - 'a';
                ar[textInd]++;
            }
        }

        int maxVal = 0;
	    int maxInd = 0;

        for (int i = 0; i < ar.length; i++){
	        if (ar[i] >= maxVal){
                maxVal = ar[i];
                maxInd = i;
            }
        }

        System.out.println((char)(maxInd + 'a'));

    }
}
