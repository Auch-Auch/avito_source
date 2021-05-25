package com.avito.android.similar_adverts;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.rec.ScreenSource;
import com.avito.android.section.SectionItemConverter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SimilarAdvertsViewModelImplFactory_Factory implements Factory<SimilarAdvertsViewModelImplFactory> {
    public final Provider<String> a;
    public final Provider<Boolean> b;
    public final Provider<SchedulersFactory3> c;
    public final Provider<SimilarAdvertsInteractor> d;
    public final Provider<SectionItemConverter> e;
    public final Provider<ActivityIntentFactory> f;
    public final Provider<FavoriteAdvertsPresenter> g;
    public final Provider<SimilarAdvertsResourceProvider> h;
    public final Provider<ScreenSource> i;
    public final Provider<Analytics> j;

    public SimilarAdvertsViewModelImplFactory_Factory(Provider<String> provider, Provider<Boolean> provider2, Provider<SchedulersFactory3> provider3, Provider<SimilarAdvertsInteractor> provider4, Provider<SectionItemConverter> provider5, Provider<ActivityIntentFactory> provider6, Provider<FavoriteAdvertsPresenter> provider7, Provider<SimilarAdvertsResourceProvider> provider8, Provider<ScreenSource> provider9, Provider<Analytics> provider10) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
    }

    public static SimilarAdvertsViewModelImplFactory_Factory create(Provider<String> provider, Provider<Boolean> provider2, Provider<SchedulersFactory3> provider3, Provider<SimilarAdvertsInteractor> provider4, Provider<SectionItemConverter> provider5, Provider<ActivityIntentFactory> provider6, Provider<FavoriteAdvertsPresenter> provider7, Provider<SimilarAdvertsResourceProvider> provider8, Provider<ScreenSource> provider9, Provider<Analytics> provider10) {
        return new SimilarAdvertsViewModelImplFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static SimilarAdvertsViewModelImplFactory newInstance(String str, boolean z, SchedulersFactory3 schedulersFactory3, SimilarAdvertsInteractor similarAdvertsInteractor, SectionItemConverter sectionItemConverter, ActivityIntentFactory activityIntentFactory, FavoriteAdvertsPresenter favoriteAdvertsPresenter, SimilarAdvertsResourceProvider similarAdvertsResourceProvider, ScreenSource screenSource, Analytics analytics) {
        return new SimilarAdvertsViewModelImplFactory(str, z, schedulersFactory3, similarAdvertsInteractor, sectionItemConverter, activityIntentFactory, favoriteAdvertsPresenter, similarAdvertsResourceProvider, screenSource, analytics);
    }

    @Override // javax.inject.Provider
    public SimilarAdvertsViewModelImplFactory get() {
        return newInstance(this.a.get(), this.b.get().booleanValue(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get());
    }
}
