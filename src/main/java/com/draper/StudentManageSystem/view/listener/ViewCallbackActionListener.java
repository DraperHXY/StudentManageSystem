package com.draper.StudentManageSystem.view.listener;

import java.awt.event.ActionListener;

/**
 * 回调函数，反向控制 View 层
 *
 * Created by Draper_HXY 31/05/2018 10:10 AM
 * Email: Draper_HXY@163.com
 */
public interface ViewCallbackActionListener extends ActionListener{

    void callbackActionPerformed(Object callbackObj);

}
