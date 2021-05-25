package com.avito.android.tns_gallery;

import android.app.Activity;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class TnsGalleryItemSizeHelperImpl_Factory implements Factory<TnsGalleryItemSizeHelperImpl> {
    public final Provider<Activity> a;
    public final Provider<TnsGallerySettings> b;

    public TnsGalleryItemSizeHelperImpl_Factory(Provider<Activity> provider, Provider<TnsGallerySettings> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static TnsGalleryItemSizeHelperImpl_Factory create(Provider<Activity> provider, Provider<TnsGallerySettings> provider2) {
        return new TnsGalleryItemSizeHelperImpl_Factory(provider, provider2);
    }

    public static TnsGalleryItemSizeHelperImpl newInstance(Activity activity, TnsGallerySettings tnsGallerySettings) {
        return new TnsGalleryItemSizeHelperImpl(activity, tnsGallerySettings);
    }

    @Override // javax.inject.Provider
    public TnsGalleryItemSizeHelperImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
