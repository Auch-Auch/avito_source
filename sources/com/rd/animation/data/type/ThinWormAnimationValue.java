package com.rd.animation.data.type;

import com.rd.animation.data.Value;
public class ThinWormAnimationValue extends WormAnimationValue implements Value {
    public int c;

    public int getHeight() {
        return this.c;
    }

    public void setHeight(int i) {
        this.c = i;
    }
}
