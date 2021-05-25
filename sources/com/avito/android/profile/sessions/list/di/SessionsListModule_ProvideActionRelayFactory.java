package com.avito.android.profile.sessions.list.di;

import com.avito.android.profile.sessions.adapter.action.SessionsItemAction;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class SessionsListModule_ProvideActionRelayFactory implements Factory<PublishRelay<SessionsItemAction>> {

    public static final class a {
        public static final SessionsListModule_ProvideActionRelayFactory a = new SessionsListModule_ProvideActionRelayFactory();
    }

    public static SessionsListModule_ProvideActionRelayFactory create() {
        return a.a;
    }

    public static PublishRelay<SessionsItemAction> provideActionRelay() {
        return (PublishRelay) Preconditions.checkNotNullFromProvides(SessionsListModule.INSTANCE.provideActionRelay());
    }

    @Override // javax.inject.Provider
    public PublishRelay<SessionsItemAction> get() {
        return provideActionRelay();
    }
}
