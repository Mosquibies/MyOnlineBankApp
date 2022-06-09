package app.utils;

import java.util.Random;

public class RandomNumber {

    public int getRandom(int min, int max) {
        int diff = max - min;
        Random r = new Random();
        int i = r.nextInt(diff + 1);
        i += min;
        return i;
    }

    public float getRandomFloat() {
        float min = 0F;
        float max = 2000000F;
        float i = (min + new Random().nextFloat() * (max - min));
        System.out.println(i);
        return i;
    }
}
