package com.school.web.controller;

import java.util.Scanner;

import com.school.web.bean.StudentBean;
import com.school.web.service.StudentService;
import com.school.web.serviceImpl.StudentServiceImpl;

public class StudentController {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int index = 0, sel = 0;
		System.out.print("학생 수 입력 : ");
		index = scanner.nextInt();
		StudentService studentService = new StudentServiceImpl(index);
		while(true) {
			System.out.println("[0]종료 [1]학생부등록 [2]성적등록 [3]총 학생수\n"
					+ "[4]학생이름 리스트 [5] 내정보 보기 [6] 이름 검색");
			sel = scanner.nextInt();
			switch(sel) {
			case 0:
				System.out.println("종료");
				return;
			case 1:
				StudentBean studentBean = new StudentBean();
				System.out.print("ID 입력 : ");
				studentBean.setId(scanner.next());
				System.out.print("PW 입력 : ");
				studentBean.setPw(scanner.next());
				System.out.print("이름 입력 : ");
				studentBean.setName(scanner.next());
				studentService.addStudent(studentBean);
				break;
			case 2:
				
				break;
			case 3:
				System.out.println("총학생수는 " + studentService.list().length);
				break;
			case 4:
				StudentBean[] students = studentService.list();
				for(int i = 0; i < students.length; i++) {
					System.out.println(students[i].getName());
				}
				break;
			case 5:
				System.out.print("ID 입력 : ");
				StudentBean tmp = studentService.findStudentById(scanner.next());
				System.out.println("[이름] " + tmp.getName()
//								+ "[국어] " + tmp.getKor()
//								+ "[영어] " + tmp.getEng()
//								+ "[수학] " + tmp.getMath()
								  );
				break;
			case 6:
				System.out.print("이름 입력 : ");
				StudentBean[] student = studentService.findStudentByName(scanner.next());
				if(student == null) {
					System.out.println("이름이 없어요");
				} else {
					for(int i = 0; i < student.length; i++) {
						System.out.println(student[i].toString());
					}
				}
				break;
			}
		}
	}
}
