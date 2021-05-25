package com.avito.android.analytics.provider.pixel;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class PixelEventObserver_Factory implements Factory<PixelEventObserver> {
    public final Provider<PixelEventTracker> a;

    public PixelEventObserver_Factory(Provider<PixelEventTracker> provider) {
        this.a = provider;
    }

    public static PixelEventObserver_Factory create(Provider<PixelEventTracker> provider) {
        return new PixelEventObserver_Factory(provider);
    }

    public static PixelEventObserver newInstance(PixelEventTracker pixelEventTracker) {
        return new PixelEventObserver(pixelEventTracker);
    }

    @Override // javax.inject.Provider
    public PixelEventObserver get() {
        return newInstance(this.a.get());
    }
}
