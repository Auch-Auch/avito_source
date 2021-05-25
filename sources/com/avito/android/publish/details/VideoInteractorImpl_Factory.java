package com.avito.android.publish.details;

import com.avito.android.remote.PublishApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class VideoInteractorImpl_Factory implements Factory<VideoInteractorImpl> {
    public final Provider<PublishApi> a;
    public final Provider<SchedulersFactory> b;

    public VideoInteractorImpl_Factory(Provider<PublishApi> provider, Provider<SchedulersFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static VideoInteractorImpl_Factory create(Provider<PublishApi> provider, Provider<SchedulersFactory> provider2) {
        return new VideoInteractorImpl_Factory(provider, provider2);
    }

    public static VideoInteractorImpl newInstance(PublishApi publishApi, SchedulersFactory schedulersFactory) {
        return new VideoInteractorImpl(publishApi, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public VideoInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
