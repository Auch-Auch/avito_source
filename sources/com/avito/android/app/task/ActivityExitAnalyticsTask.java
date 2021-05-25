package com.avito.android.app.task;

import android.app.Activity;
import android.app.Application;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.ExceptionEvent;
import com.avito.android.app.SimpleActivityLifecycleCallbacks;
import com.avito.android.app.task.ApplicationBlockingStartupTask;
import com.avito.android.app.task.ApplicationStartupTask;
import com.avito.android.preferences.ActivityAnalyticsStorage;
import com.avito.android.util.Logs;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Collection;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/app/task/ActivityExitAnalyticsTask;", "Lcom/avito/android/app/task/ApplicationBlockingStartupTask;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "execute", "(Landroid/app/Application;)Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "Lcom/avito/android/preferences/ActivityAnalyticsStorage;", "storage", "Lcom/avito/android/preferences/ActivityAnalyticsStorage;", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/preferences/ActivityAnalyticsStorage;)V", "application_release"}, k = 1, mv = {1, 4, 2})
public final class ActivityExitAnalyticsTask implements ApplicationBlockingStartupTask {
    public final Analytics analytics;
    public final ActivityAnalyticsStorage storage;

    public ActivityExitAnalyticsTask(@NotNull Analytics analytics2, @NotNull ActivityAnalyticsStorage activityAnalyticsStorage) {
        Intrinsics.checkNotNullParameter(analytics2, "analytics");
        Intrinsics.checkNotNullParameter(activityAnalyticsStorage, "storage");
        this.analytics = analytics2;
        this.storage = activityAnalyticsStorage;
    }

    public static final ActivityAnalyticsStorage.ActivityRecord access$createRecord(ActivityExitAnalyticsTask activityExitAnalyticsTask, Activity activity) {
        Objects.requireNonNull(activityExitAnalyticsTask);
        String valueOf = String.valueOf(System.identityHashCode(activity));
        String name = activity.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "activity.javaClass.name");
        return new ActivityAnalyticsStorage.ActivityRecord(valueOf, name);
    }

    @Override // com.avito.android.app.task.ApplicationBlockingStartupTask
    @NotNull
    public ApplicationStartupTask.ExecutionResult execute(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Collection<ActivityAnalyticsStorage.ActivityRecord> popActivities = this.storage.popActivities();
        for (T t : popActivities) {
            Analytics analytics2 = this.analytics;
            ZombieActivityDetectedException zombieActivityDetectedException = new ZombieActivityDetectedException();
            StackTraceElement[] stackTraceElementArr = {new StackTraceElement(t.getName(), "onStart", t.getName(), 0)};
            StackTraceElement[] stackTrace = zombieActivityDetectedException.getStackTrace();
            Intrinsics.checkNotNullExpressionValue(stackTrace, "exception.stackTrace");
            zombieActivityDetectedException.setStackTrace((StackTraceElement[]) ArraysKt___ArraysJvmKt.plus((Object[]) stackTraceElementArr, (Object[]) stackTrace));
            analytics2.track(new ExceptionEvent(zombieActivityDetectedException, null, 2, null));
        }
        Logs.debug$default("ActivityExitAnalyticsTask", "Unexpected exit activities: " + popActivities, null, 4, null);
        application.registerActivityLifecycleCallbacks(new SimpleActivityLifecycleCallbacks() { // from class: com.avito.android.app.task.ActivityExitAnalyticsTask$registerCallbacks$1
            @Override // com.avito.android.app.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(@NotNull Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                ActivityExitAnalyticsTask.access$getStorage$p(ActivityExitAnalyticsTask.this).saveActivity(ActivityExitAnalyticsTask.access$createRecord(ActivityExitAnalyticsTask.this, activity));
            }

            @Override // com.avito.android.app.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(@NotNull Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                ActivityExitAnalyticsTask.access$getStorage$p(ActivityExitAnalyticsTask.this).removeActivity(ActivityExitAnalyticsTask.access$createRecord(ActivityExitAnalyticsTask.this, activity));
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
