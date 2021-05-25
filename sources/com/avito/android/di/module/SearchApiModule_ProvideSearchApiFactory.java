package com.avito.android.di.module;

import com.avito.android.remote.RetrofitFactory;
import com.avito.android.remote.SearchApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SearchApiModule_ProvideSearchApiFactory implements Factory<SearchApi> {
    public final Provider<RetrofitFactory> a;

    public SearchApiModule_ProvideSearchApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static SearchApiModule_ProvideSearchApiFactory create(Provider<RetrofitFactory> provider) {
        return new SearchApiModule_ProvideSearchApiFactory(provider);
    }

    public static SearchApi provideSearchApi(RetrofitFactory retrofitFactory) {
        return (SearchApi) Preconditions.checkNotNullFromProvides(SearchApiModule.INSTANCE.provideSearchApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public SearchApi get() {
        return provideSearchApi(this.a.get());
    }
}
