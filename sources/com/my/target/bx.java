package com.my.target;

import androidx.annotation.NonNull;
public class bx {
    public float a = 1.0f;
    public float b = 0.5f;
    public float c = 0.0f;

    @NonNull
    public static bx bE() {
        return new bx();
    }

    public float bF() {
        return this.a;
    }

    public float bG() {
        return this.b;
    }

    public float bH() {
        return this.c;
    }

    public void f(float f) {
        this.b = f;
    }

    public void g(float f) {
        this.a = f;
    }

    public void h(float f) {
        this.c = f;
    }
}
