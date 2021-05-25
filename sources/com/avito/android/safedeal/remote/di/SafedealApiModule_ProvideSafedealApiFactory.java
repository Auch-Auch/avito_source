package com.avito.android.safedeal.remote.di;

import com.avito.android.remote.RetrofitFactory;
import com.avito.android.safedeal.remote.SafeDealApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SafedealApiModule_ProvideSafedealApiFactory implements Factory<SafeDealApi> {
    public final Provider<RetrofitFactory> a;

    public SafedealApiModule_ProvideSafedealApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static SafedealApiModule_ProvideSafedealApiFactory create(Provider<RetrofitFactory> provider) {
        return new SafedealApiModule_ProvideSafedealApiFactory(provider);
    }

    public static SafeDealApi provideSafedealApi(RetrofitFactory retrofitFactory) {
        return (SafeDealApi) Preconditions.checkNotNullFromProvides(SafedealApiModule.INSTANCE.provideSafedealApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public SafeDealApi get() {
        return provideSafedealApi(this.a.get());
    }
}
