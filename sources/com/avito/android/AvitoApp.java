package com.avito.android;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import androidx.work.Configuration;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.OrientationTracker;
import com.avito.android.analytics.events.AppStartEvent;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.sideload.SideloadDelegate;
import com.avito.android.analytics.task.StartupAnalyticsTracker;
import com.avito.android.analytics.task.StartupAnalyticsTrackerKt;
import com.avito.android.app.ApplicationDelegate;
import com.avito.android.app.NoOpApplicationDelegate;
import com.avito.android.app.StartupTime;
import com.avito.android.app.task.ScheduleMetricSendingTask;
import com.avito.android.di.ComponentDependencies;
import com.avito.android.di.HasComponentDependencies;
import com.avito.android.di.component.ApplicationComponent;
import com.avito.android.di.component.DaggerApplicationComponent;
import com.avito.android.di.module.ApplicationDelegateModule;
import com.avito.android.remote.auth.AuthSource;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u00052\u00020\u0006B\u0007¢\u0006\u0004\bM\u0010\rJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0012\u0010\rJ\u000f\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020'8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\"\u0010,\u001a\u00020+8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00107\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u00038V@WX\u000e¢\u0006\f\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0018\u00109\u001a\u0004\u0018\u0001088\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b9\u0010:Rd\u0010A\u001a\u001f\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020=0<\u0012\t\u0012\u00070=¢\u0006\u0002\b>0;j\u0002`?2#\u0010@\u001a\u001f\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020=0<\u0012\t\u0012\u00070=¢\u0006\u0002\b>0;j\u0002`?8\u0016@TX.¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010L\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u0010K¨\u0006N"}, d2 = {"Lcom/avito/android/AvitoApp;", "Lcom/avito/android/BaseApp;", "Lcom/avito/android/ComponentProvider;", "Lcom/avito/android/di/component/ApplicationComponent;", "Lcom/avito/android/di/HasComponentDependencies;", "Lcom/avito/android/app/task/ScheduleMetricSendingTask$StartupTimeHolder;", "Landroidx/work/Configuration$Provider;", "Landroid/content/Context;", "base", "", "attachBaseContext", "(Landroid/content/Context;)V", "onCreate", "()V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "injectSelf", "", "obtainComponent", "()Ljava/lang/Object;", "Landroidx/work/Configuration;", "getWorkManagerConfiguration", "()Landroidx/work/Configuration;", "Lcom/avito/android/app/ApplicationDelegate;", "delegate", "Lcom/avito/android/app/ApplicationDelegate;", "getDelegate", "()Lcom/avito/android/app/ApplicationDelegate;", "setDelegate", "(Lcom/avito/android/app/ApplicationDelegate;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "", "getStartupBeginElapsedMs", "()J", "startupBeginElapsedMs", "Lcom/avito/android/analytics/task/StartupAnalyticsTracker;", "tracker", "Lcom/avito/android/analytics/task/StartupAnalyticsTracker;", "getTracker", "()Lcom/avito/android/analytics/task/StartupAnalyticsTracker;", "setTracker", "(Lcom/avito/android/analytics/task/StartupAnalyticsTracker;)V", "value", "getComponent", "()Lcom/avito/android/di/component/ApplicationComponent;", "setComponent", "(Lcom/avito/android/di/component/ApplicationComponent;)V", "component", "Lcom/avito/android/analytics/OrientationTracker;", "orientationTracker", "Lcom/avito/android/analytics/OrientationTracker;", "", "Ljava/lang/Class;", "Lcom/avito/android/di/ComponentDependencies;", "Lkotlin/jvm/JvmSuppressWildcards;", "Lcom/avito/android/di/ComponentDependenciesProvider;", "<set-?>", "dependencies", "Ljava/util/Map;", "getDependencies", "()Ljava/util/Map;", "setDependencies", "(Ljava/util/Map;)V", AuthSource.SEND_ABUSE, "J", "_startupBeginElapsedMs", AuthSource.BOOKING_ORDER, "Lcom/avito/android/di/component/ApplicationComponent;", "_component", "<init>", "avito-103.5-(1342)_release"}, k = 1, mv = {1, 4, 2})
public class AvitoApp extends BaseApp implements ComponentProvider<ApplicationComponent>, HasComponentDependencies, ScheduleMetricSendingTask.StartupTimeHolder, Configuration.Provider {
    public long a;
    @Inject
    public Analytics analytics;
    public ApplicationComponent b;
    @Inject
    public ApplicationDelegate delegate;
    @Inject
    public Map<Class<? extends ComponentDependencies>, ComponentDependencies> dependencies;
    @Inject
    @JvmField
    @Nullable
    public OrientationTracker orientationTracker;
    @Inject
    public StartupAnalyticsTracker tracker;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AvitoApp a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AvitoApp avitoApp) {
            super(0);
            this.a = avitoApp;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a = SystemClock.elapsedRealtime();
            StartupTime.Updater.update();
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AvitoApp a;
        public final /* synthetic */ android.content.res.Configuration b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(AvitoApp avitoApp, android.content.res.Configuration configuration) {
            super(0);
            this.a = avitoApp;
            this.b = configuration;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            OrientationTracker orientationTracker = this.a.orientationTracker;
            if (orientationTracker != null) {
                orientationTracker.trackOrientationChange(this.b);
            }
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AvitoApp a;
        public final /* synthetic */ long b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(AvitoApp avitoApp, long j) {
            super(0);
            this.a = avitoApp;
            this.b = j;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Timer B1 = a2.b.a.a.a.B1();
            this.a.injectSelf();
            this.a.getTracker().track(StartupAnalyticsTrackerKt.APP_INJECT, B1.elapsed());
            this.a.getAnalytics().track(new AppStartEvent(this.b));
            Timer timer = new TimerFactory().timer();
            timer.start();
            this.a.getDelegate().initialize();
            this.a.getTracker().track(StartupAnalyticsTrackerKt.APP_INIT, timer.elapsed());
            AvitoApp avitoApp = this.a;
            new SideloadDelegate(avitoApp, avitoApp.getAnalytics()).trackIfSideload();
            this.a.getDelegate().onStartUpFinished(SystemClock.elapsedRealtime() - this.a.getStartupBeginElapsedMs());
            this.a.setDelegate(new NoOpApplicationDelegate());
            return Unit.INSTANCE;
        }
    }

    @Override // com.avito.android.BaseApp, android.content.ContextWrapper
    public void attachBaseContext(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "base");
        super.attachBaseContext(context);
        runIfMainProcess(new a(this));
    }

    @NotNull
    public final Analytics getAnalytics() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final ApplicationDelegate getDelegate() {
        ApplicationDelegate applicationDelegate = this.delegate;
        if (applicationDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
        }
        return applicationDelegate;
    }

    @Override // com.avito.android.di.HasComponentDependencies
    @NotNull
    public Map<Class<? extends ComponentDependencies>, ComponentDependencies> getDependencies() {
        Map<Class<? extends ComponentDependencies>, ComponentDependencies> map = this.dependencies;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dependencies");
        }
        return map;
    }

    @Override // com.avito.android.app.task.ScheduleMetricSendingTask.StartupTimeHolder
    public long getStartupBeginElapsedMs() {
        return this.a;
    }

    @NotNull
    public final StartupAnalyticsTracker getTracker() {
        StartupAnalyticsTracker startupAnalyticsTracker = this.tracker;
        if (startupAnalyticsTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        return startupAnalyticsTracker;
    }

    @Override // androidx.work.Configuration.Provider
    @NotNull
    public Configuration getWorkManagerConfiguration() {
        Configuration build = new Configuration.Builder().build();
        Intrinsics.checkNotNullExpressionValue(build, "WorkManagerConfiguration.Builder().build()");
        return build;
    }

    public void injectSelf() {
        getComponent().plus(new ApplicationDelegateModule()).inject(this);
    }

    @Override // com.avito.android.BaseApp
    @NotNull
    public Object obtainComponent() {
        return getComponent();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull android.content.res.Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        runIfMainProcess(new b(this, configuration));
    }

    @Override // android.app.Application
    public void onCreate() {
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate();
        runIfMainProcess(new c(this, currentTimeMillis));
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    @VisibleForTesting
    public void setComponent(@NotNull ApplicationComponent applicationComponent) {
        Intrinsics.checkNotNullParameter(applicationComponent, "value");
        this.b = applicationComponent;
    }

    public final void setDelegate(@NotNull ApplicationDelegate applicationDelegate) {
        Intrinsics.checkNotNullParameter(applicationDelegate, "<set-?>");
        this.delegate = applicationDelegate;
    }

    public void setDependencies(@NotNull Map<Class<? extends ComponentDependencies>, ComponentDependencies> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.dependencies = map;
    }

    public final void setTracker(@NotNull StartupAnalyticsTracker startupAnalyticsTracker) {
        Intrinsics.checkNotNullParameter(startupAnalyticsTracker, "<set-?>");
        this.tracker = startupAnalyticsTracker;
    }

    @Override // com.avito.android.ComponentProvider
    @NotNull
    public ApplicationComponent getComponent() {
        if (this.b == null) {
            this.b = DaggerApplicationComponent.builder().bindApp(this).build();
        }
        ApplicationComponent applicationComponent = this.b;
        Objects.requireNonNull(applicationComponent, "null cannot be cast to non-null type com.avito.android.di.component.ApplicationComponent");
        return applicationComponent;
    }
}
