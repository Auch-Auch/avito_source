package com.yandex.mapkit.coverage;

import androidx.annotation.NonNull;
import com.yandex.mapkit.coverage.IsCoveredSession;
import com.yandex.mapkit.coverage.RegionsSession;
import com.yandex.mapkit.geometry.LinearRing;
import com.yandex.mapkit.geometry.Point;
public interface Coverage {
    @NonNull
    IsCoveredSession isCovered(@NonNull LinearRing linearRing, int i, @NonNull IsCoveredSession.IsCoveredListener isCoveredListener);

    @NonNull
    IsCoveredSession isCovered(@NonNull Point point, int i, @NonNull IsCoveredSession.IsCoveredListener isCoveredListener);

    @NonNull
    RegionsSession regions(@NonNull Point point, int i, @NonNull RegionsSession.RegionsListener regionsListener);

    void setActiveArea(@NonNull LinearRing linearRing, int i);
}
