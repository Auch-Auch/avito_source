package com.yandex.mapkit.road_events.internal;

import androidx.annotation.NonNull;
import com.yandex.mapkit.road_events.RoadEventFailedError;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.internal.ErrorBinding;
public class RoadEventFailedErrorBinding extends ErrorBinding implements RoadEventFailedError {
    public RoadEventFailedErrorBinding(NativeObject nativeObject) {
        super(nativeObject);
    }

    @Override // com.yandex.mapkit.road_events.RoadEventFailedError
    @NonNull
    public native RoadEventFailedError.Code getCode();

    @Override // com.yandex.mapkit.road_events.RoadEventFailedError
    @NonNull
    public native String getDescription();
}
