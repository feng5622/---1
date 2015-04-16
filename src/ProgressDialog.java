import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;  
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JDialog;  
import javax.swing.JFrame;  
import javax.swing.JPanel;
  
public class ProgressDialog implements Callable<String>
{  
    static JPanel panel1;
    static JButton button1;
    static GridBagConstraints gridBagConstraints1;
    static ProgressPane progresspane;
    private static JDialog Dialog = null;
	private static final Color MYSELF_COLOR = new Color(46,223,134);
	private static String Videoname1;
	boolean goon = true;
	static ProgressDialog ss = new ProgressDialog();
	
	public ProgressDialog()
	{
		goon = true;
	}
	
    public static String showDialog(JFrame father, String Videoname) throws InterruptedException, ExecutionException 
    {
    	Videoname1 = Videoname;
    	
        Dialog = new JDialog(father, true);
    	Dialog.setBounds(100,100,450,120);
    	Dialog.setTitle("微易码温馨提示");
    	Dialog.setLayout(new BorderLayout());
    	
    	printFrame();
    	
    	FutureTask<String> jiangong = new FutureTask<String>(ss);
    	new Thread(jiangong).start();
    	
    	
        Dialog.getContentPane().setBackground(Color.red);
        Dialog.pack();  
        Dialog.setSize(new Dimension(450,120));  
        Dialog.setLocationRelativeTo(father);
        Dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        Dialog.setVisible(true);
        
        System.out.println("返回的地址" + jiangong.get());
        return jiangong.get();

    }
    
     public static void printFrame()
	 {
		  progresspane = new ProgressPane(); 
		  
		  button1 = new JButton("正在下载");
		  button1.setFont(new Font("楷体",Font.BOLD,16));
		  button1.setForeground(Color.BLACK);
		  button1.setBackground(MYSELF_COLOR);
		  button1. setFocusPainted(false);
		  
		  panel1 = new JPanel(); 
		  panel1.setLayout(new GridBagLayout()); 
		  
		  gridBagConstraints1 = new GridBagConstraints(); 
		  gridBagConstraints1.gridy = 0; 
		  gridBagConstraints1.gridx = 0; 
		  
		  panel1.add(button1, gridBagConstraints1); 
		  
		  Dialog.add(panel1, BorderLayout.CENTER); 
		  Dialog.add(progresspane, BorderLayout.NORTH);
	}

	@Override
	public String call() throws Exception 
	{
		String Path = null;
		goon = true;
		while(goon)
		{
			Path = ClientTest.sendMessage(Videoname1);
			goon = false;
		}
		if(Path == null)
		{
			Dialog.dispose();
		}
		else
		{
			for(int i = 3; i >0 ;i --)
			{
				ProgressDialog.button1.setText("下载成功！本窗口将在"+ i + "s后自动关闭");
				Thread.sleep(1000);	
			}
			Dialog.dispose();
		}
		
		
		
		return Path;
	}
}  

