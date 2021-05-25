package com.yandex.mapkit.coverage.internal;

import androidx.annotation.NonNull;
import com.yandex.mapkit.coverage.IsCoveredSession;
import com.yandex.runtime.NativeObject;
public class IsCoveredSessionBinding implements IsCoveredSession {
    private final NativeObject nativeObject;

    public IsCoveredSessionBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    @Override // com.yandex.mapkit.coverage.IsCoveredSession
    public native void cancel();

    @Override // com.yandex.mapkit.coverage.IsCoveredSession
    public native void retry(@NonNull IsCoveredSession.IsCoveredListener isCoveredListener);
}
