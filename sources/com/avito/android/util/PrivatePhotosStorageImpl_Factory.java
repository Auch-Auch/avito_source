package com.avito.android.util;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PrivatePhotosStorageImpl_Factory implements Factory<PrivatePhotosStorageImpl> {
    public final Provider<Context> a;

    public PrivatePhotosStorageImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static PrivatePhotosStorageImpl_Factory create(Provider<Context> provider) {
        return new PrivatePhotosStorageImpl_Factory(provider);
    }

    public static PrivatePhotosStorageImpl newInstance(Context context) {
        return new PrivatePhotosStorageImpl(context);
    }

    @Override // javax.inject.Provider
    public PrivatePhotosStorageImpl get() {
        return newInstance(this.a.get());
    }
}
