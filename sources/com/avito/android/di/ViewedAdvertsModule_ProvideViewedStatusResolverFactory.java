package com.avito.android.di;

import com.avito.android.advert.viewed.ViewedAdvertsInteractor;
import com.avito.android.serp.adapter.ViewedStatusResolver;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ViewedAdvertsModule_ProvideViewedStatusResolverFactory implements Factory<ViewedStatusResolver> {
    public final Provider<ViewedAdvertsInteractor> a;

    public ViewedAdvertsModule_ProvideViewedStatusResolverFactory(Provider<ViewedAdvertsInteractor> provider) {
        this.a = provider;
    }

    public static ViewedAdvertsModule_ProvideViewedStatusResolverFactory create(Provider<ViewedAdvertsInteractor> provider) {
        return new ViewedAdvertsModule_ProvideViewedStatusResolverFactory(provider);
    }

    public static ViewedStatusResolver provideViewedStatusResolver(ViewedAdvertsInteractor viewedAdvertsInteractor) {
        return (ViewedStatusResolver) Preconditions.checkNotNullFromProvides(ViewedAdvertsModule.provideViewedStatusResolver(viewedAdvertsInteractor));
    }

    @Override // javax.inject.Provider
    public ViewedStatusResolver get() {
        return provideViewedStatusResolver(this.a.get());
    }
}
