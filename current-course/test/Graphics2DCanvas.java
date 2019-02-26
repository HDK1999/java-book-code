import java.awt.*;
import java.awt.geom.*;

public class Graphics2DCanvas extends Canvas{
    public void paint(Graphics g){ 
    	Graphics2D graphics2D = (Graphics2D) g;
  	  Rectangle2D rectangle2d = new Rectangle2D.Double(200, 100 ,100 ,200);
  	  graphics2D.setColor(Color.black);
    graphics2D.draw(rectangle2d);
  	  AffineTransform af=new AffineTransform();
  	  af.rotate(100, 200);
  	  graphics2D.draw(rectangle2d);

   }
    
   public static void main(String[] args){
	   Graphics2DCanvas gc=new Graphics2DCanvas();
	   Frame f = new Frame("»­±ÊÑÝÊ¾");
	f.add(gc);
		f.setVisible(true);
   }
}
