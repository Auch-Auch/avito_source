package com.avito.android.di;

import android.app.Application;
import androidx.core.app.NotificationManagerCompat;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.ServiceIntentFactory;
import com.avito.android.remote.notification.NotificationBitmapInteractor;
import com.avito.android.remote.notification.NotificationCounterStorage;
import com.avito.android.remote.notification.NotificationInteractor;
import com.avito.android.remote.notification.NotificationResourceProvider;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class NotificationInteractorModule_ProvideNotificationInteractorFactory implements Factory<NotificationInteractor> {
    public final NotificationInteractorModule a;
    public final Provider<Application> b;
    public final Provider<NotificationManagerCompat> c;
    public final Provider<NotificationBitmapInteractor> d;
    public final Provider<NotificationCounterStorage> e;
    public final Provider<NotificationResourceProvider> f;
    public final Provider<ActivityIntentFactory> g;
    public final Provider<ServiceIntentFactory> h;
    public final Provider<SchedulersFactory> i;
    public final Provider<BuildInfo> j;

    public NotificationInteractorModule_ProvideNotificationInteractorFactory(NotificationInteractorModule notificationInteractorModule, Provider<Application> provider, Provider<NotificationManagerCompat> provider2, Provider<NotificationBitmapInteractor> provider3, Provider<NotificationCounterStorage> provider4, Provider<NotificationResourceProvider> provider5, Provider<ActivityIntentFactory> provider6, Provider<ServiceIntentFactory> provider7, Provider<SchedulersFactory> provider8, Provider<BuildInfo> provider9) {
        this.a = notificationInteractorModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = provider6;
        this.h = provider7;
        this.i = provider8;
        this.j = provider9;
    }

    public static NotificationInteractorModule_ProvideNotificationInteractorFactory create(NotificationInteractorModule notificationInteractorModule, Provider<Application> provider, Provider<NotificationManagerCompat> provider2, Provider<NotificationBitmapInteractor> provider3, Provider<NotificationCounterStorage> provider4, Provider<NotificationResourceProvider> provider5, Provider<ActivityIntentFactory> provider6, Provider<ServiceIntentFactory> provider7, Provider<SchedulersFactory> provider8, Provider<BuildInfo> provider9) {
        return new NotificationInteractorModule_ProvideNotificationInteractorFactory(notificationInteractorModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static NotificationInteractor provideNotificationInteractor(NotificationInteractorModule notificationInteractorModule, Application application, NotificationManagerCompat notificationManagerCompat, NotificationBitmapInteractor notificationBitmapInteractor, NotificationCounterStorage notificationCounterStorage, NotificationResourceProvider notificationResourceProvider, ActivityIntentFactory activityIntentFactory, ServiceIntentFactory serviceIntentFactory, SchedulersFactory schedulersFactory, BuildInfo buildInfo) {
        return (NotificationInteractor) Preconditions.checkNotNullFromProvides(notificationInteractorModule.provideNotificationInteractor(application, notificationManagerCompat, notificationBitmapInteractor, notificationCounterStorage, notificationResourceProvider, activityIntentFactory, serviceIntentFactory, schedulersFactory, buildInfo));
    }

    @Override // javax.inject.Provider
    public NotificationInteractor get() {
        return provideNotificationInteractor(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get());
    }
}
