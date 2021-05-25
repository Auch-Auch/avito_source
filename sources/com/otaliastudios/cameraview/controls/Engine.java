package com.otaliastudios.cameraview.controls;
public enum Engine implements Control {
    CAMERA1(0),
    CAMERA2(1);
    
    public int a;

    /* access modifiers changed from: public */
    Engine(int i) {
        this.a = i;
    }
}
