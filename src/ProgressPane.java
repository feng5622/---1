import java.awt.Font;
import java.awt.GridBagConstraints; 
import java.awt.GridBagLayout; 
import java.awt.Insets; 

import javax.swing.JLabel; 
import javax.swing.JPanel; 
import javax.swing.JProgressBar;

/**
 * Java进度条
 * @author dell
 *
 */
public class ProgressPane extends JPanel
{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 8607906619589907075L;
	public JLabel label; 
	 public JProgressBar progressBar;
	
	 public ProgressPane()
	 { 
		 super(); 
		 setLayout(new GridBagLayout()); 
		 setSize(394, 33);
		
		 progressBar = new JProgressBar(0,100); 
		 progressBar.setStringPainted(true);
		 progressBar.setFont(new Font("楷体",Font.BOLD + Font.ITALIC,16));
		 final GridBagConstraints gridBagConstraints = new GridBagConstraints(); 
		 gridBagConstraints.weightx = 1.0; 
		 gridBagConstraints.ipady = 1; //进度条的宽度
		 gridBagConstraints.fill = GridBagConstraints.BOTH; 
		 gridBagConstraints.weighty = 1.0; 
		 gridBagConstraints.gridx = 0; 
		 gridBagConstraints.gridy = 0; 
		 gridBagConstraints.ipadx = 75; 
		 gridBagConstraints.insets = new Insets(4, 0, 0, 0); 
		 add(progressBar, gridBagConstraints);
		
		 label = new JLabel(); 
		 final GridBagConstraints gridBagConstraints_1 = new GridBagConstraints(); 
		 add(label, gridBagConstraints_1); 
		 label.setText("进度显示"); 
		  
		 gridBagConstraints_1.gridx = 1; 
		 gridBagConstraints_1.gridy = 0; 
		 gridBagConstraints_1.ipadx = 54; 
		 gridBagConstraints_1.insets = new Insets(0, 12, 10, 0); 
	 }

} 