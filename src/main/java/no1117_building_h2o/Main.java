package no1117_building_h2o;

public class Main {
    public static void main(String[] args) {
        String input = "HOH";
        String output = "";
        // O出现的次数
        //int times = input.toCharArray().length / 3;
        int times = 6;
        try {
            H2O h2o = new H2O();
            new Thread(() -> {
                try {
                    for (int i = 0; i < times; i++) {
                        h2o.oxygen(new ReleaseOxygen());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            new Thread(() -> {
                try {
                    for (int i = 0; i < times*2; i++) {
                        h2o.hydrogen(new ReleaseHydrogen());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
