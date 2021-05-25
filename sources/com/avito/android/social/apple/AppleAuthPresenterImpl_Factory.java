package com.avito.android.social.apple;

import com.avito.android.Features;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AppleAuthPresenterImpl_Factory implements Factory<AppleAuthPresenterImpl> {
    public final Provider<Features> a;

    public AppleAuthPresenterImpl_Factory(Provider<Features> provider) {
        this.a = provider;
    }

    public static AppleAuthPresenterImpl_Factory create(Provider<Features> provider) {
        return new AppleAuthPresenterImpl_Factory(provider);
    }

    public static AppleAuthPresenterImpl newInstance(Features features) {
        return new AppleAuthPresenterImpl(features);
    }

    @Override // javax.inject.Provider
    public AppleAuthPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
