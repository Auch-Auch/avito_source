package com.yandex.mapkit.road_events.internal;

import androidx.annotation.NonNull;
import com.yandex.mapkit.road_events.EventInfoSession;
import com.yandex.runtime.NativeObject;
public class EventInfoSessionBinding implements EventInfoSession {
    private final NativeObject nativeObject;

    public EventInfoSessionBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    @Override // com.yandex.mapkit.road_events.EventInfoSession
    public native void cancel();

    @Override // com.yandex.mapkit.road_events.EventInfoSession
    public native void retry(@NonNull EventInfoSession.EventInfoListener eventInfoListener);
}
