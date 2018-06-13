package com.draper.StudentManageSystem.controller.view;

import com.draper.StudentManageSystem.controller.ContextController;
import com.draper.StudentManageSystem.controller.qualification.QualificationCheck;
import com.draper.StudentManageSystem.controller.qualification.QualificationState;
import com.draper.StudentManageSystem.view.HomeView;
import com.draper.StudentManageSystem.view.listener.ViewCallbackActionListener;
import com.draper.StudentManageSystem.view.util.SwingConsoleUtil;

import static com.draper.StudentManageSystem.view.LoginInView.LOGIN_FAILED;
import static com.draper.StudentManageSystem.view.LoginInView.LOGIN_SUCCESS;

/**
 * Created by Draper_HXY 31/05/2018 9:52 AM
 * Email: Draper_HXY@163.com
 */
public class LoginInViewController {
    private static ViewCallbackActionListener listener;


    private LoginInViewController(){}

    public void check(String account, String password) {
        QualificationState state = QualificationCheck.check(account, password);
        ContextController contextController = ContextController.getInstance();
        contextController.setQualificationState(state);
        //当资格权限为 null 代表登录失败
        //反之登陆成功
        if (state == null) {
            listener.callbackActionPerformed(LOGIN_FAILED);
        } else {
            SwingConsoleUtil.run(HomeView.getInstance(), 400, 300);
            listener.callbackActionPerformed(LOGIN_SUCCESS);
        }

    }

    public void setListener(ViewCallbackActionListener listener) {
        this.listener = listener;
    }

    private static class LoginInViewControllerHolder{
        private static final LoginInViewController LOGIN_IN_VIEW_CONTROLLER = new LoginInViewController();
    }

    public static LoginInViewController getInstance(){
        return LoginInViewControllerHolder.LOGIN_IN_VIEW_CONTROLLER;
    }
}
