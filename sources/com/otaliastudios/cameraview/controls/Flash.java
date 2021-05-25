package com.otaliastudios.cameraview.controls;
public enum Flash implements Control {
    OFF(0),
    ON(1),
    AUTO(2),
    TORCH(3);
    
    public int a;

    /* access modifiers changed from: public */
    Flash(int i) {
        this.a = i;
    }
}
