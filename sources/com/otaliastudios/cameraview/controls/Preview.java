package com.otaliastudios.cameraview.controls;
public enum Preview implements Control {
    SURFACE(0),
    TEXTURE(1),
    GL_SURFACE(2);
    
    public int a;

    /* access modifiers changed from: public */
    Preview(int i) {
        this.a = i;
    }
}
