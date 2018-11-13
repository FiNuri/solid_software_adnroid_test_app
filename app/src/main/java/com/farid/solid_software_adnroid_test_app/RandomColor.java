package com.farid.solid_software_adnroid_test_app;

import android.graphics.Color;
import java.util.Random;

public class RandomColor{

    private int rgb;

    public RandomColor(){

        setRandomColor();
    }
    //устанавливает рандомное значение для rgb
    private void setRandomColor(){

        Random random = new Random();
        int rColor = Color.argb(255, random.nextInt(),random.nextInt(),random.nextInt());
        this.rgb = rColor;
    }
    //возврощает rgb попутно обновляя его
    public int getRgb(){
        setRandomColor();
        return this.rgb;
    }
}
