package com.avito.android.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.preference.PreferenceManager;
import com.avito.android.Features;
import com.avito.android.IdProvider;
import com.avito.android.IdProviderImpl;
import com.avito.android.app.ActivityProvider;
import com.avito.android.app.task.ApplicationStartupTasksRegistry;
import com.avito.android.app.task.ApplicationStartupTasksRegistryImpl;
import com.avito.android.app.task.MutableApplicationStartupTasksRegistry;
import com.avito.android.calls_shared.di.CallsModule;
import com.avito.android.db.sqlbrite.di.BriteDbModule;
import com.avito.android.di.CategoriesModule;
import com.avito.android.di.PermissionsModule;
import com.avito.android.di.TopLocationModule;
import com.avito.android.location.LocationInfoProvider;
import com.avito.android.location.LocationInfoProviderImpl;
import com.avito.android.remote.error.ErrorConverterModule;
import com.avito.android.service.SafeServiceStarter;
import com.avito.android.service.SafeServiceStarterImpl;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.DeviceMetricsImpl;
import com.avito.android.util.RandomKeyProvider;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.SchedulersFactory3Impl;
import com.avito.android.util.SchedulersFactoryImpl;
import com.avito.android.util.UUIDRandomKeyProvider;
import com.google.android.exoplayer2.util.MimeTypes;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.util.Locale;
import java.util.Objects;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b!\u0010\"J\u0017\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020#H\u0007¢\u0006\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/avito/android/di/module/CoreApplicationModule;", "", "Ljava/util/Locale;", "provideDefaultLocale", "()Ljava/util/Locale;", "Lcom/avito/android/app/ActivityProvider;", "provideActivityProvider", "()Lcom/avito/android/app/ActivityProvider;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/content/Context;", "provideContext", "(Landroid/app/Application;)Landroid/content/Context;", "Lcom/avito/android/util/SchedulersFactory;", "provideLegacySchedulersFactory", "()Lcom/avito/android/util/SchedulersFactory;", "Lcom/avito/android/util/SchedulersFactory3;", "provideSchedulersFactory", "()Lcom/avito/android/util/SchedulersFactory3;", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Landroid/view/Display;", "display", "Landroid/util/DisplayMetrics;", "displayMetrics", "Lcom/avito/android/util/DeviceMetrics;", "provideDeviceMetrics", "(Lcom/avito/android/util/BuildInfo;Landroid/view/Display;Landroid/util/DisplayMetrics;)Lcom/avito/android/util/DeviceMetrics;", "Landroid/content/SharedPreferences;", "provideDefaultSharedPreferences", "(Landroid/app/Application;)Landroid/content/SharedPreferences;", "provideDisplay", "(Landroid/app/Application;)Landroid/view/Display;", "provideDisplayMetrics", "(Landroid/app/Application;)Landroid/util/DisplayMetrics;", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/app/task/MutableApplicationStartupTasksRegistry;", "provideMutableApplicationStartupTasksRegistry", "(Lcom/avito/android/Features;)Lcom/avito/android/app/task/MutableApplicationStartupTasksRegistry;", "<init>", "()V", "Bindings", "core_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {BeduinModule.class, CoreAnalyticsModule.class, ExternalApplicationsModule.class, PersistenceCoreModule.class, PermissionsModule.class, CallsModule.class, BriteDbModule.class, ImplicitIntentFactoryModule.class, NavigationModule.class, AppFeaturesModule.class, DeepLinkModule.class, PersistenceGeoModule.class, PersistenceFingerprintModule.class, MessengerInfoModule.class, ErrorConverterModule.class, ScreenAnalyticsModule.class, CategoriesModule.class, TopLocationModule.class, Bindings.class})
public final class CoreApplicationModule {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/avito/android/di/module/CoreApplicationModule$Bindings;", "", "Lcom/avito/android/app/task/MutableApplicationStartupTasksRegistry;", "impl", "Lcom/avito/android/app/task/ApplicationStartupTasksRegistry;", "bindApplicationStartupTasksRegistry", "(Lcom/avito/android/app/task/MutableApplicationStartupTasksRegistry;)Lcom/avito/android/app/task/ApplicationStartupTasksRegistry;", "Lcom/avito/android/location/LocationInfoProviderImpl;", "Lcom/avito/android/location/LocationInfoProvider;", "bindLocationInfoStorage", "(Lcom/avito/android/location/LocationInfoProviderImpl;)Lcom/avito/android/location/LocationInfoProvider;", "Lcom/avito/android/IdProviderImpl;", "Lcom/avito/android/IdProvider;", "provideIdProvider", "(Lcom/avito/android/IdProviderImpl;)Lcom/avito/android/IdProvider;", "Lcom/avito/android/util/UUIDRandomKeyProvider;", "Lcom/avito/android/util/RandomKeyProvider;", "bindRandomKeyProvider", "(Lcom/avito/android/util/UUIDRandomKeyProvider;)Lcom/avito/android/util/RandomKeyProvider;", "Lcom/avito/android/service/SafeServiceStarterImpl;", "Lcom/avito/android/service/SafeServiceStarter;", "bindSafeServiceStarter", "(Lcom/avito/android/service/SafeServiceStarterImpl;)Lcom/avito/android/service/SafeServiceStarter;", "core_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Bindings {
        @Singleton
        @Binds
        @NotNull
        ApplicationStartupTasksRegistry bindApplicationStartupTasksRegistry(@NotNull MutableApplicationStartupTasksRegistry mutableApplicationStartupTasksRegistry);

