package com.rd.animation.data.type;

import com.rd.animation.data.Value;
public class ScaleAnimationValue extends ColorAnimationValue implements Value {
    public int c;
    public int d;

    public int getRadius() {
        return this.c;
    }

    public int getRadiusReverse() {
        return this.d;
    }

    public void setRadius(int i) {
        this.c = i;
    }

    public void setRadiusReverse(int i) {
        this.d = i;
    }
}
