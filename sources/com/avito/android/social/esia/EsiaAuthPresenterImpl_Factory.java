package com.avito.android.social.esia;

import com.avito.android.Features;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class EsiaAuthPresenterImpl_Factory implements Factory<EsiaAuthPresenterImpl> {
    public final Provider<Features> a;

    public EsiaAuthPresenterImpl_Factory(Provider<Features> provider) {
        this.a = provider;
    }

    public static EsiaAuthPresenterImpl_Factory create(Provider<Features> provider) {
        return new EsiaAuthPresenterImpl_Factory(provider);
    }

    public static EsiaAuthPresenterImpl newInstance(Features features) {
        return new EsiaAuthPresenterImpl(features);
    }

    @Override // javax.inject.Provider
    public EsiaAuthPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
