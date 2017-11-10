import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class ImagePanel extends JPanel{

    private BufferedImage image;
    public resizePicture r;
    public Rectangle selectionBounds;
    public Point clickPoint;
    
    
    
    
    public ImagePanel(File f) {
       try {                
          image = ImageIO.read(f);
          r=new resizePicture(image);
          MouseAdapter mouseHandler = new MouseAdapter() {
              @Override
              public void mouseClicked(MouseEvent e) {
                  if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 2) {
                	  selectionBounds = null;
                  }
              }

              @Override
              public void mousePressed(MouseEvent e) {
                  clickPoint = e.getPoint();
                  selectionBounds = null;
              }

              @Override
              public void mouseReleased(MouseEvent e) {
                  clickPoint = null;
              }

              @Override
              public void mouseDragged(MouseEvent e) {
                  Point dragPoint = e.getPoint();
                  int x = Math.min(clickPoint.x, dragPoint.x);
                  int y = Math.min(clickPoint.y, dragPoint.y);
                  int width = Math.max(clickPoint.x - dragPoint.x, dragPoint.x - clickPoint.x);
                  int height = Math.max(clickPoint.y - dragPoint.y, dragPoint.y - clickPoint.y);
                  selectionBounds = new Rectangle(x, y, width, height);
                  repaint();
              }
          };

          addMouseListener(mouseHandler);
          addMouseMotionListener(mouseHandler);
          
          
          
          
          
       } catch (IOException e) {
            System.out.println(e.getMessage());
       }
    }

    public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
		
	}

	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
        if(selectionBounds != null){
        	Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(new Color(255, 255, 255, 128));

            Area fill = new Area(new Rectangle(new Point(0, 0), getSize()));
            if (selectionBounds != null) {
                fill.subtract(new Area(selectionBounds));
            }
            g2d.fill(fill);
            if (selectionBounds != null) {
                g2d.setColor(Color.BLACK);
                g2d.draw(selectionBounds);
            }
            g2d.dispose();      
        }
              
    }

}