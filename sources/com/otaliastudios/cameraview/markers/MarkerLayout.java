package com.otaliastudios.cameraview.markers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
public class MarkerLayout extends FrameLayout {
    public static final int TYPE_AUTOFOCUS = 1;
    @SuppressLint({"UseSparseArrays"})
    public final HashMap<Integer, View> a = new HashMap<>();

    public MarkerLayout(@NonNull Context context) {
        super(context);
    }

    public void onEvent(int i, @NonNull PointF[] pointFArr) {
        View view = this.a.get(Integer.valueOf(i));
        if (view != null) {
            view.clearAnimation();
            if (i == 1) {
                PointF pointF = pointFArr[0];
                view.setTranslationX((float) ((int) (pointF.x - ((float) (view.getWidth() / 2)))));
                view.setTranslationY((float) ((int) (pointF.y - ((float) (view.getHeight() / 2)))));
            }
        }
    }

    public void onMarker(int i, @Nullable Marker marker) {
        View onAttach;
        View view = this.a.get(Integer.valueOf(i));
        if (view != null) {
            removeView(view);
        }
        if (marker != null && (onAttach = marker.onAttach(getContext(), this)) != null) {
            this.a.put(Integer.valueOf(i), onAttach);
            addView(onAttach);
        }
    }
}
