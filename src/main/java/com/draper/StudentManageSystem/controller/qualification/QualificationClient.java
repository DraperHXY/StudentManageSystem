package com.draper.StudentManageSystem.controller.qualification;

import java.util.Scanner;

/**
 * Created by Draper_HXY 30/05/2018 9:54 AM
 * Email: Draper_HXY@163.com
 */
public class QualificationClient {

    public static QualificationState check(String account, String password) {
        QualificationState state = QualificationCheck.check(account, password);
        return state;
    }

    public static void main(String[] args) {
        QualificationContext qualificationContext = new QualificationContext();

        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("请输入账号");
            String account = in.nextLine();
            System.out.println("请输入密码");
            String password = in.nextLine();
            QualificationState state = QualificationCheck.check(account, password);
            if (state == null) {
                System.out.println("账号密码错误");
            } else {
                qualificationContext.setQualificationState(state);
                qualificationContext.getInfo();
                qualificationContext.operate(null);
            }
        }
    }
}
