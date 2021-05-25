package com.avito.android.search.map.middleware;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.async_phone.AsyncPhonePresenter;
import com.avito.android.deep_linking.ClickStreamLinkHandler;
import com.avito.android.inline_filters.InlineFiltersPresenter;
import com.avito.android.search.map.interactor.SearchMapAnalyticsInteractor;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class NavigationMiddlewareImpl_Factory implements Factory<NavigationMiddlewareImpl> {
    public final Provider<SearchMapAnalyticsInteractor> a;
    public final Provider<ClickStreamLinkHandler> b;
    public final Provider<AccountStateProvider> c;
    public final Provider<InlineFiltersPresenter> d;
    public final Provider<AsyncPhonePresenter> e;

    public NavigationMiddlewareImpl_Factory(Provider<SearchMapAnalyticsInteractor> provider, Provider<ClickStreamLinkHandler> provider2, Provider<AccountStateProvider> provider3, Provider<InlineFiltersPresenter> provider4, Provider<AsyncPhonePresenter> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static NavigationMiddlewareImpl_Factory create(Provider<SearchMapAnalyticsInteractor> provider, Provider<ClickStreamLinkHandler> provider2, Provider<AccountStateProvider> provider3, Provider<InlineFiltersPresenter> provider4, Provider<AsyncPhonePresenter> provider5) {
        return new NavigationMiddlewareImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static NavigationMiddlewareImpl newInstance(SearchMapAnalyticsInteractor searchMapAnalyticsInteractor, ClickStreamLinkHandler clickStreamLinkHandler, AccountStateProvider accountStateProvider, InlineFiltersPresenter inlineFiltersPresenter, AsyncPhonePresenter asyncPhonePresenter) {
        return new NavigationMiddlewareImpl(searchMapAnalyticsInteractor, clickStreamLinkHandler, accountStateProvider, inlineFiltersPresenter, asyncPhonePresenter);
    }

    @Override // javax.inject.Provider
    public NavigationMiddlewareImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
