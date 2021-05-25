package com.avito.android.analytics.provider.pixel;

import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PixelInteractorImpl_Factory implements Factory<PixelInteractorImpl> {
    public final Provider<PixelApi> a;
    public final Provider<SchedulersFactory> b;

    public PixelInteractorImpl_Factory(Provider<PixelApi> provider, Provider<SchedulersFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static PixelInteractorImpl_Factory create(Provider<PixelApi> provider, Provider<SchedulersFactory> provider2) {
        return new PixelInteractorImpl_Factory(provider, provider2);
    }

    public static PixelInteractorImpl newInstance(PixelApi pixelApi, SchedulersFactory schedulersFactory) {
        return new PixelInteractorImpl(pixelApi, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public PixelInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
