package com.draper.StudentManageSystem.controller.qualification.states;


import com.draper.StudentManageSystem.controller.qualification.QualificationState;

/**
 * Created by Draper_HXY 30/05/2018 10:07 AM
 * Email: Draper_HXY@163.com
 */
public class DepartmentChairmanState extends QualificationState {
    @Override
    public void operate(Object o) {
        System.out.println("主任汇总给家长");
    }

    @Override
    public Object getInfo() {
        return "从老师得到汇总";
    }

    @Override
    public String toString() {
        return "系主任";
    }
}
