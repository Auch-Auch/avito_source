package com.yandex.runtime.init.tests;

import com.yandex.runtime.Error;
import com.yandex.runtime.init.MiidListener;
public class MiidListenerTestImpl implements MiidListener {
    private long nativePromise;

    public MiidListenerTestImpl(long j) {
        this.nativePromise = j;
    }

    private static native void setPromiseValueNative(long j, String str);

    @Override // com.yandex.runtime.init.MiidListener
    public void onMiidError(Error error) {
    }

    @Override // com.yandex.runtime.init.MiidListener
    public void onMiidReceived(String str) {
        setPromiseValueNative(this.nativePromise, str);
    }
}
