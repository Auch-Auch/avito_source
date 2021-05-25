package com.otaliastudios.cameraview.controls;
public enum WhiteBalance implements Control {
    AUTO(0),
    INCANDESCENT(1),
    FLUORESCENT(2),
    DAYLIGHT(3),
    CLOUDY(4);
    
    public int a;

    /* access modifiers changed from: public */
    WhiteBalance(int i) {
        this.a = i;
    }
}
