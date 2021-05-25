package com.avito.android.messenger.di;

import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.analytics.MessengerErrorTracker;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessengerModule_ProvideMessengerErrorTracker$messenger_releaseFactory implements Factory<MessengerErrorTracker> {
    public final MessengerModule a;
    public final Provider<Analytics> b;

    public MessengerModule_ProvideMessengerErrorTracker$messenger_releaseFactory(MessengerModule messengerModule, Provider<Analytics> provider) {
        this.a = messengerModule;
        this.b = provider;
    }

    public static MessengerModule_ProvideMessengerErrorTracker$messenger_releaseFactory create(MessengerModule messengerModule, Provider<Analytics> provider) {
        return new MessengerModule_ProvideMessengerErrorTracker$messenger_releaseFactory(messengerModule, provider);
    }

    public static MessengerErrorTracker provideMessengerErrorTracker$messenger_release(MessengerModule messengerModule, Analytics analytics) {
        return (MessengerErrorTracker) Preconditions.checkNotNullFromProvides(messengerModule.provideMessengerErrorTracker$messenger_release(analytics));
    }

    @Override // javax.inject.Provider
    public MessengerErrorTracker get() {
        return provideMessengerErrorTracker$messenger_release(this.a, this.b.get());
    }
}
