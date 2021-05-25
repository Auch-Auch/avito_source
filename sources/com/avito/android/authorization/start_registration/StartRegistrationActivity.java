package com.avito.android.authorization.start_registration;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.authorization.AuthParamsKt;
import com.avito.android.authorization.R;
import com.avito.android.authorization.reset_password.StartRegistrationViewImpl;
import com.avito.android.authorization.start_registration.StartRegistrationPresenter;
import com.avito.android.authorization.start_registration.di.DaggerStartRegistrationComponent;
import com.avito.android.authorization.start_registration.di.StartRegistrationComponent;
import com.avito.android.authorization.start_registration.di.StartRegistrationDependencies;
import com.avito.android.code_confirmation.Source;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.Bundles;
import com.avito.android.util.IntentsKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b4\u0010\u0010J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J)\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0012\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0014\u0010\u0007J'\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ/\u0010 \u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\bH\u0016¢\u0006\u0004\b \u0010!J\u001f\u0010\"\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\"\u0010#J\u001f\u0010$\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0016¢\u0006\u0004\b$\u0010#J\u000f\u0010%\u001a\u00020\u0005H\u0016¢\u0006\u0004\b%\u0010\u0010R\"\u0010'\u001a\u00020&8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010.\u001a\u00020-8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u00065"}, d2 = {"Lcom/avito/android/authorization/start_registration/StartRegistrationActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/authorization/start_registration/StartRegistrationPresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onStart", "()V", "onStop", "onDestroy", "outState", "onSaveInstanceState", "", "login", "hash", "", "isPhoneUsed", "finishStartRegistration", "(Ljava/lang/String;Ljava/lang/String;Z)V", "text", "", "codeTimeout", "codeLength", "openCodeConfirmation", "(Ljava/lang/String;Ljava/lang/String;JI)V", "openSelectProfile", "(Ljava/lang/String;Ljava/lang/String;)V", "openCompleteRegistration", "leaveScreen", "Lcom/avito/android/authorization/start_registration/StartRegistrationPresenter;", "presenter", "Lcom/avito/android/authorization/start_registration/StartRegistrationPresenter;", "getPresenter", "()Lcom/avito/android/authorization/start_registration/StartRegistrationPresenter;", "setPresenter", "(Lcom/avito/android/authorization/start_registration/StartRegistrationPresenter;)V", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "<init>", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class StartRegistrationActivity extends BaseActivity implements StartRegistrationPresenter.Router {
    @Inject
    public ActivityIntentFactory intentFactory;
    @Inject
    public StartRegistrationPresenter presenter;

    @Override // com.avito.android.authorization.start_registration.StartRegistrationPresenter.Router
    public void finishStartRegistration(@NotNull String str, @NotNull String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "login");
        Intrinsics.checkNotNullParameter(str2, "hash");
        if (z) {
            openSelectProfile(str, str2);
        } else {
            openCompleteRegistration(str, str2);
        }
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
    public final StartRegistrationPresenter getPresenter() {
        StartRegistrationPresenter startRegistrationPresenter = this.presenter;
        if (startRegistrationPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return startRegistrationPresenter;
    }

    @Override // com.avito.android.authorization.start_registration.StartRegistrationPresenter.Router
    public void leaveScreen() {
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1 || i != 1) {
            return;
        }
        if (intent != null) {
            boolean isPhoneUsed = AuthParamsKt.isPhoneUsed(intent);
            String hash = AuthParamsKt.getHash(intent);
            if (hash != null) {
                String login = AuthParamsKt.getLogin(intent);
                if (login != null) {
                    finishStartRegistration(login, hash, isPhoneUsed);
                    return;
                }
                throw new IllegalStateException("Login can't be null");
            }
            throw new IllegalStateException("Hash can't be null");
        }
        throw new IllegalStateException("PhoneUsed flag can't be null");
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        String login = AuthParamsKt.getLogin(intent);
        StartRegistrationComponent.Builder dependentOn = DaggerStartRegistrationComponent.builder().dependentOn((StartRegistrationDependencies) ComponentDependenciesKt.getDependencies(StartRegistrationDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this)));
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        dependentOn.withResources(resources).withPresenterState(bundle != null ? Bundles.getKundle(bundle, "presenter_state") : null).withSrc(Source.REGISTRATION).withRetry(false).build().inject(this);
        setContentView(R.layout.start_registration);
        if (bundle == null) {
            StartRegistrationPresenter startRegistrationPresenter = this.presenter;
            if (startRegistrationPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            startRegistrationPresenter.setStartLogin(login);
        }
        View findViewById = findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(android.R.id.content)");
        StartRegistrationViewImpl startRegistrationViewImpl = new StartRegistrationViewImpl(findViewById);
        StartRegistrationPresenter startRegistrationPresenter2 = this.presenter;
        if (startRegistrationPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        startRegistrationPresenter2.attachView(startRegistrationViewImpl);
        if (bundle == null) {
            startRegistrationViewImpl.requestFieldFocus();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        StartRegistrationPresenter startRegistrationPresenter = this.presenter;
        if (startRegistrationPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        startRegistrationPresenter.detachView();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        StartRegistrationPresenter startRegistrationPresenter = this.presenter;
        if (startRegistrationPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Bundles.putKundle(bundle, "presenter_state", startRegistrationPresenter.onSaveState());
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        StartRegistrationPresenter startRegistrationPresenter = this.presenter;
        if (startRegistrationPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        startRegistrationPresenter.attachRouter(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        StartRegistrationPresenter startRegistrationPresenter = this.presenter;
        if (startRegistrationPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        startRegistrationPresenter.detachRouter();
        super.onStop();
    }

    @Override // com.avito.android.authorization.start_registration.StartRegistrationPresenter.Router
    public void openCodeConfirmation(@NotNull String str, @NotNull String str2, long j, int i) {
        Intrinsics.checkNotNullParameter(str, "login");
        Intrinsics.checkNotNullParameter(str2, "text");
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        startActivityForResult(IntentsKt.withClearTopFlags(activityIntentFactory.codeConfirmationIntent(str, null, str2, j, i, Source.REGISTRATION)), 1);
    }

    @Override // com.avito.android.authorization.start_registration.StartRegistrationPresenter.Router
    public void openCompleteRegistration(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "login");
        Intrinsics.checkNotNullParameter(str2, "hash");
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        startActivityForResult(activityIntentFactory.completeRegistrationIntent(AuthParamsKt.getTargetIntent(this), str, str2), 3);
    }

    @Override // com.avito.android.authorization.start_registration.StartRegistrationPresenter.Router
    public void openSelectProfile(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "login");
        Intrinsics.checkNotNullParameter(str2, "hash");
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        startActivityForResult(activityIntentFactory.selectProfileIntent(AuthParamsKt.getTargetIntent(this), str, str2), 2);
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    public final void setPresenter(@NotNull StartRegistrationPresenter startRegistrationPresenter) {
        Intrinsics.checkNotNullParameter(startRegistrationPresenter, "<set-?>");
        this.presenter = startRegistrationPresenter;
    }
}
