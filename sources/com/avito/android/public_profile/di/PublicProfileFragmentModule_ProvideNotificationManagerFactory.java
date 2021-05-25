package com.avito.android.public_profile.di;

import android.app.Application;
import androidx.core.app.NotificationManagerCompat;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublicProfileFragmentModule_ProvideNotificationManagerFactory implements Factory<NotificationManagerCompat> {
    public final Provider<Application> a;

    public PublicProfileFragmentModule_ProvideNotificationManagerFactory(Provider<Application> provider) {
        this.a = provider;
    }

    public static PublicProfileFragmentModule_ProvideNotificationManagerFactory create(Provider<Application> provider) {
        return new PublicProfileFragmentModule_ProvideNotificationManagerFactory(provider);
    }

    public static NotificationManagerCompat provideNotificationManager(Application application) {
        return (NotificationManagerCompat) Preconditions.checkNotNullFromProvides(PublicProfileFragmentModule.provideNotificationManager(application));
    }

    @Override // javax.inject.Provider
    public NotificationManagerCompat get() {
        return provideNotificationManager(this.a.get());
    }
}
