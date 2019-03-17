package com.dziecielski;

public class Pid{
    private float Kp, Pi, Pd;
    private float setPoint;
    private float last, current;
    private float sum;

    public Pid() {
        this.Kp = 0;
        this.Pi = 0;
        this.Pd = 0;
        this.setPoint = 0;
        this.last = 0;
        this.current = 0;
        this.sum = 0;
    }

    public Pid(float Kp, float Pi, float Pd) {
        this.Kp = Kp;
        this.Pi = Pi;
        this.Pd = Pd;
        this.setPoint = 0;
        this.last = 0;
        this.current = 0;
        this.sum = 0;
    }

    public float getKp(){
        return this.Kp;
    }

    public void setKp(float Kp){
        this.Kp = Kp;
    }
    public float getPi() {
        return this.Pi;
    }

    public void setPi(float Pi) {
        this.Pi = Pi;
    }

    public float getPd() {
        return this.Pd;
    }

    public void setPd(float Pd) {
        this.Pd = Pd;
    }

    public void setSetpoint(float x){
        this.setPoint = x;
    }

    private float getP(float deviation){
        return this.Kp * deviation;
    }

    private float getI(float deviation){
        this.sum += deviation;
        return this.Pi * this.sum;
    }

    private float getD(float deviation){
        return this.Pd * (this.current - this.last);
    }

    public float getOutput(float current){
        this.last = this.current;
        this.current = current;

        float deviation = this.setPoint - this.current;
        return getP(deviation) + getI(deviation) + getD(deviation);
    }
}