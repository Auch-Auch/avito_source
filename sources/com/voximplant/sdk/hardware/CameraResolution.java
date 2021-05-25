package com.voximplant.sdk.hardware;
public class CameraResolution {
    public int height;
    public int width;

    public CameraResolution(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public String toString() {
        return this.width + "x" + this.height;
    }
}
