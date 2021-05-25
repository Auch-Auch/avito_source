package com.avito.android.app.task;

import android.app.Application;
import com.adjust.sdk.sig.BuildConfig;
import com.avito.android.analytics.CrashReporter;
import com.avito.android.analytics.provider.crashlytics_initialization.FirebaseCrashlyticsInitialization;
import com.avito.android.analytics.provider.metrica.Metrica;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.task.StartupAnalyticsTracker;
import com.avito.android.analytics.task.StartupAnalyticsTrackerKt;
import com.avito.android.analytics_adjust.Adjust;
import com.avito.android.analytics_firebase.Firebase;
import com.avito.android.app.task.ApplicationBlockingStartupTask;
import com.avito.android.app.task.ApplicationStartupTask;
import com.avito.android.util.Completables;
import com.avito.android.util.Initializable;
import com.avito.android.util.SchedulersFactory;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.firebase.messaging.Constants;
import io.reactivex.Completable;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b!\u0010\"J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u00020\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/avito/android/app/task/AnalyticsWarmUpTask;", "Lcom/avito/android/app/task/ApplicationBlockingStartupTask;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "execute", "(Landroid/app/Application;)Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "Lcom/avito/android/analytics/task/StartupAnalyticsTracker;", "tracker", "Lcom/avito/android/analytics/task/StartupAnalyticsTracker;", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/util/SchedulersFactory;", "Lcom/avito/android/app/task/ApplicationBlockingStartupTask$Priority;", Constants.FirelogAnalytics.PARAM_PRIORITY, "Lcom/avito/android/app/task/ApplicationBlockingStartupTask$Priority;", "getPriority", "()Lcom/avito/android/app/task/ApplicationBlockingStartupTask$Priority;", "Lcom/avito/android/analytics/provider/crashlytics_initialization/FirebaseCrashlyticsInitialization;", "firebaseCrashlyticsInitialization", "Lcom/avito/android/analytics/provider/crashlytics_initialization/FirebaseCrashlyticsInitialization;", "Lcom/avito/android/analytics_firebase/Firebase;", "firebase", "Lcom/avito/android/analytics_firebase/Firebase;", "Lcom/avito/android/analytics/CrashReporter;", "crashReporter", "Lcom/avito/android/analytics/CrashReporter;", "Lcom/avito/android/analytics/provider/metrica/Metrica;", "metrica", "Lcom/avito/android/analytics/provider/metrica/Metrica;", "Lcom/avito/android/analytics_adjust/Adjust;", BuildConfig.FLAVOR, "Lcom/avito/android/analytics_adjust/Adjust;", "<init>", "(Lcom/avito/android/analytics/provider/crashlytics_initialization/FirebaseCrashlyticsInitialization;Lcom/avito/android/analytics/provider/metrica/Metrica;Lcom/avito/android/analytics_adjust/Adjust;Lcom/avito/android/analytics_firebase/Firebase;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/analytics/task/StartupAnalyticsTracker;Lcom/avito/android/analytics/CrashReporter;)V", "application_release"}, k = 1, mv = {1, 4, 2})
public final class AnalyticsWarmUpTask implements ApplicationBlockingStartupTask {
    public final Adjust adjust;
    public final CrashReporter crashReporter;
    public final Firebase firebase;
    public final FirebaseCrashlyticsInitialization firebaseCrashlyticsInitialization;
    public final Metrica metrica;
    @NotNull
    public final ApplicationBlockingStartupTask.Priority priority = ApplicationBlockingStartupTask.Priority.CRITICAL;
    public final SchedulersFactory schedulers;
    public final StartupAnalyticsTracker tracker;

    public static final class a<V> implements Callable<Object> {
        public final /* synthetic */ AnalyticsWarmUpTask a;

        public a(AnalyticsWarmUpTask analyticsWarmUpTask) {
            this.a = analyticsWarmUpTask;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            Initializable.DefaultImpls.initialize$default(this.a.adjust, null, 1, null);
            Metrica metrica = this.a.metrica;
            if (metrica != null) {
                Initializable.DefaultImpls.initialize$default(metrica, null, 1, null);
            }
            Initializable.DefaultImpls.initialize$default(this.a.crashReporter, null, 1, null);
            return Unit.INSTANCE;
        }
    }

    public AnalyticsWarmUpTask(@NotNull FirebaseCrashlyticsInitialization firebaseCrashlyticsInitialization2, @Nullable Metrica metrica2, @NotNull Adjust adjust2, @NotNull Firebase firebase2, @NotNull SchedulersFactory schedulersFactory, @NotNull StartupAnalyticsTracker startupAnalyticsTracker, @NotNull CrashReporter crashReporter2) {
        Intrinsics.checkNotNullParameter(firebaseCrashlyticsInitialization2, "firebaseCrashlyticsInitialization");
        Intrinsics.checkNotNullParameter(adjust2, BuildConfig.FLAVOR);
        Intrinsics.checkNotNullParameter(firebase2, "firebase");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(startupAnalyticsTracker, "tracker");
        Intrinsics.checkNotNullParameter(crashReporter2, "crashReporter");
        this.firebaseCrashlyticsInitialization = firebaseCrashlyticsInitialization2;
        this.metrica = metrica2;
        this.adjust = adjust2;
        this.firebase = firebase2;
        this.schedulers = schedulersFactory;
        this.tracker = startupAnalyticsTracker;
        this.crashReporter = crashReporter2;
    }

    @Override // com.avito.android.app.task.ApplicationBlockingStartupTask
    @NotNull
    public ApplicationStartupTask.ExecutionResult execute(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Timer timer = new TimerFactory().timer();
        timer.start();
        Initializable.DefaultImpls.initialize$default(this.firebaseCrashlyticsInitialization, null, 1, null);
        this.tracker.track(StartupAnalyticsTrackerKt.FABRIC, timer.elapsed());
        Timer timer2 = new TimerFactory().timer();
        timer2.start();
        Initializable.DefaultImpls.initialize$default(this.firebase, null, 1, null);
        this.tracker.track(StartupAnalyticsTrackerKt.FIREBASE, timer2.elapsed());
        Completable subscribeOn = Completable.fromCallable(new a(this)).subscribeOn(this.schedulers.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "Completable\n            …scribeOn(schedulers.io())");
        Completables.subscribeIgnoreResult(subscribeOn);
        return ApplicationStartupTask.ExecutionResult.Success.INSTANCE;
    }

    @Override // com.avito.android.app.task.ApplicationBlockingStartupTask
    @NotNull
    public ApplicationBlockingStartupTask.Priority getPriority() {
        return this.priority;
    }
}
