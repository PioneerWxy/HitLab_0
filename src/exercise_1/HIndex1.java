package exercise_1;

import java.util.Scanner;

public class HIndex1 {
    public static void main(String[] args) {
        // 从控制台读入用户输入，按 3,0,6,1,5 的格式,存储于数组
        Scanner scanner = new Scanner(System.in);
        int[] citations = new int[100];
        String[] strs;
        System.out.println("Please input the citation numbers:");
        String line = scanner.nextLine();
        strs = line.split(",");
        for (int i = 0; i < strs.length; i++)
            citations[i] = Integer.parseInt(strs[i]);
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
        //计算 h-index
        int hindex = 0;
        for (int j = 0; j < number; j++) {
            if (citations[j] >= j + 1)
                hindex = j + 1;
            else
                break;
        }
        //打印到控制台
        System.out.println("The h-index is: " + hindex);
        scanner.close();
    }
}
