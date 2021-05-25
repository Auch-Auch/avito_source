package com.avito.android.extended_profile;

import com.avito.android.db.favorites.FavoritesSyncDao;
import com.avito.android.db.viewed.ViewedAdvertsDao;
import com.avito.android.extended_profile.tracker.ExtendedProfileTracker;
import com.avito.android.public_profile.remote.PublicProfileApi;
import com.avito.android.remote.ExtendedProfileApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.serp.adapter.SerpAdvertConverter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ExtendedProfileInteractorImpl_Factory implements Factory<ExtendedProfileInteractorImpl> {
    public final Provider<ExtendedProfileApi> a;
    public final Provider<PublicProfileApi> b;
    public final Provider<FavoritesSyncDao> c;
    public final Provider<ViewedAdvertsDao> d;
    public final Provider<SchedulersFactory3> e;
    public final Provider<SerpAdvertConverter> f;
    public final Provider<TypedErrorThrowableConverter> g;
    public final Provider<ExtendedProfileTracker> h;

    public ExtendedProfileInteractorImpl_Factory(Provider<ExtendedProfileApi> provider, Provider<PublicProfileApi> provider2, Provider<FavoritesSyncDao> provider3, Provider<ViewedAdvertsDao> provider4, Provider<SchedulersFactory3> provider5, Provider<SerpAdvertConverter> provider6, Provider<TypedErrorThrowableConverter> provider7, Provider<ExtendedProfileTracker> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static ExtendedProfileInteractorImpl_Factory create(Provider<ExtendedProfileApi> provider, Provider<PublicProfileApi> provider2, Provider<FavoritesSyncDao> provider3, Provider<ViewedAdvertsDao> provider4, Provider<SchedulersFactory3> provider5, Provider<SerpAdvertConverter> provider6, Provider<TypedErrorThrowableConverter> provider7, Provider<ExtendedProfileTracker> provider8) {
        return new ExtendedProfileInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static ExtendedProfileInteractorImpl newInstance(ExtendedProfileApi extendedProfileApi, PublicProfileApi publicProfileApi, FavoritesSyncDao favoritesSyncDao, ViewedAdvertsDao viewedAdvertsDao, SchedulersFactory3 schedulersFactory3, SerpAdvertConverter serpAdvertConverter, TypedErrorThrowableConverter typedErrorThrowableConverter, ExtendedProfileTracker extendedProfileTracker) {
        return new ExtendedProfileInteractorImpl(extendedProfileApi, publicProfileApi, favoritesSyncDao, viewedAdvertsDao, schedulersFactory3, serpAdvertConverter, typedErrorThrowableConverter, extendedProfileTracker);
    }

    @Override // javax.inject.Provider
    public ExtendedProfileInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
