package concurrency.p1117_building_h2o;

public class ReleaseHydrogen implements Runnable {
    @Override
    public void run() {
        System.out.print("H");
    }
}
