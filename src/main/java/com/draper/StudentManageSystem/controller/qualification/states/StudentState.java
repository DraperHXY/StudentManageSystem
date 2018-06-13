package com.draper.StudentManageSystem.controller.qualification.states;


import com.draper.StudentManageSystem.controller.qualification.QualificationState;

/**
 * Created by Draper_HXY 30/05/2018 10:04 AM
 * Email: Draper_HXY@163.com
 */
public class StudentState extends QualificationState {
    @Override
    public void operate(Object o) {
        System.out.println("学生添加信息，学业典考核");
    }

    @Override
    public Object getInfo() {
        return "学生查找信息";
    }

    @Override
    public String toString() {
        return "学生";
    }
}
