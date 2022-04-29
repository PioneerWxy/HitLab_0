package exercise_1;

import java.util.Scanner;

public class HIndex1 {
    public static void main(String[] args) {
        // read input from keyboard
        Scanner scanner = new Scanner(System.in);
        //System.out.println("Please input the citation numbers:");

        String[] strs;
        int[] citations = new int[100];
        String line = new String();

        //loop, until user inputs legal string
        while (true) {
            System.out.println("Please input the citation numbers:");
            line = scanner.nextLine();
            //if the input is empty
            if (line.length() == 0) {
                System.out.println("Input empty!");
                continue;
            }
            //check if each part is integer >= 0
            boolean legalNumbers = true;
            strs = line.split(",");
            for (int i = 0; i < strs.length; i++) {
                //if not, stop checking others and let user re-input
                if(! strs[i].matches("[0-9]+")) {
                    System.out.println(strs[i] + " is illegal: ");
                    legalNumbers = false;
                    break;//break for
                }
                //otherwise, store the integer into array
                citations[i] = Integer.parseInt(strs[i]);
            }
            if (!legalNumbers)
                continue;//continue while
            else {
                //sort and calculate h-index
                int number = bubbleSortOfCitations(citations);
                int hindex = calculateHIndex(citations, number);
                //output to console
                System.out.println("The h-index is: " + hindex);
                break;
            }
        }


    }

    private static int calculateHIndex(int[] citations, int number) {
        //计算 h-index
        int hindex = 0;
        for (int j = 0; j < number; j++) {
            if (citations[j] >= j + 1)
                hindex = j + 1;
            else
                break;
        }
        return hindex;
    }

    private static int bubbleSortOfCitations(int[] citations) {
        // 编写排序功能（冒泡排序）
        int number = citations.length;
        for (int i = 0; i < number - 1; i++) {
            for (int j = 0; j < number - i - 1; j++) {
                if (citations[j] < citations[j + 1]) {
                    int temp = citations[j + 1];
                    citations[j + 1] = citations[j];
                    citations[j] = temp;
                }
            }
        }
        return number;
    }
}
