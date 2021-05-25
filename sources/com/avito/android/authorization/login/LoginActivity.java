package com.avito.android.authorization.login;

import a2.b.a.a.a;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AuthIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.AuthParamsKt;
import com.avito.android.authorization.event.HiddenLoginOpenedEvent;
import com.avito.android.authorization.event.LoginOpenedEvent;
import com.avito.android.authorization.login.LoginPresenter;
import com.avito.android.authorization.login.di.DaggerLoginComponent;
import com.avito.android.authorization.login.di.LoginComponent;
import com.avito.android.authorization.login.di.LoginDependencies;
import com.avito.android.authorization.login.di.LoginModule;
import com.avito.android.authorization.login_protection.LoginProtectionPhoneListActivityKt;
import com.avito.android.authorization.smart_lock.ResolvableResult;
import com.avito.android.authorization.smart_lock.SmartLockSaver;
import com.avito.android.code_confirmation.Source;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.RegisterLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui_components.R;
import com.avito.android.util.Bundles;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.IntentsKt;
import com.avito.android.util.Kundle;
import com.avito.android.util.ToastsKt;
import com.avito.android.util.preferences.Preference;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0010\u001cJI\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0015\u001a\u00020\u0014*\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0019\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\rH\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\rH\u0014¢\u0006\u0004\b\u001d\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u001e\u0010\u001cJ\u0017\u0010 \u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0013H\u0014¢\u0006\u0004\b \u0010!J)\u0010$\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010\u0013H\u0014¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u0017H\u0014¢\u0006\u0004\b'\u0010\u001aJ\u000f\u0010(\u001a\u00020\rH\u0016¢\u0006\u0004\b(\u0010\u001cJ\u0019\u0010)\u001a\u00020\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b)\u0010*J/\u0010+\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b+\u0010,J/\u0010-\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b-\u0010,J7\u0010.\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b.\u0010/J7\u00101\u001a\u00020\r2\u0006\u00100\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b1\u0010/J\u001f\u00103\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u0003H\u0016¢\u0006\u0004\b3\u00104J'\u00107\u001a\u00020\r2\u0006\u00100\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u00032\u0006\u00106\u001a\u00020\u0003H\u0016¢\u0006\u0004\b7\u00108J9\u0010<\u001a\u00020\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u0003092\b\u00100\u001a\u0004\u0018\u00010\u00032\u0006\u0010;\u001a\u00020\u0014H\u0016¢\u0006\u0004\b<\u0010=J\u0017\u0010@\u001a\u00020\r2\u0006\u0010?\u001a\u00020>H\u0016¢\u0006\u0004\b@\u0010AJ\u0017\u0010D\u001a\u00020\r2\u0006\u0010C\u001a\u00020BH\u0016¢\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u00020\rH\u0016¢\u0006\u0004\bF\u0010\u001cR\"\u0010H\u001a\u00020G8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010O\u001a\u00020N8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\"\u0010V\u001a\u00020U8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\"\u0010]\u001a\u00020\\8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\"\u0010d\u001a\u00020c8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\"\u0010k\u001a\u00020j8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bk\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\"\u0010r\u001a\u00020q8\u0006@\u0006X.¢\u0006\u0012\n\u0004\br\u0010s\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\"\u0010y\u001a\u00020x8\u0006@\u0006X.¢\u0006\u0012\n\u0004\by\u0010z\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~¨\u0006\u0001"}, d2 = {"Lcom/avito/android/authorization/login/LoginActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/authorization/login/LoginPresenter$Router;", "", "login", "phone", "text", "", "codeTimeout", "", "codeLength", "requestCode", "src", "", "c", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIILjava/lang/String;)V", "result", AuthSource.SEND_ABUSE, "(I)V", "Landroid/content/Intent;", "", AuthSource.BOOKING_ORDER, "(Landroid/content/Intent;)Z", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "onDestroy", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "resultCode", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "outState", "onSaveInstanceState", "completeLogin", "openPasswordRecovery", "(Ljava/lang/String;)V", "openPasswordResetCodeConfirmation", "(Ljava/lang/String;Ljava/lang/String;JI)V", "openLoginCodeConfirmation", "openTfaCodeConfirmation", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JI)V", "challengeId", "openPhoneAntihackLoginCodeConfirmation", "hash", "openChangePassword", "(Ljava/lang/String;Ljava/lang/String;)V", "phonePart", "inputHint", "openPhoneProving", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "phones", "isAntihackMode", "openPhoneList", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Z)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Lcom/avito/android/authorization/smart_lock/ResolvableResult;", "resolvableResult", "resolveResult", "(Lcom/avito/android/authorization/smart_lock/ResolvableResult;)V", "leaveScreen", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/authorization/smart_lock/SmartLockSaver;", "smartLock", "Lcom/avito/android/authorization/smart_lock/SmartLockSaver;", "getSmartLock", "()Lcom/avito/android/authorization/smart_lock/SmartLockSaver;", "setSmartLock", "(Lcom/avito/android/authorization/smart_lock/SmartLockSaver;)V", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/authorization/login/LoginInteractor;", "interactor", "Lcom/avito/android/authorization/login/LoginInteractor;", "getInteractor", "()Lcom/avito/android/authorization/login/LoginInteractor;", "setInteractor", "(Lcom/avito/android/authorization/login/LoginInteractor;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/authorization/login/LoginPresenter;", "presenter", "Lcom/avito/android/authorization/login/LoginPresenter;", "getPresenter", "()Lcom/avito/android/authorization/login/LoginPresenter;", "setPresenter", "(Lcom/avito/android/authorization/login/LoginPresenter;)V", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Lcom/avito/android/util/DialogRouter;", "getDialogRouter", "()Lcom/avito/android/util/DialogRouter;", "setDialogRouter", "(Lcom/avito/android/util/DialogRouter;)V", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "<init>", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class LoginActivity extends BaseActivity implements LoginPresenter.Router {
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public Analytics analytics;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public DialogRouter dialogRouter;
    @Inject
    public Features features;
    @Inject
    public LoginInteractor interactor;
    @Inject
    public LoginPresenter presenter;
    @Inject
    public SmartLockSaver smartLock;

    public final void a(int i) {
        Intent targetIntent = AuthParamsKt.getTargetIntent(this);
        targetIntent.setExtrasClassLoader(getClassLoader());
        startActivity(IntentsKt.withClearTopFlags(com.avito.android.authorization.IntentsKt.withResult(targetIntent, i)));
        finish();
    }

    public final boolean b(Intent intent) {
        return intent.getBooleanExtra("is_hidden_login", false);
    }

    public final void c(String str, String str2, String str3, long j, int i, int i2, String str4) {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivityForResult(IntentsKt.withClearTopFlags(activityIntentFactory2.codeConfirmationIntent(str, str2, str3, j, i, str4)), i2);
    }

    @Override // com.avito.android.authorization.login.LoginPresenter.Router
    public void completeLogin() {
        a(-1);
    }

    @Override // com.avito.android.authorization.login.LoginPresenter.Router
    public void followDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (deepLink instanceof RegisterLink) {
            ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
            if (activityIntentFactory2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
            }
            Intent intent2 = getIntent();
            Intrinsics.checkNotNullExpressionValue(intent2, "intent");
            Intent intent3 = AuthParamsKt.getIntent(intent2);
            if (intent3 == null) {
                ActivityIntentFactory activityIntentFactory3 = this.activityIntentFactory;
                if (activityIntentFactory3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
                }
                intent3 = activityIntentFactory3.profilePreviewIntent();
            }
            startActivity(activityIntentFactory2.registrationActivityIntent(intent3));
        } else if (intent != null) {
            try {
                startActivity(IntentsKt.makeSafeForExternalApps(intent));
            } catch (Exception unused) {
                ToastsKt.showToast$default(this, R.string.no_application_installed_to_perform_this_action, 0, 2, (Object) null);
            }
        }
    }

    @NotNull
    public final ActivityIntentFactory getActivityIntentFactory() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        return activityIntentFactory2;
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
    public final DeepLinkIntentFactory getDeepLinkIntentFactory() {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        return deepLinkIntentFactory2;
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
    public final Features getFeatures() {
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        return features2;
    }

    @NotNull
    public final LoginInteractor getInteractor() {
        LoginInteractor loginInteractor = this.interactor;
        if (loginInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        return loginInteractor;
    }

    @NotNull
    public final LoginPresenter getPresenter() {
        LoginPresenter loginPresenter = this.presenter;
        if (loginPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return loginPresenter;
    }

    @NotNull
    public final SmartLockSaver getSmartLock() {
        SmartLockSaver smartLockSaver = this.smartLock;
        if (smartLockSaver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smartLock");
        }
        return smartLockSaver;
    }

    @Override // com.avito.android.authorization.login.LoginPresenter.Router
    public void leaveScreen() {
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        if (!b(intent)) {
            a(0);
        } else {
            finish();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        String login;
        switch (i) {
            case 42:
                if (i2 == -1) {
                    completeLogin();
                    break;
                }
                break;
            case 43:
                if (i2 == -1) {
                    if (intent == null || (login = AuthParamsKt.getLogin(intent)) == null) {
                        throw new IllegalStateException("login must be specified");
                    }
                    String hash = AuthParamsKt.getHash(intent);
                    if (hash != null) {
                        openChangePassword(login, hash);
                        break;
                    } else {
                        throw new IllegalStateException("hash must be specified");
                    }
                }
                break;
            case 44:
                SmartLockSaver smartLockSaver = this.smartLock;
                if (smartLockSaver == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("smartLock");
                }
                smartLockSaver.handleResult(i2, intent);
                break;
            case 45:
            case 46:
            case 47:
                if (i2 != -1) {
                    finish();
                    break;
                } else {
                    LoginPresenter loginPresenter = this.presenter;
                    if (loginPresenter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                    }
                    loginPresenter.onPhoneVerified();
                    break;
                }
            case 48:
                if (i2 != -1) {
                    finish();
                    break;
                } else if (intent != null) {
                    boolean booleanExtra = intent.getBooleanExtra(LoginProtectionPhoneListActivityKt.EXTRA_IS_ANTIHACK_MODE, false);
                    if (!booleanExtra) {
                        if (!booleanExtra) {
                            completeLogin();
                            break;
                        }
                    } else {
                        LoginPresenter loginPresenter2 = this.presenter;
                        if (loginPresenter2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("presenter");
                        }
                        loginPresenter2.onPhoneVerified();
                        break;
                    }
                } else {
                    throw new IllegalStateException("data must be not null");
                }
                break;
            case 49:
                if (i2 != -1) {
                    finish();
                    break;
                } else {
                    completeLogin();
                    break;
                }
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        String login = AuthParamsKt.getLogin(intent);
        Intent intent2 = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent2, "intent");
        String stringExtra = intent2.getStringExtra(Preference.PASSWORD);
        Intent intent3 = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent3, "intent");
        boolean b = b(intent3);
        Intent intent4 = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent4, "intent");
        boolean booleanExtra = intent4.getBooleanExtra("skip_saved_login", false);
        String stringExtra2 = getIntent().getStringExtra(LoginModule.SUGGEST_KEY);
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        LoginComponent.Builder withActivity = DaggerLoginComponent.builder().dependentOn((LoginDependencies) ComponentDependenciesKt.getDependencies(LoginDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).withActivity(this);
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        LoginComponent.Builder withResources = withActivity.withResources(resources);
        Kundle kundle = null;
        LoginComponent.Builder withPresenterState = withResources.withPresenterState(bundle != null ? Bundles.getKundle(bundle, "presenter") : null);
        if (bundle != null) {
            kundle = Bundles.getKundle(bundle, "smartlock");
        }
        withPresenterState.withSmartLockSaverState(kundle).withSrc("login").withSuggestKey(stringExtra2).withRetry(false).build().inject(this);
        super.onCreate(bundle);
        setContentView(com.avito.android.authorization.R.layout.login);
        if (bundle == null) {
            LoginPresenter loginPresenter = this.presenter;
            if (loginPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            loginPresenter.setStartLogin(login, stringExtra, b, booleanExtra);
            if (b) {
                Analytics analytics2 = this.analytics;
                if (analytics2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("analytics");
                }
                analytics2.track(new HiddenLoginOpenedEvent());
            }
            Analytics analytics3 = this.analytics;
            if (analytics3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analytics");
            }
            analytics3.track(new LoginOpenedEvent());
        }
        View findViewById = findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(android.R.id.content)");
        DialogRouter dialogRouter2 = this.dialogRouter;
        if (dialogRouter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogRouter");
        }
        LoginViewImpl loginViewImpl = new LoginViewImpl(findViewById, dialogRouter2);
        LoginPresenter loginPresenter2 = this.presenter;
        if (loginPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        loginPresenter2.attachView(loginViewImpl);
        if (bundle == null) {
            loginViewImpl.requestFieldFocus();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        LoginPresenter loginPresenter = this.presenter;
        if (loginPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        loginPresenter.detachView();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        String login = AuthParamsKt.getLogin(intent);
        String stringExtra = intent.getStringExtra(Preference.PASSWORD);
        boolean b = b(intent);
        boolean booleanExtra = intent.getBooleanExtra("skip_saved_login", false);
        LoginPresenter loginPresenter = this.presenter;
        if (loginPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        loginPresenter.setStartLogin(login, stringExtra, b, booleanExtra);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        LoginPresenter loginPresenter = this.presenter;
        if (loginPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Bundles.putKundle(bundle, "presenter", loginPresenter.onSaveState());
        SmartLockSaver smartLockSaver = this.smartLock;
        if (smartLockSaver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smartLock");
        }
        Bundles.putKundle(bundle, "smartlock", smartLockSaver.onSaveState());
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        LoginPresenter loginPresenter = this.presenter;
        if (loginPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        loginPresenter.attachRouter(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        LoginPresenter loginPresenter = this.presenter;
        if (loginPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        loginPresenter.detachRouter();
        super.onStop();
    }

    @Override // com.avito.android.authorization.login.LoginPresenter.Router
    public void openChangePassword(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "login");
        Intrinsics.checkNotNullParameter(str2, "hash");
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivity(IntentsKt.withClearTopFlags(AuthIntentFactory.DefaultImpls.changePasswordIntent$default(activityIntentFactory2, str, str2, null, 4, null)));
    }

    @Override // com.avito.android.authorization.login.LoginPresenter.Router
    public void openLoginCodeConfirmation(@NotNull String str, @NotNull String str2, long j, int i) {
        Intrinsics.checkNotNullParameter(str, "login");
        Intrinsics.checkNotNullParameter(str2, "text");
        c(str, null, str2, j, i, 45, "login");
    }

    @Override // com.avito.android.authorization.login.LoginPresenter.Router
    public void openPasswordRecovery(@Nullable String str) {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivity(AuthIntentFactory.DefaultImpls.resetPasswordIntent$default(activityIntentFactory2, str, false, null, 6, null));
    }

    @Override // com.avito.android.authorization.login.LoginPresenter.Router
    public void openPasswordResetCodeConfirmation(@NotNull String str, @NotNull String str2, long j, int i) {
        Intrinsics.checkNotNullParameter(str, "login");
        Intrinsics.checkNotNullParameter(str2, "text");
        c(str, null, str2, j, i, 43, Source.AUTHORIZATION);
    }

    @Override // com.avito.android.authorization.login.LoginPresenter.Router
    public void openPhoneAntihackLoginCodeConfirmation(@NotNull String str, @NotNull String str2, @NotNull String str3, long j, int i) {
        a.Z0(str, "challengeId", str2, "login", str3, "text");
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivityForResult(IntentsKt.withClearTopFlags(activityIntentFactory2.phoneAntihackCodeConfirmationIntent(str, str2, str3, j, i, Source.PHONE_ANTIHACK)), 47);
    }

    @Override // com.avito.android.authorization.login.LoginPresenter.Router
    public void openPhoneList(@Nullable String str, @NotNull List<String> list, @Nullable String str2, boolean z) {
        Intrinsics.checkNotNullParameter(list, "phones");
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivityForResult(activityIntentFactory2.antihackPhoneListIntent(str, list, str2, z), 48);
    }

    @Override // com.avito.android.authorization.login.LoginPresenter.Router
    public void openPhoneProving(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        a.Z0(str, "challengeId", str2, "phonePart", str3, "inputHint");
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivityForResult(IntentsKt.withClearTopFlags(AuthIntentFactory.DefaultImpls.phoneProvingIntent$default(activityIntentFactory2, str, str2, str3, false, 8, null)), 46);
    }

    @Override // com.avito.android.authorization.login.LoginPresenter.Router
    public void openTfaCodeConfirmation(@NotNull String str, @NotNull String str2, @NotNull String str3, long j, int i) {
        a.Z0(str, "phone", str2, "login", str3, "text");
        c(str2, str, str3, j, i, 49, "login");
    }

    @Override // com.avito.android.authorization.login.LoginPresenter.Router
    public void resolveResult(@NotNull ResolvableResult resolvableResult) {
        Intrinsics.checkNotNullParameter(resolvableResult, "resolvableResult");
        resolvableResult.resolve(this, 44);
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setDialogRouter(@NotNull DialogRouter dialogRouter2) {
        Intrinsics.checkNotNullParameter(dialogRouter2, "<set-?>");
        this.dialogRouter = dialogRouter2;
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setInteractor(@NotNull LoginInteractor loginInteractor) {
        Intrinsics.checkNotNullParameter(loginInteractor, "<set-?>");
        this.interactor = loginInteractor;
    }

    public final void setPresenter(@NotNull LoginPresenter loginPresenter) {
        Intrinsics.checkNotNullParameter(loginPresenter, "<set-?>");
        this.presenter = loginPresenter;
    }

    public final void setSmartLock(@NotNull SmartLockSaver smartLockSaver) {
        Intrinsics.checkNotNullParameter(smartLockSaver, "<set-?>");
        this.smartLock = smartLockSaver;
    }
}
