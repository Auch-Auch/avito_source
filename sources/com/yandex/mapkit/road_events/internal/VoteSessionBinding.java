package com.yandex.mapkit.road_events.internal;

import androidx.annotation.NonNull;
import com.yandex.mapkit.road_events.VoteSession;
import com.yandex.runtime.NativeObject;
public class VoteSessionBinding implements VoteSession {
    private final NativeObject nativeObject;

    public VoteSessionBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    @Override // com.yandex.mapkit.road_events.VoteSession
    public native void cancel();

    @Override // com.yandex.mapkit.road_events.VoteSession
    public native void retry(@NonNull VoteSession.VoteListener voteListener);
}
