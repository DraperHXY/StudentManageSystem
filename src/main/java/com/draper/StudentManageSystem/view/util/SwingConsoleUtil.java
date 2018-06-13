package com.draper.StudentManageSystem.view.util;

import javax.swing.*;

/**
 * Created by Draper_HXY 30/05/2018 12:22 PM
 * Email: Draper_HXY@163.com
 */
public class SwingConsoleUtil {
    public static void run(final JFrame f, final int width, final int height) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                f.setTitle(f.getClass().getSimpleName());
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setSize(width, height);
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
        });
    }
}
