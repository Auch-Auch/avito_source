package com.avito.android.domteka;

import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DomotekaApiModule_ProvideDomotekaApiFactory implements Factory<DomotekaApi> {
    public final Provider<RetrofitFactory> a;

    public DomotekaApiModule_ProvideDomotekaApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static DomotekaApiModule_ProvideDomotekaApiFactory create(Provider<RetrofitFactory> provider) {
        return new DomotekaApiModule_ProvideDomotekaApiFactory(provider);
    }

    public static DomotekaApi provideDomotekaApi(RetrofitFactory retrofitFactory) {
        return (DomotekaApi) Preconditions.checkNotNullFromProvides(DomotekaApiModule.INSTANCE.provideDomotekaApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public DomotekaApi get() {
        return provideDomotekaApi(this.a.get());
    }
}
