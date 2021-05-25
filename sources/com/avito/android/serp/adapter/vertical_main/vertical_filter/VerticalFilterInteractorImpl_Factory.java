package com.avito.android.serp.adapter.vertical_main.vertical_filter;

import com.avito.android.remote.SearchApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class VerticalFilterInteractorImpl_Factory implements Factory<VerticalFilterInteractorImpl> {
    public final Provider<SearchApi> a;
    public final Provider<SchedulersFactory3> b;

    public VerticalFilterInteractorImpl_Factory(Provider<SearchApi> provider, Provider<SchedulersFactory3> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static VerticalFilterInteractorImpl_Factory create(Provider<SearchApi> provider, Provider<SchedulersFactory3> provider2) {
        return new VerticalFilterInteractorImpl_Factory(provider, provider2);
    }

    public static VerticalFilterInteractorImpl newInstance(SearchApi searchApi, SchedulersFactory3 schedulersFactory3) {
        return new VerticalFilterInteractorImpl(searchApi, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public VerticalFilterInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
