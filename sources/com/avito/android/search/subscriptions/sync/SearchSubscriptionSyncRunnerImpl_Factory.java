package com.avito.android.search.subscriptions.sync;

import dagger.internal.Factory;
public final class SearchSubscriptionSyncRunnerImpl_Factory implements Factory<SearchSubscriptionSyncRunnerImpl> {

    public static final class a {
        public static final SearchSubscriptionSyncRunnerImpl_Factory a = new SearchSubscriptionSyncRunnerImpl_Factory();
    }

    public static SearchSubscriptionSyncRunnerImpl_Factory create() {
        return a.a;
    }

    public static SearchSubscriptionSyncRunnerImpl newInstance() {
        return new SearchSubscriptionSyncRunnerImpl();
    }

    @Override // javax.inject.Provider
    public SearchSubscriptionSyncRunnerImpl get() {
        return newInstance();
    }
}
