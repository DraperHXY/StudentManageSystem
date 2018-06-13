package com.draper.StudentManageSystem.controller.qualification;

/**
 * 通过实体权限的不同而采用不同的状态来对待
 *
 * Created by Draper_HXY 30/05/2018 9:43 AM
 * Email: Draper_HXY@163.com
 */
public abstract class QualificationState {

    protected QualificationContext qualificationContext;

    public void setQualificationContext(QualificationContext qualificationContext){
        this.qualificationContext = qualificationContext;
    }

    public abstract void operate(Object o);

    public abstract Object getInfo();

}
