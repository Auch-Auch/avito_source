package com.avito.android.abuse.auth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AuthIntentFactory;
import com.avito.android.abuse.R;
import com.avito.android.abuse.auth.AuthQueryPresenter;
import com.avito.android.abuse.auth.di.AuthQueryDependencies;
import com.avito.android.abuse.auth.di.DaggerAuthQueryComponent;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.activity.BaseActivity;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b*\u0010\fJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0014¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\fJ)\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\fJ\u000f\u0010\u0018\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0018\u0010\fJ\u000f\u0010\u0019\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\fJ\u000f\u0010\u001a\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010$\u001a\u00020#8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lcom/avito/android/abuse/auth/AuthQueryActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/abuse/auth/AuthQueryPresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpActivityComponent", "(Landroid/os/Bundle;)Z", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "onDestroy", "onBackPressed", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "showLoginScreen", "closeWithResult", "leaveScreen", "getContentLayoutId", "()I", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/abuse/auth/AuthQueryPresenter;", "presenter", "Lcom/avito/android/abuse/auth/AuthQueryPresenter;", "getPresenter", "()Lcom/avito/android/abuse/auth/AuthQueryPresenter;", "setPresenter", "(Lcom/avito/android/abuse/auth/AuthQueryPresenter;)V", "<init>", "abuse_release"}, k = 1, mv = {1, 4, 2})
public final class AuthQueryActivity extends BaseActivity implements AuthQueryPresenter.Router {
    @Inject
    public ActivityIntentFactory intentFactory;
    @Inject
    public AuthQueryPresenter presenter;

    @Override // com.avito.android.abuse.auth.AuthQueryPresenter.Router
    public void closeWithResult() {
        setResult(-1);
        finish();
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.auth_query;
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
    public final AuthQueryPresenter getPresenter() {
        AuthQueryPresenter authQueryPresenter = this.presenter;
        if (authQueryPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return authQueryPresenter;
    }

    @Override // com.avito.android.abuse.auth.AuthQueryPresenter.Router
    public void leaveScreen() {
        setResult(0);
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        boolean z = i2 == -1;
        if (i != 42) {
            super.onActivityResult(i, i2, intent);
        } else if (z) {
            closeWithResult();
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        AuthQueryPresenter authQueryPresenter = this.presenter;
        if (authQueryPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        authQueryPresenter.onBackPressed();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        AuthQueryPresenter authQueryPresenter = this.presenter;
        if (authQueryPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        View containerView = getContainerView();
        Objects.requireNonNull(containerView, "null cannot be cast to non-null type android.view.ViewGroup");
        authQueryPresenter.attachView(new AuthQueryViewImpl((ViewGroup) containerView));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        AuthQueryPresenter authQueryPresenter = this.presenter;
        if (authQueryPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        authQueryPresenter.detachView();
        super.onDestroy();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        AuthQueryPresenter authQueryPresenter = this.presenter;
        if (authQueryPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        authQueryPresenter.attachRouter(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        AuthQueryPresenter authQueryPresenter = this.presenter;
        if (authQueryPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        authQueryPresenter.detachRouter();
        super.onStop();
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    public final void setPresenter(@NotNull AuthQueryPresenter authQueryPresenter) {
        Intrinsics.checkNotNullParameter(authQueryPresenter, "<set-?>");
        this.presenter = authQueryPresenter;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpActivityComponent(@Nullable Bundle bundle) {
        DaggerAuthQueryComponent.builder().dependentOn((AuthQueryDependencies) ComponentDependenciesKt.getDependencies(AuthQueryDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).build().inject(this);
        return true;
    }

    @Override // com.avito.android.abuse.auth.AuthQueryPresenter.Router
    public void showLoginScreen() {
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        startActivityForResult(AuthIntentFactory.DefaultImpls.authIntent$default(activityIntentFactory, null, AuthSource.SEND_ABUSE, null, 5, null), 42);
    }
}
