package java2d;
import java.awt.*;
import java.awt.geom.*;

class MyCanvas3 extends Canvas {
	public void paint(Graphics oldg) {
		Graphics2D g = (Graphics2D) oldg;
		// …Ë÷√± ª≠øÌ∂»
		BasicStroke stroke = new BasicStroke(10);
		g.setStroke(stroke);
		// ª≠œﬂ
		Line2D line = new Line2D.Float(0, 0, 20, 30);
		g.draw(line);
		line = new Line2D.Float(50, 50, 100, 50);
		g.draw(line);
		line = new Line2D.Float(50, 50, 50, 100);
		g.draw(line);

		stroke = new BasicStroke(5);
		g.setStroke(stroke);

		// …Ë÷√Ω•±‰ÃÓ≥‰
		GradientPaint gt = new GradientPaint(0, 0, Color.green, 50, 30,
				Color.blue, true);
		g.setPaint((Paint) gt);
		// ª≠æÿ–Œ
		Rectangle2D rect = new Rectangle2D.Float(80, 80, 40, 40);
		g.draw(rect);
		rect = new Rectangle2D.Float(100, 100, 40, 40);
		g.fill(rect);
		// ª≠Õ÷‘≤
		Ellipse2D ellipse = new Ellipse2D.Float(120, 120, 30, 40);
		g.draw(ellipse);
		gt = new GradientPaint(0, 0, Color.red, 30, 30, Color.yellow, true);
		g.setPaint((Paint) gt);
		ellipse = new Ellipse2D.Float(140, 140, 20, 20);
		g.fill(ellipse);
		// ª≠‘≤Ω«æÿ–Œ
		RoundRectangle2D roundRect = new RoundRectangle2D.Float(160, 160, 40,
				40, 20, 20);
		g.draw(roundRect);
		roundRect = new RoundRectangle2D.Float(180, 180, 40, 40, 20, 20);
		g.fill(roundRect);
		// ª≠º∏∫ŒÕº–Œ
		GeneralPath path = new GeneralPath();
		path.moveTo(150, 0);
		path.lineTo(160, 50);
		path.curveTo(190, 200, 240, 140, 200, 100);
		g.fill(path);
	}
}

public class GUI2D {
	public static void main(String[] args) {
		MyCanvas3 cv = new MyCanvas3();
		Frame f = new Frame("≤‚ ‘øÚº‹");
		f.add(cv);
		f.setBounds(30, 30, 400, 400);
		f.setVisible(true);
	}
}