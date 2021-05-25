package com.avito.android.rating.publish.select_advert.adapter.loading;

import com.avito.android.rating.details.adapter.loading.LoadingItemNextPageAction;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class LoadingItemModule_ProvideLoadingItemShownAction$rating_releaseFactory implements Factory<PublishRelay<LoadingItemNextPageAction>> {

    public static final class a {
        public static final LoadingItemModule_ProvideLoadingItemShownAction$rating_releaseFactory a = new LoadingItemModule_ProvideLoadingItemShownAction$rating_releaseFactory();
    }

    public static LoadingItemModule_ProvideLoadingItemShownAction$rating_releaseFactory create() {
        return a.a;
    }

    public static PublishRelay<LoadingItemNextPageAction> provideLoadingItemShownAction$rating_release() {
        return (PublishRelay) Preconditions.checkNotNullFromProvides(LoadingItemModule.provideLoadingItemShownAction$rating_release());
    }

    @Override // javax.inject.Provider
    public PublishRelay<LoadingItemNextPageAction> get() {
        return provideLoadingItemShownAction$rating_release();
    }
}
