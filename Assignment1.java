/********************************************************************************
 * Michael Zou Wu | EMPLID: 23253305
 * Complication: javac Assignment1.java
 * Execution: java Assignment1 < input.txt
 *
 * Reads in a text file and for each line verifies whether the word has
 * unique characters and prints each word in order of sorted characters
 * alongside the boolean value.
 *
 *********************************************************************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Assignment1 {
    /**
     * the main method
     * @param args
     * @throws FileNotFoundException
     */
    public static void main (String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input.txt"));
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            System.out.println(isUniqueChar(s) + "\t" + sortWord(s));
        }
        sc.close();
    }

    /**
     * the isUniqueChar method
     * @param s
     * @return true or false
     */
    public static boolean isUniqueChar(String s) {
        for (int i = 0; i < s.length(); i++){
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j))
                    return false;
            }
        }
        return true;
    }

    /**
     * the sortWord method
     * @param s
     * @return the sorted string
     */
    private static String sortWord(String s) {
        char[] c = s.toLowerCase().toCharArray();
        StringBuilder sortedWord = new StringBuilder();
        insertionSort(c);
        for (int i = 0; i < c.length; i++) {
            sortedWord.append(c[i]);
        }
        return sortedWord.toString();
    }

    /**
     * the insertionSort method
     * @param ch
     */
    public static void insertionSort(char[] ch) {
        if (ch == null || ch.length == 0)
            return;

        for (int i = 0; i < ch.length; i++) {
            char temp = ch[i];
            int j = i;
            while (j > 0 && ch[j-1] > temp) {
                ch[j] = ch[j-1];
                j--;
            }
            ch[j] = temp;
        }
        return;
    }
}
