package com.draper.StudentManageSystem.controller.view;

import com.draper.StudentManageSystem.controller.ContextController;
import com.draper.StudentManageSystem.view.HomeView;
import com.draper.StudentManageSystem.view.listener.ViewCallbackActionListener;

/**
 * Created by Draper_HXY 31/05/2018 6:09 PM
 * Email: Draper_HXY@163.com
 */
public class HomeViewController {
    private static ViewCallbackActionListener listener;

    private HomeViewController() {
    }

    private static class HomeViewControllerHolder {
        private static final HomeViewController HOME_VIEW_CONTROLLER = new HomeViewController();
    }

    public static HomeViewController getInstance() {
        return HomeViewControllerHolder.HOME_VIEW_CONTROLLER;
    }


    public void setListener(ViewCallbackActionListener listener) {
        this.listener = listener;
    }

    public void logout() {
        ContextController.getInstance().setQualificationState(null);
        listener.callbackActionPerformed(HomeView.Logout);
    }

    public void welcome() {
        listener.callbackActionPerformed(HomeView.Welcome);
    }


}
