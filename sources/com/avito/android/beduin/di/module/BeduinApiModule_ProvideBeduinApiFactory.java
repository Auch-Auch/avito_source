package com.avito.android.beduin.di.module;

import com.avito.android.beduin.BeduinApi;
import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class BeduinApiModule_ProvideBeduinApiFactory implements Factory<BeduinApi> {
    public final Provider<RetrofitFactory> a;

    public BeduinApiModule_ProvideBeduinApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static BeduinApiModule_ProvideBeduinApiFactory create(Provider<RetrofitFactory> provider) {
        return new BeduinApiModule_ProvideBeduinApiFactory(provider);
    }

    public static BeduinApi provideBeduinApi(RetrofitFactory retrofitFactory) {
        return (BeduinApi) Preconditions.checkNotNullFromProvides(BeduinApiModule.INSTANCE.provideBeduinApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public BeduinApi get() {
        return provideBeduinApi(this.a.get());
    }
}
