package com.avito.android.analytics.statsd;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SendStatsdEventsTaskDelegateImpl_Factory implements Factory<SendStatsdEventsTaskDelegateImpl> {
    public final Provider<StatsdSender> a;

    public SendStatsdEventsTaskDelegateImpl_Factory(Provider<StatsdSender> provider) {
        this.a = provider;
    }

    public static SendStatsdEventsTaskDelegateImpl_Factory create(Provider<StatsdSender> provider) {
        return new SendStatsdEventsTaskDelegateImpl_Factory(provider);
    }

    public static SendStatsdEventsTaskDelegateImpl newInstance(StatsdSender statsdSender) {
        return new SendStatsdEventsTaskDelegateImpl(statsdSender);
    }

    @Override // javax.inject.Provider
    public SendStatsdEventsTaskDelegateImpl get() {
        return newInstance(this.a.get());
    }
}
