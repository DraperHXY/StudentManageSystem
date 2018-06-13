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
 * Created by Draper_HXY 01/06/2018 1:59 PM
 * Email: Draper_HXY@163.com
 */
public class StudentEnteringComponent extends JPanel implements ViewActionListener,ViewCallbackActionListener,ViewKeyActionListener {
    private HomeViewController homeViewController;

    private JLabel
            interestLabel,
            planLabel;
    private JTextField
            interestTextField,
            planTextField;

    private JButton submitButton, cancelButton;


    private StudentEnteringComponent(){
        interestLabel = new JLabel("兴趣爱好");
        planLabel = new JLabel("四年计划");

        interestLabel.setHorizontalAlignment(JLabel.RIGHT);
        planLabel.setHorizontalAlignment(JLabel.RIGHT);

        interestTextField = new JTextField(12);
        planTextField = new JTextField(12);

        submitButton = new JButton("提交");
        cancelButton = new JButton("取消");

        JPanel panel = new JPanel(new GridLayout(1, 2));
        JPanel panelTop = new JPanel();
        JPanel panelBottom = new JPanel(new GridLayout(3,1));
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        panel1.add(interestLabel);
        panel1.add(interestTextField);

        panel2.add(planLabel);
        panel2.add(planTextField);

        panel3.add(submitButton);
        panel3.add(cancelButton);

        panelTop.add(StudentTestData.getTestComponent());
        panelBottom.add(panel1);
        panelBottom.add(panel2);
        panelBottom.add(panel3);

        panel.add(panelTop);
        panel.add(panelBottom);
        add(panel);

        planTextField.addKeyListener(this);
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

    private static class StudentEnteringComponentHolder{
        private static final StudentEnteringComponent STUDENT_ENTERING_COMPONENT = new StudentEnteringComponent();
    }

    public static StudentEnteringComponent getInstance(){
        return StudentEnteringComponentHolder.STUDENT_ENTERING_COMPONENT;
    }
}
