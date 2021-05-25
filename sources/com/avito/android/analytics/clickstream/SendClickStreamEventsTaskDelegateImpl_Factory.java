package com.avito.android.analytics.clickstream;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SendClickStreamEventsTaskDelegateImpl_Factory implements Factory<SendClickStreamEventsTaskDelegateImpl> {
    public final Provider<ClickStreamSender> a;

    public SendClickStreamEventsTaskDelegateImpl_Factory(Provider<ClickStreamSender> provider) {
        this.a = provider;
    }

    public static SendClickStreamEventsTaskDelegateImpl_Factory create(Provider<ClickStreamSender> provider) {
        return new SendClickStreamEventsTaskDelegateImpl_Factory(provider);
    }

    public static SendClickStreamEventsTaskDelegateImpl newInstance(ClickStreamSender clickStreamSender) {
        return new SendClickStreamEventsTaskDelegateImpl(clickStreamSender);
    }

    @Override // javax.inject.Provider
    public SendClickStreamEventsTaskDelegateImpl get() {
        return newInstance(this.a.get());
    }
}
