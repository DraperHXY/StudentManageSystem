package com.draper.StudentManageSystem.controller.qualification;

import com.draper.StudentManageSystem.controller.qualification.states.*;

/**
 * Created by Draper_HXY 30/05/2018 10:30 AM
 * Email: Draper_HXY@163.com
 */
public class QualificationCheck {

    public static QualificationState check(String account, String password) {
        if (!account.equals(password)) {
            return null;
        }
        switch (account) {
            case admissionOfficeAccount:
                return new AdmissionOfficeState();
            case studentStatusDepartmentAccount:
                return new StudentStatusDepartmentState();
            case studentAccount:
                return new StudentState();
            case teacherAccount:
                return new TeacherState();
            case departmentChairmanAccount:
                return new DepartmentChairmanState();
            case parentAccount:
                return new ParentState();
            default:
                return null;
        }
    }

    public final static String admissionOfficeAccount = "zsb";
    public final static String studentStatusDepartmentAccount = "xjk";
    public final static String studentAccount = "xs";
    public final static String teacherAccount = "ls";
    public final static String departmentChairmanAccount = "xzr";
    public final static String parentAccount = "jz";

}
