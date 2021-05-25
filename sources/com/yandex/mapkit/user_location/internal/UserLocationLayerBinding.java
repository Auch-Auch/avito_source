package com.yandex.mapkit.user_location.internal;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yandex.mapkit.location.LocationViewSource;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.user_location.UserLocationLayer;
import com.yandex.mapkit.user_location.UserLocationObjectListener;
import com.yandex.mapkit.user_location.UserLocationTapListener;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.subscription.Subscription;
public class UserLocationLayerBinding implements UserLocationLayer {
    private final NativeObject nativeObject;
    private Subscription<UserLocationObjectListener> userLocationObjectListenerSubscription = new Subscription<UserLocationObjectListener>() { // from class: com.yandex.mapkit.user_location.internal.UserLocationLayerBinding.1
        public NativeObject createNativeListener(UserLocationObjectListener userLocationObjectListener) {
            return UserLocationLayerBinding.createUserLocationObjectListener(userLocationObjectListener);
        }
    };
    private Subscription<UserLocationTapListener> userLocationTapListenerSubscription = new Subscription<UserLocationTapListener>() { // from class: com.yandex.mapkit.user_location.internal.UserLocationLayerBinding.2
        public NativeObject createNativeListener(UserLocationTapListener userLocationTapListener) {
            return UserLocationLayerBinding.createUserLocationTapListener(userLocationTapListener);
        }
    };

    public UserLocationLayerBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    /* access modifiers changed from: private */
    public static native NativeObject createUserLocationObjectListener(UserLocationObjectListener userLocationObjectListener);

    /* access modifiers changed from: private */
    public static native NativeObject createUserLocationTapListener(UserLocationTapListener userLocationTapListener);

    @Override // com.yandex.mapkit.user_location.UserLocationLayer
    @Nullable
    public native CameraPosition cameraPosition();

    @Override // com.yandex.mapkit.user_location.UserLocationLayer
    public native boolean isAnchorEnabled();

    @Override // com.yandex.mapkit.user_location.UserLocationLayer
    public native boolean isAutoZoomEnabled();

    @Override // com.yandex.mapkit.user_location.UserLocationLayer
    public native boolean isHeadingEnabled();

    @Override // com.yandex.mapkit.user_location.UserLocationLayer
    public native boolean isValid();

    @Override // com.yandex.mapkit.user_location.UserLocationLayer
    public native boolean isVisible();

    @Override // com.yandex.mapkit.user_location.UserLocationLayer
    public native void resetAnchor();

    @Override // com.yandex.mapkit.user_location.UserLocationLayer
    public native void setAnchor(@NonNull PointF pointF, @NonNull PointF pointF2);

    @Override // com.yandex.mapkit.user_location.UserLocationLayer
    public native void setAutoZoomEnabled(boolean z);

    @Override // com.yandex.mapkit.user_location.UserLocationLayer
    public native void setHeadingEnabled(boolean z);

    @Override // com.yandex.mapkit.user_location.UserLocationLayer
    public native void setObjectListener(@Nullable UserLocationObjectListener userLocationObjectListener);

    @Override // com.yandex.mapkit.user_location.UserLocationLayer
    public native void setSource(@Nullable LocationViewSource locationViewSource);

    @Override // com.yandex.mapkit.user_location.UserLocationLayer
    public native void setTapListener(@Nullable UserLocationTapListener userLocationTapListener);

    @Override // com.yandex.mapkit.user_location.UserLocationLayer
    public native void setVisible(boolean z);
}
