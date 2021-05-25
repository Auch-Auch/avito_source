package com.yandex.mapkit.map.internal;

import androidx.annotation.NonNull;
import com.yandex.mapkit.map.Callback;
import com.yandex.mapkit.map.CompositeIcon;
import com.yandex.mapkit.map.IconStyle;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.image.ImageProvider;
public class CompositeIconBinding implements CompositeIcon {
    private final NativeObject nativeObject;

    public CompositeIconBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    @Override // com.yandex.mapkit.map.CompositeIcon
    public native boolean isValid();

    @Override // com.yandex.mapkit.map.CompositeIcon
    public native void removeAll();

    @Override // com.yandex.mapkit.map.CompositeIcon
    public native void removeIcon(@NonNull String str);

    @Override // com.yandex.mapkit.map.CompositeIcon
    public native void setIcon(@NonNull String str, @NonNull ImageProvider imageProvider, @NonNull IconStyle iconStyle);

    @Override // com.yandex.mapkit.map.CompositeIcon
    public native void setIcon(@NonNull String str, @NonNull ImageProvider imageProvider, @NonNull IconStyle iconStyle, @NonNull Callback callback);

    @Override // com.yandex.mapkit.map.CompositeIcon
    public native void setIconStyle(@NonNull String str, @NonNull IconStyle iconStyle);
}
