package com.draper.StudentManageSystem;

import com.draper.StudentManageSystem.view.LoginInView;
import com.draper.StudentManageSystem.view.util.SwingConsoleUtil;

/**
 * Created by Draper_HXY 30/05/2018 10:48 PM
 * Email: Draper_HXY@163.com
 */
public class Main {

    public static void main(String[] args) {
        SwingConsoleUtil.run(LoginInView.getInstance(), 270, 170);
    }

}
