import javax.accessibility.Accessible;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

class MyWindowAddapter extends WindowAdapter{
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}


}


public class AppWindow extends Frame {
	public static int xcoord=50;
	public static int ycoord=100;
	public static int width=80;
	public static int height=30;
	public static int width_window = 300;
	public static int height_window = 200;

	public AppWindow() {
		addWindowListener(new MyWindowAddapter());
	}

    public static void main(String[] args) {
	AppWindow appwin = new AppWindow();
	appwin.setSize(new Dimension(width_window,height_window));
	appwin.setTitle("An AWT-Based Application");
	Button b = new Button("exit");
	b.setBounds(xcoord,ycoord,width,height);
	b.addMouseMotionListener(new MouseMotionListener() {
		@Override
		public void mouseDragged(MouseEvent mouseEvent) {

		}

		@Override
		public void mouseMoved(MouseEvent mouseEvent) {
			System.out.print(appwin.getBounds().height);
			xcoord=(int)(Math.random()*(appwin.getBounds().width-80));
			ycoord=(int)(Math.random()*(appwin.getBounds().height-30)+20);
			b.setBounds(xcoord,ycoord,width,height);
		}
	});
	appwin.add(b);
	appwin.setLayout(null);
	appwin.setVisible(true);
    }
}
