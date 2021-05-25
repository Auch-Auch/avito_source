package com.avito.android.search.subscriptions;

import com.avito.android.Features;
import com.avito.android.TopLocationInteractor;
import com.avito.android.db.SavedSearchDao;
import com.avito.android.remote.LocationApi;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.subscriptions.remote.SubscriptionsApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class SearchSubscriptionSyncService_MembersInjector implements MembersInjector<SearchSubscriptionSyncService> {
    public final Provider<SubscriptionsApi> a;
    public final Provider<LocationApi> b;
    public final Provider<TopLocationInteractor> c;
    public final Provider<SearchSubscriptionConsumer> d;
    public final Provider<SavedSearchDao> e;
    public final Provider<SchedulersFactory3> f;
    public final Provider<SearchParamsConverter> g;
    public final Provider<Features> h;

    public SearchSubscriptionSyncService_MembersInjector(Provider<SubscriptionsApi> provider, Provider<LocationApi> provider2, Provider<TopLocationInteractor> provider3, Provider<SearchSubscriptionConsumer> provider4, Provider<SavedSearchDao> provider5, Provider<SchedulersFactory3> provider6, Provider<SearchParamsConverter> provider7, Provider<Features> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static MembersInjector<SearchSubscriptionSyncService> create(Provider<SubscriptionsApi> provider, Provider<LocationApi> provider2, Provider<TopLocationInteractor> provider3, Provider<SearchSubscriptionConsumer> provider4, Provider<SavedSearchDao> provider5, Provider<SchedulersFactory3> provider6, Provider<SearchParamsConverter> provider7, Provider<Features> provider8) {
        return new SearchSubscriptionSyncService_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    @InjectedFieldSignature("com.avito.android.search.subscriptions.SearchSubscriptionSyncService.features")
    public static void injectFeatures(SearchSubscriptionSyncService searchSubscriptionSyncService, Features features) {
        searchSubscriptionSyncService.features = features;
    }

    @InjectedFieldSignature("com.avito.android.search.subscriptions.SearchSubscriptionSyncService.locationApi")
    public static void injectLocationApi(SearchSubscriptionSyncService searchSubscriptionSyncService, LocationApi locationApi) {
        searchSubscriptionSyncService.locationApi = locationApi;
    }

    @InjectedFieldSignature("com.avito.android.search.subscriptions.SearchSubscriptionSyncService.savedSearchDao")
    public static void injectSavedSearchDao(SearchSubscriptionSyncService searchSubscriptionSyncService, SavedSearchDao savedSearchDao) {
        searchSubscriptionSyncService.savedSearchDao = savedSearchDao;
    }

    @InjectedFieldSignature("com.avito.android.search.subscriptions.SearchSubscriptionSyncService.schedulersFactory")
    public static void injectSchedulersFactory(SearchSubscriptionSyncService searchSubscriptionSyncService, SchedulersFactory3 schedulersFactory3) {
        searchSubscriptionSyncService.schedulersFactory = schedulersFactory3;
    }

    @InjectedFieldSignature("com.avito.android.search.subscriptions.SearchSubscriptionSyncService.searchParamsConverter")
    public static void injectSearchParamsConverter(SearchSubscriptionSyncService searchSubscriptionSyncService, SearchParamsConverter searchParamsConverter) {
        searchSubscriptionSyncService.searchParamsConverter = searchParamsConverter;
    }

    @InjectedFieldSignature("com.avito.android.search.subscriptions.SearchSubscriptionSyncService.searchSubscriptionConsumer")
    public static void injectSearchSubscriptionConsumer(SearchSubscriptionSyncService searchSubscriptionSyncService, SearchSubscriptionConsumer searchSubscriptionConsumer) {
        searchSubscriptionSyncService.searchSubscriptionConsumer = searchSubscriptionConsumer;
    }

    @InjectedFieldSignature("com.avito.android.search.subscriptions.SearchSubscriptionSyncService.subscriptionsApi")
    public static void injectSubscriptionsApi(SearchSubscriptionSyncService searchSubscriptionSyncService, SubscriptionsApi subscriptionsApi) {
        searchSubscriptionSyncService.subscriptionsApi = subscriptionsApi;
    }

    @InjectedFieldSignature("com.avito.android.search.subscriptions.SearchSubscriptionSyncService.topLocationInteractor")
    public static void injectTopLocationInteractor(SearchSubscriptionSyncService searchSubscriptionSyncService, TopLocationInteractor topLocationInteractor) {
        searchSubscriptionSyncService.topLocationInteractor = topLocationInteractor;
    }

    public void injectMembers(SearchSubscriptionSyncService searchSubscriptionSyncService) {
        injectSubscriptionsApi(searchSubscriptionSyncService, this.a.get());
        injectLocationApi(searchSubscriptionSyncService, this.b.get());
        injectTopLocationInteractor(searchSubscriptionSyncService, this.c.get());
        injectSearchSubscriptionConsumer(searchSubscriptionSyncService, this.d.get());
        injectSavedSearchDao(searchSubscriptionSyncService, this.e.get());
        injectSchedulersFactory(searchSubscriptionSyncService, this.f.get());
        injectSearchParamsConverter(searchSubscriptionSyncService, this.g.get());
        injectFeatures(searchSubscriptionSyncService, this.h.get());
    }
}
