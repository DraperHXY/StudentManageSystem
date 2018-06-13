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
 * Created by Draper_HXY 01/06/2018 3:08 PM
 * Email: Draper_HXY@163.com
 */
public class DepartmentChairmanCheckComponent extends JPanel implements ViewActionListener, ViewCallbackActionListener, ViewKeyActionListener{
    private HomeViewController homeViewController;

    private JLabel
            scoreLabel,
            passRateLabel;
    private JTextField
            scoreLabelTextField,
            passRateTextField;

    private JButton submitButton, cancelButton;

    private DepartmentChairmanCheckComponent(){
        scoreLabel = new JLabel("分数");
        passRateLabel = new JLabel("通过率");

        scoreLabel.setHorizontalAlignment(JLabel.RIGHT);
        passRateLabel.setHorizontalAlignment(JLabel.RIGHT);

        scoreLabelTextField = new JTextField(12);
        passRateTextField = new JTextField(12);

        submitButton = new JButton("提交");
        cancelButton = new JButton("取消");

        JPanel panel = new JPanel(new GridLayout(1, 2));
        JPanel panelTop = new JPanel();
        JPanel panelBottom = new JPanel(new GridLayout(3,1));
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        panel1.add(scoreLabel);
        panel1.add(scoreLabelTextField);

        panel2.add(passRateLabel);
        panel2.add(passRateTextField);

        panel3.add(submitButton);
        panel3.add(cancelButton);


        panelTop.add(StudentTestData.getTestComponent());
        panelBottom.add(panel1);
        panelBottom.add(panel2);
        panelBottom.add(panel3);

        panel.add(panelTop);
        panel.add(panelBottom);
        add(panel);


        passRateTextField.addKeyListener(this);
        submitButton.addActionListener(this);
        cancelButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            // TODO: 31/05/2018 提交验证
        } else if (e.getSource() == cancelButton) {
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
        // TODO: 31/05/2018 提交验证
    }

    private static class ChairmanDepartmentCheckComponentHolder{
        private static final DepartmentChairmanCheckComponent CHAIRMAN_DEPARTMENT_CHECK_COMPONENT = new DepartmentChairmanCheckComponent();
    }

    public static DepartmentChairmanCheckComponent getInstance(){
        return ChairmanDepartmentCheckComponentHolder.CHAIRMAN_DEPARTMENT_CHECK_COMPONENT;
    }
}
