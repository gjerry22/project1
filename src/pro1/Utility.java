package pro1;

import java.util.Scanner;

public class Utility {
    private static Scanner scanner = new Scanner(System.in);

    public static char readMenuSelection() {
        char c;
        while(true) {
            String str = readKeyBoard(1);
            c = str.charAt(0);
            if(c != '1' && c != '2' && c != '3' && c != '4') {
                System.out.print("选择错误，请重新输入：");
            } else break;
        }
        return c;
    }

    public static int readNumber() {
        int n;
        while(true) {
            String str = scanner.nextLine();
            try {
                n = Integer.parseInt(str);
                if(Math.abs(n) < 10000) break;
                else System.out.println("请输入绝对值小于10000的数：");
            } catch(NumberFormatException e) {
                System.out.print("数字输入有误，请重新输入：");
            }
        }
        return n;
    }

    public static String readString() {

        return readKeyBoard(8);
    }

    public static char readConfirmSelection() {
        char c;
        while(true) {
            String str = readKeyBoard(1).toUpperCase();
            c = str.charAt(0);
            if(c == 'Y' || c =='N') break;
            else System.out.print("选择错误，请重新输入：");
        }
        return c;
    }

    private static String readKeyBoard(int limit) {
        String line = "";

        while(scanner.hasNext()) {
            line = scanner.nextLine();
            if(line.length() < 1 || line.length() > limit) {
                System.out.print("输入长度（不大于" + limit + "）错误，请重新输入：");
            } else break;
        }
        return line;
    }
}
