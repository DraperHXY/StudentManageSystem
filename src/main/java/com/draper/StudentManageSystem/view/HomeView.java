package com.draper.StudentManageSystem.view;

import com.draper.StudentManageSystem.controller.ContextController;
import com.draper.StudentManageSystem.controller.qualification.QualificationState;
import com.draper.StudentManageSystem.controller.qualification.states.*;
import com.draper.StudentManageSystem.controller.view.HomeViewController;
import com.draper.StudentManageSystem.view.component.StudentTestData;
import com.draper.StudentManageSystem.view.component.*;
import com.draper.StudentManageSystem.view.listener.ViewActionListener;
import com.draper.StudentManageSystem.view.listener.ViewCallbackActionListener;
import com.draper.StudentManageSystem.view.util.SwingConsoleUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by Draper_HXY 31/05/2018 11:24 AM
 * Email: Draper_HXY@163.com
 */
public class HomeView extends JFrame implements ViewActionListener, ViewCallbackActionListener {
    private HomeViewController homeViewController;
    private AdmissionOfficeEnteringComponent admissionOfficeEnteringComponent;
    private StudentStatusDepartmentEnteringComponent studentStatusDepartmentEnteringComponent;
    private static JMenuItem[] menuItems = {
            new JMenuItem("注销"),
            new JMenuItem("录入信息"),
            new JMenuItem("录入信息"),
            new JMenuItem("录入信息"),
            new JMenuItem("上交学业典"),
            new JMenuItem("测试"),
            new JMenuItem("审核"),
            new JMenuItem("反馈")
    };

    private static Component centerComponent;

    public static final int Logout = 0;
    public static final int Welcome = 1;
    public static final int AdmissionOfficeEntering = 1;
    public static final int StudentStatusEntering = 2;
    public static final int StudentEntering = 3;
    public static final int TeacherCheck = 4;
    public static final int Test = 5;
    public static final int DepartmentChairmanCheck = 6;
    public static final int ParentFeedback = 7;

    private static JMenu
            menu,
            admissionOfficeMenu,
            studentStatusDepartmentMenu,
            studentMenu,
            teacherMenu,
            departmentChairmanMenu,
            parentMenu;

    private static JMenuBar menuBar;
    private static JLabel welcomeLabel;

