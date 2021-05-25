package com.avito.android.remote.di;

import com.avito.android.remote.ExtendedProfileSettingsApi;
import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ExtendedProfileSettingsApiModule_ProvideExtendedProfileSettingsApiFactory implements Factory<ExtendedProfileSettingsApi> {
    public final Provider<RetrofitFactory> a;

    public ExtendedProfileSettingsApiModule_ProvideExtendedProfileSettingsApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static ExtendedProfileSettingsApiModule_ProvideExtendedProfileSettingsApiFactory create(Provider<RetrofitFactory> provider) {
        return new ExtendedProfileSettingsApiModule_ProvideExtendedProfileSettingsApiFactory(provider);
    }

    public static ExtendedProfileSettingsApi provideExtendedProfileSettingsApi(RetrofitFactory retrofitFactory) {
        return (ExtendedProfileSettingsApi) Preconditions.checkNotNullFromProvides(ExtendedProfileSettingsApiModule.INSTANCE.provideExtendedProfileSettingsApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public ExtendedProfileSettingsApi get() {
        return provideExtendedProfileSettingsApi(this.a.get());
    }
}
