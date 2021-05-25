package com.avito.android.di;

import com.avito.android.calls.remote.CallsApi;
import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CallsApiModule_ProvideCallsApiFactory implements Factory<CallsApi> {
    public final Provider<RetrofitFactory> a;

    public CallsApiModule_ProvideCallsApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static CallsApiModule_ProvideCallsApiFactory create(Provider<RetrofitFactory> provider) {
        return new CallsApiModule_ProvideCallsApiFactory(provider);
    }

    public static CallsApi provideCallsApi(RetrofitFactory retrofitFactory) {
        return (CallsApi) Preconditions.checkNotNullFromProvides(CallsApiModule.INSTANCE.provideCallsApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public CallsApi get() {
        return provideCallsApi(this.a.get());
    }
}
