package com.otaliastudios.cameraview.gesture;

import android.content.res.TypedArray;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.R;
public class GestureParser {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;

    public GestureParser(@NonNull TypedArray typedArray) {
        this.a = typedArray.getInteger(R.styleable.CameraView_cameraGestureTap, GestureAction.d.a);
        this.b = typedArray.getInteger(R.styleable.CameraView_cameraGestureLongTap, GestureAction.e.a);
        this.c = typedArray.getInteger(R.styleable.CameraView_cameraGesturePinch, GestureAction.c.a);
        this.d = typedArray.getInteger(R.styleable.CameraView_cameraGestureScrollHorizontal, GestureAction.f.a);
        this.e = typedArray.getInteger(R.styleable.CameraView_cameraGestureScrollVertical, GestureAction.g.a);
    }

    public final GestureAction a(int i) {
        GestureAction[] values = GestureAction.values();
        for (int i2 = 0; i2 < 8; i2++) {
            GestureAction gestureAction = values[i2];
            if (gestureAction.a == i) {
                return gestureAction;
            }
        }
        return null;
    }

    public GestureAction getHorizontalScrollAction() {
        return a(this.d);
    }

    public GestureAction getLongTapAction() {
        return a(this.b);
    }

    public GestureAction getPinchAction() {
        return a(this.c);
    }

    public GestureAction getTapAction() {
        return a(this.a);
    }

    public GestureAction getVerticalScrollAction() {
        return a(this.e);
    }
}
