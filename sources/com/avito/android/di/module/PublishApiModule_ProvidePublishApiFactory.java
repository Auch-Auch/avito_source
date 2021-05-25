package com.avito.android.di.module;

import com.avito.android.remote.PublishApi;
import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishApiModule_ProvidePublishApiFactory implements Factory<PublishApi> {
    public final Provider<RetrofitFactory> a;

    public PublishApiModule_ProvidePublishApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static PublishApiModule_ProvidePublishApiFactory create(Provider<RetrofitFactory> provider) {
        return new PublishApiModule_ProvidePublishApiFactory(provider);
    }

    public static PublishApi providePublishApi(RetrofitFactory retrofitFactory) {
        return (PublishApi) Preconditions.checkNotNullFromProvides(PublishApiModule.INSTANCE.providePublishApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public PublishApi get() {
        return providePublishApi(this.a.get());
    }
}
