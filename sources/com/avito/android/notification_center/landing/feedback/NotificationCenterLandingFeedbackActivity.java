package com.avito.android.notification_center.landing.feedback;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.notification_center.R;
import com.avito.android.notification_center.landing.feedback.di.DaggerNotificationCenterLandingFeedbackComponent;
import com.avito.android.notification_center.landing.feedback.di.NotificationCenterLandingFeedbackComponent;
import com.avito.android.notification_center.landing.feedback.di.NotificationCenterLandingFeedbackDependencies;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.Kundle;
import com.jakewharton.rxrelay2.PublishRelay;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b+\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\r\u0010\u0007J\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\tR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u00020\u001d8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R(\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050$8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lcom/avito/android/notification_center/landing/feedback/NotificationCenterLandingFeedbackActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/notification_center/landing/feedback/NotificationCenterLandingFeedbackRouter;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "onDestroy", "outState", "onSaveInstanceState", "leaveScreen", "Lcom/avito/android/notification_center/landing/feedback/NotificationCenterLandingFeedbackPresenter;", "presenter", "Lcom/avito/android/notification_center/landing/feedback/NotificationCenterLandingFeedbackPresenter;", "getPresenter", "()Lcom/avito/android/notification_center/landing/feedback/NotificationCenterLandingFeedbackPresenter;", "setPresenter", "(Lcom/avito/android/notification_center/landing/feedback/NotificationCenterLandingFeedbackPresenter;)V", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Lcom/avito/android/util/DialogRouter;", "getDialogRouter", "()Lcom/avito/android/util/DialogRouter;", "setDialogRouter", "(Lcom/avito/android/util/DialogRouter;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics$notification_center_release", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics$notification_center_release", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/jakewharton/rxrelay2/PublishRelay;", "onCancelDialogRelay", "Lcom/jakewharton/rxrelay2/PublishRelay;", "getOnCancelDialogRelay", "()Lcom/jakewharton/rxrelay2/PublishRelay;", "setOnCancelDialogRelay", "(Lcom/jakewharton/rxrelay2/PublishRelay;)V", "<init>", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationCenterLandingFeedbackActivity extends BaseActivity implements NotificationCenterLandingFeedbackRouter {
    @Inject
    public Analytics analytics;
    @Inject
    public DialogRouter dialogRouter;
    @Inject
    public PublishRelay<Unit> onCancelDialogRelay;
    @Inject
    public NotificationCenterLandingFeedbackPresenter presenter;

    @NotNull
    public final Analytics getAnalytics$notification_center_release() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final DialogRouter getDialogRouter() {
        DialogRouter dialogRouter2 = this.dialogRouter;
        if (dialogRouter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogRouter");
        }
        return dialogRouter2;
    }

    @NotNull
    public final PublishRelay<Unit> getOnCancelDialogRelay() {
        PublishRelay<Unit> publishRelay = this.onCancelDialogRelay;
        if (publishRelay == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onCancelDialogRelay");
        }
        return publishRelay;
    }

    @NotNull
    public final NotificationCenterLandingFeedbackPresenter getPresenter() {
        NotificationCenterLandingFeedbackPresenter notificationCenterLandingFeedbackPresenter = this.presenter;
        if (notificationCenterLandingFeedbackPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return notificationCenterLandingFeedbackPresenter;
    }

    @Override // com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackRouter
    public void leaveScreen() {
        finish();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("key_id");
        Intrinsics.checkNotNullExpressionValue(stringExtra, "intent.getStringExtra(KEY_ID)");
        NotificationCenterLandingFeedbackComponent.Builder withActivity = DaggerNotificationCenterLandingFeedbackComponent.builder().dependencies((NotificationCenterLandingFeedbackDependencies) ComponentDependenciesKt.getDependencies(NotificationCenterLandingFeedbackDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).withId(stringExtra).withPresenterState(bundle != null ? (Kundle) bundle.getParcelable("key_state") : null).withActivity(this);
        PublishRelay<Unit> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        withActivity.withCancelRelay(create).build().inject(this);
        setContentView(R.layout.notification_center_landing_feedback);
        ViewGroup viewGroup = (ViewGroup) findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(viewGroup, "contentView");
        DialogRouter dialogRouter2 = this.dialogRouter;
        if (dialogRouter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogRouter");
        }
        PublishRelay<Unit> publishRelay = this.onCancelDialogRelay;
        if (publishRelay == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onCancelDialogRelay");
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        NotificationCenterLandingFeedbackViewImpl notificationCenterLandingFeedbackViewImpl = new NotificationCenterLandingFeedbackViewImpl(viewGroup, dialogRouter2, publishRelay, analytics2);
        NotificationCenterLandingFeedbackPresenter notificationCenterLandingFeedbackPresenter = this.presenter;
        if (notificationCenterLandingFeedbackPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        notificationCenterLandingFeedbackPresenter.attachView(notificationCenterLandingFeedbackViewImpl);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        NotificationCenterLandingFeedbackPresenter notificationCenterLandingFeedbackPresenter = this.presenter;
        if (notificationCenterLandingFeedbackPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        notificationCenterLandingFeedbackPresenter.detachView();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        NotificationCenterLandingFeedbackPresenter notificationCenterLandingFeedbackPresenter = this.presenter;
        if (notificationCenterLandingFeedbackPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        bundle.putParcelable("key_state", notificationCenterLandingFeedbackPresenter.getState());
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        NotificationCenterLandingFeedbackPresenter notificationCenterLandingFeedbackPresenter = this.presenter;
        if (notificationCenterLandingFeedbackPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        notificationCenterLandingFeedbackPresenter.attachRouter(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        NotificationCenterLandingFeedbackPresenter notificationCenterLandingFeedbackPresenter = this.presenter;
        if (notificationCenterLandingFeedbackPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        notificationCenterLandingFeedbackPresenter.detachRouter();
        NotificationCenterLandingFeedbackPresenter notificationCenterLandingFeedbackPresenter2 = this.presenter;
        if (notificationCenterLandingFeedbackPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        notificationCenterLandingFeedbackPresenter2.cancelDialog();
        super.onStop();
    }

    public final void setAnalytics$notification_center_release(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setDialogRouter(@NotNull DialogRouter dialogRouter2) {
        Intrinsics.checkNotNullParameter(dialogRouter2, "<set-?>");
        this.dialogRouter = dialogRouter2;
    }

    public final void setOnCancelDialogRelay(@NotNull PublishRelay<Unit> publishRelay) {
        Intrinsics.checkNotNullParameter(publishRelay, "<set-?>");
        this.onCancelDialogRelay = publishRelay;
    }

    public final void setPresenter(@NotNull NotificationCenterLandingFeedbackPresenter notificationCenterLandingFeedbackPresenter) {
        Intrinsics.checkNotNullParameter(notificationCenterLandingFeedbackPresenter, "<set-?>");
        this.presenter = notificationCenterLandingFeedbackPresenter;
    }
}
