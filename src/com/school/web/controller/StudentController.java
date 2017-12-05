package com.school.web.controller;

import javax.swing.JOptionPane;

import com.school.web.bean.StudentBean;
import com.school.web.service.StudentService;
import com.school.web.serviceImpl.StudentServiceImpl;
import com.school.web.ui.MainPage;

public class StudentController{
	public static void main(String[] args) {
		int sel = 0;
		StudentService studentService = new StudentServiceImpl();
		StudentBean student = null;
		StudentBean[] students = null;
		while(true) {
			sel = Integer.parseInt(JOptionPane.showInputDialog(
					"[0]종료\n [1]학생부등록 [2]성적등록 [3]총 학생수\n"
					+ "[4]학생이름 리스트 [5] 내정보 보기 [6] 이름 검색\n"
					+ "[7] 비번변경 [8] 회원삭제 [9] 화면보기"));
			switch(sel) {
			case 0:
				JOptionPane.showMessageDialog(null, "종료");
				return;
			case 1:
				student = new StudentBean();
				student.setId(JOptionPane.showInputDialog("ID 입력 : "));
				student.setPw(JOptionPane.showInputDialog("PW 입력 : "));
				student.setName(JOptionPane.showInputDialog("이름 입력 : "));
				studentService.addStudent(student);
				JOptionPane.showMessageDialog(null, "등록되었습니다");
				break;
			case 2:
				
				break;
			case 3:
				JOptionPane.showMessageDialog(null, 
						"총 학생수는 " + 
						studentService.list().length + "입니다");
				break;
			case 4:
				students = studentService.list();
				JOptionPane.showMessageDialog(null, 
						students, "학생이름 리스트",
						JOptionPane.INFORMATION_MESSAGE);
//				for(int i = 0; i < studentService.getIndex(); i++) {
//					System.out.println(students[i].getName());
//				}
				break;
			case 5:
				StudentBean tmp = studentService
						.findStudentById(
						JOptionPane
						.showInputDialog("ID 입력 : "));
				JOptionPane.showMessageDialog(null, tmp);
				break;
			case 6:
				students = studentService
						.findStudentByName(
						JOptionPane
						.showInputDialog("이름 입력 : "));
				if(students == null) {
					JOptionPane.showMessageDialog(null, "이름이 없어요");
				} else {
					JOptionPane.showMessageDialog(null, students);
				}
				break;
			case 7:
				student = new StudentBean();
				student.setId(JOptionPane.showInputDialog("ID 입력 : "));
				student.setPw(JOptionPane.showInputDialog("변경할 PW : "));
				studentService.updatePw(student);
				StudentBean resStu = studentService.findStudentById(student.getId());
				JOptionPane.showMessageDialog(null, resStu);
				break;
			case 8:
				studentService.deleteStudent(
							   JOptionPane
							   .showInputDialog("ID 입력 : "));
				JOptionPane.showMessageDialog(null, studentService.list());
//				for(int i = 0; i < tempStu.length; i++) {
//					System.out.println(tempStu[i].toString());
//				}
				break;
			case 9:
				MainPage mp = new MainPage();
				break;
			}
		}
	}
}
