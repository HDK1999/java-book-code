import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
public class SWTDemo {
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		//设置窗口的标题
		shell.setText("Hello,SWT ");
		shell.open();  //显示窗口
		//检测窗口是否释放，如果释放并且不存在事件需要处理，释放display
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
