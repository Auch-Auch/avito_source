package com.avito.android.di.module;

import com.avito.android.db.SearchSubscriptionDao;
import com.avito.android.messenger.UnreadMessagesCounterObservable;
import com.avito.android.preferences.MessengerStorage;
import com.avito.android.preferences.UserAdvertsInfoStorage;
import com.avito.android.remote.notification.UnreadNotificationsInteractor;
import com.avito.android.search.subscriptions.SearchSubscriptionObservable;
import com.avito.android.user_advert.UserAdvertsInfoCache;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UnreadNotificationsModule_ProvideNotificationsInteractorFactory implements Factory<UnreadNotificationsInteractor> {
    public final Provider<SearchSubscriptionObservable> a;
    public final Provider<UnreadMessagesCounterObservable> b;
    public final Provider<UserAdvertsInfoCache> c;
    public final Provider<SearchSubscriptionDao> d;
    public final Provider<MessengerStorage> e;
    public final Provider<UserAdvertsInfoStorage> f;
    public final Provider<SchedulersFactory3> g;

    public UnreadNotificationsModule_ProvideNotificationsInteractorFactory(Provider<SearchSubscriptionObservable> provider, Provider<UnreadMessagesCounterObservable> provider2, Provider<UserAdvertsInfoCache> provider3, Provider<SearchSubscriptionDao> provider4, Provider<MessengerStorage> provider5, Provider<UserAdvertsInfoStorage> provider6, Provider<SchedulersFactory3> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static UnreadNotificationsModule_ProvideNotificationsInteractorFactory create(Provider<SearchSubscriptionObservable> provider, Provider<UnreadMessagesCounterObservable> provider2, Provider<UserAdvertsInfoCache> provider3, Provider<SearchSubscriptionDao> provider4, Provider<MessengerStorage> provider5, Provider<UserAdvertsInfoStorage> provider6, Provider<SchedulersFactory3> provider7) {
        return new UnreadNotificationsModule_ProvideNotificationsInteractorFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static UnreadNotificationsInteractor provideNotificationsInteractor(SearchSubscriptionObservable searchSubscriptionObservable, UnreadMessagesCounterObservable unreadMessagesCounterObservable, UserAdvertsInfoCache userAdvertsInfoCache, SearchSubscriptionDao searchSubscriptionDao, MessengerStorage messengerStorage, UserAdvertsInfoStorage userAdvertsInfoStorage, SchedulersFactory3 schedulersFactory3) {
        return (UnreadNotificationsInteractor) Preconditions.checkNotNullFromProvides(UnreadNotificationsModule.provideNotificationsInteractor(searchSubscriptionObservable, unreadMessagesCounterObservable, userAdvertsInfoCache, searchSubscriptionDao, messengerStorage, userAdvertsInfoStorage, schedulersFactory3));
    }

    @Override // javax.inject.Provider
    public UnreadNotificationsInteractor get() {
        return provideNotificationsInteractor(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
