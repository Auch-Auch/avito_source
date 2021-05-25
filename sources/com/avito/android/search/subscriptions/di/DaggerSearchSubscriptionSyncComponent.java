package com.avito.android.search.subscriptions.di;

import com.avito.android.search.subscriptions.di.SearchSubscriptionSyncComponent;
import com.avito.android.search.subscriptions.sync.SearchSubscriptionService;
import com.avito.android.search.subscriptions.sync.SearchSubscriptionService_MembersInjector;
import com.avito.android.search.subscriptions.sync.SearchSubscriptionSyncInteractor;
import dagger.internal.Preconditions;
public final class DaggerSearchSubscriptionSyncComponent implements SearchSubscriptionSyncComponent {
    public final SearchSubscriptionDependencies a;

    public static final class b implements SearchSubscriptionSyncComponent.Builder {
        public SearchSubscriptionDependencies a;

        public b(a aVar) {
        }

        @Override // com.avito.android.search.subscriptions.di.SearchSubscriptionSyncComponent.Builder
        public SearchSubscriptionSyncComponent build() {
            Preconditions.checkBuilderRequirement(this.a, SearchSubscriptionDependencies.class);
            return new DaggerSearchSubscriptionSyncComponent(this.a, null);
        }

        @Override // com.avito.android.search.subscriptions.di.SearchSubscriptionSyncComponent.Builder
        public SearchSubscriptionSyncComponent.Builder dependentOn(SearchSubscriptionDependencies searchSubscriptionDependencies) {
            this.a = (SearchSubscriptionDependencies) Preconditions.checkNotNull(searchSubscriptionDependencies);
            return this;
        }
    }

    public DaggerSearchSubscriptionSyncComponent(SearchSubscriptionDependencies searchSubscriptionDependencies, a aVar) {
        this.a = searchSubscriptionDependencies;
    }

    public static SearchSubscriptionSyncComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.search.subscriptions.di.SearchSubscriptionSyncComponent
    public void inject(SearchSubscriptionService searchSubscriptionService) {
        SearchSubscriptionService_MembersInjector.injectInteractor(searchSubscriptionService, (SearchSubscriptionSyncInteractor) Preconditions.checkNotNullFromComponent(this.a.searchSubscriptionSyncInteractor()));
    }
}
