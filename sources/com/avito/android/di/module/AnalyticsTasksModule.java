package com.avito.android.di.module;

import android.content.SharedPreferences;
import com.adjust.sdk.sig.BuildConfig;
import com.avito.android.TypedLazy;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.CrashReporter;
import com.avito.android.analytics.clickstream.ClickStreamCommonModule;
import com.avito.android.analytics.inhouse_transport.InHouseAnalyticsFlushInteractor;
import com.avito.android.analytics.inhouse_transport.InHouseAnalyticsTimer;
import com.avito.android.analytics.inhouse_transport.InHouseAnalyticsWatchDog;
import com.avito.android.analytics.provider.crashlytics.CrashRecorder;
import com.avito.android.analytics.provider.crashlytics.FirebaseCrashlytics;
import com.avito.android.analytics.provider.crashlytics_initialization.FirebaseCrashlyticsInitialization;
import com.avito.android.analytics.provider.metrica.Metrica;
import com.avito.android.analytics.statsd.StatsdCommonModule;
import com.avito.android.analytics.task.StartupAnalyticsTracker;
import com.avito.android.analytics_adjust.Adjust;
import com.avito.android.analytics_firebase.Firebase;
import com.avito.android.app.task.ActivityExitAnalyticsTask;
import com.avito.android.app.task.AnalyticsWarmUpTask;
import com.avito.android.app.task.ApplicationBackgroundStartupTask;
import com.avito.android.app.task.ApplicationBlockingStartupTask;
import com.avito.android.app.task.DeleteOldClickstreamStorageTask;
import com.avito.android.app.task.FpsMeasurerTask;
import com.avito.android.app.task.InHouseWatchDogStartupTask;
import com.avito.android.app.task.InitLogErrorsToAnalyticsTask;
import com.avito.android.app.task.RegisterAnalyticsActivityListenerTask;
import com.avito.android.app.task.ScheduleAppDataSendingTask;
import com.avito.android.app.task.ScheduleMetricSendingTask;
import com.avito.android.app.task.SendCrashRecordsToClickStreamTask;
import com.avito.android.app.task.UpdateVersionTask;
import com.avito.android.app.task.UserIdentifierAnalyticsTask;
import com.avito.android.app.task.UserKeysAnalyticsTask;
import com.avito.android.fps.FpsReporter;
import com.avito.android.fps.FramesListener;
import com.avito.android.preferences.ActivityAnalyticsStorage;
import com.avito.android.preferences.PrefActivityAnalyticsStorage;
import com.avito.android.remote.DeviceIdProvider;
import com.avito.android.service.short_task.ShortTaskExactScheduler;
import com.avito.android.service.short_task.app_update.AppUpdateTask;
import com.avito.android.service.short_task.metrics.SendMetricTask;
import com.avito.android.util.GooglePlayServicesInfo;
import com.avito.android.util.SchedulersFactory;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bk\u0010lJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J?\u0010\r\u001a\u00020\u00022\u000e\b\u0001\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0001\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0001\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007H\u0007¢\u0006\u0004\b\r\u0010\u000eJM\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJq\u0010.\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020-0,0\u001c2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u00072\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u00072\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u00072\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u00072\f\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u00072\f\u0010+\u001a\b\u0012\u0004\u0012\u00020*0\u0007H\u0007¢\u0006\u0004\b.\u0010/J\u0017\u00103\u001a\u0002022\u0006\u00101\u001a\u000200H\u0007¢\u0006\u0004\b3\u00104J\u001f\u00109\u001a\u00020 2\u0006\u00106\u001a\u0002052\u0006\u00108\u001a\u000207H\u0007¢\u0006\u0004\b9\u0010:J\u001f\u0010<\u001a\u00020\u00142\u0006\u00108\u001a\u0002072\u0006\u0010;\u001a\u000202H\u0007¢\u0006\u0004\b<\u0010=J\u001f\u0010B\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020>2\u0006\u0010A\u001a\u00020@H\u0007¢\u0006\u0004\bB\u0010CJ'\u0010J\u001a\u00020\u00182\u0006\u0010E\u001a\u00020D2\u0006\u0010G\u001a\u00020F2\u0006\u0010I\u001a\u00020HH\u0007¢\u0006\u0004\bJ\u0010KJ\u0017\u0010L\u001a\u00020*2\u0006\u0010G\u001a\u00020FH\u0007¢\u0006\u0004\bL\u0010MJ\u0017\u0010N\u001a\u00020$2\u0006\u0010G\u001a\u00020FH\u0007¢\u0006\u0004\bN\u0010OJ7\u0010W\u001a\u00020&2\u0006\u00108\u001a\u0002072\u0006\u0010Q\u001a\u00020P2\u0006\u0010S\u001a\u00020R2\u0006\u0010U\u001a\u00020T2\u0006\u0010V\u001a\u00020DH\u0007¢\u0006\u0004\bW\u0010XJ'\u0010]\u001a\u00020(2\u0006\u0010Q\u001a\u00020P2\u0006\u0010Z\u001a\u00020Y2\u0006\u0010\\\u001a\u00020[H\u0007¢\u0006\u0004\b]\u0010^JI\u0010i\u001a\u00020\u000f2\u0006\u0010`\u001a\u00020_2\b\u0010b\u001a\u0004\u0018\u00010a2\u0006\u0010Z\u001a\u00020Y2\u0006\u0010d\u001a\u00020c2\u0006\u0010E\u001a\u00020D2\u0006\u0010f\u001a\u00020e2\u0006\u0010h\u001a\u00020gH\u0007¢\u0006\u0004\bi\u0010j¨\u0006m"}, d2 = {"Lcom/avito/android/di/module/AnalyticsTasksModule;", "", "Lcom/avito/android/analytics/inhouse_transport/InHouseAnalyticsWatchDog;", "watchDog", "Lcom/avito/android/app/task/InHouseWatchDogStartupTask;", "provideStatsdWatchDogStartupTask", "(Lcom/avito/android/analytics/inhouse_transport/InHouseAnalyticsWatchDog;)Lcom/avito/android/app/task/InHouseWatchDogStartupTask;", "Ldagger/Lazy;", "Lcom/avito/android/analytics/inhouse_transport/InHouseAnalyticsFlushInteractor;", "statsd", "flushInteractor", "Lcom/avito/android/analytics/inhouse_transport/InHouseAnalyticsTimer;", "timer", "provideInHouseAnalyticsWatchDog", "(Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)Lcom/avito/android/analytics/inhouse_transport/InHouseAnalyticsWatchDog;", "Lcom/avito/android/app/task/AnalyticsWarmUpTask;", "analyticsWarmUpTask", "analyticsWatchDogStartupTask", "Lcom/avito/android/app/task/RegisterAnalyticsActivityListenerTask;", "registerAnalyticsActivityListenerTask", "Lcom/avito/android/app/task/ActivityExitAnalyticsTask;", "activityExitAnalyticsTask", "Lcom/avito/android/app/task/InitLogErrorsToAnalyticsTask;", "initLogErrorsToAnalyticsTask", "Lcom/avito/android/app/task/ScheduleMetricSendingTask;", "scheduleMetricSendingTask", "Lcom/avito/android/app/task/FpsMeasurerTask;", "fpsMeasurer", "", "Lcom/avito/android/app/task/ApplicationBlockingStartupTask;", "provideBlockingTasks", "(Lcom/avito/android/app/task/AnalyticsWarmUpTask;Lcom/avito/android/app/task/InHouseWatchDogStartupTask;Lcom/avito/android/app/task/RegisterAnalyticsActivityListenerTask;Lcom/avito/android/app/task/ActivityExitAnalyticsTask;Lcom/avito/android/app/task/InitLogErrorsToAnalyticsTask;Lcom/avito/android/app/task/ScheduleMetricSendingTask;Lcom/avito/android/app/task/FpsMeasurerTask;)Ljava/util/List;", "Lcom/avito/android/app/task/SendCrashRecordsToClickStreamTask;", "sendCrashRecordsToClickStreamTask", "Lcom/avito/android/app/task/DeleteOldClickstreamStorageTask;", "deleteOldClickstreamStorageTask", "Lcom/avito/android/app/task/UpdateVersionTask;", "updateVersionTask", "Lcom/avito/android/app/task/UserKeysAnalyticsTask;", "userKeysAnalyticsTask", "Lcom/avito/android/app/task/UserIdentifierAnalyticsTask;", "userIdentifierAnalyticsTask", "Lcom/avito/android/app/task/ScheduleAppDataSendingTask;", "sendDataSizeTask", "Lcom/avito/android/TypedLazy;", "Lcom/avito/android/app/task/ApplicationBackgroundStartupTask;", "provideBackgroundTasks", "(Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)Ljava/util/List;", "Landroid/content/SharedPreferences;", "preferences", "Lcom/avito/android/preferences/ActivityAnalyticsStorage;", "activityAnalyticsStorage", "(Landroid/content/SharedPreferences;)Lcom/avito/android/preferences/ActivityAnalyticsStorage;", "Lcom/avito/android/analytics/provider/crashlytics/CrashRecorder;", "crashRecorder", "Lcom/avito/android/analytics/Analytics;", "analytics", "provideSendCrashRecordsToClickStreamTask", "(Lcom/avito/android/analytics/provider/crashlytics/CrashRecorder;Lcom/avito/android/analytics/Analytics;)Lcom/avito/android/app/task/SendCrashRecordsToClickStreamTask;", "storage", "provideActivityExitAnalyticsTask", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/preferences/ActivityAnalyticsStorage;)Lcom/avito/android/app/task/ActivityExitAnalyticsTask;", "Lcom/avito/android/fps/FpsReporter;", "fpsReporter", "Lcom/avito/android/fps/FramesListener;", "callback", "provideFpsMeasurer", "(Lcom/avito/android/fps/FpsReporter;Lcom/avito/android/fps/FramesListener;)Lcom/avito/android/app/task/FpsMeasurerTask;", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/service/short_task/ShortTaskExactScheduler;", "taskScheduler", "Lcom/avito/android/service/short_task/metrics/SendMetricTask;", "sendTask", "provideScheduleMetricSendingTask", "(Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/service/short_task/ShortTaskExactScheduler;Lcom/avito/android/service/short_task/metrics/SendMetricTask;)Lcom/avito/android/app/task/ScheduleMetricSendingTask;", "provideScheduleAppDataSendingTask", "(Lcom/avito/android/service/short_task/ShortTaskExactScheduler;)Lcom/avito/android/app/task/ScheduleAppDataSendingTask;", "provideUpdateVersionTask", "(Lcom/avito/android/service/short_task/ShortTaskExactScheduler;)Lcom/avito/android/app/task/UpdateVersionTask;", "Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlytics;", "crashlytics", "Lcom/avito/android/remote/DeviceIdProvider;", "deviceIdProvider", "Lcom/avito/android/util/GooglePlayServicesInfo;", "googlePlayServicesInfo", "schedulers", "provideUserKeysAnalyticsTask", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlytics;Lcom/avito/android/remote/DeviceIdProvider;Lcom/avito/android/util/GooglePlayServicesInfo;Lcom/avito/android/util/SchedulersFactory;)Lcom/avito/android/app/task/UserKeysAnalyticsTask;", "Lcom/avito/android/analytics_adjust/Adjust;", BuildConfig.FLAVOR, "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "provideUserIdentifierAnalyticsTask", "(Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlytics;Lcom/avito/android/analytics_adjust/Adjust;Lcom/avito/android/account/AccountStateProvider;)Lcom/avito/android/app/task/UserIdentifierAnalyticsTask;", "Lcom/avito/android/analytics/provider/crashlytics_initialization/FirebaseCrashlyticsInitialization;", "firebaseCrashlyticsInitialization", "Lcom/avito/android/analytics/provider/metrica/Metrica;", "metrica", "Lcom/avito/android/analytics_firebase/Firebase;", "firebase", "Lcom/avito/android/analytics/task/StartupAnalyticsTracker;", "tracker", "Lcom/avito/android/analytics/CrashReporter;", "crashReporter", "provideAnalyticsWarmUpTask", "(Lcom/avito/android/analytics/provider/crashlytics_initialization/FirebaseCrashlyticsInitialization;Lcom/avito/android/analytics/provider/metrica/Metrica;Lcom/avito/android/analytics_adjust/Adjust;Lcom/avito/android/analytics_firebase/Firebase;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/analytics/task/StartupAnalyticsTracker;Lcom/avito/android/analytics/CrashReporter;)Lcom/avito/android/app/task/AnalyticsWarmUpTask;", "<init>", "()V", "application_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {GooglePlayServicesInfoModule.class, SendMetricsModule.class})
public final class AnalyticsTasksModule {
    @NotNull
    public static final AnalyticsTasksModule INSTANCE = new AnalyticsTasksModule();

    @Provides
    @JvmStatic
    @NotNull
    public static final InHouseAnalyticsWatchDog provideInHouseAnalyticsWatchDog(@StatsdCommonModule.Statsd @NotNull Lazy<InHouseAnalyticsFlushInteractor> lazy, @ClickStreamCommonModule.ClickStream @NotNull Lazy<InHouseAnalyticsFlushInteractor> lazy2, @ClickStreamCommonModule.ClickStream @NotNull Lazy<InHouseAnalyticsTimer> lazy3) {
        Intrinsics.checkNotNullParameter(lazy, "statsd");
        Intrinsics.checkNotNullParameter(lazy2, "flushInteractor");
        Intrinsics.checkNotNullParameter(lazy3, "timer");
        return new InHouseAnalyticsWatchDog(CollectionsKt__CollectionsKt.listOf((Object[]) new Lazy[]{lazy, lazy2}), lazy3);
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final InHouseWatchDogStartupTask provideStatsdWatchDogStartupTask(@NotNull InHouseAnalyticsWatchDog inHouseAnalyticsWatchDog) {
        Intrinsics.checkNotNullParameter(inHouseAnalyticsWatchDog, "watchDog");
        return new InHouseWatchDogStartupTask(inHouseAnalyticsWatchDog);
    }

    @Provides
    @NotNull
    public final ActivityAnalyticsStorage activityAnalyticsStorage(@NotNull SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "preferences");
        return new PrefActivityAnalyticsStorage(sharedPreferences);
    }

    @Provides
    @NotNull
    public final ActivityExitAnalyticsTask provideActivityExitAnalyticsTask(@NotNull Analytics analytics, @NotNull ActivityAnalyticsStorage activityAnalyticsStorage) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(activityAnalyticsStorage, "storage");
        return new ActivityExitAnalyticsTask(analytics, activityAnalyticsStorage);
    }

    @Provides
    @NotNull
    public final AnalyticsWarmUpTask provideAnalyticsWarmUpTask(@NotNull FirebaseCrashlyticsInitialization firebaseCrashlyticsInitialization, @Nullable Metrica metrica, @NotNull Adjust adjust, @NotNull Firebase firebase, @NotNull SchedulersFactory schedulersFactory, @NotNull StartupAnalyticsTracker startupAnalyticsTracker, @NotNull CrashReporter crashReporter) {
        Intrinsics.checkNotNullParameter(firebaseCrashlyticsInitialization, "firebaseCrashlyticsInitialization");
        Intrinsics.checkNotNullParameter(adjust, BuildConfig.FLAVOR);
        Intrinsics.checkNotNullParameter(firebase, "firebase");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(startupAnalyticsTracker, "tracker");
        Intrinsics.checkNotNullParameter(crashReporter, "crashReporter");
        return new AnalyticsWarmUpTask(firebaseCrashlyticsInitialization, metrica, adjust, firebase, schedulersFactory, startupAnalyticsTracker, crashReporter);
    }

    @Provides
    @AnalyticsTasks
    @NotNull
    public final List<TypedLazy<? extends ApplicationBackgroundStartupTask>> provideBackgroundTasks(@NotNull Lazy<SendCrashRecordsToClickStreamTask> lazy, @NotNull Lazy<DeleteOldClickstreamStorageTask> lazy2, @NotNull Lazy<UpdateVersionTask> lazy3, @NotNull Lazy<UserKeysAnalyticsTask> lazy4, @NotNull Lazy<UserIdentifierAnalyticsTask> lazy5, @NotNull Lazy<ScheduleAppDataSendingTask> lazy6) {
        Intrinsics.checkNotNullParameter(lazy, "sendCrashRecordsToClickStreamTask");
        Intrinsics.checkNotNullParameter(lazy2, "deleteOldClickstreamStorageTask");
        Intrinsics.checkNotNullParameter(lazy3, "updateVersionTask");
        Intrinsics.checkNotNullParameter(lazy4, "userKeysAnalyticsTask");
        Intrinsics.checkNotNullParameter(lazy5, "userIdentifierAnalyticsTask");
        Intrinsics.checkNotNullParameter(lazy6, "sendDataSizeTask");
        return CollectionsKt__CollectionsKt.listOf((Object[]) new TypedLazy[]{new TypedLazy(SendCrashRecordsToClickStreamTask.class, lazy), new TypedLazy(DeleteOldClickstreamStorageTask.class, lazy2), new TypedLazy(UpdateVersionTask.class, lazy3), new TypedLazy(UserKeysAnalyticsTask.class, lazy4), new TypedLazy(UserIdentifierAnalyticsTask.class, lazy5), new TypedLazy(ScheduleAppDataSendingTask.class, lazy6)});
    }

    @Provides
    @AnalyticsTasks
    @NotNull
    public final List<ApplicationBlockingStartupTask> provideBlockingTasks(@NotNull AnalyticsWarmUpTask analyticsWarmUpTask, @NotNull InHouseWatchDogStartupTask inHouseWatchDogStartupTask, @NotNull RegisterAnalyticsActivityListenerTask registerAnalyticsActivityListenerTask, @NotNull ActivityExitAnalyticsTask activityExitAnalyticsTask, @NotNull InitLogErrorsToAnalyticsTask initLogErrorsToAnalyticsTask, @NotNull ScheduleMetricSendingTask scheduleMetricSendingTask, @NotNull FpsMeasurerTask fpsMeasurerTask) {
        Intrinsics.checkNotNullParameter(analyticsWarmUpTask, "analyticsWarmUpTask");
        Intrinsics.checkNotNullParameter(inHouseWatchDogStartupTask, "analyticsWatchDogStartupTask");
        Intrinsics.checkNotNullParameter(registerAnalyticsActivityListenerTask, "registerAnalyticsActivityListenerTask");
        Intrinsics.checkNotNullParameter(activityExitAnalyticsTask, "activityExitAnalyticsTask");
        Intrinsics.checkNotNullParameter(initLogErrorsToAnalyticsTask, "initLogErrorsToAnalyticsTask");
        Intrinsics.checkNotNullParameter(scheduleMetricSendingTask, "scheduleMetricSendingTask");
        Intrinsics.checkNotNullParameter(fpsMeasurerTask, "fpsMeasurer");
        return CollectionsKt__CollectionsKt.listOf((Object[]) new ApplicationBlockingStartupTask[]{analyticsWarmUpTask, inHouseWatchDogStartupTask, registerAnalyticsActivityListenerTask, activityExitAnalyticsTask, initLogErrorsToAnalyticsTask, scheduleMetricSendingTask, fpsMeasurerTask});
    }

    @Provides
    @NotNull
    public final FpsMeasurerTask provideFpsMeasurer(@NotNull FpsReporter fpsReporter, @NotNull FramesListener framesListener) {
        Intrinsics.checkNotNullParameter(fpsReporter, "fpsReporter");
        Intrinsics.checkNotNullParameter(framesListener, "callback");
        return new FpsMeasurerTask(fpsReporter, framesListener);
    }

    @Provides
    @NotNull
    public final ScheduleAppDataSendingTask provideScheduleAppDataSendingTask(@NotNull ShortTaskExactScheduler shortTaskExactScheduler) {
        Intrinsics.checkNotNullParameter(shortTaskExactScheduler, "taskScheduler");
        return new ScheduleAppDataSendingTask(shortTaskExactScheduler);
    }

    @Provides
    @NotNull
    public final ScheduleMetricSendingTask provideScheduleMetricSendingTask(@NotNull SchedulersFactory schedulersFactory, @NotNull ShortTaskExactScheduler shortTaskExactScheduler, @NotNull SendMetricTask sendMetricTask) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(shortTaskExactScheduler, "taskScheduler");
        Intrinsics.checkNotNullParameter(sendMetricTask, "sendTask");
        return new ScheduleMetricSendingTask(sendMetricTask, schedulersFactory, shortTaskExactScheduler);
    }

    @Provides
    @NotNull
    public final SendCrashRecordsToClickStreamTask provideSendCrashRecordsToClickStreamTask(@NotNull CrashRecorder crashRecorder, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(crashRecorder, "crashRecorder");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        return new SendCrashRecordsToClickStreamTask(crashRecorder, analytics);
    }

    @Provides
    @NotNull
    public final UpdateVersionTask provideUpdateVersionTask(@NotNull ShortTaskExactScheduler shortTaskExactScheduler) {
        Intrinsics.checkNotNullParameter(shortTaskExactScheduler, "taskScheduler");
        return new UpdateVersionTask(new AppUpdateTask(), shortTaskExactScheduler);
    }

    @Provides
    @NotNull
    public final UserIdentifierAnalyticsTask provideUserIdentifierAnalyticsTask(@NotNull FirebaseCrashlytics firebaseCrashlytics, @NotNull Adjust adjust, @NotNull AccountStateProvider accountStateProvider) {
        Intrinsics.checkNotNullParameter(firebaseCrashlytics, "crashlytics");
        Intrinsics.checkNotNullParameter(adjust, BuildConfig.FLAVOR);
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        return new UserIdentifierAnalyticsTask(firebaseCrashlytics, adjust, accountStateProvider);
    }

    @Provides
    @NotNull
    public final UserKeysAnalyticsTask provideUserKeysAnalyticsTask(@NotNull Analytics analytics, @NotNull FirebaseCrashlytics firebaseCrashlytics, @NotNull DeviceIdProvider deviceIdProvider, @NotNull GooglePlayServicesInfo googlePlayServicesInfo, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(firebaseCrashlytics, "crashlytics");
        Intrinsics.checkNotNullParameter(deviceIdProvider, "deviceIdProvider");
        Intrinsics.checkNotNullParameter(googlePlayServicesInfo, "googlePlayServicesInfo");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        return new UserKeysAnalyticsTask(analytics, firebaseCrashlytics, deviceIdProvider, googlePlayServicesInfo, schedulersFactory);
    }
}
