package com.avito.android.messenger.analytics.graphite_counter;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ChatAppendCounter_Factory implements Factory<ChatAppendCounter> {
    public final Provider<Analytics> a;
    public final Provider<Features> b;

    public ChatAppendCounter_Factory(Provider<Analytics> provider, Provider<Features> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ChatAppendCounter_Factory create(Provider<Analytics> provider, Provider<Features> provider2) {
        return new ChatAppendCounter_Factory(provider, provider2);
    }

    public static ChatAppendCounter newInstance(Analytics analytics, Features features) {
        return new ChatAppendCounter(analytics, features);
    }

    @Override // javax.inject.Provider
    public ChatAppendCounter get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
