package com.yandex.mapkit.logo.internal;

import androidx.annotation.NonNull;
import com.yandex.mapkit.logo.Alignment;
import com.yandex.mapkit.logo.Logo;
import com.yandex.runtime.NativeObject;
public class LogoBinding implements Logo {
    private final NativeObject nativeObject;

    public LogoBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    @Override // com.yandex.mapkit.logo.Logo
    public native boolean isValid();

    @Override // com.yandex.mapkit.logo.Logo
    public native void setAlignment(@NonNull Alignment alignment);
}
