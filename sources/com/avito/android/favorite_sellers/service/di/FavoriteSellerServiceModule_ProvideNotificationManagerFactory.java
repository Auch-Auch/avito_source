package com.avito.android.favorite_sellers.service.di;

import android.app.Application;
import androidx.core.app.NotificationManagerCompat;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class FavoriteSellerServiceModule_ProvideNotificationManagerFactory implements Factory<NotificationManagerCompat> {
    public final Provider<Application> a;

    public FavoriteSellerServiceModule_ProvideNotificationManagerFactory(Provider<Application> provider) {
        this.a = provider;
    }

    public static FavoriteSellerServiceModule_ProvideNotificationManagerFactory create(Provider<Application> provider) {
        return new FavoriteSellerServiceModule_ProvideNotificationManagerFactory(provider);
    }

    public static NotificationManagerCompat provideNotificationManager(Application application) {
        return (NotificationManagerCompat) Preconditions.checkNotNullFromProvides(FavoriteSellerServiceModule.INSTANCE.provideNotificationManager(application));
    }

    @Override // javax.inject.Provider
    public NotificationManagerCompat get() {
        return provideNotificationManager(this.a.get());
    }
}
