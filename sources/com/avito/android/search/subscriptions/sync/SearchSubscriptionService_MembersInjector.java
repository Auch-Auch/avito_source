package com.avito.android.search.subscriptions.sync;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class SearchSubscriptionService_MembersInjector implements MembersInjector<SearchSubscriptionService> {
    public final Provider<SearchSubscriptionSyncInteractor> a;

    public SearchSubscriptionService_MembersInjector(Provider<SearchSubscriptionSyncInteractor> provider) {
        this.a = provider;
    }

    public static MembersInjector<SearchSubscriptionService> create(Provider<SearchSubscriptionSyncInteractor> provider) {
        return new SearchSubscriptionService_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.search.subscriptions.sync.SearchSubscriptionService.interactor")
    public static void injectInteractor(SearchSubscriptionService searchSubscriptionService, SearchSubscriptionSyncInteractor searchSubscriptionSyncInteractor) {
        searchSubscriptionService.interactor = searchSubscriptionSyncInteractor;
    }

    public void injectMembers(SearchSubscriptionService searchSubscriptionService) {
        injectInteractor(searchSubscriptionService, this.a.get());
    }
}
