package com.avito.android.notification_center.landing.share;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ViewGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.notification_center.landing.share.NotificationCenterLandingShareView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.server_time.TimeSource;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui_components.R;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.IntentsKt;
import com.avito.android.util.Kundle;
import com.avito.android.util.ToastsKt;
import java.util.Locale;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bN\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ)\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0012\u0010\u0007J\u000f\u0010\u0013\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0013\u0010\tJ\u000f\u0010\u0014\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0014\u0010\tJ!\u0010\u0018\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u0018\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u0018\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001d\u0010\tJ\u0017\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u00020!8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0018\u0010*\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\"\u0010,\u001a\u00020+8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00103\u001a\u0002028\u0006@\u0006X.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010:\u001a\u0002098\u0006@\u0006X.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010A\u001a\u00020@8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010H\u001a\u00020G8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010M¨\u0006O"}, d2 = {"Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingShareActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingShareRouter;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "outState", "onSaveInstanceState", "onStop", "onDestroy", "", "title", "url", "share", "(Ljava/lang/String;Ljava/lang/String;)V", "Landroid/net/Uri;", "imageUri", "(Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;)V", "close", "intent", AuthSource.SEND_ABUSE, "(Landroid/content/Intent;)V", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getImplicitIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setImplicitIntentFactory", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "k", "Landroid/content/Intent;", "shareIntent", "Ljava/util/Locale;", "locale", "Ljava/util/Locale;", "getLocale", "()Ljava/util/Locale;", "setLocale", "(Ljava/util/Locale;)V", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "connectivityProvider", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "getConnectivityProvider", "()Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "setConnectivityProvider", "(Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/server_time/TimeSource;", "getTimeSource", "()Lcom/avito/android/server_time/TimeSource;", "setTimeSource", "(Lcom/avito/android/server_time/TimeSource;)V", "Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingSharePresenter;", "presenter", "Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingSharePresenter;", "getPresenter", "()Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingSharePresenter;", "setPresenter", "(Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingSharePresenter;)V", "<init>", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationCenterLandingShareActivity extends BaseActivity implements NotificationCenterLandingShareRouter {
    @Inject
    public Analytics analytics;
    @Inject
    public ConnectivityProvider connectivityProvider;
    @Inject
    public ImplicitIntentFactory implicitIntentFactory;
    public Intent k;
    @Inject
    public Locale locale;
    @Inject
    public NotificationCenterLandingSharePresenter presenter;
    @Inject
    public TimeSource timeSource;

    public final void a(Intent intent) {
        this.k = intent;
        String string = getResources().getString(R.string.share);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(ui_R.string.share)");
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        try {
            startActivityForResult(IntentsKt.makeSafeForExternalApps(implicitIntentFactory2.pickActivityIntent(intent, string)), 1);
        } catch (Exception unused) {
            ToastsKt.showToast$default(this, R.string.no_application_installed_to_perform_this_action, 0, 2, (Object) null);
        }
    }

    @Override // com.avito.android.notification_center.landing.share.NotificationCenterLandingShareRouter
    public void close() {
        finish();
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
    public final ConnectivityProvider getConnectivityProvider() {
        ConnectivityProvider connectivityProvider2 = this.connectivityProvider;
        if (connectivityProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("connectivityProvider");
        }
        return connectivityProvider2;
    }

    @NotNull
    public final ImplicitIntentFactory getImplicitIntentFactory() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        return implicitIntentFactory2;
    }

    @NotNull
    public final Locale getLocale() {
        Locale locale2 = this.locale;
        if (locale2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locale");
        }
        return locale2;
    }

    @NotNull
    public final NotificationCenterLandingSharePresenter getPresenter() {
        NotificationCenterLandingSharePresenter notificationCenterLandingSharePresenter = this.presenter;
        if (notificationCenterLandingSharePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return notificationCenterLandingSharePresenter;
    }

    @NotNull
    public final TimeSource getTimeSource() {
        TimeSource timeSource2 = this.timeSource;
        if (timeSource2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timeSource");
        }
        return timeSource2;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            Intent intent2 = this.k;
            if (i2 != -1 || intent == null || intent2 == null) {
                NotificationCenterLandingSharePresenter notificationCenterLandingSharePresenter = this.presenter;
                if (notificationCenterLandingSharePresenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                notificationCenterLandingSharePresenter.trackAppSelected(null);
            } else {
                ComponentName component = intent.getComponent();
                if (component != null) {
                    NotificationCenterLandingSharePresenter notificationCenterLandingSharePresenter2 = this.presenter;
                    if (notificationCenterLandingSharePresenter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                    }
                    notificationCenterLandingSharePresenter2.trackAppSelected(component.getPackageName());
                    Object clone = intent2.clone();
                    Objects.requireNonNull(clone, "null cannot be cast to non-null type android.content.Intent");
                    Intent intent3 = (Intent) clone;
                    intent3.setComponent(component);
                    startActivity(intent3);
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            }
            this.k = null;
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Kundle kundle = null;
        this.k = bundle != null ? (Intent) bundle.getParcelable("key_share_intent") : null;
        NotificationCenterLandingShareDependencies notificationCenterLandingShareDependencies = (NotificationCenterLandingShareDependencies) ComponentDependenciesKt.getDependencies(NotificationCenterLandingShareDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this));
        String stringExtra = getIntent().getStringExtra("key_id");
        Intrinsics.checkNotNullExpressionValue(stringExtra, "intent.getStringExtra(KEY_ID)");
        if (bundle != null) {
            kundle = (Kundle) bundle.getParcelable("key_state");
        }
        DaggerNotificationCenterLandingShareComponent.builder().dependencies(notificationCenterLandingShareDependencies).module(new NotificationCenterLandingShareModule(stringExtra, kundle)).build().inject(this);
        setContentView(com.avito.android.notification_center.R.layout.notification_center_landing_share);
        ViewGroup viewGroup = (ViewGroup) findViewById(16908290);
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        Locale locale2 = this.locale;
        if (locale2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locale");
        }
        TimeSource timeSource2 = this.timeSource;
        if (timeSource2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timeSource");
        }
        Intrinsics.checkNotNullExpressionValue(viewGroup, "contentView");
        ConnectivityProvider connectivityProvider2 = this.connectivityProvider;
        if (connectivityProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("connectivityProvider");
        }
        NotificationCenterLandingShareView.Impl impl = new NotificationCenterLandingShareView.Impl(analytics2, locale2, timeSource2, viewGroup, connectivityProvider2);
        NotificationCenterLandingSharePresenter notificationCenterLandingSharePresenter = this.presenter;
        if (notificationCenterLandingSharePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        notificationCenterLandingSharePresenter.attachView(impl);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        NotificationCenterLandingSharePresenter notificationCenterLandingSharePresenter = this.presenter;
        if (notificationCenterLandingSharePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        notificationCenterLandingSharePresenter.detachView();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        NotificationCenterLandingSharePresenter notificationCenterLandingSharePresenter = this.presenter;
        if (notificationCenterLandingSharePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Kundle state = notificationCenterLandingSharePresenter.getState();
        bundle.putParcelable("key_share_intent", this.k);
        bundle.putParcelable("key_state", state);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        NotificationCenterLandingSharePresenter notificationCenterLandingSharePresenter = this.presenter;
        if (notificationCenterLandingSharePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        notificationCenterLandingSharePresenter.attachRouter(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        NotificationCenterLandingSharePresenter notificationCenterLandingSharePresenter = this.presenter;
        if (notificationCenterLandingSharePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        notificationCenterLandingSharePresenter.detachRouter();
        super.onStop();
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setConnectivityProvider(@NotNull ConnectivityProvider connectivityProvider2) {
        Intrinsics.checkNotNullParameter(connectivityProvider2, "<set-?>");
        this.connectivityProvider = connectivityProvider2;
    }

    public final void setImplicitIntentFactory(@NotNull ImplicitIntentFactory implicitIntentFactory2) {
        Intrinsics.checkNotNullParameter(implicitIntentFactory2, "<set-?>");
        this.implicitIntentFactory = implicitIntentFactory2;
    }

    public final void setLocale(@NotNull Locale locale2) {
        Intrinsics.checkNotNullParameter(locale2, "<set-?>");
        this.locale = locale2;
    }

    public final void setPresenter(@NotNull NotificationCenterLandingSharePresenter notificationCenterLandingSharePresenter) {
        Intrinsics.checkNotNullParameter(notificationCenterLandingSharePresenter, "<set-?>");
        this.presenter = notificationCenterLandingSharePresenter;
    }

    public final void setTimeSource(@NotNull TimeSource timeSource2) {
        Intrinsics.checkNotNullParameter(timeSource2, "<set-?>");
        this.timeSource = timeSource2;
    }

    @Override // com.avito.android.notification_center.landing.share.NotificationCenterLandingShareRouter
    public void share(@Nullable String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str2, "url");
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        a(implicitIntentFactory2.shareIntent(str, str2));
    }

    @Override // com.avito.android.notification_center.landing.share.NotificationCenterLandingShareRouter
    public void share(@Nullable String str, @NotNull String str2, @NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(str2, "url");
        Intrinsics.checkNotNullParameter(uri, "imageUri");
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        a(implicitIntentFactory2.shareIntent(str, str2, uri));
    }
}
