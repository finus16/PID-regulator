package com.dziecielski;

public class Tank{
    private float a, maxHeight; // in meters
    private float hole;
    private Pid pid;
    private Pump pump;
    private float h; // current height of water in tank

    public Tank(float a, float h){
        this.a = a;
        this.maxHeight = h;
        this.pid = new Pid(0.7f, 0.05f, 1.8f); // set PID 
        this.pump = new Pump(5.0f); // set pump with desired flow
        this.hole = 0.5f; // set hole in tank
        this.pid.setSetpoint(0.8f*this.maxHeight); // we desire 0.8 of the maximum height
    }

    public float getA() {
        return this.a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public float getMaxHeight() {
        return this.maxHeight;
    }

    public void setMaxHeight(int h) {
        this.maxHeight = h;
    }

    public void setHole(float hole){
        this.hole = hole;
    }

    public float getInflow(){
        return this.pump.getFlow();
    }

    public float getOutflow(){
        return (this.h * this.hole);
    }

    public int getFill(){
        return (int)(this.h / this.maxHeight * 100);
    }

    public void calculate(){
        float delta = pump.getFlow() - (h * hole); 
        this.h = this.h + (delta / (this.a*this.a));
        if(this.h>maxHeight){
            this.h = maxHeight;
        }
        if(this.h<0.0f){
            this.h = 0.0f;
        }


        float pidOutput = this.pid.getOutput(this.h);
        if(pidOutput>5.0f){
            pidOutput = 5.0f;
        }
        if(pidOutput<0.0f){
            pidOutput = 0.0f;
        }

        pump.setFlow(pidOutput);
    }


}