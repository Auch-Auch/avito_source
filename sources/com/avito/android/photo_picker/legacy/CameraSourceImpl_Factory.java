package com.avito.android.photo_picker.legacy;

import dagger.internal.Factory;
public final class CameraSourceImpl_Factory implements Factory<CameraSourceImpl> {

    public static final class a {
        public static final CameraSourceImpl_Factory a = new CameraSourceImpl_Factory();
    }

    public static CameraSourceImpl_Factory create() {
        return a.a;
    }

    public static CameraSourceImpl newInstance() {
        return new CameraSourceImpl();
    }

    @Override // javax.inject.Provider
    public CameraSourceImpl get() {
        return newInstance();
    }
}
