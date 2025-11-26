package chaptor_14;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.sound.sampled.*;
import java.io.*;

class MyFrame2 extends JFrame{
    Clip clip;
    JLabel label = new JLabel("오디오 파일을 선택하세요");
    String fileName;
    public MyFrame2() {
        setTitle("오디오 파일을 찾아 연주/종료 제어");
        createMenu();
        setLayout(new FlowLayout());
        add(label);
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void createMenu() {
        JMenuBar mb = new JMenuBar();
        
        JMenu audio = new JMenu("오디오");
        
        JMenuItem start = new JMenuItem("연주");
        JMenuItem close = new JMenuItem("종료");
        
        start.addActionListener(new OpenActionListener());
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (clip != null && clip.isRunning()) {
                    clip.stop();
                    label.setText(fileName + " 연주가 종료되었습니다.");
                }
            }
        });
        
        audio.add(start);
        audio.add(close);
        
        mb.add(audio);
        
        setJMenuBar(mb);
    }
    class OpenActionListener implements ActionListener{
        private JFileChooser chooser;
        public OpenActionListener(){
            chooser = new JFileChooser();
        }
        public void actionPerformed(ActionEvent e) {
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "Audio Files(wav,au,mid,rmf)", 
                    "wav", "au", "mid", "rmf");
            chooser.setFileFilter(filter);
            int ret = chooser.showOpenDialog(null);
            if(ret != JFileChooser.APPROVE_OPTION) {
                JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다",
                                            "경고", JOptionPane.WARNING_MESSAGE);
                return; 
            }
            String filePath = chooser.getSelectedFile().getPath();
            fileName = chooser.getSelectedFile().getName();
            label.setText(fileName + "를 연주하고 있습니다.");
            
            loadAudio(filePath);
        }
        private void loadAudio(String pathName) {
            try {
                clip = AudioSystem.getClip();
                File audioFile = new File(pathName);
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
                clip.open(audioStream);
                clip.start();
            }
            catch(LineUnavailableException e) { e.printStackTrace(); }
            catch(UnsupportedAudioFileException e) { e.printStackTrace(); }
            catch(IOException e) { e.printStackTrace(); }
            
        }
    }
}

public class report_7 {
    public static void main(String[] args) {
        MyFrame2 my = new MyFrame2();
    }
}
