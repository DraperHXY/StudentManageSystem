package com.draper.StudentManageSystem.controller.qualification.states;


import com.draper.StudentManageSystem.controller.qualification.QualificationState;

/**
 * Created by Draper_HXY 30/05/2018 10:06 AM
 * Email: Draper_HXY@163.com
 */
public class TeacherState extends QualificationState {
    @Override
    public void operate(Object o) {
        System.out.println("老师汇总给系主任");
    }

    @Override
    public Object getInfo() {
        return "得到学生的信息";
    }

    @Override
    public String toString() {
        return "老师";
    }
}
