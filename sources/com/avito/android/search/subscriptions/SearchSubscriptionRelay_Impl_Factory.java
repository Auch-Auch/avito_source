package com.avito.android.search.subscriptions;

import com.avito.android.search.subscriptions.SearchSubscriptionRelay;
import dagger.internal.Factory;
public final class SearchSubscriptionRelay_Impl_Factory implements Factory<SearchSubscriptionRelay.Impl> {

    public static final class a {
        public static final SearchSubscriptionRelay_Impl_Factory a = new SearchSubscriptionRelay_Impl_Factory();
    }

    public static SearchSubscriptionRelay_Impl_Factory create() {
        return a.a;
    }

    public static SearchSubscriptionRelay.Impl newInstance() {
        return new SearchSubscriptionRelay.Impl();
    }

    @Override // javax.inject.Provider
    public SearchSubscriptionRelay.Impl get() {
        return newInstance();
    }
}
