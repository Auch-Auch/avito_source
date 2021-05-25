package com.otaliastudios.cameraview.internal;

import android.opengl.GLES20;
public class Issue514Workaround {
    public final int a;

    public Issue514Workaround(int i) {
        this.a = i;
    }

    public void beforeOverlayUpdateTexImage() {
        GLES20.glBindTexture(36197, this.a);
    }

    public void end() {
        GLES20.glBindTexture(36197, 0);
    }
}
