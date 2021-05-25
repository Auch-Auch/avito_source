package com.avito.android.app.task;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.ActivityLifecycleEvent;
import com.avito.android.app.SimpleActivityLifecycleCallbacks;
import com.avito.android.app.task.ApplicationBlockingStartupTask;
import com.avito.android.app.task.ApplicationStartupTask;
import com.avito.android.util.Logs;
import com.google.android.exoplayer2.util.MimeTypes;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/app/task/RegisterAnalyticsActivityListenerTask;", "Lcom/avito/android/app/task/ApplicationBlockingStartupTask;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "execute", "(Landroid/app/Application;)Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "<init>", "(Lcom/avito/android/analytics/Analytics;)V", "application_release"}, k = 1, mv = {1, 4, 2})
public final class RegisterAnalyticsActivityListenerTask implements ApplicationBlockingStartupTask {
    public final Analytics analytics;

    @Inject
    public RegisterAnalyticsActivityListenerTask(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "analytics");
        this.analytics = analytics2;
    }

    @Override // com.avito.android.app.task.ApplicationBlockingStartupTask
    @NotNull
    public ApplicationStartupTask.ExecutionResult execute(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        application.registerActivityLifecycleCallbacks(new SimpleActivityLifecycleCallbacks(this) { // from class: com.avito.android.app.task.RegisterAnalyticsActivityListenerTask$execute$1
            public final /* synthetic */ RegisterAnalyticsActivityListenerTask a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // com.avito.android.app.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                this.a.analytics.track(new ActivityLifecycleEvent.CreateActivity(activity));
                String simpleName = activity.getClass().getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "activity.javaClass.simpleName");
                Logs.info$default(simpleName, "onCreate", null, 4, null);
            }

            @Override // com.avito.android.app.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(@NotNull Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                String simpleName = activity.getClass().getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "activity.javaClass.simpleName");
                Logs.info$default(simpleName, "onDestroy", null, 4, null);
            }

            @Override // com.avito.android.app.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(@NotNull Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                this.a.analytics.track(new ActivityLifecycleEvent.PauseActivity(activity));
                String simpleName = activity.getClass().getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "activity.javaClass.simpleName");
                Logs.info$default(simpleName, "onPause", null, 4, null);
            }

            @Override // com.avito.android.app.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(@NotNull Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                this.a.analytics.track(new ActivityLifecycleEvent.ResumeActivity(activity));
                String simpleName = activity.getClass().getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "activity.javaClass.simpleName");
                Logs.info$default(simpleName, "onResume", null, 4, null);
            }

            @Override // com.avito.android.app.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(@NotNull Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                this.a.analytics.track(new ActivityLifecycleEvent.StartActivity(activity));
                String simpleName = activity.getClass().getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "activity.javaClass.simpleName");
                Logs.info$default(simpleName, "onStart", null, 4, null);
            }

            @Override // com.avito.android.app.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(@NotNull Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                this.a.analytics.track(new ActivityLifecycleEvent.StopActivity(activity));
                String simpleName = activity.getClass().getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "activity.javaClass.simpleName");
                Logs.info$default(simpleName, "onStop", null, 4, null);
            }
        });
        return ApplicationStartupTask.ExecutionResult.Success.INSTANCE;
    }

    @Override // com.avito.android.app.task.ApplicationBlockingStartupTask
    @NotNull
    public ApplicationBlockingStartupTask.Priority getPriority() {
        return ApplicationBlockingStartupTask.DefaultImpls.getPriority(this);
    }
}
