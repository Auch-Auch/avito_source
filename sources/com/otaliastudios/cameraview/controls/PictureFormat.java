package com.otaliastudios.cameraview.controls;
public enum PictureFormat implements Control {
    JPEG(0),
    DNG(1);
    
    public int a;

    /* access modifiers changed from: public */
    PictureFormat(int i) {
        this.a = i;
    }
}
