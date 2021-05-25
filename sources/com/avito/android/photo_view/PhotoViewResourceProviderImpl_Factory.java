package com.avito.android.photo_view;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PhotoViewResourceProviderImpl_Factory implements Factory<PhotoViewResourceProviderImpl> {
    public final Provider<Resources> a;

    public PhotoViewResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static PhotoViewResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new PhotoViewResourceProviderImpl_Factory(provider);
    }

    public static PhotoViewResourceProviderImpl newInstance(Resources resources) {
        return new PhotoViewResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public PhotoViewResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
