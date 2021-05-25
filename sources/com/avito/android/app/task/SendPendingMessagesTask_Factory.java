package com.avito.android.app.task;

import com.avito.android.MessengerWorkFactory;
import com.avito.android.util.SchedulersFactory;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SendPendingMessagesTask_Factory implements Factory<SendPendingMessagesTask> {
    public final Provider<PendingMessageHandler> a;
    public final Provider<MessengerWorkFactory> b;
    public final Provider<SchedulersFactory> c;

    public SendPendingMessagesTask_Factory(Provider<PendingMessageHandler> provider, Provider<MessengerWorkFactory> provider2, Provider<SchedulersFactory> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static SendPendingMessagesTask_Factory create(Provider<PendingMessageHandler> provider, Provider<MessengerWorkFactory> provider2, Provider<SchedulersFactory> provider3) {
        return new SendPendingMessagesTask_Factory(provider, provider2, provider3);
    }

    public static SendPendingMessagesTask newInstance(Lazy<PendingMessageHandler> lazy, MessengerWorkFactory messengerWorkFactory, SchedulersFactory schedulersFactory) {
        return new SendPendingMessagesTask(lazy, messengerWorkFactory, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public SendPendingMessagesTask get() {
        return newInstance(DoubleCheck.lazy(this.a), this.b.get(), this.c.get());
    }
}
