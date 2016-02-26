/*
 * fillTest.java
 * 
 * Version: $Id: fillTest.java, v 1.1 2015/03/03 20:14:43
 * 
 * Revisions: 
 * 		
 * Initial Revision
 * 
 */

/**
 * 
 * A simple class for performing fillTest algorithms.
 *
 * @author Sanika Kulkarni
 *
 */


import java.awt.*;
import java.awt.event.*;

public class fillTest {
    
    public fillTest() {}    

    static public void main(String[] args){
        
        simpleCanvas T = new simpleCanvas( 901, 601 );
        Rasterizer R = new Rasterizer( 601 );

        T.setColor( 0, 0, 0 );
        T.clear();
        T.setColor( 1, 0, 0 );

        int x[] = new int[10];
        int y[] = new int[10];

        // ########### TEAPOT START ###########
        // BASE
        x[0] = 140;  y[0] = 40;
        x[1] = 300;  y[1] = 40;
        x[2] = 280;  y[2] = 60;
        x[3] = 160;  y[3] = 60;
        R.drawPolygon( 4, x, y, T );
    
        // LEFT BOTTOM TRIANGLE
        x[0] = 100;  y[0] = 120;
        x[1] = 160;  y[1] = 60;
        x[2] = 280;  y[2] = 60;
        T.setColor( 0.90f, 0, 0 );
       R.drawPolygon( 3, x, y, T );
    
        x[0] = 280;  y[0] = 60;
        x[1] = 340;  y[1] = 100;
        x[2] = 400;  y[2] = 180;
        T.setColor( 0.80f, 0, 0 );
        R.drawPolygon( 3, x, y, T );
    
        // SPOUT
        x[0] = 280;  y[0] = 60;
        x[1] = 400;  y[1] = 180;
        x[2] = 440;  y[2] = 200;
        x[3] = 380;  y[3] = 200;
        x[4] = 320;  y[4] = 160;
        T.setColor( 0.7f, 0, 0 );
       R.drawPolygon( 5, x, y, T );
    
        x[0] = 280;  y[0] = 60;
        x[1] = 320;  y[1] = 160;
        x[2] = 280;  y[2] = 240;
        x[3] = 160;  y[3] = 240;
        x[4] = 100;  y[4] = 120;
        T.setColor( 0.6f, 0, 0 );
        R.drawPolygon( 5, x, y, T );
    
        x[0] = 100;  y[0] = 120;
        x[1] = 60;   y[1] = 160;
        x[2] = 45;   y[2] = 200;
        x[3] = 180;  y[3] = 220;
        x[4] = 180;  y[4] = 200;
        x[5] = 70;   y[5] = 190;
        x[6] = 75;   y[6] = 165;
        x[7] = 120;  y[7] = 120;
        T.setColor( 0.5f, 0, 0 );
        R.drawPolygon( 8, x, y, T );
    
        x[0] = 210;  y[0] = 240;
        x[1] = 190;  y[1] = 260;
        x[2] = 250;  y[2] = 260;
        x[3] = 230;  y[3] = 240;
        T.setColor( 0.4f, 0, 0 );
        R.drawPolygon( 4, x, y, T );
    
        // ######## TRIANGLE #######
        x[0] = 440;  y[0] = 220;
        x[1] = 410;  y[1] = 280;
        x[2] = 480;  y[2] = 280;
        T.setColor( 0, 1, 0 );
        R.drawPolygon( 3, x, y, T );
    
        // ########## QUAD ##########
        x[0] = 520;  y[0] = 280;
        x[1] = 580;  y[1] = 320;
        x[2] = 540;  y[2] = 380;
        x[3] = 480;  y[3] = 340;
      T.setColor( 0, 0.8f, 0.8f );
       R.drawPolygon( 4, x, y, T );
    
        // ############ STAR #############
        x[0] = 670;  y[0] = 389;
        x[1] = 640;  y[1] = 369;
        x[2] = 646;  y[2] = 402;
        x[3] = 622;  y[3] = 425;
        x[4] = 655;  y[4] = 430;
        x[5] = 670;  y[5] = 460;
        x[6] = 670;  y[6] = 410;
        T.setColor( 0.8f, 0.8f, 0 );
       R.drawPolygon( 7, x, y, T );
    
        // ############ RIGHT SIDE #############
        x[0] = 670;  y[0] = 460;
        x[1] = 684;  y[1] = 430;
        x[2] = 717;  y[2] = 425;
        x[3] = 693;  y[3] = 402;
        x[4] = 699;  y[4] = 369;
        x[5] = 670;  y[5] = 389;
        x[6] = 670;  y[6] = 410;
        T.setColor( 0.7f, 0.7f, 0 );
        R.drawPolygon( 7, x, y, T );
    
        // ########## BORDERS ###############
        // SQUARE BOTTOM LEFT
        x[0] = 0;    y[0] = 0;
        x[1] = 0;    y[1] = 20;
        x[2] = 20;   y[2] = 20;
        x[3] = 20;   y[3] = 0;
        T.setColor( 0, 0, 1 );
        R.drawPolygon( 4, x, y, T );
    
        x[0] = 0;    y[0] = 10;
        x[1] = 10;   y[1] = 10;
        x[2] = 10;   y[2] = 580;
        x[3] = 0;    y[3] = 580;
        T.setColor( 0, 0.1f, 0.9f );
     //   R.drawPolygon( 4, x, y, T );
    
        x[0] = 0;    y[0] = 580;
        x[1] = 0;    y[1] = 600;
        x[2] = 20;   y[2] = 600;
        x[3] = 20;   y[3] = 580;
       T.setColor( 0, 0.2f, 0.8f );
        R.drawPolygon( 4, x, y, T );
    
        //  TRIANGLE TOP:TOP
        x[0] = 10;   y[0] = 590;
        x[1] = 10;   y[1] = 600;
        x[2] = 880;  y[2] = 600;
        T.setColor( 0, 0.3f, 0.7f );
        R.drawPolygon( 3, x, y, T );
    
        //  TRIANGLE TOP:BOTTOM
        x[0] = 10;   y[0] = 590;
        x[1] = 880;  y[1] = 590;
        x[2] = 880;  y[2] = 600;
        T.setColor( 0, 0.4f, 0.6f );
      //  R.drawPolygon( 3, x, y, T );
    
        // SQUARE TOP RIGHT
        x[0] = 900;  y[0] = 600;
        x[1] = 900;  y[1] = 580;
        x[2] = 880;  y[2] = 580;
        x[3] = 880;  y[3] = 600;
        T.setColor( 0.1f, 0.4f, 0.5f );
        R.drawPolygon( 4, x, y, T );
    
        //  TRIANGLE RIGHT:RIGHT
        x[0] = 890;  y[0] = 580;
        x[1] = 900;  y[1] = 580;
        x[2] = 890;  y[2] = 20;
        T.setColor( 0.2f, 0.4f, 0.4f );
     //   R.drawPolygon( 3, x, y, T );
    
        //  TRIANGLE RIGHT:LEFT
        x[0] = 900;  y[0] = 580;
        x[1] = 900;  y[1] = 20;
        x[2] = 890;  y[2] = 20;
        T.setColor( 0.3f, 0.4f, 0.3f );
    //    R.drawPolygon( 3, x, y, T );
    
        // SQUARE BOTTOM RIGHT
        x[0] = 900;  y[0] = 0;
        x[1] = 900;  y[1] = 20;
        x[2] = 880;  y[2] = 20;
        x[3] = 880;  y[3] = 0;
        T.setColor( 0.4f, 0.4f, 0.2f );
   //     R.drawPolygon( 4, x, y, T );
    
        // QUAD BOTTOM
        x[0] = 20;   y[0] = 0;
        x[1] = 20;   y[1] = 10;
        x[2] = 880;  y[2] = 10;
        x[3] = 880;  y[3] = 0;
        T.setColor( 0.4f, 0.5f, 0.1f );
     //   R.drawPolygon( 4, x, y, T ); */

        
        Frame f = new Frame( "Poly Fill Test" );
        f.add("Center", T);
        f.pack();
        f.setResizable (false);
        f.setVisible(true);
        
        f.addWindowListener( new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        
    }

}
