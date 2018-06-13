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
 * Created by Draper_HXY 31/05/2018 6:36 PM
 * Email: Draper_HXY@163.com
 */
public class AdmissionOfficeEnteringComponent extends JPanel implements ViewActionListener, ViewCallbackActionListener, ViewKeyActionListener {
    private HomeViewController homeViewController;

    private JLabel
            nameLabel,
            ageLabel,
            idNumberLabel,
            addressLabel;
    private JTextField
            nameTextField,
            ageTextField,
            idNumberTextField,
            addressTextField;

    private JButton submitButton, cancelButton;

    private AdmissionOfficeEnteringComponent() {
        nameLabel = new JLabel("姓名");
        ageLabel = new JLabel("年龄");
        idNumberLabel = new JLabel("身份证号");
        addressLabel = new JLabel("地址");

        nameLabel.setHorizontalAlignment(JLabel.RIGHT);
        ageLabel.setHorizontalAlignment(JLabel.RIGHT);
        idNumberLabel.setHorizontalAlignment(JLabel.RIGHT);
        addressLabel.setHorizontalAlignment(JLabel.RIGHT);

        nameTextField = new JTextField(12);
        ageTextField = new JTextField(12);
        idNumberTextField = new JTextField(12);
        addressTextField = new JTextField(12);

        submitButton = new JButton("提交");
        cancelButton = new JButton("取消");

        JPanel panel = new JPanel(new GridLayout(1, 2));
        JPanel panelTop = new JPanel();
        JPanel panelBottom = new JPanel(new GridLayout(5,1));
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel panel5 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        panel1.add(nameLabel);
        panel1.add(nameTextField);

        panel2.add(ageLabel);
        panel2.add(ageTextField);

        panel3.add(idNumberLabel);
        panel3.add(idNumberTextField);

        panel4.add(addressLabel);
        panel4.add(addressTextField);

        panel5.add(submitButton);
        panel5.add(cancelButton);

        panelTop.add(StudentTestData.getTestComponent());
        panelBottom.add(panel1);
        panelBottom.add(panel2);
        panelBottom.add(panel3);
        panelBottom.add(panel4);
        panelBottom.add(panel5);

        panel.add(panelTop);
        panel.add(panelBottom);
        add(panel);

        addressTextField.addKeyListener(this);
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
        // TODO: 01/06/2018 提交验证
    }

    private static class EnteringComponentHolder {
        private static final AdmissionOfficeEnteringComponent ENTERING_COMPONENT = new AdmissionOfficeEnteringComponent();
    }

    public static AdmissionOfficeEnteringComponent getInstance() {
        return EnteringComponentHolder.ENTERING_COMPONENT;
    }
}
