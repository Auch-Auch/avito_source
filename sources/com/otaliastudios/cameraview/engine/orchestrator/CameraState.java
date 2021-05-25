package com.otaliastudios.cameraview.engine.orchestrator;

import androidx.annotation.NonNull;
public enum CameraState {
    OFF(0),
    ENGINE(1),
    BIND(2),
    PREVIEW(3);
    
    public int a;

    /* access modifiers changed from: public */
    CameraState(int i) {
        this.a = i;
    }

    public boolean isAtLeast(@NonNull CameraState cameraState) {
        return this.a >= cameraState.a;
    }
}
