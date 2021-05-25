package com.avito.android.payment.di.module;

import com.avito.android.payment.top_up.form.TopUpFormResourceProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class TopUpFormModule_ProvideTopUpFormResourceProviderFactory implements Factory<TopUpFormResourceProvider> {
    public final TopUpFormModule a;

    public TopUpFormModule_ProvideTopUpFormResourceProviderFactory(TopUpFormModule topUpFormModule) {
        this.a = topUpFormModule;
    }

    public static TopUpFormModule_ProvideTopUpFormResourceProviderFactory create(TopUpFormModule topUpFormModule) {
        return new TopUpFormModule_ProvideTopUpFormResourceProviderFactory(topUpFormModule);
    }

    public static TopUpFormResourceProvider provideTopUpFormResourceProvider(TopUpFormModule topUpFormModule) {
        return (TopUpFormResourceProvider) Preconditions.checkNotNullFromProvides(topUpFormModule.provideTopUpFormResourceProvider());
    }

    @Override // javax.inject.Provider
    public TopUpFormResourceProvider get() {
        return provideTopUpFormResourceProvider(this.a);
    }
}
