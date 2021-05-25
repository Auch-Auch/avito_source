package com.avito.android.di.module;

import com.avito.android.remote.RetrofitFactory;
import com.avito.android.remote.SearchRadiusApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SearchRadiusApiModule_ProvideSearchRadiusApiFactory implements Factory<SearchRadiusApi> {
    public final Provider<RetrofitFactory> a;

    public SearchRadiusApiModule_ProvideSearchRadiusApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static SearchRadiusApiModule_ProvideSearchRadiusApiFactory create(Provider<RetrofitFactory> provider) {
        return new SearchRadiusApiModule_ProvideSearchRadiusApiFactory(provider);
    }

    public static SearchRadiusApi provideSearchRadiusApi(RetrofitFactory retrofitFactory) {
        return (SearchRadiusApi) Preconditions.checkNotNullFromProvides(SearchRadiusApiModule.INSTANCE.provideSearchRadiusApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public SearchRadiusApi get() {
        return provideSearchRadiusApi(this.a.get());
    }
}
