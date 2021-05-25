package com.yandex.mapkit.road_events.internal;

import androidx.annotation.NonNull;
import com.yandex.mapkit.road_events.FeedSession;
import com.yandex.runtime.NativeObject;
public class FeedSessionBinding implements FeedSession {
    private final NativeObject nativeObject;

    public FeedSessionBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    @Override // com.yandex.mapkit.road_events.FeedSession
    public native void cancel();

    @Override // com.yandex.mapkit.road_events.FeedSession
    public native void fetchNextPage(@NonNull FeedSession.FeedListener feedListener);

    @Override // com.yandex.mapkit.road_events.FeedSession
    public native boolean hasNextPage();
}
