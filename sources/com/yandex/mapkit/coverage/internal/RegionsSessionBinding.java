package com.yandex.mapkit.coverage.internal;

import androidx.annotation.NonNull;
import com.yandex.mapkit.coverage.RegionsSession;
import com.yandex.runtime.NativeObject;
public class RegionsSessionBinding implements RegionsSession {
    private final NativeObject nativeObject;

    public RegionsSessionBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    @Override // com.yandex.mapkit.coverage.RegionsSession
    public native void cancel();

    @Override // com.yandex.mapkit.coverage.RegionsSession
    public native void retry(@NonNull RegionsSession.RegionsListener regionsListener);
}
