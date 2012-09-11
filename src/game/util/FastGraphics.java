package game.util;


	import java.awt.BasicStroke;
	import java.awt.Color;
	import java.awt.Component;
	import java.awt.Dimension;
	import java.awt.Font;
	import java.awt.Graphics;
	import java.awt.Graphics2D;
	import java.awt.Rectangle;
	import java.awt.RenderingHints;
	import java.awt.Shape;
	import java.awt.Toolkit;
	import java.awt.geom.RoundRectangle2D;
	import java.awt.image.BufferedImage;

	/**
	 * @author David
	 *
	 */
	public class FastGraphics {

		Graphics2D gPublic;
		

	public int getWidthPercent(Component comp, int k) {
		
		double a, b;
		a = comp.getHeight()/100;
		b = a*k;
		return (int) b;
	}

	public int getHeightPercent(Component comp, int k) {
		
		double a, b;
		a = comp.getHeight()/100;
		b = a*k;
		return (int) b;
	} 

	public void drawShape(Shape shape, Color outline, Color fill, BufferedImage img)	{
		
		Graphics2D g2 = (Graphics2D)img.getGraphics();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(outline);
		g2.draw(shape);
		g2.setColor(fill);
		g2.fill(shape);
	 ;}

	public void drawShapeB(Shape shape, Color outline, Color fill, BufferedImage img, int border)	{
		
		Graphics2D g2 = (Graphics2D)img.getGraphics();
		g2.setStroke(new BasicStroke(border));
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(outline);
		g2.draw(shape);
		g2.setColor(fill);
		g2.fill(shape);
	 ;}

	public void fastShapeB(Shape shape, Color outline, Color fill, int border)	{
		
		gPublic.setStroke(new BasicStroke(border));
		gPublic.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		gPublic.setColor(outline);
		gPublic.draw(shape);
		gPublic.setColor(fill);
		gPublic.fill(shape);
	 ;}

	public void fastRR(Rectangle rect, int corner, Color outline, Color fill, int border)	{
		
		
		RoundRectangle2D shape = new RoundRectangle2D.Double(rect.getX(),rect.getY(), rect.getWidth(), rect.getHeight(), corner, corner);
		gPublic.setStroke(new BasicStroke(border));
		gPublic.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		gPublic.setColor(fill);
		gPublic.fill(shape);
		gPublic.setColor(outline);
		gPublic.draw(shape);
		
	 ;}

	public void RR(Rectangle rect, int corner, Color outline, Color fill, int border, Graphics g2)	{
		
		Graphics2D g = (Graphics2D) g2;
		RoundRectangle2D shape = new RoundRectangle2D.Double(rect.getX(),rect.getY(), rect.getWidth(), rect.getHeight(), corner, corner);
		g.setStroke(new BasicStroke(border));
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(fill);
		g.fill(shape);
		g.setColor(outline);
		g.draw(shape);

	 ;}

	public void text(Font font, Color color, String text, Graphics g2, int x, int y)	{
		
		Graphics2D g;
		g = (Graphics2D)g2;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g.setColor(color);
		g.setFont(font);
		g.drawString(text, x, y);
		
	 ;}

	public void fastShape(Shape shape, Color outline, Color fill)	{
		
		gPublic.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		gPublic.setColor(outline);
		gPublic.draw(shape);
		gPublic.setColor(fill);
		gPublic.fill(shape);
	 ;}

	public void setGraphics(BufferedImage img){
		
		gPublic = (Graphics2D)img.getGraphics();
		
	}

	public void draw3DRect(int x, int y, int height, int width, Color outline, Color fill, Boolean raised)	{
		
		gPublic.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		gPublic.setColor(outline);
		
		gPublic.draw3DRect(x,y,width,height,raised);
		gPublic.setColor(fill);
		gPublic.fill3DRect(x,y,width,height,raised);
		
	 ;}

	public Dimension getRes()	{
		// Get the default toolkit
		Toolkit toolkit = Toolkit.getDefaultToolkit();

		// Get the current screen size
		Dimension scrnsize = toolkit.getScreenSize();

		// Print the screen size
		

		
		return scrnsize;
	}
	}

