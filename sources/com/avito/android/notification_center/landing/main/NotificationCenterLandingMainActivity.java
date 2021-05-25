package com.avito.android.notification_center.landing.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.notification_center.R;
import com.avito.android.notification_center.landing.main.di.DaggerNotificationCenterLandingMainComponent;
import com.avito.android.notification_center.landing.main.di.NotificationCenterLandingMainDependencies;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.Kundle;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b(\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u000b\u0010\u0007J\u000f\u0010\f\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\f\u0010\tJ\u000f\u0010\r\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\r\u0010\tJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\tR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u00020!8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006)"}, d2 = {"Lcom/avito/android/notification_center/landing/main/NotificationCenterLandingMainActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/notification_center/landing/main/NotificationCenterLandingMainRouter;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "outState", "onSaveInstanceState", "onStop", "onDestroy", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "leaveScreen", "Lcom/avito/android/notification_center/landing/main/NotificationCenterLandingMainPresenter;", "presenter", "Lcom/avito/android/notification_center/landing/main/NotificationCenterLandingMainPresenter;", "getPresenter", "()Lcom/avito/android/notification_center/landing/main/NotificationCenterLandingMainPresenter;", "setPresenter", "(Lcom/avito/android/notification_center/landing/main/NotificationCenterLandingMainPresenter;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics$notification_center_release", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics$notification_center_release", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "<init>", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationCenterLandingMainActivity extends BaseActivity implements NotificationCenterLandingMainRouter {
    @Inject
    public Analytics analytics;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public NotificationCenterLandingMainPresenter presenter;

    @Override // com.avito.android.notification_center.landing.main.NotificationCenterLandingMainRouter
    public void followDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent != null) {
            startActivity(intent);
        }
    }

    @NotNull
    public final Analytics getAnalytics$notification_center_release() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final DeepLinkIntentFactory getDeepLinkIntentFactory() {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        return deepLinkIntentFactory2;
    }

    @NotNull
    public final NotificationCenterLandingMainPresenter getPresenter() {
        NotificationCenterLandingMainPresenter notificationCenterLandingMainPresenter = this.presenter;
        if (notificationCenterLandingMainPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return notificationCenterLandingMainPresenter;
    }

    @Override // com.avito.android.notification_center.landing.main.NotificationCenterLandingMainRouter
    public void leaveScreen() {
        finish();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("key_id");
        Intrinsics.checkNotNullExpressionValue(stringExtra, "intent.getStringExtra(KEY_ID)");
        DaggerNotificationCenterLandingMainComponent.builder().dependencies((NotificationCenterLandingMainDependencies) ComponentDependenciesKt.getDependencies(NotificationCenterLandingMainDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).withId(stringExtra).withPresenterState(bundle != null ? (Kundle) bundle.getParcelable("key_state") : null).build().inject(this);
        setContentView(R.layout.notification_center_landing_main);
        ViewGroup viewGroup = (ViewGroup) findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(viewGroup, "contentView");
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        NotificationCenterLandingMainViewImpl notificationCenterLandingMainViewImpl = new NotificationCenterLandingMainViewImpl(viewGroup, analytics2);
        NotificationCenterLandingMainPresenter notificationCenterLandingMainPresenter = this.presenter;
        if (notificationCenterLandingMainPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        notificationCenterLandingMainPresenter.attachView(notificationCenterLandingMainViewImpl);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        NotificationCenterLandingMainPresenter notificationCenterLandingMainPresenter = this.presenter;
        if (notificationCenterLandingMainPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        notificationCenterLandingMainPresenter.detachView();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        NotificationCenterLandingMainPresenter notificationCenterLandingMainPresenter = this.presenter;
        if (notificationCenterLandingMainPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        bundle.putParcelable("key_state", notificationCenterLandingMainPresenter.getState());
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        NotificationCenterLandingMainPresenter notificationCenterLandingMainPresenter = this.presenter;
        if (notificationCenterLandingMainPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        notificationCenterLandingMainPresenter.attachRouter(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        NotificationCenterLandingMainPresenter notificationCenterLandingMainPresenter = this.presenter;
        if (notificationCenterLandingMainPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        notificationCenterLandingMainPresenter.detachRouter();
        super.onStop();
    }

    public final void setAnalytics$notification_center_release(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setPresenter(@NotNull NotificationCenterLandingMainPresenter notificationCenterLandingMainPresenter) {
        Intrinsics.checkNotNullParameter(notificationCenterLandingMainPresenter, "<set-?>");
        this.presenter = notificationCenterLandingMainPresenter;
    }
}
