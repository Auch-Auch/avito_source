package com.avito.android.di.module;

import com.avito.android.remote.model.SearchParamsConverter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class SerpInteractorModule_ProvideSearchParamsConverter$serp_core_releaseFactory implements Factory<SearchParamsConverter> {

    public static final class a {
        public static final SerpInteractorModule_ProvideSearchParamsConverter$serp_core_releaseFactory a = new SerpInteractorModule_ProvideSearchParamsConverter$serp_core_releaseFactory();
    }

    public static SerpInteractorModule_ProvideSearchParamsConverter$serp_core_releaseFactory create() {
        return a.a;
    }

    public static SearchParamsConverter provideSearchParamsConverter$serp_core_release() {
        return (SearchParamsConverter) Preconditions.checkNotNullFromProvides(SerpInteractorModule.provideSearchParamsConverter$serp_core_release());
    }

    @Override // javax.inject.Provider
    public SearchParamsConverter get() {
        return provideSearchParamsConverter$serp_core_release();
    }
}
