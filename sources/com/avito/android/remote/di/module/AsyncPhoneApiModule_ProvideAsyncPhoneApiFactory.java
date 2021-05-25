package com.avito.android.remote.di.module;

import com.avito.android.remote.AsyncPhoneApi;
import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AsyncPhoneApiModule_ProvideAsyncPhoneApiFactory implements Factory<AsyncPhoneApi> {
    public final Provider<RetrofitFactory> a;

    public AsyncPhoneApiModule_ProvideAsyncPhoneApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static AsyncPhoneApiModule_ProvideAsyncPhoneApiFactory create(Provider<RetrofitFactory> provider) {
        return new AsyncPhoneApiModule_ProvideAsyncPhoneApiFactory(provider);
    }

    public static AsyncPhoneApi provideAsyncPhoneApi(RetrofitFactory retrofitFactory) {
        return (AsyncPhoneApi) Preconditions.checkNotNullFromProvides(AsyncPhoneApiModule.INSTANCE.provideAsyncPhoneApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public AsyncPhoneApi get() {
        return provideAsyncPhoneApi(this.a.get());
    }
}
