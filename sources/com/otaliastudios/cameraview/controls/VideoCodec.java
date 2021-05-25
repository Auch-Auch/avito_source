package com.otaliastudios.cameraview.controls;
public enum VideoCodec implements Control {
    DEVICE_DEFAULT(0),
    H_263(1),
    H_264(2);
    
    public int a;

    /* access modifiers changed from: public */
    VideoCodec(int i) {
        this.a = i;
    }
}
