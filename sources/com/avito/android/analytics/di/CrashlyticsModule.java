package com.avito.android.analytics.di;

import com.avito.android.analytics.EventObserver;
import com.avito.android.analytics.provider.crashlytics.CrashRecorder;
import com.avito.android.analytics.provider.crashlytics.CrashRecorderImpl;
import com.avito.android.analytics.provider.crashlytics.FirebaseCrashlytics;
import com.avito.android.analytics.provider.crashlytics.FirebaseCrashlyticsEventObserver;
import com.avito.android.analytics.provider.crashlytics.FirebaseCrashlyticsEventTracker;
import com.avito.android.analytics.provider.crashlytics.FirebaseCrashlyticsEventTrackerImpl;
import com.avito.android.analytics.provider.crashlytics.FirebaseCrashlyticsImpl;
import com.avito.android.analytics.provider.crashlytics.LogBufferCrashHandler;
import com.avito.android.analytics.provider.crashlytics.LogBufferProvider;
import com.avito.android.analytics.provider.crashlytics.TimberBufferingTree;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import java.lang.Thread;
import javax.inject.Singleton;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b*\u0010+J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H!¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH!¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH!¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H!¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH!¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010#\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u001aH!¢\u0006\u0004\b!\u0010\"J\u0017\u0010)\u001a\u00020&2\u0006\u0010%\u001a\u00020$H!¢\u0006\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lcom/avito/android/analytics/di/CrashlyticsModule;", "", "Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlyticsImpl;", "crashlytics", "Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlytics;", "bindCrashlytics$analytics_firebase_crashlytics_release", "(Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlyticsImpl;)Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlytics;", "bindCrashlytics", "Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlyticsEventObserver;", "crashlyticsEventObserver", "Lcom/avito/android/analytics/EventObserver;", "bindCrashlyticsEventObserver$analytics_firebase_crashlytics_release", "(Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlyticsEventObserver;)Lcom/avito/android/analytics/EventObserver;", "bindCrashlyticsEventObserver", "Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlyticsEventTrackerImpl;", "crashlyticsEventTracker", "Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlyticsEventTracker;", "bindCrashlyticsEventTracker$analytics_firebase_crashlytics_release", "(Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlyticsEventTrackerImpl;)Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlyticsEventTracker;", "bindCrashlyticsEventTracker", "Lcom/avito/android/analytics/provider/crashlytics/LogBufferCrashHandler;", "logBufferCrashHandler", "Ljava/lang/Thread$UncaughtExceptionHandler;", "bindUncaughtExceptionHandler$analytics_firebase_crashlytics_release", "(Lcom/avito/android/analytics/provider/crashlytics/LogBufferCrashHandler;)Ljava/lang/Thread$UncaughtExceptionHandler;", "bindUncaughtExceptionHandler", "Lcom/avito/android/analytics/provider/crashlytics/TimberBufferingTree;", "timberBufferingTree", "Lcom/avito/android/analytics/provider/crashlytics/LogBufferProvider;", "bindLogBufferProvider$analytics_firebase_crashlytics_release", "(Lcom/avito/android/analytics/provider/crashlytics/TimberBufferingTree;)Lcom/avito/android/analytics/provider/crashlytics/LogBufferProvider;", "bindLogBufferProvider", "Ltimber/log/Timber$Tree;", "bindTimberBufferingTree$analytics_firebase_crashlytics_release", "(Lcom/avito/android/analytics/provider/crashlytics/TimberBufferingTree;)Ltimber/log/Timber$Tree;", "bindTimberBufferingTree", "Lcom/avito/android/analytics/provider/crashlytics/CrashRecorderImpl;", "crashRecorderImpl", "Lcom/avito/android/analytics/provider/crashlytics/CrashRecorder;", "bindCrashRecorder$analytics_firebase_crashlytics_release", "(Lcom/avito/android/analytics/provider/crashlytics/CrashRecorderImpl;)Lcom/avito/android/analytics/provider/crashlytics/CrashRecorder;", "bindCrashRecorder", "<init>", "()V", "analytics-firebase-crashlytics_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {FirebaseCrashlyticsInitialization.class})
public abstract class CrashlyticsModule {
    @Singleton
    @Binds
    @NotNull
    public abstract CrashRecorder bindCrashRecorder$analytics_firebase_crashlytics_release(@NotNull CrashRecorderImpl crashRecorderImpl);

    @Singleton
    @Binds
    @NotNull
    public abstract FirebaseCrashlytics bindCrashlytics$analytics_firebase_crashlytics_release(@NotNull FirebaseCrashlyticsImpl firebaseCrashlyticsImpl);

    @Binds
    @IntoSet
    @NotNull
    @Singleton
    public abstract EventObserver bindCrashlyticsEventObserver$analytics_firebase_crashlytics_release(@NotNull FirebaseCrashlyticsEventObserver firebaseCrashlyticsEventObserver);

    @Singleton
    @Binds
    @NotNull
    public abstract FirebaseCrashlyticsEventTracker bindCrashlyticsEventTracker$analytics_firebase_crashlytics_release(@NotNull FirebaseCrashlyticsEventTrackerImpl firebaseCrashlyticsEventTrackerImpl);

    @Singleton
    @Binds
    @NotNull
    public abstract LogBufferProvider bindLogBufferProvider$analytics_firebase_crashlytics_release(@NotNull TimberBufferingTree timberBufferingTree);

    @Singleton
    @Binds
    @NotNull
    public abstract Timber.Tree bindTimberBufferingTree$analytics_firebase_crashlytics_release(@NotNull TimberBufferingTree timberBufferingTree);

    @Singleton
    @Binds
    @NotNull
    public abstract Thread.UncaughtExceptionHandler bindUncaughtExceptionHandler$analytics_firebase_crashlytics_release(@NotNull LogBufferCrashHandler logBufferCrashHandler);
}
