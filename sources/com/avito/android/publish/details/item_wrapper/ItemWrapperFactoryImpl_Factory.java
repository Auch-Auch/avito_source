package com.avito.android.publish.details.item_wrapper;

import com.avito.android.publish.details.PublishDetailsResourceProvider;
import com.avito.android.publish.details.VideoInteractor;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ItemWrapperFactoryImpl_Factory implements Factory<ItemWrapperFactoryImpl> {
    public final Provider<VideoInteractor> a;
    public final Provider<PublishDetailsResourceProvider> b;

    public ItemWrapperFactoryImpl_Factory(Provider<VideoInteractor> provider, Provider<PublishDetailsResourceProvider> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ItemWrapperFactoryImpl_Factory create(Provider<VideoInteractor> provider, Provider<PublishDetailsResourceProvider> provider2) {
        return new ItemWrapperFactoryImpl_Factory(provider, provider2);
    }

    public static ItemWrapperFactoryImpl newInstance(VideoInteractor videoInteractor, PublishDetailsResourceProvider publishDetailsResourceProvider) {
        return new ItemWrapperFactoryImpl(videoInteractor, publishDetailsResourceProvider);
    }

    @Override // javax.inject.Provider
    public ItemWrapperFactoryImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
