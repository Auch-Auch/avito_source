package com.avito.android.notification_center.landing.unified;

import com.avito.android.Features;
import com.avito.android.serp.adapter.FavoriteStatusResolver;
import com.avito.android.serp.adapter.ViewedStatusResolver;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class NotificationsCenterLandingUnifiedConverterImpl_Factory implements Factory<NotificationsCenterLandingUnifiedConverterImpl> {
    public final Provider<FavoriteStatusResolver> a;
    public final Provider<ViewedStatusResolver> b;
    public final Provider<Features> c;

    public NotificationsCenterLandingUnifiedConverterImpl_Factory(Provider<FavoriteStatusResolver> provider, Provider<ViewedStatusResolver> provider2, Provider<Features> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static NotificationsCenterLandingUnifiedConverterImpl_Factory create(Provider<FavoriteStatusResolver> provider, Provider<ViewedStatusResolver> provider2, Provider<Features> provider3) {
        return new NotificationsCenterLandingUnifiedConverterImpl_Factory(provider, provider2, provider3);
    }

    public static NotificationsCenterLandingUnifiedConverterImpl newInstance(FavoriteStatusResolver favoriteStatusResolver, ViewedStatusResolver viewedStatusResolver, Features features) {
        return new NotificationsCenterLandingUnifiedConverterImpl(favoriteStatusResolver, viewedStatusResolver, features);
    }

    @Override // javax.inject.Provider
    public NotificationsCenterLandingUnifiedConverterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
