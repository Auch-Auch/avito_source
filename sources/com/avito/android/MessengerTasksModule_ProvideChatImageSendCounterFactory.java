package com.avito.android;

import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.analytics.graphite_counter.MessengerGraphiteCounter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessengerTasksModule_ProvideChatImageSendCounterFactory implements Factory<MessengerGraphiteCounter> {
    public final Provider<Analytics> a;
    public final Provider<Features> b;

    public MessengerTasksModule_ProvideChatImageSendCounterFactory(Provider<Analytics> provider, Provider<Features> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MessengerTasksModule_ProvideChatImageSendCounterFactory create(Provider<Analytics> provider, Provider<Features> provider2) {
        return new MessengerTasksModule_ProvideChatImageSendCounterFactory(provider, provider2);
    }

    public static MessengerGraphiteCounter provideChatImageSendCounter(Analytics analytics, Features features) {
        return (MessengerGraphiteCounter) Preconditions.checkNotNullFromProvides(MessengerTasksModule.INSTANCE.provideChatImageSendCounter(analytics, features));
    }

    @Override // javax.inject.Provider
    public MessengerGraphiteCounter get() {
        return provideChatImageSendCounter(this.a.get(), this.b.get());
    }
}
