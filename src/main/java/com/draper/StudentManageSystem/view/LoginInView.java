package com.draper.StudentManageSystem.view;

import com.draper.StudentManageSystem.controller.ContextController;
import com.draper.StudentManageSystem.controller.view.LoginInViewController;
import com.draper.StudentManageSystem.view.listener.ViewActionListener;
import com.draper.StudentManageSystem.view.listener.ViewCallbackActionListener;
import com.draper.StudentManageSystem.view.listener.ViewKeyActionListener;
import com.draper.StudentManageSystem.view.util.DialogUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * Created by Draper_HXY 30/05/2018 10:53 PM
 * Email: Draper_HXY@163.com
 */
public class LoginInView extends JFrame implements ViewActionListener, ViewCallbackActionListener,ViewKeyActionListener {
    private LoginInViewController loginInViewController;
    private JLabel titleLabel;
    private JLabel accountLabel;
    private JLabel passwordLabel;
    private JTextField accountTextField;
    private JPasswordField passwordTextField;
    private JButton submitButton;
    private JButton resetButton;

    public static final int LOGIN_SUCCESS = 1;
    public static final int LOGIN_FAILED = 0;

    private LoginInView() {
        setLayout(new FlowLayout());
        titleLabel = new JLabel("学生信息管理系统");
        titleLabel.setFont(new Font(null, Font.BOLD, 30));
        accountLabel = new JLabel("账号");
        accountTextField = new JTextField(18);
        passwordLabel = new JLabel("密码");
        passwordTextField = new JPasswordField(18);
        submitButton = new JButton("登录");
        resetButton = new JButton("重置");
        submitButton.addActionListener(this);
        passwordTextField.addKeyListener(this);
        resetButton.addActionListener(this);

        add(titleLabel);
        add(accountLabel);
        add(accountTextField);
        add(passwordLabel);
        add(passwordTextField);
        add(submitButton);
        add(resetButton);

        loginInViewController = LoginInViewController.getInstance();
        loginInViewController.setListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "登录":
                String account = accountTextField.getText();
                String password = passwordTextField.getText();
                loginInViewController.check(account, password);
                break;
            case "重置":
                accountTextField.setText("");
                passwordTextField.setText("");
                break;
            default:
                break;
        }
    }

    @Override
    public void callbackActionPerformed(Object callbackObj) {
        switch (Integer.parseInt(callbackObj.toString())) {
            case LOGIN_SUCCESS:
                dispose();
                DialogUtil.info(ContextController.getInstance().getQualificationState() + ":" + "登录成功！");
                break;
            case LOGIN_FAILED:
                DialogUtil.error("账号密码错误！");
                break;
            default:
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER){
            String account = accountTextField.getText();
            String password = passwordTextField.getText();
            loginInViewController.check(account, password);
        }
    }

    private static class LoginInViewHolder{
        private static final LoginInView LOGIN_IN_VIEW = new LoginInView();
    }

    public static LoginInView getInstance(){
        return LoginInViewHolder.LOGIN_IN_VIEW;
    }

}
