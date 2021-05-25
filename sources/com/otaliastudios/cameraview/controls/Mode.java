package com.otaliastudios.cameraview.controls;
public enum Mode implements Control {
    PICTURE(0),
    VIDEO(1);
    
    public int a;

    /* access modifiers changed from: public */
    Mode(int i) {
        this.a = i;
    }
}
