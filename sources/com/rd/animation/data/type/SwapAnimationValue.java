package com.rd.animation.data.type;

import com.rd.animation.data.Value;
public class SwapAnimationValue implements Value {
    public int a;
    public int b;

    public int getCoordinate() {
        return this.a;
    }

    public int getCoordinateReverse() {
        return this.b;
    }

    public void setCoordinate(int i) {
        this.a = i;
    }

    public void setCoordinateReverse(int i) {
        this.b = i;
    }
}
