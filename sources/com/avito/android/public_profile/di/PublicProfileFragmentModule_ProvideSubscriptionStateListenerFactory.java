package com.avito.android.public_profile.di;

import com.avito.android.public_profile.ui.SubscriptionStateListener;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class PublicProfileFragmentModule_ProvideSubscriptionStateListenerFactory implements Factory<SubscriptionStateListener> {

    public static final class a {
        public static final PublicProfileFragmentModule_ProvideSubscriptionStateListenerFactory a = new PublicProfileFragmentModule_ProvideSubscriptionStateListenerFactory();
    }

    public static PublicProfileFragmentModule_ProvideSubscriptionStateListenerFactory create() {
        return a.a;
    }

    public static SubscriptionStateListener provideSubscriptionStateListener() {
        return (SubscriptionStateListener) Preconditions.checkNotNullFromProvides(PublicProfileFragmentModule.provideSubscriptionStateListener());
    }

    @Override // javax.inject.Provider
    public SubscriptionStateListener get() {
        return provideSubscriptionStateListener();
    }
}
