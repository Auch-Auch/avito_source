package com.avito.android.di.module;

import com.avito.android.analytics.Analytics;
import com.avito.android.db.DbHelper;
import com.avito.android.db.FavoriteDao;
import com.avito.android.util.DeviceMetrics;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Locale;
import javax.inject.Provider;
public final class FavoriteModule_ProvideFavoriteDaoFactory implements Factory<FavoriteDao> {
    public final Provider<DbHelper> a;
    public final Provider<DeviceMetrics> b;
    public final Provider<Analytics> c;
    public final Provider<Locale> d;

    public FavoriteModule_ProvideFavoriteDaoFactory(Provider<DbHelper> provider, Provider<DeviceMetrics> provider2, Provider<Analytics> provider3, Provider<Locale> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static FavoriteModule_ProvideFavoriteDaoFactory create(Provider<DbHelper> provider, Provider<DeviceMetrics> provider2, Provider<Analytics> provider3, Provider<Locale> provider4) {
        return new FavoriteModule_ProvideFavoriteDaoFactory(provider, provider2, provider3, provider4);
    }

    public static FavoriteDao provideFavoriteDao(DbHelper dbHelper, DeviceMetrics deviceMetrics, Analytics analytics, Locale locale) {
        return (FavoriteDao) Preconditions.checkNotNullFromProvides(FavoriteModule.provideFavoriteDao(dbHelper, deviceMetrics, analytics, locale));
    }

    @Override // javax.inject.Provider
    public FavoriteDao get() {
        return provideFavoriteDao(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
