package com.avito.android.analytics.event;

import android.app.Activity;
import com.avito.android.analytics.Event;
import com.avito.android.analytics.provider.crashlytics.FirebaseCrashlyticsEvent;
import com.avito.android.analytics.provider.crashlytics.FirebaseCrashlyticsEventTracker;
import com.avito.android.analytics_adjust.AdjustEvent;
import com.avito.android.analytics_adjust.AdjustEventTracker;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u00012\u00020\u0002:\u0005\t\n\u000b\f\rR\u001c\u0010\b\u001a\u00020\u00038\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u0001\u0005\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/analytics/event/ActivityLifecycleEvent;", "Lcom/avito/android/analytics/Event;", "Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlyticsEvent;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getClassName", "()Ljava/lang/String;", "className", "CreateActivity", "PauseActivity", "ResumeActivity", "StartActivity", "StopActivity", "Lcom/avito/android/analytics/event/ActivityLifecycleEvent$CreateActivity;", "Lcom/avito/android/analytics/event/ActivityLifecycleEvent$StartActivity;", "Lcom/avito/android/analytics/event/ActivityLifecycleEvent$ResumeActivity;", "Lcom/avito/android/analytics/event/ActivityLifecycleEvent$PauseActivity;", "Lcom/avito/android/analytics/event/ActivityLifecycleEvent$StopActivity;", "analytics_release"}, k = 1, mv = {1, 4, 2})
public abstract class ActivityLifecycleEvent implements Event, FirebaseCrashlyticsEvent {
    @NotNull
    public final String a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/avito/android/analytics/event/ActivityLifecycleEvent$CreateActivity;", "Lcom/avito/android/analytics/event/ActivityLifecycleEvent;", "Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlyticsEventTracker;", "tracker", "", "accept", "(Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlyticsEventTracker;)V", "Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
    public static final class CreateActivity extends ActivityLifecycleEvent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CreateActivity(@NotNull Activity activity) {
            super(activity, null);
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // com.avito.android.analytics.provider.crashlytics.FirebaseCrashlyticsEvent
        public void accept(@NotNull FirebaseCrashlyticsEventTracker firebaseCrashlyticsEventTracker) {
            Intrinsics.checkNotNullParameter(firebaseCrashlyticsEventTracker, "tracker");
            firebaseCrashlyticsEventTracker.trackEvent(getClassName() + ".onCreate");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0006\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/avito/android/analytics/event/ActivityLifecycleEvent$PauseActivity;", "Lcom/avito/android/analytics/event/ActivityLifecycleEvent;", "Lcom/avito/android/analytics_adjust/AdjustEvent;", "Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlyticsEventTracker;", "tracker", "", "accept", "(Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlyticsEventTracker;)V", "Lcom/avito/android/analytics_adjust/AdjustEventTracker;", "(Lcom/avito/android/analytics_adjust/AdjustEventTracker;)V", "Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
    public static final class PauseActivity extends ActivityLifecycleEvent implements AdjustEvent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PauseActivity(@NotNull Activity activity) {
            super(activity, null);
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // com.avito.android.analytics.provider.crashlytics.FirebaseCrashlyticsEvent
        public void accept(@NotNull FirebaseCrashlyticsEventTracker firebaseCrashlyticsEventTracker) {
            Intrinsics.checkNotNullParameter(firebaseCrashlyticsEventTracker, "tracker");
            firebaseCrashlyticsEventTracker.trackEvent(getClassName() + ".onPause");
        }

        @Override // com.avito.android.analytics_adjust.AdjustEvent
        public void accept(@NotNull AdjustEventTracker adjustEventTracker) {
            Intrinsics.checkNotNullParameter(adjustEventTracker, "tracker");
            adjustEventTracker.trackOnPause();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0006\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/avito/android/analytics/event/ActivityLifecycleEvent$ResumeActivity;", "Lcom/avito/android/analytics/event/ActivityLifecycleEvent;", "Lcom/avito/android/analytics_adjust/AdjustEvent;", "Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlyticsEventTracker;", "tracker", "", "accept", "(Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlyticsEventTracker;)V", "Lcom/avito/android/analytics_adjust/AdjustEventTracker;", "(Lcom/avito/android/analytics_adjust/AdjustEventTracker;)V", "Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
    public static final class ResumeActivity extends ActivityLifecycleEvent implements AdjustEvent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ResumeActivity(@NotNull Activity activity) {
            super(activity, null);
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // com.avito.android.analytics.provider.crashlytics.FirebaseCrashlyticsEvent
        public void accept(@NotNull FirebaseCrashlyticsEventTracker firebaseCrashlyticsEventTracker) {
            Intrinsics.checkNotNullParameter(firebaseCrashlyticsEventTracker, "tracker");
            firebaseCrashlyticsEventTracker.trackEvent(getClassName() + ".onResume");
        }

        @Override // com.avito.android.analytics_adjust.AdjustEvent
        public void accept(@NotNull AdjustEventTracker adjustEventTracker) {
            Intrinsics.checkNotNullParameter(adjustEventTracker, "tracker");
            adjustEventTracker.trackOnResume();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/avito/android/analytics/event/ActivityLifecycleEvent$StartActivity;", "Lcom/avito/android/analytics/event/ActivityLifecycleEvent;", "Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlyticsEventTracker;", "tracker", "", "accept", "(Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlyticsEventTracker;)V", "Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
    public static final class StartActivity extends ActivityLifecycleEvent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public StartActivity(@NotNull Activity activity) {
            super(activity, null);
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // com.avito.android.analytics.provider.crashlytics.FirebaseCrashlyticsEvent
        public void accept(@NotNull FirebaseCrashlyticsEventTracker firebaseCrashlyticsEventTracker) {
            Intrinsics.checkNotNullParameter(firebaseCrashlyticsEventTracker, "tracker");
            firebaseCrashlyticsEventTracker.trackEvent(getClassName() + ".onStart");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/avito/android/analytics/event/ActivityLifecycleEvent$StopActivity;", "Lcom/avito/android/analytics/event/ActivityLifecycleEvent;", "Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlyticsEventTracker;", "tracker", "", "accept", "(Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlyticsEventTracker;)V", "Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
    public static final class StopActivity extends ActivityLifecycleEvent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public StopActivity(@NotNull Activity activity) {
            super(activity, null);
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // com.avito.android.analytics.provider.crashlytics.FirebaseCrashlyticsEvent
        public void accept(@NotNull FirebaseCrashlyticsEventTracker firebaseCrashlyticsEventTracker) {
            Intrinsics.checkNotNullParameter(firebaseCrashlyticsEventTracker, "tracker");
            firebaseCrashlyticsEventTracker.trackEvent(getClassName() + ".onStop");
        }
    }

    public ActivityLifecycleEvent(Activity activity, j jVar) {
        String simpleName = activity.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "activity.javaClass.simpleName");
        this.a = simpleName;
    }

    @NotNull
    public final String getClassName() {
        return this.a;
    }
}
