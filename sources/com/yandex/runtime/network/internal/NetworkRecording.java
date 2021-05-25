package com.yandex.runtime.network.internal;

import androidx.annotation.Nullable;
public class NetworkRecording {
    @Nullable
    public static native NetworkPlayer createPlayer();

    @Nullable
    public static native NetworkRecorder createRecorder();
}
