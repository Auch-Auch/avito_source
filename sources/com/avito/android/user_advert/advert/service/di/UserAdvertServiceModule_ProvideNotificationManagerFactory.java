package com.avito.android.user_advert.advert.service.di;

import android.app.Application;
import androidx.core.app.NotificationManagerCompat;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UserAdvertServiceModule_ProvideNotificationManagerFactory implements Factory<NotificationManagerCompat> {
    public final Provider<Application> a;

    public UserAdvertServiceModule_ProvideNotificationManagerFactory(Provider<Application> provider) {
        this.a = provider;
    }

    public static UserAdvertServiceModule_ProvideNotificationManagerFactory create(Provider<Application> provider) {
        return new UserAdvertServiceModule_ProvideNotificationManagerFactory(provider);
    }

    public static NotificationManagerCompat provideNotificationManager(Application application) {
        return (NotificationManagerCompat) Preconditions.checkNotNullFromProvides(UserAdvertServiceModule.INSTANCE.provideNotificationManager(application));
    }

    @Override // javax.inject.Provider
    public NotificationManagerCompat get() {
        return provideNotificationManager(this.a.get());
    }
}
