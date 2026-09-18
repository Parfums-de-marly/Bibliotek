import Øve_Opgaver.TrafficLight;

void main() {
    TrafficLight trafficLight = new TrafficLight();

    trafficLight.next();
    IO.println(trafficLight.currentColor);

    trafficLight.next();
    IO.println(trafficLight.currentColor);

    trafficLight.next();
    IO.println(trafficLight.currentColor);

}

