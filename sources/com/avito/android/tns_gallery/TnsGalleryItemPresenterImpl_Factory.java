package com.avito.android.tns_gallery;

import dagger.internal.Factory;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
public final class TnsGalleryItemPresenterImpl_Factory implements Factory<TnsGalleryItemPresenterImpl> {
    public final Provider<Consumer<TnsGalleryItemClickAction>> a;
    public final Provider<TnsGalleryItemSizeHelper> b;

    public TnsGalleryItemPresenterImpl_Factory(Provider<Consumer<TnsGalleryItemClickAction>> provider, Provider<TnsGalleryItemSizeHelper> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static TnsGalleryItemPresenterImpl_Factory create(Provider<Consumer<TnsGalleryItemClickAction>> provider, Provider<TnsGalleryItemSizeHelper> provider2) {
        return new TnsGalleryItemPresenterImpl_Factory(provider, provider2);
    }

    public static TnsGalleryItemPresenterImpl newInstance(Consumer<TnsGalleryItemClickAction> consumer, TnsGalleryItemSizeHelper tnsGalleryItemSizeHelper) {
        return new TnsGalleryItemPresenterImpl(consumer, tnsGalleryItemSizeHelper);
    }

    @Override // javax.inject.Provider
    public TnsGalleryItemPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
