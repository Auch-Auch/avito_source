package com.otaliastudios.cameraview.gesture;

import androidx.annotation.NonNull;
/* JADX WARN: Init of enum PINCH can be incorrect */
/* JADX WARN: Init of enum TAP can be incorrect */
/* JADX WARN: Init of enum LONG_TAP can be incorrect */
/* JADX WARN: Init of enum SCROLL_HORIZONTAL can be incorrect */
/* JADX WARN: Init of enum SCROLL_VERTICAL can be incorrect */
public enum Gesture {
    PINCH(r1),
    TAP(r4),
    LONG_TAP(r4),
    SCROLL_HORIZONTAL(r1),
    SCROLL_VERTICAL(r1);
    
    public GestureType a;

    /* access modifiers changed from: public */
    static {
        GestureType gestureType = GestureType.CONTINUOUS;
        GestureType gestureType2 = GestureType.ONE_SHOT;
    }

    /* access modifiers changed from: public */
    Gesture(@NonNull GestureType gestureType) {
        this.a = gestureType;
    }

    public boolean isAssignableTo(@NonNull GestureAction gestureAction) {
        return gestureAction == GestureAction.NONE || gestureAction.b == this.a;
    }
}
