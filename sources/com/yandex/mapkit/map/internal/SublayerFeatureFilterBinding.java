package com.yandex.mapkit.map.internal;

import androidx.annotation.NonNull;
import com.yandex.mapkit.map.SublayerFeatureFilter;
import com.yandex.mapkit.map.SublayerFeatureFilterType;
import com.yandex.runtime.NativeObject;
import java.util.List;
public class SublayerFeatureFilterBinding implements SublayerFeatureFilter {
    private final NativeObject nativeObject;

    public SublayerFeatureFilterBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    @Override // com.yandex.mapkit.map.SublayerFeatureFilter
    @NonNull
    public native List<String> getTags();

    @Override // com.yandex.mapkit.map.SublayerFeatureFilter
    @NonNull
    public native SublayerFeatureFilterType getType();

    @Override // com.yandex.mapkit.map.SublayerFeatureFilter
    public native boolean isValid();

    @Override // com.yandex.mapkit.map.SublayerFeatureFilter
    public native void setTags(@NonNull List<String> list);

    @Override // com.yandex.mapkit.map.SublayerFeatureFilter
    public native void setType(@NonNull SublayerFeatureFilterType sublayerFeatureFilterType);
}
