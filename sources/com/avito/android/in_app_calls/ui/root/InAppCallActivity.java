package com.avito.android.in_app_calls.ui.root;

import a2.b.a.a.a;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.avito.android.analytics.Analytics;
import com.avito.android.app.task.ApplicationStartupTask;
import com.avito.android.app.task.ApplicationStartupTasksRegistry;
import com.avito.android.calls.analytics.CallAnalyticsTracker;
import com.avito.android.calls_shared.tracker.events.CallEvent;
import com.avito.android.calls_shared.tracker.events.CallEventTracker;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.in_app_calls.R;
import com.avito.android.in_app_calls.data.CallActivityRequest;
import com.avito.android.in_app_calls.di.CallActivityComponent;
import com.avito.android.in_app_calls.di.CallActivityComponentDependencies;
import com.avito.android.in_app_calls.di.DaggerCallActivityComponent;
import com.avito.android.in_app_calls.task.InitCallClientTask;
import com.avito.android.in_app_calls.task.InitCallsTask;
import com.avito.android.in_app_calls.ui.InAppCallsRouter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.Logs;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b9\u0010:J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010(\u001a\u00020'8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R\"\u00103\u001a\u0002028\u0006@\u0006X.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006;"}, d2 = {"Lcom/avito/android/in_app_calls/ui/root/InAppCallActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "", "getContentLayoutId", "()I", "Landroid/content/Intent;", "intent", "", "onNewIntent", "(Landroid/content/Intent;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Lcom/avito/android/in_app_calls/data/CallActivityRequest;", "request", AuthSource.SEND_ABUSE, "(Lcom/avito/android/in_app_calls/data/CallActivityRequest;)V", "Lcom/avito/android/app/task/ApplicationStartupTasksRegistry;", "startupTasksRegistry", "Lcom/avito/android/app/task/ApplicationStartupTasksRegistry;", "getStartupTasksRegistry", "()Lcom/avito/android/app/task/ApplicationStartupTasksRegistry;", "setStartupTasksRegistry", "(Lcom/avito/android/app/task/ApplicationStartupTasksRegistry;)V", "Lcom/avito/android/calls/analytics/CallAnalyticsTracker;", "analyticsTracker", "Lcom/avito/android/calls/analytics/CallAnalyticsTracker;", "getAnalyticsTracker", "()Lcom/avito/android/calls/analytics/CallAnalyticsTracker;", "setAnalyticsTracker", "(Lcom/avito/android/calls/analytics/CallAnalyticsTracker;)V", "Lcom/avito/android/calls_shared/tracker/events/CallEventTracker;", "callEventTracker", "Lcom/avito/android/calls_shared/tracker/events/CallEventTracker;", "getCallEventTracker", "()Lcom/avito/android/calls_shared/tracker/events/CallEventTracker;", "setCallEventTracker", "(Lcom/avito/android/calls_shared/tracker/events/CallEventTracker;)V", "Lcom/avito/android/in_app_calls/ui/InAppCallsRouter;", "router", "Lcom/avito/android/in_app_calls/ui/InAppCallsRouter;", "getRouter", "()Lcom/avito/android/in_app_calls/ui/InAppCallsRouter;", "setRouter", "(Lcom/avito/android/in_app_calls/ui/InAppCallsRouter;)V", "", "k", "Z", "wasScreenOpenedTracked", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "<init>", "()V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class InAppCallActivity extends BaseActivity {
    @Inject
    public Analytics analytics;
    @Inject
    public CallAnalyticsTracker analyticsTracker;
    @Inject
    public CallEventTracker callEventTracker;
    public boolean k;
    @Inject
    public InAppCallsRouter router;
    @Inject
    public ApplicationStartupTasksRegistry startupTasksRegistry;

    public final void a(CallActivityRequest callActivityRequest) {
        if (!this.k) {
            CallEventTracker callEventTracker2 = this.callEventTracker;
            if (callEventTracker2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("callEventTracker");
            }
            callEventTracker2.track(new CallEvent.ScreenOpened(callActivityRequest.getCallUuid(), callActivityRequest.getCallSide(), callActivityRequest.getScenario()));
            if (callActivityRequest instanceof CallActivityRequest.Dial.NewCall) {
                CallAnalyticsTracker callAnalyticsTracker = this.analyticsTracker;
                if (callAnalyticsTracker == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("analyticsTracker");
                }
                callAnalyticsTracker.trackCallUiShown("call");
                CallAnalyticsTracker callAnalyticsTracker2 = this.analyticsTracker;
                if (callAnalyticsTracker2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("analyticsTracker");
                }
                callAnalyticsTracker2.trackCallInitiated(false);
            } else if (callActivityRequest instanceof CallActivityRequest.Dial.ByPreviousCall) {
                CallAnalyticsTracker callAnalyticsTracker3 = this.analyticsTracker;
                if (callAnalyticsTracker3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("analyticsTracker");
                }
                callAnalyticsTracker3.trackCallUiShown("callback");
                CallAnalyticsTracker callAnalyticsTracker4 = this.analyticsTracker;
                if (callAnalyticsTracker4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("analyticsTracker");
                }
                callAnalyticsTracker4.trackCallInitiated(false);
            } else if (callActivityRequest instanceof CallActivityRequest.Receive.ReceiveCall) {
                CallAnalyticsTracker callAnalyticsTracker5 = this.analyticsTracker;
                if (callAnalyticsTracker5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("analyticsTracker");
                }
                callAnalyticsTracker5.trackCallUiShown("receive");
            } else if (callActivityRequest instanceof CallActivityRequest.Receive.PendingAction) {
                CallAnalyticsTracker callAnalyticsTracker6 = this.analyticsTracker;
                if (callAnalyticsTracker6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("analyticsTracker");
                }
                StringBuilder L = a.L("pending.");
                String str = ((CallActivityRequest.Receive.PendingAction) callActivityRequest).getPendingAction().toString();
                Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                String lowerCase = str.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                L.append(lowerCase);
                callAnalyticsTracker6.trackCallUiShown(L.toString());
            } else if (callActivityRequest instanceof CallActivityRequest.Open) {
                CallAnalyticsTracker callAnalyticsTracker7 = this.analyticsTracker;
                if (callAnalyticsTracker7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("analyticsTracker");
                }
                callAnalyticsTracker7.trackCallUiShown("open");
            } else {
                throw new NoWhenBranchMatchedException();
            }
            this.k = true;
        }
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
    public final CallAnalyticsTracker getAnalyticsTracker() {
        CallAnalyticsTracker callAnalyticsTracker = this.analyticsTracker;
        if (callAnalyticsTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsTracker");
        }
        return callAnalyticsTracker;
    }

    @NotNull
    public final CallEventTracker getCallEventTracker() {
        CallEventTracker callEventTracker2 = this.callEventTracker;
        if (callEventTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callEventTracker");
        }
        return callEventTracker2;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.activity_in_app_call;
    }

    @NotNull
    public final InAppCallsRouter getRouter() {
        InAppCallsRouter inAppCallsRouter = this.router;
        if (inAppCallsRouter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("router");
        }
        return inAppCallsRouter;
    }

    @NotNull
    public final ApplicationStartupTasksRegistry getStartupTasksRegistry() {
        ApplicationStartupTasksRegistry applicationStartupTasksRegistry = this.startupTasksRegistry;
        if (applicationStartupTasksRegistry == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startupTasksRegistry");
        }
        return applicationStartupTasksRegistry;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().clearFlags(67108864);
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            Window window = getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "window");
            View decorView = window.getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
            int systemUiVisibility = decorView.getSystemUiVisibility();
            Window window2 = getWindow();
            Intrinsics.checkNotNullExpressionValue(window2, "window");
            View decorView2 = window2.getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView2, "window.decorView");
            decorView2.setSystemUiVisibility(systemUiVisibility & -8193);
        }
        if (i >= 27) {
            setShowWhenLocked(true);
            setTurnScreenOn(true);
            Object systemService = getSystemService("keyguard");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.KeyguardManager");
            ((KeyguardManager) systemService).requestDismissKeyguard(this, null);
        } else {
            getWindow().addFlags(6815744);
        }
        CallActivityComponent.CallActivityComponentComponentFactory factory = DaggerCallActivityComponent.factory();
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        Resources resources = applicationContext.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "applicationContext.resources");
        factory.create(this, resources, (CallActivityComponentDependencies) ComponentDependenciesKt.getDependencies(CallActivityComponentDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).inject(this);
        if (bundle == null) {
            Intent intent = getIntent();
            CallActivityRequest callActivityRequest = intent != null ? (CallActivityRequest) intent.getParcelableExtra("request") : null;
            if (callActivityRequest != null) {
                Logs.verbose$default("InAppCallActivity", "New instance created: dialRequest = " + callActivityRequest, null, 4, null);
                a(callActivityRequest);
                InAppCallsRouter inAppCallsRouter = this.router;
                if (inAppCallsRouter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("router");
                }
                inAppCallsRouter.openCallScreen(callActivityRequest);
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        ApplicationStartupTasksRegistry applicationStartupTasksRegistry = this.startupTasksRegistry;
        if (applicationStartupTasksRegistry == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startupTasksRegistry");
        }
        applicationStartupTasksRegistry.requireAtLeast(InitCallsTask.class, ApplicationStartupTask.State.Scheduled.class);
        applicationStartupTasksRegistry.requireAtLeast(InitCallClientTask.class, ApplicationStartupTask.State.Scheduled.class);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(@Nullable Intent intent) {
        super.onNewIntent(intent);
        CallActivityRequest callActivityRequest = intent != null ? (CallActivityRequest) intent.getParcelableExtra("request") : null;
        if (callActivityRequest != null) {
            Logs.verbose$default("InAppCallActivity", "New request: " + callActivityRequest, null, 4, null);
            a(callActivityRequest);
            InAppCallsRouter inAppCallsRouter = this.router;
            if (inAppCallsRouter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("router");
            }
            inAppCallsRouter.openCallScreen(callActivityRequest);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setAnalyticsTracker(@NotNull CallAnalyticsTracker callAnalyticsTracker) {
        Intrinsics.checkNotNullParameter(callAnalyticsTracker, "<set-?>");
        this.analyticsTracker = callAnalyticsTracker;
    }

    public final void setCallEventTracker(@NotNull CallEventTracker callEventTracker2) {
        Intrinsics.checkNotNullParameter(callEventTracker2, "<set-?>");
        this.callEventTracker = callEventTracker2;
    }

    public final void setRouter(@NotNull InAppCallsRouter inAppCallsRouter) {
        Intrinsics.checkNotNullParameter(inAppCallsRouter, "<set-?>");
        this.router = inAppCallsRouter;
    }

    public final void setStartupTasksRegistry(@NotNull ApplicationStartupTasksRegistry applicationStartupTasksRegistry) {
        Intrinsics.checkNotNullParameter(applicationStartupTasksRegistry, "<set-?>");
        this.startupTasksRegistry = applicationStartupTasksRegistry;
    }
}
