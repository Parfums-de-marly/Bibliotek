package Øve_Opgaver;

public class TrafficLight {

    public Color currentColor;

    public TrafficLight(){
        this.currentColor = Color.Red;
        this.currentColor = Color.Yellow;
        this.currentColor = Color.Green;
    }

    public void next(){
        if (currentColor == Color.Red){
            currentColor = Color.Green;
        } else if (currentColor == Color.Green){
            currentColor = Color.Yellow;
        } else if (currentColor == Color.Yellow){
            currentColor = Color.Red;
        }
    }

}
