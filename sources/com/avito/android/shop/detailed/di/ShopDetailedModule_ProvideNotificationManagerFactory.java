package com.avito.android.shop.detailed.di;

import android.content.Context;
import androidx.core.app.NotificationManagerCompat;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ShopDetailedModule_ProvideNotificationManagerFactory implements Factory<NotificationManagerCompat> {
    public final ShopDetailedModule a;
    public final Provider<Context> b;

    public ShopDetailedModule_ProvideNotificationManagerFactory(ShopDetailedModule shopDetailedModule, Provider<Context> provider) {
        this.a = shopDetailedModule;
        this.b = provider;
    }

    public static ShopDetailedModule_ProvideNotificationManagerFactory create(ShopDetailedModule shopDetailedModule, Provider<Context> provider) {
        return new ShopDetailedModule_ProvideNotificationManagerFactory(shopDetailedModule, provider);
    }

    public static NotificationManagerCompat provideNotificationManager(ShopDetailedModule shopDetailedModule, Context context) {
        return (NotificationManagerCompat) Preconditions.checkNotNullFromProvides(shopDetailedModule.provideNotificationManager(context));
    }

    @Override // javax.inject.Provider
    public NotificationManagerCompat get() {
        return provideNotificationManager(this.a, this.b.get());
    }
}
