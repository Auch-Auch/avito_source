package com.avito.android.search.subscriptions.adapter;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SearchSubscriptionBlueprint_Factory implements Factory<SearchSubscriptionBlueprint> {
    public final Provider<SearchSubscriptionItemPresenter> a;

    public SearchSubscriptionBlueprint_Factory(Provider<SearchSubscriptionItemPresenter> provider) {
        this.a = provider;
    }

    public static SearchSubscriptionBlueprint_Factory create(Provider<SearchSubscriptionItemPresenter> provider) {
        return new SearchSubscriptionBlueprint_Factory(provider);
    }

    public static SearchSubscriptionBlueprint newInstance(SearchSubscriptionItemPresenter searchSubscriptionItemPresenter) {
        return new SearchSubscriptionBlueprint(searchSubscriptionItemPresenter);
    }

    @Override // javax.inject.Provider
    public SearchSubscriptionBlueprint get() {
        return newInstance(this.a.get());
    }
}
