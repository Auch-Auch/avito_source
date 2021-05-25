package com.avito.android.location.find;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class FindDetectLocationPresenterImpl_Factory implements Factory<FindDetectLocationPresenterImpl> {
    public final Provider<DefaultLocationProvider> a;
    public final Provider<DetectLocationProvider> b;

    public FindDetectLocationPresenterImpl_Factory(Provider<DefaultLocationProvider> provider, Provider<DetectLocationProvider> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static FindDetectLocationPresenterImpl_Factory create(Provider<DefaultLocationProvider> provider, Provider<DetectLocationProvider> provider2) {
        return new FindDetectLocationPresenterImpl_Factory(provider, provider2);
    }

    public static FindDetectLocationPresenterImpl newInstance(DefaultLocationProvider defaultLocationProvider, DetectLocationProvider detectLocationProvider) {
        return new FindDetectLocationPresenterImpl(defaultLocationProvider, detectLocationProvider);
    }

    @Override // javax.inject.Provider
    public FindDetectLocationPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
