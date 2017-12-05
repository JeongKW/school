package com.school.web.serviceImpl;

import com.school.web.bean.StudentBean;
import com.school.web.service.StudentService;

public class StudentServiceImpl implements StudentService{
	private StudentBean[] students;
	private int index;
	
	public StudentServiceImpl() {
//		this.lastLength = 10;
		students = new StudentBean[10];
		this.index = 0;
	}

	@Override
	public void addStudent(StudentBean student) {
		if(index == students.length) {
			StudentBean[] copyStudents = students; // 10
			students = new StudentBean[students.length + 10]; // 20
			System.arraycopy(copyStudents, 0, students, 0, index);
		}
		students[index] = student;
		index++;
	}
	
	@Override
	public void addScore(StudentBean student) {
		
	}

	@Override
	public StudentBean login(StudentBean student) {
		return null;
	}

	@Override
	public StudentBean find(String id) {
		return null;
	}
	
	@Override
	public StudentBean[] list() {
		return students;
	}

	@Override
	public StudentBean findStudentById(String id) {
		StudentBean student = new StudentBean();
		if(id != null) {
			for(int i = 0; i < index; i++) {
				if(id.equals(students[i].getId())) {
					student = students[i];
					break;
				}
			}
		}
		return student;
	}

	@Override
	public StudentBean[] findStudentByName(String name) {
		StudentBean[] studentTmp = null;
		int res = 0;
		for(int i = 0; i < index; i++) {
			if(name.equals(students[i].getName())) {
				res++;
			}
		}
		if(res != 0) {
			studentTmp = new StudentBean[res];
			for(int i = 0, j = 0; i < index; i++) {
				if(name.equals(students[i].getName())) {
					studentTmp[j] = students[i];
					j++;
					 // 필요없는 for 돌리지말자
					if(j == res) {
						break;
					}
				}
			}
		}
		return studentTmp;
	}

	@Override
	public int getIndex() {
		return index;
	}

	@Override
	public void updatePw(StudentBean updateStu) {
		if(updateStu != null) {
			for(int i = 0; i < index; i++) {
				if(updateStu.getId().equals(students[i].getId())) {
					students[i].setPw(updateStu.getPw());
					break;
				}
			}
		}
		// findStudentById(updateStu.getId()).setPw(updateStu.getPw());
	}

	@Override
	public void deleteStudent(String id) {
//		StudentBean[] tempStu = new StudentBean[index];
//		for(int i = 0; i < index; i++) {
//			tempStu[i] = students[i];
//		}
//		students = new StudentBean[index - 1];
//		for(int i = 0, j = 0; i < index; i++) {
//			if(id.equals(tempStu[i].getId())){
//				continue;
//			} else {
//				students[j] = tempStu[i];
//				j++;
//			}
//		}
		for(int i = 0; i < index; i++) {
			if(id.equals(students[i].getId())) {
				students[i] = students[index - 1];
				students[index - 1] = null;
				break;
			}
		}
	}
}
