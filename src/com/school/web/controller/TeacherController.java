package com.school.web.controller;

import java.util.Scanner;

import com.school.web.bean.TeacherBean;

public class TeacherController {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		TeacherBean teacherBean = new TeacherBean();
		System.out.print("id : ");
		teacherBean.setId(scanner.next());
		System.out.print("pw : ");
		teacherBean.setPw(scanner.next());
		System.out.print("name : ");
		teacherBean.setName(scanner.next());
		System.out.print("subject : ");
		teacherBean.setSubject(scanner.next());
	}
}
