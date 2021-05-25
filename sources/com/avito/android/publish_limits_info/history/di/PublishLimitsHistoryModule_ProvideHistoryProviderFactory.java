package com.avito.android.publish_limits_info.history.di;

import com.avito.android.publish_limits_info.history.PublishLimitsHistoryViewModel;
import com.avito.android.publish_limits_info.history.tab.PublishAdvertsHistoryProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishLimitsHistoryModule_ProvideHistoryProviderFactory implements Factory<PublishAdvertsHistoryProvider> {
    public final Provider<PublishLimitsHistoryViewModel> a;

    public PublishLimitsHistoryModule_ProvideHistoryProviderFactory(Provider<PublishLimitsHistoryViewModel> provider) {
        this.a = provider;
    }

    public static PublishLimitsHistoryModule_ProvideHistoryProviderFactory create(Provider<PublishLimitsHistoryViewModel> provider) {
        return new PublishLimitsHistoryModule_ProvideHistoryProviderFactory(provider);
    }

    public static PublishAdvertsHistoryProvider provideHistoryProvider(PublishLimitsHistoryViewModel publishLimitsHistoryViewModel) {
        return (PublishAdvertsHistoryProvider) Preconditions.checkNotNullFromProvides(PublishLimitsHistoryModule.INSTANCE.provideHistoryProvider(publishLimitsHistoryViewModel));
    }

    @Override // javax.inject.Provider
    public PublishAdvertsHistoryProvider get() {
        return provideHistoryProvider(this.a.get());
    }
}
