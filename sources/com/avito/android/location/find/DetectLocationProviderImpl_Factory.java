package com.avito.android.location.find;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class DetectLocationProviderImpl_Factory implements Factory<DetectLocationProviderImpl> {
    public final Provider<DetectLocationInteractor> a;

    public DetectLocationProviderImpl_Factory(Provider<DetectLocationInteractor> provider) {
        this.a = provider;
    }

    public static DetectLocationProviderImpl_Factory create(Provider<DetectLocationInteractor> provider) {
        return new DetectLocationProviderImpl_Factory(provider);
    }

    public static DetectLocationProviderImpl newInstance(DetectLocationInteractor detectLocationInteractor) {
        return new DetectLocationProviderImpl(detectLocationInteractor);
    }

    @Override // javax.inject.Provider
    public DetectLocationProviderImpl get() {
        return newInstance(this.a.get());
    }
}
