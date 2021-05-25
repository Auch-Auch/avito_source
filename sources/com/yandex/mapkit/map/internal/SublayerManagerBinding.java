package com.yandex.mapkit.map.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yandex.mapkit.map.Sublayer;
import com.yandex.mapkit.map.SublayerFeatureType;
import com.yandex.mapkit.map.SublayerManager;
import com.yandex.runtime.NativeObject;
public class SublayerManagerBinding implements SublayerManager {
    private final NativeObject nativeObject;

    public SublayerManagerBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    @Override // com.yandex.mapkit.map.SublayerManager
    @NonNull
    public native Sublayer appendSublayer(@NonNull String str, @NonNull SublayerFeatureType sublayerFeatureType);

    @Override // com.yandex.mapkit.map.SublayerManager
    @Nullable
    public native Integer findFirstOf(@NonNull String str);

    @Override // com.yandex.mapkit.map.SublayerManager
    @Nullable
    public native Integer findFirstOf(@NonNull String str, @NonNull SublayerFeatureType sublayerFeatureType);

    @Override // com.yandex.mapkit.map.SublayerManager
    @Nullable
    public native Sublayer get(int i);

    @Override // com.yandex.mapkit.map.SublayerManager
    @NonNull
    public native Sublayer insertSublayerAfter(int i, @NonNull String str, @NonNull SublayerFeatureType sublayerFeatureType);

    @Override // com.yandex.mapkit.map.SublayerManager
    @NonNull
    public native Sublayer insertSublayerBefore(int i, @NonNull String str, @NonNull SublayerFeatureType sublayerFeatureType);

    @Override // com.yandex.mapkit.map.SublayerManager
    public native boolean isValid();

    @Override // com.yandex.mapkit.map.SublayerManager
    public native void moveAfter(int i, int i2);

    @Override // com.yandex.mapkit.map.SublayerManager
    public native void moveBefore(int i, int i2);

    @Override // com.yandex.mapkit.map.SublayerManager
    public native void moveToEnd(int i);

    @Override // com.yandex.mapkit.map.SublayerManager
    public native void remove(int i);

    @Override // com.yandex.mapkit.map.SublayerManager
    public native int size();
}
