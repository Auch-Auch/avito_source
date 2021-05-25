package com.otaliastudios.cameraview.controls;
public enum AudioCodec implements Control {
    DEVICE_DEFAULT(0),
    AAC(1),
    HE_AAC(2),
    AAC_ELD(3);
    
    public int a;

    /* access modifiers changed from: public */
    AudioCodec(int i) {
        this.a = i;
    }
}
