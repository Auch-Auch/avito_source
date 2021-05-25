package com.avito.android.authorization.reset_password;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AuthIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.AuthParamsKt;
import com.avito.android.authorization.R;
import com.avito.android.authorization.event.ResetPasswordOpenedEvent;
import com.avito.android.authorization.reset_password.ResetPasswordPresenter;
import com.avito.android.authorization.reset_password.di.DaggerResetPasswordComponent;
import com.avito.android.authorization.reset_password.di.ResetPasswordComponent;
import com.avito.android.authorization.reset_password.di.ResetPasswordDependencies;
import com.avito.android.code_confirmation.Source;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.Bundles;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.IntentsKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b=\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000b\u0010\tJ)\u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0014\u0010\u0007J/\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0005H\u0016¢\u0006\u0004\b \u0010\tR\"\u0010\"\u001a\u00020!8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010)\u001a\u00020(8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00100\u001a\u00020/8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u00107\u001a\u0002068\u0006@\u0006X.¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<¨\u0006>"}, d2 = {"Lcom/avito/android/authorization/reset_password/ResetPasswordActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/authorization/reset_password/ResetPasswordPresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "onDestroy", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "outState", "onSaveInstanceState", "", "login", "text", "", "codeTimeout", "codeLength", "openCodeConfirmation", "(Ljava/lang/String;Ljava/lang/String;JI)V", "hash", "openChangePassword", "(Ljava/lang/String;Ljava/lang/String;)V", "leaveScreen", "Lcom/avito/android/authorization/reset_password/ResetPasswordPresenter;", "presenter", "Lcom/avito/android/authorization/reset_password/ResetPasswordPresenter;", "getPresenter", "()Lcom/avito/android/authorization/reset_password/ResetPasswordPresenter;", "setPresenter", "(Lcom/avito/android/authorization/reset_password/ResetPasswordPresenter;)V", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Lcom/avito/android/util/DialogRouter;", "getDialogRouter", "()Lcom/avito/android/util/DialogRouter;", "setDialogRouter", "(Lcom/avito/android/util/DialogRouter;)V", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "<init>", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class ResetPasswordActivity extends BaseActivity implements ResetPasswordPresenter.Router {
    @Inject
    public Analytics analytics;
    @Inject
    public DialogRouter dialogRouter;
    @Inject
    public ActivityIntentFactory intentFactory;
    @Inject
    public ResetPasswordPresenter presenter;

    @NotNull
    public final Analytics getAnalytics() {
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
    public final ActivityIntentFactory getIntentFactory() {
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        return activityIntentFactory;
    }

    @NotNull
    public final ResetPasswordPresenter getPresenter() {
        ResetPasswordPresenter resetPasswordPresenter = this.presenter;
        if (resetPasswordPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return resetPasswordPresenter;
    }

    @Override // com.avito.android.authorization.reset_password.ResetPasswordPresenter.Router
    public void leaveScreen() {
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        String login;
        super.onActivityResult(i, i2, intent);
        if (i != 1 || i2 != -1) {
            return;
        }
        if (intent == null || (login = AuthParamsKt.getLogin(intent)) == null) {
            throw new IllegalStateException("login must be specified");
        }
        String hash = AuthParamsKt.getHash(intent);
        if (hash != null) {
            openChangePassword(login, hash);
            return;
        }
        throw new IllegalStateException("hash must be specified");
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        String login = AuthParamsKt.getLogin(intent);
        ResetPasswordComponent.Builder withActivity = DaggerResetPasswordComponent.builder().dependentOn((ResetPasswordDependencies) ComponentDependenciesKt.getDependencies(ResetPasswordDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).withActivity(this);
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        withActivity.withResources(resources).withPresenterState(bundle != null ? Bundles.getKundle(bundle, "presenter_state") : null).withSrc(Source.AUTHORIZATION).withRetry(false).build().inject(this);
        super.onCreate(bundle);
        setContentView(R.layout.reset_password);
        if (bundle == null) {
            ResetPasswordPresenter resetPasswordPresenter = this.presenter;
            if (resetPasswordPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            resetPasswordPresenter.setStartLogin(login);
            Analytics analytics2 = this.analytics;
            if (analytics2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analytics");
            }
            analytics2.track(new ResetPasswordOpenedEvent(getIntent().getStringExtra("src")));
        }
        View findViewById = findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(android.R.id.content)");
        DialogRouter dialogRouter2 = this.dialogRouter;
        if (dialogRouter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogRouter");
        }
        ResetPasswordViewImpl resetPasswordViewImpl = new ResetPasswordViewImpl(findViewById, dialogRouter2);
        ResetPasswordPresenter resetPasswordPresenter2 = this.presenter;
        if (resetPasswordPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        resetPasswordPresenter2.attachView(resetPasswordViewImpl);
        if (bundle == null) {
            resetPasswordViewImpl.requestFieldFocus();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        ResetPasswordPresenter resetPasswordPresenter = this.presenter;
        if (resetPasswordPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        resetPasswordPresenter.detachView();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        ResetPasswordPresenter resetPasswordPresenter = this.presenter;
        if (resetPasswordPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Bundles.putKundle(bundle, "presenter_state", resetPasswordPresenter.onSaveState());
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        ResetPasswordPresenter resetPasswordPresenter = this.presenter;
        if (resetPasswordPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        resetPasswordPresenter.attachRouter(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        ResetPasswordPresenter resetPasswordPresenter = this.presenter;
        if (resetPasswordPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        resetPasswordPresenter.detachRouter();
        super.onStop();
    }

    @Override // com.avito.android.authorization.reset_password.ResetPasswordPresenter.Router
    public void openChangePassword(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "login");
        Intrinsics.checkNotNullParameter(str2, "hash");
        leaveScreen();
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        startActivity(IntentsKt.withClearTopFlags(AuthIntentFactory.DefaultImpls.changePasswordIntent$default(activityIntentFactory, str, str2, null, 4, null)));
    }

    @Override // com.avito.android.authorization.reset_password.ResetPasswordPresenter.Router
    public void openCodeConfirmation(@NotNull String str, @NotNull String str2, long j, int i) {
        Intrinsics.checkNotNullParameter(str, "login");
        Intrinsics.checkNotNullParameter(str2, "text");
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        startActivityForResult(IntentsKt.withClearTopFlags(activityIntentFactory.codeConfirmationIntent(str, null, str2, j, i, Source.AUTHORIZATION)), 1);
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setDialogRouter(@NotNull DialogRouter dialogRouter2) {
        Intrinsics.checkNotNullParameter(dialogRouter2, "<set-?>");
        this.dialogRouter = dialogRouter2;
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    public final void setPresenter(@NotNull ResetPasswordPresenter resetPasswordPresenter) {
        Intrinsics.checkNotNullParameter(resetPasswordPresenter, "<set-?>");
        this.presenter = resetPasswordPresenter;
    }
}
