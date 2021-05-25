package com.otaliastudios.cameraview.markers;

import android.graphics.PointF;
import androidx.annotation.NonNull;
public interface AutoFocusMarker extends Marker {
    void onAutoFocusEnd(@NonNull AutoFocusTrigger autoFocusTrigger, boolean z, @NonNull PointF pointF);

    void onAutoFocusStart(@NonNull AutoFocusTrigger autoFocusTrigger, @NonNull PointF pointF);
}
