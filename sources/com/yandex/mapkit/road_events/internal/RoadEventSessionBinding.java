package com.yandex.mapkit.road_events.internal;

import androidx.annotation.NonNull;
import com.yandex.mapkit.road_events.RoadEventSession;
import com.yandex.runtime.NativeObject;
public class RoadEventSessionBinding implements RoadEventSession {
    private final NativeObject nativeObject;

    public RoadEventSessionBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    @Override // com.yandex.mapkit.road_events.RoadEventSession
    public native void cancel();

    @Override // com.yandex.mapkit.road_events.RoadEventSession
    public native void retry(@NonNull RoadEventSession.RoadEventListener roadEventListener);
}
