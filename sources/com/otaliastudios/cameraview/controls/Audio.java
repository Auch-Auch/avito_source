package com.otaliastudios.cameraview.controls;
public enum Audio implements Control {
    OFF(0),
    ON(1),
    MONO(2),
    STEREO(3);
    
    public int a;

    /* access modifiers changed from: public */
    Audio(int i) {
        this.a = i;
    }
}
