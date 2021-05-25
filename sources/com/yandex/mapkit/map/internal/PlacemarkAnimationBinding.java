package com.yandex.mapkit.map.internal;

import androidx.annotation.NonNull;
import com.yandex.mapkit.map.Callback;
import com.yandex.mapkit.map.IconStyle;
import com.yandex.mapkit.map.ModelStyle;
import com.yandex.mapkit.map.PlacemarkAnimation;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.image.AnimatedImageProvider;
import com.yandex.runtime.model.AnimatedModelProvider;
public class PlacemarkAnimationBinding implements PlacemarkAnimation {
    private final NativeObject nativeObject;

    public PlacemarkAnimationBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    @Override // com.yandex.mapkit.map.PlacemarkAnimation
    public native boolean isReversed();

    @Override // com.yandex.mapkit.map.PlacemarkAnimation
    public native boolean isValid();

    @Override // com.yandex.mapkit.map.PlacemarkAnimation
    public native void pause();

    @Override // com.yandex.mapkit.map.PlacemarkAnimation
    public native void play();

    @Override // com.yandex.mapkit.map.PlacemarkAnimation
    public native void play(@NonNull Callback callback);

    @Override // com.yandex.mapkit.map.PlacemarkAnimation
    public native void resume();

    @Override // com.yandex.mapkit.map.PlacemarkAnimation
    public native void setIcon(@NonNull AnimatedImageProvider animatedImageProvider, @NonNull IconStyle iconStyle);

    @Override // com.yandex.mapkit.map.PlacemarkAnimation
    public native void setIcon(@NonNull AnimatedImageProvider animatedImageProvider, @NonNull IconStyle iconStyle, @NonNull Callback callback);

    @Override // com.yandex.mapkit.map.PlacemarkAnimation
    public native void setIconStyle(@NonNull IconStyle iconStyle);

    @Override // com.yandex.mapkit.map.PlacemarkAnimation
    public native void setModel(@NonNull AnimatedModelProvider animatedModelProvider, @NonNull ModelStyle modelStyle);

    @Override // com.yandex.mapkit.map.PlacemarkAnimation
    public native void setModel(@NonNull AnimatedModelProvider animatedModelProvider, @NonNull ModelStyle modelStyle, @NonNull Callback callback);

    @Override // com.yandex.mapkit.map.PlacemarkAnimation
    public native void setModelStyle(@NonNull ModelStyle modelStyle);

    @Override // com.yandex.mapkit.map.PlacemarkAnimation
    public native void setReversed(boolean z);

    @Override // com.yandex.mapkit.map.PlacemarkAnimation
    public native void stop();
}
