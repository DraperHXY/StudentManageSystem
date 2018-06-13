package com.draper.StudentManageSystem.controller.qualification.states;


import com.draper.StudentManageSystem.controller.qualification.QualificationState;

/**
 * Created by Draper_HXY 30/05/2018 10:02 AM
 * Email: Draper_HXY@163.com
 */
public class StudentStatusDepartmentState extends QualificationState {
    @Override
    public void operate(Object o) {
        System.out.println("学籍科将信息录入系统");

    }

    @Override
    public Object getInfo() {
        return "从招生办得到信息";
    }

    @Override
    public String toString() {
        return "学籍科";
    }
}
