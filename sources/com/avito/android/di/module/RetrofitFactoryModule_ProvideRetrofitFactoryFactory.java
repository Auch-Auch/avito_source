package com.avito.android.di.module;

import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;
public final class RetrofitFactoryModule_ProvideRetrofitFactoryFactory implements Factory<RetrofitFactory> {
    public final RetrofitFactoryModule a;
    public final Provider<Retrofit> b;

    public RetrofitFactoryModule_ProvideRetrofitFactoryFactory(RetrofitFactoryModule retrofitFactoryModule, Provider<Retrofit> provider) {
        this.a = retrofitFactoryModule;
        this.b = provider;
    }

    public static RetrofitFactoryModule_ProvideRetrofitFactoryFactory create(RetrofitFactoryModule retrofitFactoryModule, Provider<Retrofit> provider) {
        return new RetrofitFactoryModule_ProvideRetrofitFactoryFactory(retrofitFactoryModule, provider);
    }

    public static RetrofitFactory provideRetrofitFactory(RetrofitFactoryModule retrofitFactoryModule, Retrofit retrofit) {
        return (RetrofitFactory) Preconditions.checkNotNullFromProvides(retrofitFactoryModule.provideRetrofitFactory(retrofit));
    }

    @Override // javax.inject.Provider
    public RetrofitFactory get() {
        return provideRetrofitFactory(this.a, this.b.get());
    }
}
