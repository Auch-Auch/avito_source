package com.avito.android.search.subscriptions.adapter;

import com.avito.android.search.subscriptions.adapter.SearchSubscriptionItemPresenter;
import com.avito.android.util.Formatter;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SearchSubscriptionItemPresenterImpl_Factory implements Factory<SearchSubscriptionItemPresenterImpl> {
    public final Provider<SearchSubscriptionItemPresenter.Listener> a;
    public final Provider<Formatter<Long>> b;

    public SearchSubscriptionItemPresenterImpl_Factory(Provider<SearchSubscriptionItemPresenter.Listener> provider, Provider<Formatter<Long>> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static SearchSubscriptionItemPresenterImpl_Factory create(Provider<SearchSubscriptionItemPresenter.Listener> provider, Provider<Formatter<Long>> provider2) {
        return new SearchSubscriptionItemPresenterImpl_Factory(provider, provider2);
    }

    public static SearchSubscriptionItemPresenterImpl newInstance(Lazy<SearchSubscriptionItemPresenter.Listener> lazy, Formatter<Long> formatter) {
        return new SearchSubscriptionItemPresenterImpl(lazy, formatter);
    }

    @Override // javax.inject.Provider
    public SearchSubscriptionItemPresenterImpl get() {
        return newInstance(DoubleCheck.lazy(this.a), this.b.get());
    }
}
