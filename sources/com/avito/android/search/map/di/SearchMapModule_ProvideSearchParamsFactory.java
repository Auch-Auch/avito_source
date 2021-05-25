package com.avito.android.search.map.di;

import com.avito.android.remote.model.SearchParams;
import com.avito.android.search.map.SearchMapFragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SearchMapModule_ProvideSearchParamsFactory implements Factory<SearchParams> {
    public final Provider<SearchMapFragment.Factory.Arguments> a;

    public SearchMapModule_ProvideSearchParamsFactory(Provider<SearchMapFragment.Factory.Arguments> provider) {
        this.a = provider;
    }

    public static SearchMapModule_ProvideSearchParamsFactory create(Provider<SearchMapFragment.Factory.Arguments> provider) {
        return new SearchMapModule_ProvideSearchParamsFactory(provider);
    }

    public static SearchParams provideSearchParams(SearchMapFragment.Factory.Arguments arguments) {
        return (SearchParams) Preconditions.checkNotNullFromProvides(SearchMapModule.provideSearchParams(arguments));
    }

    @Override // javax.inject.Provider
    public SearchParams get() {
        return provideSearchParams(this.a.get());
    }
}
