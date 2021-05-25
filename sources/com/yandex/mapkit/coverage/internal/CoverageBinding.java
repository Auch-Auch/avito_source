package com.yandex.mapkit.coverage.internal;

import androidx.annotation.NonNull;
import com.yandex.mapkit.coverage.Coverage;
import com.yandex.mapkit.coverage.IsCoveredSession;
import com.yandex.mapkit.coverage.RegionsSession;
import com.yandex.mapkit.geometry.LinearRing;
import com.yandex.mapkit.geometry.Point;
import com.yandex.runtime.NativeObject;
public class CoverageBinding implements Coverage {
    private final NativeObject nativeObject;

    public CoverageBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    @Override // com.yandex.mapkit.coverage.Coverage
    @NonNull
    public native IsCoveredSession isCovered(@NonNull LinearRing linearRing, int i, @NonNull IsCoveredSession.IsCoveredListener isCoveredListener);

    @Override // com.yandex.mapkit.coverage.Coverage
    @NonNull
    public native IsCoveredSession isCovered(@NonNull Point point, int i, @NonNull IsCoveredSession.IsCoveredListener isCoveredListener);

    @Override // com.yandex.mapkit.coverage.Coverage
    @NonNull
    public native RegionsSession regions(@NonNull Point point, int i, @NonNull RegionsSession.RegionsListener regionsListener);

    @Override // com.yandex.mapkit.coverage.Coverage
    public native void setActiveArea(@NonNull LinearRing linearRing, int i);
}
