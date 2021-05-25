package com.otaliastudios.cameraview.gesture;

import androidx.annotation.NonNull;
/* JADX WARN: Init of enum NONE can be incorrect */
/* JADX WARN: Init of enum AUTO_FOCUS can be incorrect */
/* JADX WARN: Init of enum TAKE_PICTURE can be incorrect */
/* JADX WARN: Init of enum TAKE_PICTURE_SNAPSHOT can be incorrect */
/* JADX WARN: Init of enum ZOOM can be incorrect */
/* JADX WARN: Init of enum EXPOSURE_CORRECTION can be incorrect */
/* JADX WARN: Init of enum FILTER_CONTROL_1 can be incorrect */
/* JADX WARN: Init of enum FILTER_CONTROL_2 can be incorrect */
public enum GestureAction {
    NONE(0, r1),
    AUTO_FOCUS(1, r1),
    TAKE_PICTURE(2, r1),
    TAKE_PICTURE_SNAPSHOT(3, r1),
    ZOOM(4, r8),
    EXPOSURE_CORRECTION(5, r8),
    FILTER_CONTROL_1(6, r8),
    FILTER_CONTROL_2(7, r8);
    
    public static final GestureAction c;
    public static final GestureAction d;
    public static final GestureAction e;
    public static final GestureAction f;
    public static final GestureAction g;
    public int a;
    public GestureType b;

    /* access modifiers changed from: public */
    static {
        GestureAction gestureAction;
        GestureType gestureType = GestureType.ONE_SHOT;
        GestureType gestureType2 = GestureType.CONTINUOUS;
        c = gestureAction;
        d = gestureAction;
        e = gestureAction;
        f = gestureAction;
        g = gestureAction;
    }

    /* access modifiers changed from: public */
    GestureAction(int i, @NonNull GestureType gestureType) {
        this.a = i;
        this.b = gestureType;
    }
}
