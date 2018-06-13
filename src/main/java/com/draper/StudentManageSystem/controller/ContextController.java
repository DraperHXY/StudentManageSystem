package com.draper.StudentManageSystem.controller;

import com.draper.StudentManageSystem.controller.qualification.QualificationState;

/**
 * 持有用户身份，状态等全局信息
 * <p>
 * Created by Draper_HXY 31/05/2018 10:47 AM
 * Email: Draper_HXY@163.com
 */
public class ContextController {
    private QualificationState qualificationState;

    /**
     * 单例，全局只能存在一个
     */
    private ContextController() {
    }

    public static ContextController getInstance() {
        return ContextHolder.CONTEXT_CONTROLLER;
    }

    public void setQualificationState(QualificationState qualificationState) {
        this.qualificationState = qualificationState;
    }

    public QualificationState getQualificationState() {
        return qualificationState;
    }


    private static class ContextHolder {
        private static final ContextController CONTEXT_CONTROLLER = new ContextController();
    }

}
