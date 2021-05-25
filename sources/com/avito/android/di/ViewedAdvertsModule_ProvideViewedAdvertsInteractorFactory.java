package com.avito.android.di;

import com.avito.android.Features;
import com.avito.android.advert.viewed.ViewedAdvertsEventInteractor;
import com.avito.android.advert.viewed.ViewedAdvertsInteractor;
import com.avito.android.advert.viewed.ViewedAdvertsInteractorFactory;
import com.avito.android.db.viewed.ViewedAdvertsDao;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ViewedAdvertsModule_ProvideViewedAdvertsInteractorFactory implements Factory<ViewedAdvertsInteractor> {
    public final Provider<ViewedAdvertsInteractorFactory> a;
    public final Provider<ViewedAdvertsDao> b;
    public final Provider<SchedulersFactory3> c;
    public final Provider<ViewedAdvertsEventInteractor> d;
    public final Provider<Features> e;

    public ViewedAdvertsModule_ProvideViewedAdvertsInteractorFactory(Provider<ViewedAdvertsInteractorFactory> provider, Provider<ViewedAdvertsDao> provider2, Provider<SchedulersFactory3> provider3, Provider<ViewedAdvertsEventInteractor> provider4, Provider<Features> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static ViewedAdvertsModule_ProvideViewedAdvertsInteractorFactory create(Provider<ViewedAdvertsInteractorFactory> provider, Provider<ViewedAdvertsDao> provider2, Provider<SchedulersFactory3> provider3, Provider<ViewedAdvertsEventInteractor> provider4, Provider<Features> provider5) {
        return new ViewedAdvertsModule_ProvideViewedAdvertsInteractorFactory(provider, provider2, provider3, provider4, provider5);
    }

    public static ViewedAdvertsInteractor provideViewedAdvertsInteractor(ViewedAdvertsInteractorFactory viewedAdvertsInteractorFactory, ViewedAdvertsDao viewedAdvertsDao, SchedulersFactory3 schedulersFactory3, ViewedAdvertsEventInteractor viewedAdvertsEventInteractor, Features features) {
        return (ViewedAdvertsInteractor) Preconditions.checkNotNullFromProvides(ViewedAdvertsModule.provideViewedAdvertsInteractor(viewedAdvertsInteractorFactory, viewedAdvertsDao, schedulersFactory3, viewedAdvertsEventInteractor, features));
    }

    @Override // javax.inject.Provider
    public ViewedAdvertsInteractor get() {
        return provideViewedAdvertsInteractor(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