        @Singleton
        @Binds
        @NotNull
        LocationInfoProvider bindLocationInfoStorage(@NotNull LocationInfoProviderImpl locationInfoProviderImpl);

        @Singleton
        @Binds
        @NotNull
        RandomKeyProvider bindRandomKeyProvider(@NotNull UUIDRandomKeyProvider uUIDRandomKeyProvider);

        @Binds
        @NotNull
        SafeServiceStarter bindSafeServiceStarter(@NotNull SafeServiceStarterImpl safeServiceStarterImpl);

        @Singleton
        @Binds
        @NotNull
        IdProvider provideIdProvider(@NotNull IdProviderImpl idProviderImpl);
    }

    @Provides
    @Singleton
    @NotNull
    public final ActivityProvider provideActivityProvider() {
        return new ActivityProvider();
    }

    @Provides
    @NotNull
    public final Context provideContext(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Context applicationContext = application.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "application.applicationContext");
        return applicationContext;
    }

    @Provides
    @NotNull
    public final Locale provideDefaultLocale() {
        return new Locale("ru");
    }

    @Provides
    @Singleton
    @NotNull
    public final SharedPreferences provideDefaultSharedPreferences(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(application);
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "PreferenceManager.getDef…dPreferences(application)");
        return defaultSharedPreferences;
    }

    @Provides
    @Singleton
    @NotNull
    public final DeviceMetrics provideDeviceMetrics(@NotNull BuildInfo buildInfo, @NotNull Display display, @NotNull DisplayMetrics displayMetrics) {
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(display, "display");
        Intrinsics.checkNotNullParameter(displayMetrics, "displayMetrics");
        return new DeviceMetricsImpl(buildInfo, display, displayMetrics);
    }

    @Provides
    @NotNull
    public final Display provideDisplay(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Object systemService = application.getBaseContext().getSystemService("window");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        Intrinsics.checkNotNullExpressionValue(defaultDisplay, "wm.defaultDisplay");
        return defaultDisplay;
    }

    @Provides
    @NotNull
    public final DisplayMetrics provideDisplayMetrics(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Resources resources = application.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "application.resources");
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "application.resources.displayMetrics");
        return displayMetrics;
    }

    @Provides
    @Singleton
    @NotNull
    public final SchedulersFactory provideLegacySchedulersFactory() {
        return new SchedulersFactoryImpl();
    }

    @Provides
    @Singleton
    @NotNull
    public final MutableApplicationStartupTasksRegistry provideMutableApplicationStartupTasksRegistry(@NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
        return new ApplicationStartupTasksRegistryImpl(features.getFailOnMismatchedStartupTask().invoke().booleanValue());
    }

    @Provides
    @Singleton
    @NotNull
    public final SchedulersFactory3 provideSchedulersFactory() {
        return new SchedulersFactory3Impl();
    }
}
