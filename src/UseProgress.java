import java.awt.Color;

public class UseProgress
{

    ProgressDialog progress;
	private static final Color HIGHLIGHT_COLOR = new Color(75,51,226);

    public UseProgress()
    {
        progress=new ProgressDialog();
    }
    
    public void printProgress(String msg,int num)
    {
    	ProgressDialog.progresspane.progressBar.setForeground(HIGHLIGHT_COLOR);
    	ProgressDialog.progresspane.progressBar.setValue(num);
    	ProgressDialog.progresspane.progressBar.setString(msg+num+"%"); 
    }
}

