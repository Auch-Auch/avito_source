package com.avito.android.analytics.statsd;

import com.avito.android.StatsdToggles;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class StatsdCommonModule_ProvideStatsdEventValidatorFactory implements Factory<StatsdEventValidator> {
    public final Provider<StatsdToggles> a;

    public StatsdCommonModule_ProvideStatsdEventValidatorFactory(Provider<StatsdToggles> provider) {
        this.a = provider;
    }

    public static StatsdCommonModule_ProvideStatsdEventValidatorFactory create(Provider<StatsdToggles> provider) {
        return new StatsdCommonModule_ProvideStatsdEventValidatorFactory(provider);
    }

    public static StatsdEventValidator provideStatsdEventValidator(StatsdToggles statsdToggles) {
        return (StatsdEventValidator) Preconditions.checkNotNullFromProvides(StatsdCommonModule.provideStatsdEventValidator(statsdToggles));
    }

    @Override // javax.inject.Provider
    public StatsdEventValidator get() {
        return provideStatsdEventValidator(this.a.get());
    }
}
