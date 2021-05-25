package com.yandex.runtime.network.internal.internal;

import androidx.annotation.NonNull;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.network.internal.FileOperationsListener;
import com.yandex.runtime.network.internal.NetworkRecorder;
public class NetworkRecorderBinding implements NetworkRecorder {
    private final NativeObject nativeObject;

    public NetworkRecorderBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    @Override // com.yandex.runtime.network.internal.NetworkRecorder
    public native void dump(@NonNull String str, @NonNull FileOperationsListener fileOperationsListener);

    @Override // com.yandex.runtime.network.internal.NetworkRecorder
    public native boolean isValid();

    @Override // com.yandex.runtime.network.internal.NetworkRecorder
    public native void start();

    @Override // com.yandex.runtime.network.internal.NetworkRecorder
    public native void stop();
}
