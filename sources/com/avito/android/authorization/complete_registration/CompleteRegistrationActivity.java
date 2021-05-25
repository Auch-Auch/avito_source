package com.avito.android.authorization.complete_registration;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.AuthParamsKt;
import com.avito.android.authorization.R;
import com.avito.android.authorization.complete_registration.CompleteRegistrationPresenter;
import com.avito.android.authorization.complete_registration.di.CompleteRegistrationComponent;
import com.avito.android.authorization.complete_registration.di.CompleteRegistrationDependencies;
import com.avito.android.authorization.complete_registration.di.DaggerCompleteRegistrationComponent;
import com.avito.android.authorization.event.CompleteRegistrationOpenedEvent;
import com.avito.android.authorization.smart_lock.ResolvableResult;
import com.avito.android.authorization.smart_lock.SmartLockSaver;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.Bundles;
import com.avito.android.util.IntentsKt;
import com.avito.android.util.Kundle;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b0\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000b\u0010\tJ)\u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0014\u0010\u0007J\u000f\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\tJ\u000f\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\tJ\u0017\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010#\u001a\u00020\"8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010*\u001a\u00020)8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u00061"}, d2 = {"Lcom/avito/android/authorization/complete_registration/CompleteRegistrationActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/authorization/complete_registration/CompleteRegistrationPresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "onDestroy", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "outState", "onSaveInstanceState", "completeRegistration", "leaveScreen", "Lcom/avito/android/authorization/smart_lock/ResolvableResult;", "status", "resolveResult", "(Lcom/avito/android/authorization/smart_lock/ResolvableResult;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/authorization/smart_lock/SmartLockSaver;", "smartLock", "Lcom/avito/android/authorization/smart_lock/SmartLockSaver;", "getSmartLock", "()Lcom/avito/android/authorization/smart_lock/SmartLockSaver;", "setSmartLock", "(Lcom/avito/android/authorization/smart_lock/SmartLockSaver;)V", "Lcom/avito/android/authorization/complete_registration/CompleteRegistrationPresenter;", "presenter", "Lcom/avito/android/authorization/complete_registration/CompleteRegistrationPresenter;", "getPresenter", "()Lcom/avito/android/authorization/complete_registration/CompleteRegistrationPresenter;", "setPresenter", "(Lcom/avito/android/authorization/complete_registration/CompleteRegistrationPresenter;)V", "<init>", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class CompleteRegistrationActivity extends BaseActivity implements CompleteRegistrationPresenter.Router {
    @Inject
    public Analytics analytics;
    @Inject
    public CompleteRegistrationPresenter presenter;
    @Inject
    public SmartLockSaver smartLock;

    @Override // com.avito.android.authorization.complete_registration.CompleteRegistrationPresenter.Router
    public void completeRegistration() {
        startActivity(IntentsKt.withClearTopFlags(com.avito.android.authorization.IntentsKt.withResult(AuthParamsKt.getTargetIntent(this), -1)));
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
    public final CompleteRegistrationPresenter getPresenter() {
        CompleteRegistrationPresenter completeRegistrationPresenter = this.presenter;
        if (completeRegistrationPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return completeRegistrationPresenter;
    }

    @NotNull
    public final SmartLockSaver getSmartLock() {
        SmartLockSaver smartLockSaver = this.smartLock;
        if (smartLockSaver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smartLock");
        }
        return smartLockSaver;
    }

    @Override // com.avito.android.authorization.complete_registration.CompleteRegistrationPresenter.Router
    public void leaveScreen() {
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 44) {
            SmartLockSaver smartLockSaver = this.smartLock;
            if (smartLockSaver == null) {
                Intrinsics.throwUninitializedPropertyAccessException("smartLock");
            }
            smartLockSaver.handleResult(i2, intent);
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Kundle kundle = null;
        CompleteRegistrationComponent.Builder withPresenterState = DaggerCompleteRegistrationComponent.builder().dependentOn((CompleteRegistrationDependencies) ComponentDependenciesKt.getDependencies(CompleteRegistrationDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).withActivity(this).withPresenterState(bundle != null ? Bundles.getKundle(bundle, "presenter_state") : null);
        if (bundle != null) {
            kundle = Bundles.getKundle(bundle, "smartlock");
        }
        withPresenterState.withSmartLockSaverState(kundle).withLogin(AuthParamsKt.getLogin(this)).withHash(AuthParamsKt.getHash(this)).build().inject(this);
        super.onCreate(bundle);
        setContentView(R.layout.complete_registration);
        if (bundle == null) {
            Analytics analytics2 = this.analytics;
            if (analytics2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analytics");
            }
            analytics2.track(new CompleteRegistrationOpenedEvent(AuthParamsKt.getLogin(this)));
        }
        CompleteRegistrationPresenter completeRegistrationPresenter = this.presenter;
        if (completeRegistrationPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        View findViewById = findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(android.R.id.content)");
        completeRegistrationPresenter.attachView(new CompleteRegistrationViewImpl(findViewById));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        CompleteRegistrationPresenter completeRegistrationPresenter = this.presenter;
        if (completeRegistrationPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        completeRegistrationPresenter.detachView();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        CompleteRegistrationPresenter completeRegistrationPresenter = this.presenter;
        if (completeRegistrationPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Bundles.putKundle(bundle, "presenter_state", completeRegistrationPresenter.onSaveState());
        SmartLockSaver smartLockSaver = this.smartLock;
        if (smartLockSaver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smartLock");
        }
        Bundles.putKundle(bundle, "smartlock", smartLockSaver.onSaveState());
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        CompleteRegistrationPresenter completeRegistrationPresenter = this.presenter;
        if (completeRegistrationPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        completeRegistrationPresenter.attachRouter(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        CompleteRegistrationPresenter completeRegistrationPresenter = this.presenter;
        if (completeRegistrationPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        completeRegistrationPresenter.detachRouter();
        super.onStop();
    }

    @Override // com.avito.android.authorization.complete_registration.CompleteRegistrationPresenter.Router
    public void resolveResult(@NotNull ResolvableResult resolvableResult) {
        Intrinsics.checkNotNullParameter(resolvableResult, "status");
        resolvableResult.resolve(this, 44);
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setPresenter(@NotNull CompleteRegistrationPresenter completeRegistrationPresenter) {
        Intrinsics.checkNotNullParameter(completeRegistrationPresenter, "<set-?>");
        this.presenter = completeRegistrationPresenter;
    }

    public final void setSmartLock(@NotNull SmartLockSaver smartLockSaver) {
        Intrinsics.checkNotNullParameter(smartLockSaver, "<set-?>");
        this.smartLock = smartLockSaver;
    }
}
