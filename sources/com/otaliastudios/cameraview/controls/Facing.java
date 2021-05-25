package com.otaliastudios.cameraview.controls;
public enum Facing implements Control {
    BACK(0),
    FRONT(1);
    
    public int a;

    /* access modifiers changed from: public */
    Facing(int i) {
        this.a = i;
    }
}
