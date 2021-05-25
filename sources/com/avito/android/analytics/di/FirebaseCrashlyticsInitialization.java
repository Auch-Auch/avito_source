package com.avito.android.analytics.di;

import android.app.Application;
import com.avito.android.Features;
import com.avito.android.analytics.provider.crashlytics.CrashRecorder;
import com.avito.android.analytics.provider.crashlytics_initialization.FirebaseCrashlyticsInitializationImpl;
import com.avito.android.util.BuildInfo;
import com.google.android.exoplayer2.util.MimeTypes;
import dagger.Module;
import dagger.Provides;
import java.lang.Thread;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J7\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/avito/android/analytics/di/FirebaseCrashlyticsInitialization;", "", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Ljava/lang/Thread$UncaughtExceptionHandler;", "logBufferCrashHandler", "Lcom/avito/android/analytics/provider/crashlytics/CrashRecorder;", "crashRecorder", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/analytics/provider/crashlytics_initialization/FirebaseCrashlyticsInitialization;", "provideFirebaseCrashlyticsInitialization", "(Landroid/app/Application;Ljava/lang/Thread$UncaughtExceptionHandler;Lcom/avito/android/analytics/provider/crashlytics/CrashRecorder;Lcom/avito/android/Features;Lcom/avito/android/util/BuildInfo;)Lcom/avito/android/analytics/provider/crashlytics_initialization/FirebaseCrashlyticsInitialization;", "<init>", "()V", "analytics-firebase-crashlytics_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class FirebaseCrashlyticsInitialization {
    @NotNull
    public static final FirebaseCrashlyticsInitialization INSTANCE = new FirebaseCrashlyticsInitialization();

    @Provides
    @Singleton
    @NotNull
    public final com.avito.android.analytics.provider.crashlytics_initialization.FirebaseCrashlyticsInitialization provideFirebaseCrashlyticsInitialization(@NotNull Application application, @NotNull Thread.UncaughtExceptionHandler uncaughtExceptionHandler, @NotNull CrashRecorder crashRecorder, @NotNull Features features, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(uncaughtExceptionHandler, "logBufferCrashHandler");
        Intrinsics.checkNotNullParameter(crashRecorder, "crashRecorder");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        return new FirebaseCrashlyticsInitializationImpl(application, uncaughtExceptionHandler, crashRecorder, features.getSendLogsOnCrash().invoke().booleanValue(), features.getSendErrorsAsNonFatals().invoke().booleanValue(), buildInfo);
    }
}
