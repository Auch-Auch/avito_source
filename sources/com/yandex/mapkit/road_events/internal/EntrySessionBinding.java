package com.yandex.mapkit.road_events.internal;

import androidx.annotation.NonNull;
import com.yandex.mapkit.road_events.EntrySession;
import com.yandex.runtime.NativeObject;
public class EntrySessionBinding implements EntrySession {
    private final NativeObject nativeObject;

    public EntrySessionBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    @Override // com.yandex.mapkit.road_events.EntrySession
    public native void cancel();

    @Override // com.yandex.mapkit.road_events.EntrySession
    public native void retry(@NonNull EntrySession.EntryListener entryListener);
}
