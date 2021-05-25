package com.avito.android.search.subscriptions.di;

import com.avito.android.Features;
import com.avito.android.TopLocationInteractor;
import com.avito.android.db.SavedSearchDao;
import com.avito.android.remote.LocationApi;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.remote.model.SearchParamsConverterImpl_Factory;
import com.avito.android.search.subscriptions.SearchSubscriptionConsumer;
import com.avito.android.search.subscriptions.SearchSubscriptionSyncService;
import com.avito.android.search.subscriptions.SearchSubscriptionSyncService_MembersInjector;
import com.avito.android.search.subscriptions.di.SearchSubscriptionSyncServiceComponent;
import com.avito.android.subscriptions.remote.SubscriptionsApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerSearchSubscriptionSyncServiceComponent implements SearchSubscriptionSyncServiceComponent {
    public final SearchSubscriptionDependencies a;
    public Provider<SearchParamsConverter> b = DoubleCheck.provider(SearchParamsConverterImpl_Factory.create());

    public static final class b implements SearchSubscriptionSyncServiceComponent.Builder {
        public SearchSubscriptionDependencies a;

        public b(a aVar) {
        }

        @Override // com.avito.android.search.subscriptions.di.SearchSubscriptionSyncServiceComponent.Builder
        public SearchSubscriptionSyncServiceComponent build() {
            Preconditions.checkBuilderRequirement(this.a, SearchSubscriptionDependencies.class);
            return new DaggerSearchSubscriptionSyncServiceComponent(this.a, null);
        }

        @Override // com.avito.android.search.subscriptions.di.SearchSubscriptionSyncServiceComponent.Builder
        public SearchSubscriptionSyncServiceComponent.Builder dependentOn(SearchSubscriptionDependencies searchSubscriptionDependencies) {
            this.a = (SearchSubscriptionDependencies) Preconditions.checkNotNull(searchSubscriptionDependencies);
            return this;
        }
    }

    public DaggerSearchSubscriptionSyncServiceComponent(SearchSubscriptionDependencies searchSubscriptionDependencies, a aVar) {
        this.a = searchSubscriptionDependencies;
    }

    public static SearchSubscriptionSyncServiceComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.search.subscriptions.di.SearchSubscriptionSyncServiceComponent
    public void inject(SearchSubscriptionSyncService searchSubscriptionSyncService) {
        SearchSubscriptionSyncService_MembersInjector.injectSubscriptionsApi(searchSubscriptionSyncService, (SubscriptionsApi) Preconditions.checkNotNullFromComponent(this.a.subscriptionsApi()));
        SearchSubscriptionSyncService_MembersInjector.injectLocationApi(searchSubscriptionSyncService, (LocationApi) Preconditions.checkNotNullFromComponent(this.a.locationApi()));
        SearchSubscriptionSyncService_MembersInjector.injectTopLocationInteractor(searchSubscriptionSyncService, (TopLocationInteractor) Preconditions.checkNotNullFromComponent(this.a.topLocationInteractor()));
        SearchSubscriptionSyncService_MembersInjector.injectSearchSubscriptionConsumer(searchSubscriptionSyncService, (SearchSubscriptionConsumer) Preconditions.checkNotNullFromComponent(this.a.searchSubscriptionConsumer()));
        SearchSubscriptionSyncService_MembersInjector.injectSavedSearchDao(searchSubscriptionSyncService, (SavedSearchDao) Preconditions.checkNotNullFromComponent(this.a.savedSearchDao()));
        SearchSubscriptionSyncService_MembersInjector.injectSchedulersFactory(searchSubscriptionSyncService, (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3()));
        SearchSubscriptionSyncService_MembersInjector.injectSearchParamsConverter(searchSubscriptionSyncService, this.b.get());
        SearchSubscriptionSyncService_MembersInjector.injectFeatures(searchSubscriptionSyncService, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
    }
}
