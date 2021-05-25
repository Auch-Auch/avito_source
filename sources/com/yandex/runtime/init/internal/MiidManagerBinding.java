package com.yandex.runtime.init.internal;

import androidx.annotation.NonNull;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.init.MiidListener;
import com.yandex.runtime.init.MiidManager;
public class MiidManagerBinding implements MiidManager {
    private final NativeObject nativeObject;

    public MiidManagerBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    @Override // com.yandex.runtime.init.MiidManager
    public native boolean isValid();

    @Override // com.yandex.runtime.init.MiidManager
    public native void submit(@NonNull MiidListener miidListener);
}
