package com.avito.android.favorite;

import com.avito.android.analytics.FavoriteAdvertsAnalyticsInteractor;
import com.avito.android.db.favorites.FavoritesSyncDao;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FavoriteAdvertsInteractorImpl_Factory implements Factory<FavoriteAdvertsInteractorImpl> {
    public final Provider<FavoritesSyncDao> a;
    public final Provider<FavoriteAdvertsUploadInteractor> b;
    public final Provider<FavoriteAdvertsEventInteractor> c;
    public final Provider<FavoriteAdvertsAnalyticsInteractor> d;
    public final Provider<SchedulersFactory3> e;

    public FavoriteAdvertsInteractorImpl_Factory(Provider<FavoritesSyncDao> provider, Provider<FavoriteAdvertsUploadInteractor> provider2, Provider<FavoriteAdvertsEventInteractor> provider3, Provider<FavoriteAdvertsAnalyticsInteractor> provider4, Provider<SchedulersFactory3> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static FavoriteAdvertsInteractorImpl_Factory create(Provider<FavoritesSyncDao> provider, Provider<FavoriteAdvertsUploadInteractor> provider2, Provider<FavoriteAdvertsEventInteractor> provider3, Provider<FavoriteAdvertsAnalyticsInteractor> provider4, Provider<SchedulersFactory3> provider5) {
        return new FavoriteAdvertsInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static FavoriteAdvertsInteractorImpl newInstance(FavoritesSyncDao favoritesSyncDao, FavoriteAdvertsUploadInteractor favoriteAdvertsUploadInteractor, FavoriteAdvertsEventInteractor favoriteAdvertsEventInteractor, FavoriteAdvertsAnalyticsInteractor favoriteAdvertsAnalyticsInteractor, SchedulersFactory3 schedulersFactory3) {
        return new FavoriteAdvertsInteractorImpl(favoritesSyncDao, favoriteAdvertsUploadInteractor, favoriteAdvertsEventInteractor, favoriteAdvertsAnalyticsInteractor, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public FavoriteAdvertsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
