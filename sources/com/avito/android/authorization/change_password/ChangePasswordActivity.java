package com.avito.android.authorization.change_password;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AuthIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.AuthParamsKt;
import com.avito.android.authorization.R;
import com.avito.android.authorization.change_password.ChangePasswordPresenter;
import com.avito.android.authorization.change_password.di.ChangePasswordComponent;
import com.avito.android.authorization.change_password.di.ChangePasswordDependencies;
import com.avito.android.authorization.change_password.di.DaggerChangePasswordComponent;
import com.avito.android.authorization.event.ChangePasswordFromEmailEvent;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.Bundles;
import com.avito.android.util.IntentsKt;
import com.avito.android.util.preferences.Preference;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b(\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\r\u0010\u0007J\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\tJ\u0017\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u00020!8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006)"}, d2 = {"Lcom/avito/android/authorization/change_password/ChangePasswordActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/authorization/change_password/ChangePasswordPresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "onDestroy", "outState", "onSaveInstanceState", "leaveScreen", "", Preference.PASSWORD, "openLogin", "(Ljava/lang/String;)V", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/authorization/change_password/ChangePasswordPresenter;", "presenter", "Lcom/avito/android/authorization/change_password/ChangePasswordPresenter;", "getPresenter", "()Lcom/avito/android/authorization/change_password/ChangePasswordPresenter;", "setPresenter", "(Lcom/avito/android/authorization/change_password/ChangePasswordPresenter;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "<init>", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class ChangePasswordActivity extends BaseActivity implements ChangePasswordPresenter.Router {
    @Inject
    public Analytics analytics;
    @Inject
    public ActivityIntentFactory intentFactory;
    @Inject
    public ChangePasswordPresenter presenter;

    @NotNull
    public final Analytics getAnalytics() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final ActivityIntentFactory getIntentFactory() {
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        return activityIntentFactory;
    }

    @NotNull
    public final ChangePasswordPresenter getPresenter() {
        ChangePasswordPresenter changePasswordPresenter = this.presenter;
        if (changePasswordPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return changePasswordPresenter;
    }

    @Override // com.avito.android.authorization.change_password.ChangePasswordPresenter.Router
    public void leaveScreen() {
        finish();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        String login = AuthParamsKt.getLogin(this);
        ChangePasswordComponent.Builder withActivity = DaggerChangePasswordComponent.builder().dependentOn((ChangePasswordDependencies) ComponentDependenciesKt.getDependencies(ChangePasswordDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).withActivity(this);
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        withActivity.withResources(resources).withPresenterState(bundle != null ? Bundles.getKundle(bundle, "presenter_state") : null).withLogin(login).withHash(AuthParamsKt.getHash(this)).build().inject(this);
        super.onCreate(bundle);
        setContentView(R.layout.change_password);
        View findViewById = findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(android.R.id.content)");
        ChangePasswordViewImpl changePasswordViewImpl = new ChangePasswordViewImpl(findViewById);
        ChangePasswordPresenter changePasswordPresenter = this.presenter;
        if (changePasswordPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        changePasswordPresenter.attachView(changePasswordViewImpl);
        if (bundle == null) {
            changePasswordViewImpl.requestFieldFocus();
            if (Intrinsics.areEqual(getIntent().getStringExtra("source"), "email")) {
                Analytics analytics2 = this.analytics;
                if (analytics2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("analytics");
                }
                analytics2.track(new ChangePasswordFromEmailEvent(login));
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        ChangePasswordPresenter changePasswordPresenter = this.presenter;
        if (changePasswordPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        changePasswordPresenter.detachView();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        ChangePasswordPresenter changePasswordPresenter = this.presenter;
        if (changePasswordPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Bundles.putKundle(bundle, "presenter_state", changePasswordPresenter.onSaveState());
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        ChangePasswordPresenter changePasswordPresenter = this.presenter;
        if (changePasswordPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        changePasswordPresenter.attachRouter(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        ChangePasswordPresenter changePasswordPresenter = this.presenter;
        if (changePasswordPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        changePasswordPresenter.detachRouter();
        super.onStop();
    }

    @Override // com.avito.android.authorization.change_password.ChangePasswordPresenter.Router
    public void openLogin(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Preference.PASSWORD);
        leaveScreen();
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        ActivityIntentFactory activityIntentFactory2 = this.intentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        startActivity(IntentsKt.withClearTopFlags(AuthIntentFactory.DefaultImpls.loginIntent$default(activityIntentFactory, activityIntentFactory2.profilePreviewIntent(), AuthParamsKt.getLogin(this), str, false, null, false, 56, null)));
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    public final void setPresenter(@NotNull ChangePasswordPresenter changePasswordPresenter) {
        Intrinsics.checkNotNullParameter(changePasswordPresenter, "<set-?>");
        this.presenter = changePasswordPresenter;
    }
}
