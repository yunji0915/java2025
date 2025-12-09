package Exam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

public class Exam_8 extends JFrame{
	private JLabel imageLabel;
	private JRadioButton leftButton, rightButton;
	private ArrayList<ImageIcon> imageList = new ArrayList<>();
	private int currentIndex = 0;
	
	public Exam_8() {
		setTitle("이미지 갤러리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		setLayout(new BorderLayout());
		
		loadImages();
		
		imageLabel = new JLabel();
		imageLabel.setHorizontalAlignment(JLabel.CENTER);
		if(!imageList.isEmpty()) {
			imageLabel.setIcon(imageList.get(currentIndex));
		}
		add(imageLabel, BorderLayout.CENTER);
		
		imageLabel.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				showNextImage();
			}
		});
		
		leftButton = new JRadioButton("Left");
		rightButton = new JRadioButton("Right");
		ButtonGroup group = new ButtonGroup();
		group.add(leftButton);
		group.add(rightButton);
		rightButton.setSelected(true);
		
		JPanel radioPanel = new JPanel();
		radioPanel.add(leftButton);
		radioPanel.add(rightButton);
		add(radioPanel, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	private void loadImages() {
		File dir = new File("images");
		if(!dir.exists() || !dir.isDirectory()) {
			JOptionPane.showMessageDialog(this, "images 폴더가 없다");
			return;
		}
		
		File[] files = dir.listFiles((d, name)->{
			String lower = name.toLowerCase();
			return lower.endsWith(".jpg")||lower.endsWith(".jpeg")||lower.endsWith(".png");
		});
		
		if(files != null) {
			for(File file : files) {
				imageList.add(new ImageIcon(file.getPath()));
			}
		}
	}
	
	private void showNextImage() {
		if(imageList.isEmpty()) return;
		
		if(leftButton.isSelected()) {
			currentIndex = (currentIndex -1 + imageList.size()) % imageList.size();
		} else {
			currentIndex = (currentIndex -1) + imageList.size();
		}
		
		imageLabel.setIcon(imageList.get(currentIndex));
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(()-> new Exam_8());
	}

}

























