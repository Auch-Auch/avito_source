package com.avito.android.publish.details;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class VideoItemWrapper_Factory implements Factory<VideoItemWrapper> {
    public final Provider<VideoInteractor> a;
    public final Provider<PublishDetailsResourceProvider> b;

    public VideoItemWrapper_Factory(Provider<VideoInteractor> provider, Provider<PublishDetailsResourceProvider> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static VideoItemWrapper_Factory create(Provider<VideoInteractor> provider, Provider<PublishDetailsResourceProvider> provider2) {
        return new VideoItemWrapper_Factory(provider, provider2);
    }

    public static VideoItemWrapper newInstance(VideoInteractor videoInteractor, PublishDetailsResourceProvider publishDetailsResourceProvider) {
        return new VideoItemWrapper(videoInteractor, publishDetailsResourceProvider);
    }

    @Override // javax.inject.Provider
    public VideoItemWrapper get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
