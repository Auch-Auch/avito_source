package com.rd.animation.data.type;

import com.rd.animation.data.Value;
public class SlideAnimationValue implements Value {
    public int a;

    public int getCoordinate() {
        return this.a;
    }

    public void setCoordinate(int i) {
        this.a = i;
    }
}
