package com.draper.StudentManageSystem.view.component;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Draper_HXY 01/06/2018 3:18 PM
 * Email: Draper_HXY@163.com
 */
public class StudentTestData {

    public static JPanel getTestComponent() {

        // 创建内容面板，使用边界布局
        JPanel panel = new JPanel(new BorderLayout());

        Object[] columnNames = {"项目","名字"};

        Object[][] rowData = {
                {"姓名", "张三"},
                {"年龄", 18},
                {"身份证号", "110105197902280019"},
                {"地址", "北京市朝阳区"},
                {"班级", "交通运输规划与管理一班"},
                {"学号","xs201501014567"},
                {"兴趣爱好","篮球"},
                {"计划","好好学习天天向上"},
                {"分数",79},
                {"通过率",0.9}
        };

        JTable table = new JTable(rowData,columnNames);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        // 把 表头 添加到容器顶部（使用普通的中间容器添加表格时，表头 和 内容 需要分开添加）
        panel.add(table.getTableHeader(), BorderLayout.NORTH);
        // 把 表格内容 添加到容器中心
        panel.add(table, BorderLayout.CENTER);

        return panel;
    }



}
