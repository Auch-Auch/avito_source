package com.bumptech.glide;
public enum MemoryCategory {
    LOW(0.5f),
    NORMAL(1.0f),
    HIGH(1.5f);
    
    public final float a;

    /* access modifiers changed from: public */
    MemoryCategory(float f) {
        this.a = f;
    }

    public float getMultiplier() {
        return this.a;
    }
}
