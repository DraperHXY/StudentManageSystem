package com.draper.StudentManageSystem.controller.qualification.states;


import com.draper.StudentManageSystem.controller.qualification.QualificationState;

/**
 * Created by Draper_HXY 30/05/2018 10:09 AM
 * Email: Draper_HXY@163.com
 */
public class ParentState extends QualificationState {
    @Override
    public void operate(Object o) {
        System.out.println("家长进行查询");
    }

    @Override
    public Object getInfo() {
        return "从系主任处得到汇总";
    }

    @Override
    public String toString() {
        return "家长";
    }
}
