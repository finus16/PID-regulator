package com.dziecielski;

public class Pump{
    private float flow;
    private float maxFlow;

    public float getFlow() {
        return this.flow;
    }

    public void setFlow(float value) {
        if(value<0){
            this.flow = 0.0f;
        }else if(value>this.maxFlow){
            this.flow = this.maxFlow;
        }else{
            this.flow = value;
        }
    }

    public Pump(float value){
        this.maxFlow = value;
    }

}