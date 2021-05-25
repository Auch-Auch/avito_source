package com.avito.android.analytics.statsd;

import com.avito.android.analytics.inhouse_transport.InHouseEventStorage;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class StatsdSenderImpl_Factory implements Factory<StatsdSenderImpl> {
    public final Provider<StatsdApi> a;
    public final Provider<InHouseEventStorage<StatsdRecord>> b;
    public final Provider<SchedulersFactory> c;

    public StatsdSenderImpl_Factory(Provider<StatsdApi> provider, Provider<InHouseEventStorage<StatsdRecord>> provider2, Provider<SchedulersFactory> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static StatsdSenderImpl_Factory create(Provider<StatsdApi> provider, Provider<InHouseEventStorage<StatsdRecord>> provider2, Provider<SchedulersFactory> provider3) {
        return new StatsdSenderImpl_Factory(provider, provider2, provider3);
    }

    public static StatsdSenderImpl newInstance(StatsdApi statsdApi, InHouseEventStorage<StatsdRecord> inHouseEventStorage, SchedulersFactory schedulersFactory) {
        return new StatsdSenderImpl(statsdApi, inHouseEventStorage, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public StatsdSenderImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
