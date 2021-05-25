package com.avito.android.advert.closed;

import com.avito.android.advert.favorites.AdvertDetailsFavoriteInteractor;
import com.avito.android.advert.viewed.ViewedAdvertsInteractor;
import com.avito.android.util.Formatter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ClosedAdvertPresenterImpl_Factory implements Factory<ClosedAdvertPresenterImpl> {
    public final Provider<String> a;
    public final Provider<AdvertDetailsFavoriteInteractor> b;
    public final Provider<ViewedAdvertsInteractor> c;
    public final Provider<Formatter<Throwable>> d;
    public final Provider<ClosedAdvertResourcesProvider> e;
    public final Provider<SchedulersFactory3> f;

    public ClosedAdvertPresenterImpl_Factory(Provider<String> provider, Provider<AdvertDetailsFavoriteInteractor> provider2, Provider<ViewedAdvertsInteractor> provider3, Provider<Formatter<Throwable>> provider4, Provider<ClosedAdvertResourcesProvider> provider5, Provider<SchedulersFactory3> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static ClosedAdvertPresenterImpl_Factory create(Provider<String> provider, Provider<AdvertDetailsFavoriteInteractor> provider2, Provider<ViewedAdvertsInteractor> provider3, Provider<Formatter<Throwable>> provider4, Provider<ClosedAdvertResourcesProvider> provider5, Provider<SchedulersFactory3> provider6) {
        return new ClosedAdvertPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static ClosedAdvertPresenterImpl newInstance(String str, AdvertDetailsFavoriteInteractor advertDetailsFavoriteInteractor, ViewedAdvertsInteractor viewedAdvertsInteractor, Formatter<Throwable> formatter, ClosedAdvertResourcesProvider closedAdvertResourcesProvider, SchedulersFactory3 schedulersFactory3) {
        return new ClosedAdvertPresenterImpl(str, advertDetailsFavoriteInteractor, viewedAdvertsInteractor, formatter, closedAdvertResourcesProvider, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public ClosedAdvertPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
