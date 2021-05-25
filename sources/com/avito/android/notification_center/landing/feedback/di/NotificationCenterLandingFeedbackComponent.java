package com.avito.android.notification_center.landing.feedback.di;

import android.app.Activity;
import com.avito.android.di.PerActivity;
import com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackActivity;
import com.avito.android.util.Kundle;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/notification_center/landing/feedback/di/NotificationCenterLandingFeedbackComponent;", "", "Lcom/avito/android/notification_center/landing/feedback/NotificationCenterLandingFeedbackActivity;", "activity", "", "inject", "(Lcom/avito/android/notification_center/landing/feedback/NotificationCenterLandingFeedbackActivity;)V", "Builder", "notification-center_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {NotificationCenterLandingFeedbackDependencies.class}, modules = {NotificationCenterLandingFeedbackModule.class})
@PerActivity
public interface NotificationCenterLandingFeedbackComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\tH'¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH'¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0014\u001a\u00020\u00002\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/avito/android/notification_center/landing/feedback/di/NotificationCenterLandingFeedbackComponent$Builder;", "", "Lcom/avito/android/notification_center/landing/feedback/di/NotificationCenterLandingFeedbackDependencies;", "dependencies", "(Lcom/avito/android/notification_center/landing/feedback/di/NotificationCenterLandingFeedbackDependencies;)Lcom/avito/android/notification_center/landing/feedback/di/NotificationCenterLandingFeedbackComponent$Builder;", "", "id", "withId", "(Ljava/lang/String;)Lcom/avito/android/notification_center/landing/feedback/di/NotificationCenterLandingFeedbackComponent$Builder;", "Lcom/avito/android/util/Kundle;", "state", "withPresenterState", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/notification_center/landing/feedback/di/NotificationCenterLandingFeedbackComponent$Builder;", "Landroid/app/Activity;", "activity", "withActivity", "(Landroid/app/Activity;)Lcom/avito/android/notification_center/landing/feedback/di/NotificationCenterLandingFeedbackComponent$Builder;", "Lcom/jakewharton/rxrelay2/PublishRelay;", "", "relay", "withCancelRelay", "(Lcom/jakewharton/rxrelay2/PublishRelay;)Lcom/avito/android/notification_center/landing/feedback/di/NotificationCenterLandingFeedbackComponent$Builder;", "Lcom/avito/android/notification_center/landing/feedback/di/NotificationCenterLandingFeedbackComponent;", "build", "()Lcom/avito/android/notification_center/landing/feedback/di/NotificationCenterLandingFeedbackComponent;", "notification-center_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        NotificationCenterLandingFeedbackComponent build();

        @NotNull
        Builder dependencies(@NotNull NotificationCenterLandingFeedbackDependencies notificationCenterLandingFeedbackDependencies);

        @BindsInstance
        @NotNull
        Builder withActivity(@NotNull Activity activity);

        @BindsInstance
        @NotNull
        Builder withCancelRelay(@NotNull PublishRelay<Unit> publishRelay);

        @BindsInstance
        @NotNull
        Builder withId(@NotNull String str);

        @BindsInstance
        @NotNull
        Builder withPresenterState(@Nullable Kundle kundle);
    }

    void inject(@NotNull NotificationCenterLandingFeedbackActivity notificationCenterLandingFeedbackActivity);
}
