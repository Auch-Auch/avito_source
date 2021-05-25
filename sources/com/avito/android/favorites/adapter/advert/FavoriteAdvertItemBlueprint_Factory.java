package com.avito.android.favorites.adapter.advert;

import com.avito.android.server_time.TimeSource;
import dagger.internal.Factory;
import java.util.Locale;
import javax.inject.Provider;
public final class FavoriteAdvertItemBlueprint_Factory implements Factory<FavoriteAdvertItemBlueprint> {
    public final Provider<FavoriteAdvertItemPresenter> a;
    public final Provider<TimeSource> b;
    public final Provider<Locale> c;

    public FavoriteAdvertItemBlueprint_Factory(Provider<FavoriteAdvertItemPresenter> provider, Provider<TimeSource> provider2, Provider<Locale> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static FavoriteAdvertItemBlueprint_Factory create(Provider<FavoriteAdvertItemPresenter> provider, Provider<TimeSource> provider2, Provider<Locale> provider3) {
        return new FavoriteAdvertItemBlueprint_Factory(provider, provider2, provider3);
    }

    public static FavoriteAdvertItemBlueprint newInstance(FavoriteAdvertItemPresenter favoriteAdvertItemPresenter, TimeSource timeSource, Locale locale) {
        return new FavoriteAdvertItemBlueprint(favoriteAdvertItemPresenter, timeSource, locale);
    }

    @Override // javax.inject.Provider
    public FavoriteAdvertItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
