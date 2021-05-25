package com.avito.android.extended_profile.di;

import android.content.Context;
import androidx.core.app.NotificationManagerCompat;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ExtendedProfileModule_ProvideNotificationManagerFactory implements Factory<NotificationManagerCompat> {
    public final Provider<Context> a;

    public ExtendedProfileModule_ProvideNotificationManagerFactory(Provider<Context> provider) {
        this.a = provider;
    }

    public static ExtendedProfileModule_ProvideNotificationManagerFactory create(Provider<Context> provider) {
        return new ExtendedProfileModule_ProvideNotificationManagerFactory(provider);
    }

    public static NotificationManagerCompat provideNotificationManager(Context context) {
        return (NotificationManagerCompat) Preconditions.checkNotNullFromProvides(ExtendedProfileModule.provideNotificationManager(context));
    }

    @Override // javax.inject.Provider
    public NotificationManagerCompat get() {
        return provideNotificationManager(this.a.get());
    }
}
