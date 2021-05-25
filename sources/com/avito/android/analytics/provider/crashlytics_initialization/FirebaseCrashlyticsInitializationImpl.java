package com.avito.android.analytics.provider.crashlytics_initialization;

import a2.g.r.g;
import android.app.Application;
import com.avito.android.analytics.provider.crashlytics.AvitoCrashHandler;
import com.avito.android.analytics.provider.crashlytics.CrashRecorder;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.Logs;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.lang.Thread;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010 \u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\b\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0015¨\u0006#"}, d2 = {"Lcom/avito/android/analytics/provider/crashlytics_initialization/FirebaseCrashlyticsInitializationImpl;", "Lcom/avito/android/analytics/provider/crashlytics_initialization/FirebaseCrashlyticsInitialization;", "", "isInitialized", "()Z", "Lkotlin/Function0;", "", "onInitialized", "initialize", "(Lkotlin/jvm/functions/Function0;)V", AuthSource.SEND_ABUSE, "()V", "Lcom/avito/android/analytics/provider/crashlytics/CrashRecorder;", "d", "Lcom/avito/android/analytics/provider/crashlytics/CrashRecorder;", "crashRecorder", "Landroid/app/Application;", AuthSource.BOOKING_ORDER, "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "f", "Z", "sendErrorsAsNonFatals", "Lcom/avito/android/util/BuildInfo;", g.a, "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Ljava/lang/Thread$UncaughtExceptionHandler;", "c", "Ljava/lang/Thread$UncaughtExceptionHandler;", "logBufferCrashHandler", "e", "sendLogsOnCrash", "<init>", "(Landroid/app/Application;Ljava/lang/Thread$UncaughtExceptionHandler;Lcom/avito/android/analytics/provider/crashlytics/CrashRecorder;ZZLcom/avito/android/util/BuildInfo;)V", "analytics-firebase-crashlytics_release"}, k = 1, mv = {1, 4, 2})
public final class FirebaseCrashlyticsInitializationImpl implements FirebaseCrashlyticsInitialization {
    public volatile boolean a;
    public final Application b;
    public final Thread.UncaughtExceptionHandler c;
    public final CrashRecorder d;
    public final boolean e;
    public final boolean f;
    public final BuildInfo g;

    public FirebaseCrashlyticsInitializationImpl(@NotNull Application application, @NotNull Thread.UncaughtExceptionHandler uncaughtExceptionHandler, @NotNull CrashRecorder crashRecorder, boolean z, boolean z2, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(uncaughtExceptionHandler, "logBufferCrashHandler");
        Intrinsics.checkNotNullParameter(crashRecorder, "crashRecorder");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        this.b = application;
        this.c = uncaughtExceptionHandler;
        this.d = crashRecorder;
        this.e = z;
        this.f = z2;
        this.g = buildInfo;
    }

    public final void a() {
        FirebaseApp.initializeApp(this.b);
        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(this.f || this.g.isStaging());
        Logs.verbose$default("FabricWrapper", "Fabric (with crashlytics) initialized", null, 4, null);
        if (this.e) {
            Thread.setDefaultUncaughtExceptionHandler(new AvitoCrashHandler(Thread.getDefaultUncaughtExceptionHandler(), this.c, this.d));
            Logs.verbose$default("FabricWrapper", "Fabric log buffer reporting initialized", null, 4, null);
        }
    }

    @Override // com.avito.android.util.Initializable
    public synchronized void initialize(@Nullable Function0<Unit> function0) {
        if (!this.a) {
            a();
            this.a = true;
        }
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.avito.android.util.Initializable
    public boolean isInitialized() {
        return this.a;
    }
}
