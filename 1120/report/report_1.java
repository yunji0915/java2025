package chaptor_14;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class MyFrame extends JFrame{
	public MyFrame() {
		setTitle("메뉴 만들기");
		createMenu();
		setSize(250, 200);
		setVisible(true);
	}
	public void createMenu() {
		JMenuBar mb = new JMenuBar();
		
		JMenu look = new JMenu("보기");
		
		look.add(new JMenuItem("화면확대"));
		look.add(new JMenuItem("쪽윤곽"));
		
		mb.add(new JMenu("파일"));
		mb.add(new JMenu("편집"));
		mb.add(look);
		mb.add(new JMenu("입력"));
		
		setJMenuBar(mb);
	}
}

public class report_1 {
	public static void main(String[] args) {
		MyFrame my = new MyFrame();
	}
}
