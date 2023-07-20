package com.jerry.study.jdbc.cms.view;

import java.util.Scanner;

/**
 * ClassName: KeyboardUtility
 * Package: com.jerry.study.jdbc.cms.view
 * Description:
 *
 * @Author: Jerry
 * @Date: 2023/4/10
 */
public class KeyboardUtility {

    private static Scanner scan = new Scanner(System.in);
    public static int readMenuSelection() {
        while (true) {
            try {
                int choice = Integer.parseInt(scan.nextLine().strip());
                switch (choice) {
                    case 1, 2, 3, 4, 5 -> {
                        return choice;
                    }
                }
            } catch (NumberFormatException ignored) {

            }
            System.out.print("输入有误，请重新输入：");
        }
    }
}
