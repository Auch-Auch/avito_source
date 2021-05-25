package com.avito.android.search.map.di;

import com.avito.android.search.map.provider.PublishFloatingViewsProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class SearchMapModule_ProvidePublishFloatingViewsPresenterFactory implements Factory<PublishFloatingViewsProvider> {

    public static final class a {
        public static final SearchMapModule_ProvidePublishFloatingViewsPresenterFactory a = new SearchMapModule_ProvidePublishFloatingViewsPresenterFactory();
    }

    public static SearchMapModule_ProvidePublishFloatingViewsPresenterFactory create() {
        return a.a;
    }

    public static PublishFloatingViewsProvider providePublishFloatingViewsPresenter() {
        return (PublishFloatingViewsProvider) Preconditions.checkNotNullFromProvides(SearchMapModule.providePublishFloatingViewsPresenter());
    }

    @Override // javax.inject.Provider
    public PublishFloatingViewsProvider get() {
        return providePublishFloatingViewsPresenter();
    }
}
