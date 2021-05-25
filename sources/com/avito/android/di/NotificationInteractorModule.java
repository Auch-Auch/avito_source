package com.avito.android.di;

import android.app.Application;
import android.content.res.Resources;
import androidx.core.app.NotificationManagerCompat;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.ServiceIntentFactory;
import com.avito.android.notification_manager_provider.NotificationManagerModule;
import com.avito.android.remote.notification.NotificationBitmapInteractor;
import com.avito.android.remote.notification.NotificationBitmapInteractorImpl;
import com.avito.android.remote.notification.NotificationCounterStorage;
import com.avito.android.remote.notification.NotificationInteractor;
import com.avito.android.remote.notification.NotificationInteractorImpl;
import com.avito.android.remote.notification.NotificationResourceProvider;
import com.avito.android.remote.notification.NotificationResourceProviderImpl;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.SchedulersFactory;
import com.google.android.exoplayer2.util.MimeTypes;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0017¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u000f\u0010\u0010JW\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001aH\u0017¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/avito/android/di/NotificationInteractorModule;", "", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Landroidx/core/app/NotificationManagerCompat;", "provideNotificationManager", "(Landroid/app/Application;)Landroidx/core/app/NotificationManagerCompat;", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/remote/notification/NotificationBitmapInteractor;", "provideNotificationBitmapInteractor", "(Lcom/avito/android/util/DeviceMetrics;Lcom/avito/android/util/SchedulersFactory;)Lcom/avito/android/remote/notification/NotificationBitmapInteractor;", "Lcom/avito/android/remote/notification/NotificationResourceProvider;", "provideNotificationResourceProvider", "(Landroid/app/Application;)Lcom/avito/android/remote/notification/NotificationResourceProvider;", "notificationManagerCompat", "notificationBitmapInteractor", "Lcom/avito/android/remote/notification/NotificationCounterStorage;", "notificationCounterStorage", "notificationResourceProvider", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ServiceIntentFactory;", "serviceIntentFactory", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/remote/notification/NotificationInteractor;", "provideNotificationInteractor", "(Landroid/app/Application;Landroidx/core/app/NotificationManagerCompat;Lcom/avito/android/remote/notification/NotificationBitmapInteractor;Lcom/avito/android/remote/notification/NotificationCounterStorage;Lcom/avito/android/remote/notification/NotificationResourceProvider;Lcom/avito/android/ActivityIntentFactory;Lcom/avito/android/ServiceIntentFactory;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/BuildInfo;)Lcom/avito/android/remote/notification/NotificationInteractor;", "<init>", "()V", "notification_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {NotificationManagerModule.class})
public class NotificationInteractorModule {
    @Provides
    @NotNull
    public NotificationBitmapInteractor provideNotificationBitmapInteractor(@NotNull DeviceMetrics deviceMetrics, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        return new NotificationBitmapInteractorImpl(deviceMetrics, schedulersFactory);
    }

    @Provides
    @Singleton
    @NotNull
    public NotificationInteractor provideNotificationInteractor(@NotNull Application application, @NotNull NotificationManagerCompat notificationManagerCompat, @NotNull NotificationBitmapInteractor notificationBitmapInteractor, @NotNull NotificationCounterStorage notificationCounterStorage, @NotNull NotificationResourceProvider notificationResourceProvider, @NotNull ActivityIntentFactory activityIntentFactory, @NotNull ServiceIntentFactory serviceIntentFactory, @NotNull SchedulersFactory schedulersFactory, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(notificationManagerCompat, "notificationManagerCompat");
        Intrinsics.checkNotNullParameter(notificationBitmapInteractor, "notificationBitmapInteractor");
        Intrinsics.checkNotNullParameter(notificationCounterStorage, "notificationCounterStorage");
        Intrinsics.checkNotNullParameter(notificationResourceProvider, "notificationResourceProvider");
        Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
        Intrinsics.checkNotNullParameter(serviceIntentFactory, "serviceIntentFactory");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        return new NotificationInteractorImpl(application, notificationManagerCompat, notificationBitmapInteractor, notificationCounterStorage, notificationResourceProvider, activityIntentFactory, serviceIntentFactory, schedulersFactory, buildInfo);
    }

    @Provides
    @NotNull
    public NotificationManagerCompat provideNotificationManager(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        NotificationManagerCompat from = NotificationManagerCompat.from(application);
        Intrinsics.checkNotNullExpressionValue(from, "NotificationManagerCompat.from(application)");
        return from;
    }

    @Provides
    @NotNull
    public NotificationResourceProvider provideNotificationResourceProvider(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Resources resources = application.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "application.resources");
        return new NotificationResourceProviderImpl(resources);
    }
}
