package com.draper.StudentManageSystem.controller.qualification;

import com.draper.StudentManageSystem.controller.qualification.states.AdmissionOfficeState;

/**
 * Created by Draper_HXY 30/05/2018 9:41 AM
 * Email: Draper_HXY@163.com
 */
public class QualificationContext {

    private QualificationState qualificationState;

    public void setQualificationState(QualificationState qualificationState) {
        this.qualificationState = qualificationState;
        this.qualificationState.setQualificationContext(this);
    }

    public void operate(Object o){
        qualificationState.operate(o);
    }

    public void getInfo(){
        String info = (String) qualificationState.getInfo();
        System.out.println(info);

    }

}
