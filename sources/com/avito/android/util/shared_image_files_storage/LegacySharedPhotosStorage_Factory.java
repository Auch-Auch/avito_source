package com.avito.android.util.shared_image_files_storage;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class LegacySharedPhotosStorage_Factory implements Factory<LegacySharedPhotosStorage> {
    public final Provider<Context> a;

    public LegacySharedPhotosStorage_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static LegacySharedPhotosStorage_Factory create(Provider<Context> provider) {
        return new LegacySharedPhotosStorage_Factory(provider);
    }

    public static LegacySharedPhotosStorage newInstance(Context context) {
        return new LegacySharedPhotosStorage(context);
    }

    @Override // javax.inject.Provider
    public LegacySharedPhotosStorage get() {
        return newInstance(this.a.get());
    }
}
