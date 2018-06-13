package com.draper.StudentManageSystem.controller.qualification.states;


import com.draper.StudentManageSystem.controller.qualification.QualificationState;

/**
 * Created by Draper_HXY 30/05/2018 9:42 AM
 * Email: Draper_HXY@163.com
 */
public class AdmissionOfficeState extends QualificationState {

    @Override
    public void operate(Object o) {
        System.out.println("招生办发送信息到学籍科...");
    }

    @Override
    public Object getInfo() {
        return null;
    }

    @Override
    public String toString() {
        return "招生办";
    }
}
