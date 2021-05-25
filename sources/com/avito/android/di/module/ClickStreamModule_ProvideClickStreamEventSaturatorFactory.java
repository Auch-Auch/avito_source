package com.avito.android.di.module;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.clickstream.ClickStreamEventTracker;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ClickStreamModule_ProvideClickStreamEventSaturatorFactory implements Factory<ClickStreamEventTracker.ClickStreamEventSaturator> {
    public final Provider<AccountStateProvider> a;

    public ClickStreamModule_ProvideClickStreamEventSaturatorFactory(Provider<AccountStateProvider> provider) {
        this.a = provider;
    }

    public static ClickStreamModule_ProvideClickStreamEventSaturatorFactory create(Provider<AccountStateProvider> provider) {
        return new ClickStreamModule_ProvideClickStreamEventSaturatorFactory(provider);
    }

    public static ClickStreamEventTracker.ClickStreamEventSaturator provideClickStreamEventSaturator(AccountStateProvider accountStateProvider) {
        return (ClickStreamEventTracker.ClickStreamEventSaturator) Preconditions.checkNotNullFromProvides(ClickStreamModule.provideClickStreamEventSaturator(accountStateProvider));
    }

    @Override // javax.inject.Provider
    public ClickStreamEventTracker.ClickStreamEventSaturator get() {
        return provideClickStreamEventSaturator(this.a.get());
    }
}
