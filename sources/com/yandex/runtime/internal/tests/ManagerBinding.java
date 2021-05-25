package com.yandex.runtime.internal.tests;

import com.yandex.runtime.NativeObject;
public class ManagerBinding implements Manager {
    private NativeObject nativeObject;

    public ManagerBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    @Override // com.yandex.runtime.internal.tests.Manager
    public native void doSmth();
}
