package com.dziecielski;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

class MyCanvas extends Canvas{
    int tankWidth, tankHeigth;
    int borderWidth;
    int tankFill; // tank fill in %
    int holeSize;
    int desiredLevel;
    float inflow, outflow;

    MyCanvas(){
        this.tankHeigth = 350;
        this.tankWidth = 200;
        this.borderWidth = 5;
        this.tankFill = 0;
        this.holeSize = 30;
        this.desiredLevel = 280;
    }

    public void setInflow(float value){
        this.inflow = value;
    }

    public void setOutflow(float value){
        this.outflow = value;
    }

    public void setTankFill(int value){
        if(value>100){
            this.tankFill = 100;
        }else if(value<0){
            this.tankFill = 0;
        }else{
            this.tankFill = value;
        }
    }

    @Override
    public void paint(Graphics g) {
        paintTank(g);
        paintInfo(g);
        paintDesiredLevel(g);
    }

    private void paintTank(Graphics g) {
        int x, y, w, h;
        int heigth = this.getHeight();
        int width = this.getWidth();

        // black border of the tank
        x = width/2 - tankWidth/2 - borderWidth;
        y = heigth/2 - tankHeigth/2 - borderWidth;
        w = tankWidth + (2*borderWidth);
        h = tankHeigth + (2*borderWidth);
        g.setColor(Color.black);
        g.fillRect(x, y, w, h);

        // tank itself
        x = width/2 - tankWidth/2;
        y = heigth/2 - tankHeigth/2;
        w = tankWidth;
        h = tankHeigth;
        g.setColor(Color.lightGray);
        g.fillRect(x, y, w, h);

        // hole
        x = width/2 + tankWidth/2 - (holeSize - borderWidth);
        y = heigth/2 + tankHeigth/2 - holeSize;
        w = holeSize;
        h = holeSize;
        g.setColor(Color.lightGray);
        g.fillRect(x, y, w, h);

        // water
        x = width/2 - tankWidth/2;
        y = heigth/2 + tankHeigth/2 - (this.tankFill * this.tankHeigth/100);
        w = tankWidth;
        h = this.tankFill * this.tankHeigth / 100;
        g.setColor(Color.cyan);
        g.fillRect(x, y, w, h);
    }

    private void paintInfo(Graphics g) {
        int x, y;

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 30));

        // inflow
        x = this.getWidth()/2 - this.tankWidth/2 - 50;
        y = this.getHeight()/2 - this.tankHeigth/2 - 50;
        g.drawString("Inflow: " + Float.toString(this.inflow), x, y);

        // outflow
        x = this.getWidth()/2 + this.tankWidth/2 - 50;
        y = this.getHeight()/2 + this.tankHeigth/2 + 50;
        g.drawString("Outflow: " + Float.toString(this.outflow), x, y);
    }

    private void paintDesiredLevel(Graphics g){
        int x1,x2,y1,y2;

        x1 = this.getWidth()/2 - this.tankWidth/2;
        x2 = this.getWidth()/2 + this.tankWidth/2;
        y1 = this.getHeight()/2 + this.tankHeigth/2 - this.desiredLevel;
        y2 = y1;
        g.setColor(Color.RED);
        g.drawLine(x1, y1, x2, y2);
    }
}