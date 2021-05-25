package com.avito.android.serp;

import com.avito.android.remote.SearchApi;
import com.avito.android.serp.SerpSnippetInteractor;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SerpSnippetInteractor_Impl_Factory implements Factory<SerpSnippetInteractor.Impl> {
    public final Provider<SchedulersFactory3> a;
    public final Provider<SearchApi> b;

    public SerpSnippetInteractor_Impl_Factory(Provider<SchedulersFactory3> provider, Provider<SearchApi> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static SerpSnippetInteractor_Impl_Factory create(Provider<SchedulersFactory3> provider, Provider<SearchApi> provider2) {
        return new SerpSnippetInteractor_Impl_Factory(provider, provider2);
    }

    public static SerpSnippetInteractor.Impl newInstance(SchedulersFactory3 schedulersFactory3, SearchApi searchApi) {
        return new SerpSnippetInteractor.Impl(schedulersFactory3, searchApi);
    }

    @Override // javax.inject.Provider
    public SerpSnippetInteractor.Impl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
