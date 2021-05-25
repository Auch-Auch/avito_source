package com.avito.android.payment.di.module;

import com.avito.android.payment.top_up.form.TopUpFormItemConverter;
import com.avito.android.payment.top_up.form.TopUpFormResourceProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class TopUpFormModule_ProvideTopUpFormItemConverterFactory implements Factory<TopUpFormItemConverter> {
    public final TopUpFormModule a;
    public final Provider<TopUpFormResourceProvider> b;

    public TopUpFormModule_ProvideTopUpFormItemConverterFactory(TopUpFormModule topUpFormModule, Provider<TopUpFormResourceProvider> provider) {
        this.a = topUpFormModule;
        this.b = provider;
    }

    public static TopUpFormModule_ProvideTopUpFormItemConverterFactory create(TopUpFormModule topUpFormModule, Provider<TopUpFormResourceProvider> provider) {
        return new TopUpFormModule_ProvideTopUpFormItemConverterFactory(topUpFormModule, provider);
    }

    public static TopUpFormItemConverter provideTopUpFormItemConverter(TopUpFormModule topUpFormModule, TopUpFormResourceProvider topUpFormResourceProvider) {
        return (TopUpFormItemConverter) Preconditions.checkNotNullFromProvides(topUpFormModule.provideTopUpFormItemConverter(topUpFormResourceProvider));
    }

    @Override // javax.inject.Provider
    public TopUpFormItemConverter get() {
        return provideTopUpFormItemConverter(this.a, this.b.get());
    }
}
