package com.yandex.mapkit.user_location;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yandex.mapkit.location.LocationViewSource;
import com.yandex.mapkit.map.CameraPosition;
public interface UserLocationLayer {
    @Nullable
    CameraPosition cameraPosition();

    boolean isAnchorEnabled();

    boolean isAutoZoomEnabled();

    boolean isHeadingEnabled();

    boolean isValid();

    boolean isVisible();

    void resetAnchor();

    void setAnchor(@NonNull PointF pointF, @NonNull PointF pointF2);

    void setAutoZoomEnabled(boolean z);

    void setHeadingEnabled(boolean z);

    void setObjectListener(@Nullable UserLocationObjectListener userLocationObjectListener);

    void setSource(@Nullable LocationViewSource locationViewSource);

    void setTapListener(@Nullable UserLocationTapListener userLocationTapListener);

    void setVisible(boolean z);
}
