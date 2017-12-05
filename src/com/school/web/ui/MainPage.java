package com.school.web.ui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainPage extends JFrame{
	JButton bt1, bt2, bt3, bt4;
	public MainPage() {
		super("학생관리시스템");
		this.setLayout(new FlowLayout());
		bt1 = new JButton("학생수");
		bt2 = new JButton("학생등록");
		bt3 = new JButton("학생검색");
		bt4 = new JButton("학생목록");
		add(bt1);
		add(bt2);
		add(bt3);
		add(bt4);
		pack();
		setLocation(300, 300);
		
		this.setSize(500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
