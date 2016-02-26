/*
 * simpleCanvas.java
 * 
 * Version: $Id: simpleCanvas.java, v 1.1 2015/03/03 20:14:43
 * 
 * Revisions: 
 * 		
 * Initial Revision
 * 
 */

/**
 * This is a simple class to allow pixel level drawing in
 * java without using OpenGL
 *
 * techniques for pixel drawing taken from:
 *
 *   http://www.cap-lore.com/code/java/JavaPix.java
 *
 *  with my thanks.
 *  
 *  @author Sanika Kulkarni
 */
import java.awt.*;
import java.awt.image.*;


public class simpleCanvas extends Canvas {
    
    public BufferedImage I;
    private int clearC;
    private int width;
    private int height;
    private Color curColor;

    simpleCanvas (int w, int h) 
    {
        width = w;
        height = h;
        I = new BufferedImage (width, height, BufferedImage.TYPE_INT_RGB);
        curColor = new Color (0.0f, 0.0f, 0.0f);
        
        setSize (w, h);

    }
    
    
    public void clear()
    {
        for (int i=0; i < width; i++)
            for (int j=0; j < height; j++)
                I.setRGB (i,j, curColor.getRGB());
    }
    
    public void setColor (float r, float g, float b)
    {
        curColor = new Color (r,g, b);
    }
    
    
    public void setPixel (int x, int y)
    {
        I.setRGB (x, (height - y - 1), curColor.getRGB());
        
    }
    
    public void paint(Graphics g)
    {
        // draw pixels
        g.drawImage(I, 0, 0, Color.red, null);
    }

    

}
