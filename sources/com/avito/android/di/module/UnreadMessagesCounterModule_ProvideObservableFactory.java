package com.avito.android.di.module;

import com.avito.android.messenger.UnreadMessagesCounterObservable;
import com.avito.android.messenger.UnreadMessagesCounterRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UnreadMessagesCounterModule_ProvideObservableFactory implements Factory<UnreadMessagesCounterObservable> {
    public final Provider<UnreadMessagesCounterRelay> a;

    public UnreadMessagesCounterModule_ProvideObservableFactory(Provider<UnreadMessagesCounterRelay> provider) {
        this.a = provider;
    }

    public static UnreadMessagesCounterModule_ProvideObservableFactory create(Provider<UnreadMessagesCounterRelay> provider) {
        return new UnreadMessagesCounterModule_ProvideObservableFactory(provider);
    }

    public static UnreadMessagesCounterObservable provideObservable(UnreadMessagesCounterRelay unreadMessagesCounterRelay) {
        return (UnreadMessagesCounterObservable) Preconditions.checkNotNullFromProvides(UnreadMessagesCounterModule.provideObservable(unreadMessagesCounterRelay));
    }

    @Override // javax.inject.Provider
    public UnreadMessagesCounterObservable get() {
        return provideObservable(this.a.get());
    }
}
