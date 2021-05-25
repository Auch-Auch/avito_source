package com.avito.android.di.module;

import android.app.Application;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.TypedLazy;
import com.avito.android.ab_tests.configs.UserAdvertsTabTestGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.task.StartupAnalyticsTracker;
import com.avito.android.analytics.task.StartupAnalyticsTrackerImpl;
import com.avito.android.app.ActivityProvider;
import com.avito.android.app.task.ActivityListenerTask;
import com.avito.android.app.task.ApplicationBackgroundStartupTask;
import com.avito.android.app.task.ApplicationBlockingStartupTask;
import com.avito.android.app.task.ApplicationForegroundStartupTask;
import com.avito.android.app.task.CheckRequestTask;
import com.avito.android.app.task.ConveyorConfigurationTask;
import com.avito.android.app.task.DarkThemeTask;
import com.avito.android.app.task.FingerprintCalculationSchedulerTask;
import com.avito.android.app.task.GlobalAnimationsStateTask;
import com.avito.android.app.task.InitFrescoTask;
import com.avito.android.app.task.InitRxTask;
import com.avito.android.app.task.MutableApplicationStartupTasksRegistry;
import com.avito.android.app.task.SetDefaultLocaleTask;
import com.avito.android.app.task.SetupNotificationChannelsTask;
import com.avito.android.app.task.ShortcutsTask;
import com.avito.android.app.task.SubscribeToForegroundStateTask;
import com.avito.android.connection_quality.BandwidthSampler;
import com.avito.android.connection_quality.BandwidthSamplerRequestListener;
import com.avito.android.di.PerApplication;
import com.avito.android.di.module.HttpClientModule;
import com.avito.android.enabler.FetchRemoteTogglesStartUpTask;
import com.avito.android.image_loader.fresco.FrescoMemoryTrimmableRegistry;
import com.avito.android.lib.util.DarkThemeConfig;
import com.avito.android.lib.util.DarkThemeManager;
import com.avito.android.service.short_task.FingerprintCalculationTask;
import com.avito.android.service.short_task.ShortTaskExactScheduler;
import com.avito.android.service.short_task.TimeRequestTask;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.ForegroundStatusCallbacks;
import com.avito.android.util.ForegroundStatusCallbacksImpl;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.ShortcutInfoFactory;
import com.avito.android.util.ShortcutInfoFactoryImpl;
import com.avito.android.util.ShortcutManagerFactory;
import com.avito.android.util.ShortcutManagerFactoryImpl;
import com.avito.android.util.preferences.GeoContract;
import com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher;
import com.google.android.exoplayer2.util.MimeTypes;
import dagger.Binds;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;
import dagger.multibindings.IntoSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.y;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001sB\t\b\u0002¢\u0006\u0004\bq\u0010rJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJg\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ9\u0010'\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020&0%0\u001c2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0 H\u0007¢\u0006\u0004\b'\u0010(J:\u00103\u001a\u00020\u000f2\u0011\u0010,\u001a\r\u0012\t\u0012\u00070*¢\u0006\u0002\b+0)2\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/2\u0006\u00102\u001a\u000201H\u0007¢\u0006\u0004\b3\u00104J\u0017\u00107\u001a\u00020\u00152\u0006\u00106\u001a\u000205H\u0007¢\u0006\u0004\b7\u00108J\u001f\u0010=\u001a\u00020#2\u0006\u0010:\u001a\u0002092\u0006\u0010<\u001a\u00020;H\u0007¢\u0006\u0004\b=\u0010>J\u000f\u0010?\u001a\u000209H\u0007¢\u0006\u0004\b?\u0010@J\u0017\u0010B\u001a\u00020!2\u0006\u0010A\u001a\u00020;H\u0007¢\u0006\u0004\bB\u0010CJG\u0010R\u001a\u00020\r2\u0006\u0010E\u001a\u00020D2\u0006\u0010G\u001a\u00020F2\u0006\u0010I\u001a\u00020H2\u0006\u0010K\u001a\u00020J2\u0006\u0010M\u001a\u00020L2\u0006\u0010O\u001a\u00020N2\u0006\u0010Q\u001a\u00020PH\u0007¢\u0006\u0004\bR\u0010SJ9\u0010Z\u001a\u0004\u0018\u00010\u00172\u0006\u0010E\u001a\u00020D2\u0006\u0010U\u001a\u00020T2\u0006\u0010W\u001a\u00020V2\u0006\u00102\u001a\u0002012\u0006\u0010Y\u001a\u00020XH\u0007¢\u0006\u0004\bZ\u0010[J\u0017\u0010^\u001a\u00020T2\u0006\u0010]\u001a\u00020\\H\u0007¢\u0006\u0004\b^\u0010_J\u0017\u0010b\u001a\u00020V2\u0006\u0010a\u001a\u00020`H\u0007¢\u0006\u0004\bb\u0010cJ\u000f\u0010d\u001a\u00020JH\u0007¢\u0006\u0004\bd\u0010eJ\u0017\u0010h\u001a\u00020F2\u0006\u0010g\u001a\u00020fH\u0007¢\u0006\u0004\bh\u0010iJ\u0019\u0010l\u001a\u00020L2\b\b\u0001\u0010k\u001a\u00020jH\u0007¢\u0006\u0004\bl\u0010mJ\u000f\u0010p\u001a\u00020HH\u0001¢\u0006\u0004\bn\u0010o¨\u0006t"}, d2 = {"Lcom/avito/android/di/module/CoreTasksModule;", "", "Lcom/avito/android/lib/util/DarkThemeManager;", "darkThemeManager", "Lcom/avito/android/lib/util/DarkThemeConfig;", "darkThemeConfig", "Lcom/avito/android/app/task/DarkThemeTask;", "provideDarkThemeTask", "(Lcom/avito/android/lib/util/DarkThemeManager;Lcom/avito/android/lib/util/DarkThemeConfig;)Lcom/avito/android/app/task/DarkThemeTask;", "Lcom/avito/android/app/task/InitRxTask;", "initRxTask", "Lcom/avito/android/app/task/SetDefaultLocaleTask;", "setDefaultLocaleTask", "Lcom/avito/android/app/task/InitFrescoTask;", "initFrescoTask", "Lcom/avito/android/app/task/SubscribeToForegroundStateTask;", "subscribeToForegroundStateTask", "Lcom/avito/android/app/task/ConveyorConfigurationTask;", "conveyorConfigurationTask", "Lcom/avito/android/app/task/SetupNotificationChannelsTask;", "setupNotificationChannelsTask", "Lcom/avito/android/app/task/ActivityListenerTask;", "activityListenerTask", "Lcom/avito/android/app/task/ShortcutsTask;", "shortcutsTask", "darkThemeTask", "Lcom/avito/android/app/task/GlobalAnimationsStateTask;", "globalAnimationsTask", "", "Lcom/avito/android/app/task/ApplicationBlockingStartupTask;", "provideBlockingTasks", "(Lcom/avito/android/app/task/InitRxTask;Lcom/avito/android/app/task/SetDefaultLocaleTask;Lcom/avito/android/app/task/InitFrescoTask;Lcom/avito/android/app/task/SubscribeToForegroundStateTask;Lcom/avito/android/app/task/ConveyorConfigurationTask;Lcom/avito/android/app/task/SetupNotificationChannelsTask;Lcom/avito/android/app/task/ActivityListenerTask;Lcom/avito/android/app/task/ShortcutsTask;Lcom/avito/android/app/task/DarkThemeTask;Lcom/avito/android/app/task/GlobalAnimationsStateTask;)Ljava/util/Set;", "Ldagger/Lazy;", "Lcom/avito/android/app/task/CheckRequestTask;", "checkRequestTask", "Lcom/avito/android/app/task/FingerprintCalculationSchedulerTask;", "fingerprintCalculationSchedulerTask", "Lcom/avito/android/TypedLazy;", "Lcom/avito/android/app/task/ApplicationBackgroundStartupTask;", "provideBackgroundTasks", "(Ldagger/Lazy;Ldagger/Lazy;)Ljava/util/Set;", "", "Lcom/avito/android/app/task/ApplicationForegroundStartupTask;", "Lkotlin/jvm/JvmSuppressWildcards;", "tasks", "Lcom/avito/android/app/task/MutableApplicationStartupTasksRegistry;", "tasksRegistry", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Lcom/avito/android/analytics/Analytics;", "analytics", "provideSubscribeToForegroundStateTask", "(Ljava/util/List;Lcom/avito/android/app/task/MutableApplicationStartupTasksRegistry;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/analytics/Analytics;)Lcom/avito/android/app/task/SubscribeToForegroundStateTask;", "Lcom/avito/android/app/ActivityProvider;", GeoContract.PROVIDER, "provideActivityListenerTask", "(Lcom/avito/android/app/ActivityProvider;)Lcom/avito/android/app/task/ActivityListenerTask;", "Lcom/avito/android/service/short_task/FingerprintCalculationTask;", "fpCalculationTask", "Lcom/avito/android/service/short_task/ShortTaskExactScheduler;", "shortTaskScheduler", "provideFingerprintCalculationSchedulerTask", "(Lcom/avito/android/service/short_task/FingerprintCalculationTask;Lcom/avito/android/service/short_task/ShortTaskExactScheduler;)Lcom/avito/android/app/task/FingerprintCalculationSchedulerTask;", "provideFingerprintCalculationTask", "()Lcom/avito/android/service/short_task/FingerprintCalculationTask;", "taskScheduler", "providePinCertificateTask", "(Lcom/avito/android/service/short_task/ShortTaskExactScheduler;)Lcom/avito/android/app/task/CheckRequestTask;", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/connection_quality/BandwidthSamplerRequestListener;", "requestListener", "Lcom/avito/android/image_loader/fresco/FrescoMemoryTrimmableRegistry;", "trimmableRegistry", "Lcom/avito/android/util/ForegroundStatusCallbacks;", "callbacks", "Lcom/facebook/imagepipeline/backends/okhttp3/OkHttpNetworkFetcher;", "networkFetcher", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/analytics/task/StartupAnalyticsTracker;", "tracker", "provideInitFrescoTask", "(Lcom/avito/android/util/BuildInfo;Lcom/avito/android/connection_quality/BandwidthSamplerRequestListener;Lcom/avito/android/image_loader/fresco/FrescoMemoryTrimmableRegistry;Lcom/avito/android/util/ForegroundStatusCallbacks;Lcom/facebook/imagepipeline/backends/okhttp3/OkHttpNetworkFetcher;Lcom/avito/android/Features;Lcom/avito/android/analytics/task/StartupAnalyticsTracker;)Lcom/avito/android/app/task/InitFrescoTask;", "Lcom/avito/android/util/ShortcutManagerFactory;", "shortcutManagerFactory", "Lcom/avito/android/util/ShortcutInfoFactory;", "shortcutInfoFactory", "Lcom/avito/android/ab_tests/configs/UserAdvertsTabTestGroup;", "tabTestGroup", "provideShortcutsTask", "(Lcom/avito/android/util/BuildInfo;Lcom/avito/android/util/ShortcutManagerFactory;Lcom/avito/android/util/ShortcutInfoFactory;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/ab_tests/configs/UserAdvertsTabTestGroup;)Lcom/avito/android/app/task/ShortcutsTask;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "provideShortcutManagerFactory", "(Landroid/app/Application;)Lcom/avito/android/util/ShortcutManagerFactory;", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "provideShortcutInfoFactory", "(Lcom/avito/android/ActivityIntentFactory;)Lcom/avito/android/util/ShortcutInfoFactory;", "provideForegroundStatusCallbacks", "()Lcom/avito/android/util/ForegroundStatusCallbacks;", "Lcom/avito/android/connection_quality/BandwidthSampler;", "sampler", "provideBandwidthSamplerRequestListener", "(Lcom/avito/android/connection_quality/BandwidthSampler;)Lcom/avito/android/connection_quality/BandwidthSamplerRequestListener;", "Lokhttp3/OkHttpClient;", "httpClient", "provideOkHttpNetworkFetcher", "(Lokhttp3/OkHttpClient;)Lcom/facebook/imagepipeline/backends/okhttp3/OkHttpNetworkFetcher;", "provideFrescoMemoryTrimmableRegistry$application_release", "()Lcom/avito/android/image_loader/fresco/FrescoMemoryTrimmableRegistry;", "provideFrescoMemoryTrimmableRegistry", "<init>", "()V", "Bindings", "application_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Bindings.class})
public final class CoreTasksModule {
    @NotNull
    public static final CoreTasksModule INSTANCE = new CoreTasksModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/di/module/CoreTasksModule$Bindings;", "", "Lcom/avito/android/analytics/task/StartupAnalyticsTrackerImpl;", "tracker", "Lcom/avito/android/analytics/task/StartupAnalyticsTracker;", "provideStartupAnalyticsTracker", "(Lcom/avito/android/analytics/task/StartupAnalyticsTrackerImpl;)Lcom/avito/android/analytics/task/StartupAnalyticsTracker;", "Lcom/avito/android/enabler/FetchRemoteTogglesStartUpTask;", "task", "Lcom/avito/android/app/task/ApplicationForegroundStartupTask;", "bindFetchRemoteTogglesStartUpTask", "(Lcom/avito/android/enabler/FetchRemoteTogglesStartUpTask;)Lcom/avito/android/app/task/ApplicationForegroundStartupTask;", "application_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Bindings {
        @Binds
        @IntoSet
        @NotNull
        ApplicationForegroundStartupTask bindFetchRemoteTogglesStartUpTask(@NotNull FetchRemoteTogglesStartUpTask fetchRemoteTogglesStartUpTask);

        @PerApplication
        @Binds
        @NotNull
        StartupAnalyticsTracker provideStartupAnalyticsTracker(@NotNull StartupAnalyticsTrackerImpl startupAnalyticsTrackerImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final DarkThemeTask provideDarkThemeTask(@NotNull DarkThemeManager darkThemeManager, @NotNull DarkThemeConfig darkThemeConfig) {
        Intrinsics.checkNotNullParameter(darkThemeManager, "darkThemeManager");
        Intrinsics.checkNotNullParameter(darkThemeConfig, "darkThemeConfig");
        return new DarkThemeTask(darkThemeManager, darkThemeConfig);
    }

    @Provides
    @NotNull
    public final ActivityListenerTask provideActivityListenerTask(@NotNull ActivityProvider activityProvider) {
        Intrinsics.checkNotNullParameter(activityProvider, GeoContract.PROVIDER);
        return new ActivityListenerTask(activityProvider);
    }

    @Provides
    @ElementsIntoSet
    @NotNull
    public final Set<TypedLazy<? extends ApplicationBackgroundStartupTask>> provideBackgroundTasks(@NotNull Lazy<CheckRequestTask> lazy, @NotNull Lazy<FingerprintCalculationSchedulerTask> lazy2) {
        Intrinsics.checkNotNullParameter(lazy, "checkRequestTask");
        Intrinsics.checkNotNullParameter(lazy2, "fingerprintCalculationSchedulerTask");
        return y.setOf((Object[]) new TypedLazy[]{new TypedLazy(CheckRequestTask.class, lazy), new TypedLazy(FingerprintCalculationSchedulerTask.class, lazy2)});
    }

    @Provides
    @NotNull
    public final BandwidthSamplerRequestListener provideBandwidthSamplerRequestListener(@NotNull BandwidthSampler bandwidthSampler) {
        Intrinsics.checkNotNullParameter(bandwidthSampler, "sampler");
        return new BandwidthSamplerRequestListener(bandwidthSampler);
    }

    @Provides
    @ElementsIntoSet
    @NotNull
    public final Set<ApplicationBlockingStartupTask> provideBlockingTasks(@NotNull InitRxTask initRxTask, @NotNull SetDefaultLocaleTask setDefaultLocaleTask, @NotNull InitFrescoTask initFrescoTask, @NotNull SubscribeToForegroundStateTask subscribeToForegroundStateTask, @NotNull ConveyorConfigurationTask conveyorConfigurationTask, @NotNull SetupNotificationChannelsTask setupNotificationChannelsTask, @NotNull ActivityListenerTask activityListenerTask, @Nullable ShortcutsTask shortcutsTask, @NotNull DarkThemeTask darkThemeTask, @NotNull GlobalAnimationsStateTask globalAnimationsStateTask) {
        Intrinsics.checkNotNullParameter(initRxTask, "initRxTask");
        Intrinsics.checkNotNullParameter(setDefaultLocaleTask, "setDefaultLocaleTask");
        Intrinsics.checkNotNullParameter(initFrescoTask, "initFrescoTask");
        Intrinsics.checkNotNullParameter(subscribeToForegroundStateTask, "subscribeToForegroundStateTask");
        Intrinsics.checkNotNullParameter(conveyorConfigurationTask, "conveyorConfigurationTask");
        Intrinsics.checkNotNullParameter(setupNotificationChannelsTask, "setupNotificationChannelsTask");
        Intrinsics.checkNotNullParameter(activityListenerTask, "activityListenerTask");
        Intrinsics.checkNotNullParameter(darkThemeTask, "darkThemeTask");
        Intrinsics.checkNotNullParameter(globalAnimationsStateTask, "globalAnimationsTask");
        Set<ApplicationBlockingStartupTask> mutableSetOf = y.mutableSetOf(initRxTask, setDefaultLocaleTask, initFrescoTask, conveyorConfigurationTask, setupNotificationChannelsTask, subscribeToForegroundStateTask, activityListenerTask, darkThemeTask, globalAnimationsStateTask);
        if (shortcutsTask != null) {
            mutableSetOf.add(shortcutsTask);
        }
        return mutableSetOf;
    }

    @Provides
    @NotNull
    public final FingerprintCalculationSchedulerTask provideFingerprintCalculationSchedulerTask(@NotNull FingerprintCalculationTask fingerprintCalculationTask, @NotNull ShortTaskExactScheduler shortTaskExactScheduler) {
        Intrinsics.checkNotNullParameter(fingerprintCalculationTask, "fpCalculationTask");
        Intrinsics.checkNotNullParameter(shortTaskExactScheduler, "shortTaskScheduler");
        return new FingerprintCalculationSchedulerTask(fingerprintCalculationTask, shortTaskExactScheduler);
    }

    @Provides
    @NotNull
    public final FingerprintCalculationTask provideFingerprintCalculationTask() {
        return new FingerprintCalculationTask();
    }

    @Provides
    @NotNull
    public final ForegroundStatusCallbacks provideForegroundStatusCallbacks() {
        return new ForegroundStatusCallbacksImpl(null, 1, null);
    }

    @Provides
    @NotNull
    public final FrescoMemoryTrimmableRegistry provideFrescoMemoryTrimmableRegistry$application_release() {
        return new FrescoMemoryTrimmableRegistry();
    }

    @Provides
    @NotNull
    public final InitFrescoTask provideInitFrescoTask(@NotNull BuildInfo buildInfo, @NotNull BandwidthSamplerRequestListener bandwidthSamplerRequestListener, @NotNull FrescoMemoryTrimmableRegistry frescoMemoryTrimmableRegistry, @NotNull ForegroundStatusCallbacks foregroundStatusCallbacks, @NotNull OkHttpNetworkFetcher okHttpNetworkFetcher, @NotNull Features features, @NotNull StartupAnalyticsTracker startupAnalyticsTracker) {
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(bandwidthSamplerRequestListener, "requestListener");
        Intrinsics.checkNotNullParameter(frescoMemoryTrimmableRegistry, "trimmableRegistry");
        Intrinsics.checkNotNullParameter(foregroundStatusCallbacks, "callbacks");
        Intrinsics.checkNotNullParameter(okHttpNetworkFetcher, "networkFetcher");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(startupAnalyticsTracker, "tracker");
        return new InitFrescoTask(buildInfo, bandwidthSamplerRequestListener, frescoMemoryTrimmableRegistry, foregroundStatusCallbacks, okHttpNetworkFetcher, features, startupAnalyticsTracker);
    }

    @PerApplication
    @Provides
    @NotNull
    public final OkHttpNetworkFetcher provideOkHttpNetworkFetcher(@HttpClientModule.FrescoClient @NotNull OkHttpClient okHttpClient) {
        Intrinsics.checkNotNullParameter(okHttpClient, "httpClient");
        return new OkHttpNetworkFetcher(okHttpClient);
    }

    @Provides
    @NotNull
    public final CheckRequestTask providePinCertificateTask(@NotNull ShortTaskExactScheduler shortTaskExactScheduler) {
        Intrinsics.checkNotNullParameter(shortTaskExactScheduler, "taskScheduler");
        return new CheckRequestTask(new TimeRequestTask(), shortTaskExactScheduler);
    }

    @Provides
    @NotNull
    public final ShortcutInfoFactory provideShortcutInfoFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
        return new ShortcutInfoFactoryImpl(activityIntentFactory);
    }

    @Provides
    @NotNull
    public final ShortcutManagerFactory provideShortcutManagerFactory(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        return new ShortcutManagerFactoryImpl(application);
    }

    @Provides
    @Nullable
    public final ShortcutsTask provideShortcutsTask(@NotNull BuildInfo buildInfo, @NotNull ShortcutManagerFactory shortcutManagerFactory, @NotNull ShortcutInfoFactory shortcutInfoFactory, @NotNull Analytics analytics, @NotNull UserAdvertsTabTestGroup userAdvertsTabTestGroup) {
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(shortcutManagerFactory, "shortcutManagerFactory");
        Intrinsics.checkNotNullParameter(shortcutInfoFactory, "shortcutInfoFactory");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(userAdvertsTabTestGroup, "tabTestGroup");
        if (buildInfo.getSdkVersion() < 25) {
            return null;
        }
        return new ShortcutsTask(shortcutManagerFactory.createShortcutManager(), shortcutInfoFactory, analytics, userAdvertsTabTestGroup);
    }

    @Provides
    @NotNull
    public final SubscribeToForegroundStateTask provideSubscribeToForegroundStateTask(@NotNull List<ApplicationForegroundStartupTask> list, @NotNull MutableApplicationStartupTasksRegistry mutableApplicationStartupTasksRegistry, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(list, "tasks");
        Intrinsics.checkNotNullParameter(mutableApplicationStartupTasksRegistry, "tasksRegistry");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        LifecycleOwner lifecycleOwner = ProcessLifecycleOwner.get();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "ProcessLifecycleOwner.get()");
        return new SubscribeToForegroundStateTask(lifecycleOwner, list, mutableApplicationStartupTasksRegistry, schedulersFactory3, analytics);
    }
}
