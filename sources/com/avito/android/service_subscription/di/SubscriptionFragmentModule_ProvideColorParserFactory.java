package com.avito.android.service_subscription.di;

import android.content.Context;
import com.avito.android.service_subscription.subscription_new.ColorParser;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SubscriptionFragmentModule_ProvideColorParserFactory implements Factory<ColorParser> {
    public final Provider<Context> a;

    public SubscriptionFragmentModule_ProvideColorParserFactory(Provider<Context> provider) {
        this.a = provider;
    }

    public static SubscriptionFragmentModule_ProvideColorParserFactory create(Provider<Context> provider) {
        return new SubscriptionFragmentModule_ProvideColorParserFactory(provider);
    }

    public static ColorParser provideColorParser(Context context) {
        return (ColorParser) Preconditions.checkNotNullFromProvides(SubscriptionFragmentModule.provideColorParser(context));
    }

    @Override // javax.inject.Provider
    public ColorParser get() {
        return provideColorParser(this.a.get());
    }
}