    /**
     * 不采用单例模式，避免用户注销后登陆后出现原本的画面
     */
    private HomeView() {
        setLayout(new CardLayout());
        menu = new JMenu("菜单");
        admissionOfficeMenu = new JMenu("招生办");
        studentStatusDepartmentMenu = new JMenu("学籍科");
        studentMenu = new JMenu("学生");
        teacherMenu = new JMenu("老师");
        departmentChairmanMenu = new JMenu("系主任");
        parentMenu = new JMenu("家长");


        menu.add(menuItems[Logout]);
        menu.add(menuItems[Test]);
        admissionOfficeMenu.add(menuItems[AdmissionOfficeEntering]);
        studentStatusDepartmentMenu.add(menuItems[StudentStatusEntering]);
        studentMenu.add(menuItems[StudentEntering]);
        teacherMenu.add(menuItems[TeacherCheck]);
        departmentChairmanMenu.add(menuItems[DepartmentChairmanCheck]);
        parentMenu.add(menuItems[ParentFeedback]);


        menuBar = new JMenuBar();
        menuBar.add(menu);
        menuBar.add(admissionOfficeMenu);
        menuBar.add(studentStatusDepartmentMenu);
        menuBar.add(studentMenu);
        menuBar.add(teacherMenu);
        menuBar.add(departmentChairmanMenu);
        menuBar.add(parentMenu);
        setJMenuBar(menuBar);

        for (JMenuItem menuItem : menuItems) {
            menuItem.addActionListener(this);
        }

        welcomeLabel = new JLabel("欢迎使用学生管理信息系统");
        welcomeLabel.setFont(new Font(null, Font.BOLD, 30));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setVerticalAlignment(SwingConstants.CENTER);
        centerComponent = welcomeLabel;

        homeViewController = HomeViewController.getInstance();
        homeViewController.setListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuItems[Logout]) {
            homeViewController.logout();
        } else if (e.getSource() == menuItems[AdmissionOfficeEntering]) {
            remove(centerComponent);
            centerComponent = AdmissionOfficeEnteringComponent.getInstance();
            // FIXME: 31/05/2018 第一次添加不显示，第二次点击才添加成功，故重复添加
            add(centerComponent);
            add(centerComponent);
        } else if (e.getSource() == menuItems[StudentStatusEntering]) {
            remove(centerComponent);
            centerComponent = StudentStatusDepartmentEnteringComponent.getInstance();
            add(centerComponent);
            add(centerComponent);
        } else if (e.getSource() == menuItems[StudentEntering]){
            remove(centerComponent);
            centerComponent = StudentEnteringComponent.getInstance();
            add(centerComponent);
            add(centerComponent);
        } else if (e.getSource() == menuItems[TeacherCheck]){
            remove(centerComponent);
            centerComponent= TeacherSubmitCheckComponent.getInstance();
            add(centerComponent);
            add(centerComponent);
        } else if (e.getSource() == menuItems[Test]){
            remove(centerComponent);
            centerComponent = StudentTestData.getTestComponent();
            add(centerComponent);
            add(centerComponent);
        } else if (e.getSource() == menuItems[DepartmentChairmanCheck]){
            remove(centerComponent);
            centerComponent = DepartmentChairmanCheckComponent.getInstance();
            add(centerComponent);
            add(centerComponent);
        } else if (e.getSource() == menuItems[ParentFeedback]){
            remove(centerComponent);
            centerComponent = ParentFeedbackComponent.getInstance();
            add(centerComponent);
            add(centerComponent);
        }
    }

    @Override
    public void callbackActionPerformed(Object callbackObj) {
        switch (Integer.parseInt(callbackObj.toString())) {
            case Logout:
                dispose();
                SwingConsoleUtil.run(LoginInView.getInstance(), 270, 170);
                break;
            case Welcome:
                remove(centerComponent);
                centerComponent = welcomeLabel;
                add(centerComponent);
            default:
                break;
        }

    }

    /**
     * 通过用户权限不同限制用户界面
     */
    private static void restrictQualification() {
        admissionOfficeMenu.setEnabled(false);
        studentStatusDepartmentMenu.setEnabled(false);
        studentMenu.setEnabled(false);
        teacherMenu.setEnabled(false);
        departmentChairmanMenu.setEnabled(false);
        parentMenu.setEnabled(false);

        ContextController contextController = ContextController.getInstance();
        QualificationState state = contextController.getQualificationState();
        if (state instanceof AdmissionOfficeState)
            admissionOfficeMenu.setEnabled(true);
        else if (state instanceof StudentStatusDepartmentState) {
            studentStatusDepartmentMenu.setEnabled(true);
        } else if (state instanceof StudentState)
            studentMenu.setEnabled(true);
        else if (state instanceof TeacherState)
            teacherMenu.setEnabled(true);
        else if (state instanceof DepartmentChairmanState)
            departmentChairmanMenu.setEnabled(true);
        else if (state instanceof ParentState)
            parentMenu.setEnabled(true);

    }

    private static class HomeViewHolder{
        private static final HomeView HOME_VIEW = new HomeView();
    }

    public static HomeView getInstance(){
        HomeView homeView = HomeViewHolder.HOME_VIEW;
        homeView.remove(centerComponent);
        centerComponent = welcomeLabel;
        homeView.add(centerComponent);
        //每一次登陆界面打开后需要重新限定权限，因为构造函数只运行一次，故在这里添加
        restrictQualification();
        return homeView;
    }

}
