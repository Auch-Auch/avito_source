package com.my.target;

import androidx.annotation.NonNull;
public class cv extends da {
    public float g = -1.0f;
    public float h = 0.0f;

    public cv(@NonNull String str, @NonNull String str2) {
        super(str, str2);
    }

    @NonNull
    public static cv H(@NonNull String str) {
        return new cv("mrcStat", str);
    }

    public float cs() {
        return this.h;
    }

    public float getDuration() {
        return this.g;
    }

    public void k(float f) {
        this.h = f;
    }

    public void setDuration(float f) {
        this.g = f;
    }
}
