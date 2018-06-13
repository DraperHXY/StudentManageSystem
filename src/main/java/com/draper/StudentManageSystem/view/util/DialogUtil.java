package com.draper.StudentManageSystem.view.util;

import javax.swing.*;

/**
 * Created by Draper_HXY 31/05/2018 9:59 AM
 * Email: Draper_HXY@163.com
 */
public class DialogUtil {

    public static void info(String msg){
        JOptionPane.showMessageDialog(null, msg, "通知", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void warn(String msg){
        JOptionPane.showMessageDialog(null, msg, "警告", JOptionPane.WARNING_MESSAGE);
    }

    public static void error(String msg){
        JOptionPane.showMessageDialog(null, msg, "错误", JOptionPane.ERROR_MESSAGE);
    }

}
