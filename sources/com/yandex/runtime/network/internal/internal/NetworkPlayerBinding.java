package com.yandex.runtime.network.internal.internal;

import androidx.annotation.NonNull;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.network.internal.FileOperationsListener;
import com.yandex.runtime.network.internal.NetworkPlayer;
public class NetworkPlayerBinding implements NetworkPlayer {
    private final NativeObject nativeObject;

    public NetworkPlayerBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    @Override // com.yandex.runtime.network.internal.NetworkPlayer
    public native boolean isValid();

    @Override // com.yandex.runtime.network.internal.NetworkPlayer
    public native void play(@NonNull String str, @NonNull FileOperationsListener fileOperationsListener);

    @Override // com.yandex.runtime.network.internal.NetworkPlayer
    public native void stop();
}
