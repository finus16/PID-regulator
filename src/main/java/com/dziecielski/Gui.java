package com.dziecielski;

import java.awt.*;

import javax.swing.*;

public class Gui {
    JFrame frame;
    MyCanvas canvas;

    Gui(){
        canvas = new MyCanvas();
        frame = new JFrame("PID regulator");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(canvas);
    }

	public void fetchData(Tank tank) {
        canvas.setOutflow(tank.getOutflow());
        canvas.setInflow(tank.getInflow());
        canvas.setTankFill(tank.getFill());
	}

	public void refresh() {
        canvas.repaint();
	}

    
}