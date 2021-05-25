package com.avito.android.util.shared_image_files_storage;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MediaStoreSharedPhotosStorage_Factory implements Factory<MediaStoreSharedPhotosStorage> {
    public final Provider<Context> a;

    public MediaStoreSharedPhotosStorage_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static MediaStoreSharedPhotosStorage_Factory create(Provider<Context> provider) {
        return new MediaStoreSharedPhotosStorage_Factory(provider);
    }

    public static MediaStoreSharedPhotosStorage newInstance(Context context) {
        return new MediaStoreSharedPhotosStorage(context);
    }

    @Override // javax.inject.Provider
    public MediaStoreSharedPhotosStorage get() {
        return newInstance(this.a.get());
    }
}
