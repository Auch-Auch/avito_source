package com.avito.android.abuse.details.di;

import com.avito.android.abuse.details.remote.AbuseApi;
import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AbuseApiModule_ProvideAbuseApiModuleFactory implements Factory<AbuseApi> {
    public final Provider<RetrofitFactory> a;

    public AbuseApiModule_ProvideAbuseApiModuleFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static AbuseApiModule_ProvideAbuseApiModuleFactory create(Provider<RetrofitFactory> provider) {
        return new AbuseApiModule_ProvideAbuseApiModuleFactory(provider);
    }

    public static AbuseApi provideAbuseApiModule(RetrofitFactory retrofitFactory) {
        return (AbuseApi) Preconditions.checkNotNullFromProvides(AbuseApiModule.INSTANCE.provideAbuseApiModule(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public AbuseApi get() {
        return provideAbuseApiModule(this.a.get());
    }
}
