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
 * Created by Draper_HXY 01/06/2018 6:32 PM
 * Email: Draper_HXY@163.com
 */
public class ParentFeedbackComponent extends JPanel implements ViewActionListener, ViewCallbackActionListener, ViewKeyActionListener {
    private HomeViewController homeViewController;

    private JLabel
            feedbackLabel;
    private JTextField
            feedbackTextField;

    private JButton submitButton, cancelButton;

    private ParentFeedbackComponent(){
        feedbackLabel = new JLabel("反馈");
        feedbackLabel.setHorizontalAlignment(JLabel.RIGHT);

        feedbackTextField = new JTextField(12);

        submitButton = new JButton("提交");
        cancelButton = new JButton("取消");

        JPanel panel = new JPanel(new GridLayout(1, 2));
        JPanel panelTop = new JPanel();
        JPanel panelBottom = new JPanel(new GridLayout(2,1));
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        panel1.add(feedbackLabel);
        panel1.add(feedbackTextField);

        panel2.add(submitButton);
        panel2.add(cancelButton);

        panelTop.add(StudentTestData.getTestComponent());
        panelBottom.add(panel1);
        panelBottom.add(panel2);

        // TODO: 13/06/2018 Log
        System.out.println("ooo");
        panel.add(panelTop);
        panel.add(panelBottom);
        add(panel);

        feedbackTextField.addKeyListener(this);
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

    private static class ParentFeedbackComponentHolder{
        private static final ParentFeedbackComponent PARENT_FEEDBACK_COMPONENT = new ParentFeedbackComponent();
    }

    public static ParentFeedbackComponent getInstance(){
        return ParentFeedbackComponentHolder.PARENT_FEEDBACK_COMPONENT;
    }
}
