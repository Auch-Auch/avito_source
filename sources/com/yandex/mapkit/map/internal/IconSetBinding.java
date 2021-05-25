package com.yandex.mapkit.map.internal;

import androidx.annotation.NonNull;
import com.yandex.mapkit.map.IconSet;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.image.AnimatedImageProvider;
import com.yandex.runtime.image.ImageProvider;
public class IconSetBinding implements IconSet {
    private final NativeObject nativeObject;

    public IconSetBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    @Override // com.yandex.mapkit.map.IconSet
    public native void add(@NonNull AnimatedImageProvider animatedImageProvider);

    @Override // com.yandex.mapkit.map.IconSet
    public native void add(@NonNull ImageProvider imageProvider);

    @Override // com.yandex.mapkit.map.IconSet
    public native void add(@NonNull String str, @NonNull AnimatedImageProvider animatedImageProvider);

    @Override // com.yandex.mapkit.map.IconSet
    public native void add(@NonNull String str, @NonNull ImageProvider imageProvider);

    @Override // com.yandex.mapkit.map.IconSet
    public native boolean isValid();
}
