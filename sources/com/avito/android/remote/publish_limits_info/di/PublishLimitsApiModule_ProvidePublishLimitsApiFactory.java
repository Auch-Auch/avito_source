package com.avito.android.remote.publish_limits_info.di;

import com.avito.android.remote.PublishLimitsApi;
import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishLimitsApiModule_ProvidePublishLimitsApiFactory implements Factory<PublishLimitsApi> {
    public final Provider<RetrofitFactory> a;

    public PublishLimitsApiModule_ProvidePublishLimitsApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static PublishLimitsApiModule_ProvidePublishLimitsApiFactory create(Provider<RetrofitFactory> provider) {
        return new PublishLimitsApiModule_ProvidePublishLimitsApiFactory(provider);
    }

    public static PublishLimitsApi providePublishLimitsApi(RetrofitFactory retrofitFactory) {
        return (PublishLimitsApi) Preconditions.checkNotNullFromProvides(PublishLimitsApiModule.INSTANCE.providePublishLimitsApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public PublishLimitsApi get() {
        return providePublishLimitsApi(this.a.get());
    }
}
