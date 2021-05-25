package com.avito.android.analytics.provider.pixel;

import com.avito.android.util.RandomizationGenerator;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PixelEventTrackerImpl_Factory implements Factory<PixelEventTrackerImpl> {
    public final Provider<PixelParameterEncoder> a;
    public final Provider<PixelParameterFormatter> b;
    public final Provider<String> c;
    public final Provider<RandomizationGenerator> d;
    public final Provider<PixelInteractor> e;

    public PixelEventTrackerImpl_Factory(Provider<PixelParameterEncoder> provider, Provider<PixelParameterFormatter> provider2, Provider<String> provider3, Provider<RandomizationGenerator> provider4, Provider<PixelInteractor> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static PixelEventTrackerImpl_Factory create(Provider<PixelParameterEncoder> provider, Provider<PixelParameterFormatter> provider2, Provider<String> provider3, Provider<RandomizationGenerator> provider4, Provider<PixelInteractor> provider5) {
        return new PixelEventTrackerImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static PixelEventTrackerImpl newInstance(PixelParameterEncoder pixelParameterEncoder, PixelParameterFormatter pixelParameterFormatter, String str, RandomizationGenerator randomizationGenerator, PixelInteractor pixelInteractor) {
        return new PixelEventTrackerImpl(pixelParameterEncoder, pixelParameterFormatter, str, randomizationGenerator, pixelInteractor);
    }

    @Override // javax.inject.Provider
    public PixelEventTrackerImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
