package com.avito.android.messenger.analytics.graphite_counter;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ChatListAppendCounter_Factory implements Factory<ChatListAppendCounter> {
    public final Provider<Analytics> a;
    public final Provider<Features> b;

    public ChatListAppendCounter_Factory(Provider<Analytics> provider, Provider<Features> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ChatListAppendCounter_Factory create(Provider<Analytics> provider, Provider<Features> provider2) {
        return new ChatListAppendCounter_Factory(provider, provider2);
    }

    public static ChatListAppendCounter newInstance(Analytics analytics, Features features) {
        return new ChatListAppendCounter(analytics, features);
    }

    @Override // javax.inject.Provider
    public ChatListAppendCounter get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
