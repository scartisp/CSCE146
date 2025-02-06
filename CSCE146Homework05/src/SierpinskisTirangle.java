
//Simion Cartis
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class SierpinskisTirangle extends Canvas {
	public static int size = 900;
	public static int color = 0;

	public static void main(String[] args) {
		JFrame frame = new JFrame("S Triangle");
		frame.setSize(size, size);
		SierpinskisTirangle st = new SierpinskisTirangle();
		frame.add(st);

		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void paint(Graphics g) {
		int[] x = { size/2, size, 0 };
		int[] y = { 0, size, size };// the y-axis INCREASES as you go down

		drawTriangle(x, y, size, g);

	}

	public void drawTriangle(int[] x, int[] y, int size, Graphics g) {
		if (size >= 4) {
			g.setColor(Color.BLACK);
			g.fillPolygon(x, y, 3);//technically just making the black and white triangle over and over again
			//the parameters given to the recursive methods determines where I am adding those triangles

			// this code finds the midpoints of the triangle's sides
			int mx1 = (x[0] + x[1]) / 2;
			int my1 = (y[0] + y[1]) / 2;
			
			int mx2 = (x[1] + x[2]) / 2;
			int my2 = (y[1] + y[2]) / 2;
			
			int mx3 = (x[2] + x[0]) / 2;
			int my3 = (y[2] + y[0]) / 2;

			int[] whiteX = { mx1, mx2, mx3 };
			int[] whiteY = { my1, my2, my3 };
			
			g.setColor(Color.WHITE);
			g.fillPolygon(whiteX, whiteY, 3);
			
			//top triangles (holds the peek at center)
			int[] x1 = {x[0], mx1, mx3};
			int[] y1 = {y[0], my1, my3};
			drawTriangle(x1, y1, size/2, g);
			//right triangles (holds rightmost edge right)
			int[] x2 = { mx1, x[1], mx2};
			int[] y2 = { my1, y[1], my2};
			drawTriangle(x2, y2, size/2, g);
			//left triangles (holds leftmost edge left)
			int[] x3 = { mx3, mx2, x[2] };// x value must be mx3 to keep the rightmost edge relatively left
	        int[] y3 = { my3, my2, y[2] };//my3 and my1 same values, still just half the original height.
	        drawTriangle(x3, y3, size / 2, g);
		}
	}
}
