package com.avito.android.user_subscribers.di;

import com.avito.android.user_subscribers.action.SubscriberAction;
import com.jakewharton.rxrelay2.Relay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class UserSubscribersModule_ProvideRelayFactory implements Factory<Relay<SubscriberAction>> {

    public static final class a {
        public static final UserSubscribersModule_ProvideRelayFactory a = new UserSubscribersModule_ProvideRelayFactory();
    }

    public static UserSubscribersModule_ProvideRelayFactory create() {
        return a.a;
    }

    public static Relay<SubscriberAction> provideRelay() {
        return (Relay) Preconditions.checkNotNullFromProvides(UserSubscribersModule.provideRelay());
    }

    @Override // javax.inject.Provider
    public Relay<SubscriberAction> get() {
        return provideRelay();
    }
}
