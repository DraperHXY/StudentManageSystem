package com.draper.StudentManageSystem.view.component;

import com.draper.StudentManageSystem.controller.view.HomeViewController;
import com.draper.StudentManageSystem.view.listener.ViewActionListener;
import com.draper.StudentManageSystem.view.listener.ViewCallbackActionListener;
import com.draper.StudentManageSystem.view.listener.ViewKeyActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * Created by Draper_HXY 31/05/2018 10:01 PM
 * Email: Draper_HXY@163.com
 */
public class StudentStatusDepartmentEnteringComponent extends JPanel implements ViewActionListener,ViewCallbackActionListener,ViewKeyActionListener{
    private HomeViewController homeViewController;

    private JLabel
            nameLabel,
            classGradeLabel,
            studentIdLabel;
    private JTextField
            nameTextField,
            classGradeTextField,
            studentIdTextField;

    private JButton submitButton, cancelButton;

    private StudentStatusDepartmentEnteringComponent() {
        nameLabel = new JLabel("姓名");
        classGradeLabel = new JLabel("班级");
        studentIdLabel = new JLabel("学号");

        nameLabel.setHorizontalAlignment(JLabel.RIGHT);
        classGradeLabel.setHorizontalAlignment(JLabel.RIGHT);
        studentIdLabel.setHorizontalAlignment(JLabel.RIGHT);

        nameTextField = new JTextField(12);
        classGradeTextField = new JTextField(12);
        studentIdTextField = new JTextField(12);

        submitButton = new JButton("提交");
        cancelButton = new JButton("取消");

        JPanel panel = new JPanel(new GridLayout(1, 2));
        JPanel panelTop = new JPanel();
        JPanel panelBottom = new JPanel(new GridLayout(4,1));
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        panel1.add(nameLabel);
        panel1.add(nameTextField);

        panel2.add(classGradeLabel);
        panel2.add(classGradeTextField);

        panel3.add(studentIdLabel);
        panel3.add(studentIdTextField);

        panel4.add(submitButton);
        panel4.add(cancelButton);

        panelTop.add(StudentTestData.getTestComponent());
        panelBottom.add(panel1);
        panelBottom.add(panel2);
        panelBottom.add(panel3);
        panelBottom.add(panel4);

        panel.add(panelTop);
        panel.add(panelBottom);
        add(panel);

        studentIdTextField.addKeyListener(this);
        submitButton.addActionListener(this);
        cancelButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton){
            // TODO: 01/06/2018 提交验证
        } else if (e.getSource() == cancelButton){
            homeViewController = HomeViewController.getInstance();
            homeViewController.welcome();
        }
    }

    @Override
    public void callbackActionPerformed(Object callbackObj) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO: 01/06/2018 提交验证
    }

    private static class StudentStatusDepartmentEnteringComponentHolder {
        private static final StudentStatusDepartmentEnteringComponent
                STUDENT_STATUS_DEPARTMENT_ENTERING_COMPONENT =
                new StudentStatusDepartmentEnteringComponent();
    }

    public static StudentStatusDepartmentEnteringComponent getInstance() {
        return StudentStatusDepartmentEnteringComponentHolder
                .STUDENT_STATUS_DEPARTMENT_ENTERING_COMPONENT;
    }


}
