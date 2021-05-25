package com.avito.android.authorization.auth;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AuthIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.authorization.AuthParamsKt;
import com.avito.android.authorization.IntentsKt;
import com.avito.android.authorization.auth.AuthPresenter;
import com.avito.android.authorization.auth.di.AuthComponent;
import com.avito.android.authorization.auth.di.AuthDependencies;
import com.avito.android.authorization.auth.di.DaggerAuthComponent;
import com.avito.android.authorization.event.AuthOpenEvent;
import com.avito.android.authorization.event.RegistrationOpenedEvent;
import com.avito.android.authorization.event.SocialButtonClickedEvent;
import com.avito.android.authorization.event.SocialButtonClickedEventKt;
import com.avito.android.authorization.smart_lock.ResolvableResult;
import com.avito.android.authorization.smart_lock.SmartLockLoader;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.performance.DiInjectTracker;
import com.avito.android.performance.ScreenTracker;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.registration.RegisteredProfile;
import com.avito.android.social.SocialActivity;
import com.avito.android.social.SocialType;
import com.avito.android.social.SocialTypeToStringMapper;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui_components.R;
import com.avito.android.util.Bundles;
import com.avito.android.util.Keyboards;
import com.avito.android.util.Kundle;
import com.avito.android.util.ToastsKt;
import com.avito.android.util.preferences.Preference;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bp\u0010\rJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000f\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0010\u0010\rJ\u000f\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\rJ\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0014\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\rJ\u0017\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0016H\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\"\u0010\rJ)\u0010'\u001a\u00020\u00052\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#2\b\u0010&\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b)\u0010\u0007J\u0017\u0010+\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\bH\u0014¢\u0006\u0004\b+\u0010\u000bJ\u000f\u0010,\u001a\u00020\u0005H\u0016¢\u0006\u0004\b,\u0010\rJ\u0017\u0010/\u001a\u00020\u00052\u0006\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b/\u00100J5\u00106\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00162\u0006\u00102\u001a\u00020\u00162\f\u00105\u001a\b\u0012\u0004\u0012\u000204032\u0006\u0010\u001f\u001a\u00020\u0016H\u0016¢\u0006\u0004\b6\u00107R\"\u00109\u001a\u0002088\u0006@\u0006X.¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010@\u001a\u00020?8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010G\u001a\u00020F8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010N\u001a\u00020M8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010U\u001a\u00020T8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\"\u0010\\\u001a\u00020[8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\"\u0010c\u001a\u00020b8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\"\u0010j\u001a\u00020i8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010o¨\u0006q"}, d2 = {"Lcom/avito/android/authorization/auth/OldAuthActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/authorization/auth/AuthPresenter$Router;", "Landroid/content/Intent;", "intent", "", AuthSource.SEND_ABUSE, "(Landroid/content/Intent;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onBackPressed", "onStop", "onDestroy", "openRegistration", "", "skipSavedLogin", "openLogin", "(Z)V", "", "login", Preference.PASSWORD, "(Ljava/lang/String;Ljava/lang/String;)V", "cancel", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "socialType", "openSocialLogin", "(Ljava/lang/String;)V", "openSuggests", "", "requestCode", "resultCode", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onNewIntent", "outState", "onSaveInstanceState", "finishAuth", "Lcom/avito/android/authorization/smart_lock/ResolvableResult;", "result", "resolveResult", "(Lcom/avito/android/authorization/smart_lock/ResolvableResult;)V", "title", "suggestKey", "", "Lcom/avito/android/remote/model/registration/RegisteredProfile;", "profiles", "openSocialRegistrationSuggestsScreen", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/social/SocialTypeToStringMapper;", "socialTypeToStringMapper", "Lcom/avito/android/social/SocialTypeToStringMapper;", "getSocialTypeToStringMapper", "()Lcom/avito/android/social/SocialTypeToStringMapper;", "setSocialTypeToStringMapper", "(Lcom/avito/android/social/SocialTypeToStringMapper;)V", "Lcom/avito/android/authorization/smart_lock/SmartLockLoader;", "smartLock", "Lcom/avito/android/authorization/smart_lock/SmartLockLoader;", "getSmartLock", "()Lcom/avito/android/authorization/smart_lock/SmartLockLoader;", "setSmartLock", "(Lcom/avito/android/authorization/smart_lock/SmartLockLoader;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/authorization/auth/AuthPresenter;", "presenter", "Lcom/avito/android/authorization/auth/AuthPresenter;", "getPresenter", "()Lcom/avito/android/authorization/auth/AuthPresenter;", "setPresenter", "(Lcom/avito/android/authorization/auth/AuthPresenter;)V", "Lcom/avito/android/performance/ScreenTracker;", "screenTracker", "Lcom/avito/android/performance/ScreenTracker;", "getScreenTracker", "()Lcom/avito/android/performance/ScreenTracker;", "setScreenTracker", "(Lcom/avito/android/performance/ScreenTracker;)V", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "<init>", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class OldAuthActivity extends BaseActivity implements AuthPresenter.Router {
    @Inject
    public Analytics analytics;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public Features features;
    @Inject
    public ActivityIntentFactory intentFactory;
    @Inject
    public AuthPresenter presenter;
    @Inject
    public ScreenTracker screenTracker;
    @Inject
    public SmartLockLoader smartLock;
    @Inject
    public SocialTypeToStringMapper socialTypeToStringMapper;

    public final void a(Intent intent) {
        if (IntentsKt.getResult(intent) == -1) {
            Intent intent2 = AuthParamsKt.getIntent(intent);
            Keyboards.hideKeyboard(this);
            if (intent2 != null) {
                startActivity(intent2);
            }
            setResult(-1, AuthParamsKt.getSuccessAuthResultData(this));
            finish();
        }
    }

    @Override // com.avito.android.authorization.auth.AuthPresenter.Router
    public void cancel() {
        finish();
    }

    @Override // com.avito.android.authorization.auth.AuthPresenter.Router
    public void finishAuth() {
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        Intent intent2 = AuthParamsKt.getIntent(intent);
        Keyboards.hideKeyboard(this);
        if (intent2 != null) {
            startActivity(intent2);
        }
        setResult(-1, AuthParamsKt.getSuccessAuthResultData(this));
        finish();
    }

    @Override // com.avito.android.authorization.auth.AuthPresenter.Router
    public void followDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent != null) {
            try {
                startActivity(com.avito.android.util.IntentsKt.makeSafeForExternalApps(intent));
            } catch (Exception unused) {
                ToastsKt.showToast$default(this, R.string.no_application_installed_to_perform_this_action, 0, 2, (Object) null);
            }
        }
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
    public final Features getFeatures() {
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        return features2;
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
    public final AuthPresenter getPresenter() {
        AuthPresenter authPresenter = this.presenter;
        if (authPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return authPresenter;
    }

    @NotNull
    public final ScreenTracker getScreenTracker() {
        ScreenTracker screenTracker2 = this.screenTracker;
        if (screenTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenTracker");
        }
        return screenTracker2;
    }

    @NotNull
    public final SmartLockLoader getSmartLock() {
        SmartLockLoader smartLockLoader = this.smartLock;
        if (smartLockLoader == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smartLock");
        }
        return smartLockLoader;
    }

    @NotNull
    public final SocialTypeToStringMapper getSocialTypeToStringMapper() {
        SocialTypeToStringMapper socialTypeToStringMapper2 = this.socialTypeToStringMapper;
        if (socialTypeToStringMapper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("socialTypeToStringMapper");
        }
        return socialTypeToStringMapper2;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        String str = null;
        if (i == 2) {
            AuthPresenter authPresenter = this.presenter;
            if (authPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            authPresenter.show();
            if (i2 == -1) {
                String stringExtra = intent != null ? intent.getStringExtra(SocialActivity.EXTRA_SOCIAL_EMAIL) : null;
                String stringExtra2 = intent != null ? intent.getStringExtra(SocialActivity.EXTRA_SOCIAL_TOKEN) : null;
                SocialType socialType = (SocialType) (intent != null ? intent.getSerializableExtra(SocialActivity.EXTRA_SOCIAL_TYPE) : null);
                if (intent != null) {
                    str = intent.getStringExtra(SocialActivity.EXTRA_SOCIAL_USER);
                }
                AuthPresenter authPresenter2 = this.presenter;
                if (authPresenter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                SocialTypeToStringMapper socialTypeToStringMapper2 = this.socialTypeToStringMapper;
                if (socialTypeToStringMapper2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("socialTypeToStringMapper");
                }
                authPresenter2.onSocialLoginSuccess(socialTypeToStringMapper2.mapToStringOrNull(socialType), stringExtra2, stringExtra, str);
            } else if (i2 == 0) {
                AuthPresenter authPresenter3 = this.presenter;
                if (authPresenter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                authPresenter3.onSocialLoginCanceled();
            } else if (i2 == 1) {
                AuthPresenter authPresenter4 = this.presenter;
                if (authPresenter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                authPresenter4.onSocialLoginFailure();
            }
        } else if (i != 3) {
            if (i == 4) {
                SmartLockLoader smartLockLoader = this.smartLock;
                if (smartLockLoader == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("smartLock");
                }
                smartLockLoader.handleResult(i2, intent);
            } else if (i != 5) {
                super.onActivityResult(i, i2, intent);
            } else if (i2 == -1) {
                String social = intent != null ? AuthParamsKt.getSocial(intent) : null;
                if (intent != null) {
                    str = AuthParamsKt.getLogin(intent);
                }
                if (social != null) {
                    Analytics analytics2 = this.analytics;
                    if (analytics2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("analytics");
                    }
                    analytics2.track(new SocialButtonClickedEvent(SocialButtonClickedEventKt.SUGGEST, social));
                    openSocialLogin(social);
                } else if (str != null) {
                    openLogin(str, "");
                    AuthPresenter authPresenter5 = this.presenter;
                    if (authPresenter5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                    }
                    authPresenter5.show();
                } else {
                    AuthPresenter authPresenter6 = this.presenter;
                    if (authPresenter6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                    }
                    authPresenter6.setSkipSavedLogin(true);
                    AuthPresenter authPresenter7 = this.presenter;
                    if (authPresenter7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                    }
                    authPresenter7.show();
                }
            } else if (i2 == 0) {
                cancel();
            }
        } else if (i2 == -1) {
            finishAuth();
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        AuthPresenter authPresenter = this.presenter;
        if (authPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        authPresenter.onBackPressed();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Timer started = DiInjectTracker.Companion.started();
        String stringExtra = getIntent().getStringExtra("src");
        AuthComponent.Builder withActivity = DaggerAuthComponent.builder().dependentOn((AuthDependencies) ComponentDependenciesKt.getDependencies(AuthDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).withActivity(this);
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        AuthComponent.Builder withResources = withActivity.withResources(resources);
        Kundle kundle = null;
        AuthComponent.Builder withPresenterState = withResources.withPresenterState(bundle != null ? Bundles.getKundle(bundle, "presenterState") : null);
        if (bundle != null) {
            kundle = Bundles.getKundle(bundle, "smart_lock");
        }
        withPresenterState.withSmartLockState(kundle).withSrc(stringExtra).build().inject(this);
        ScreenTracker screenTracker2 = this.screenTracker;
        if (screenTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenTracker");
        }
        screenTracker2.getDiInject().finished(started);
        ScreenTracker screenTracker3 = this.screenTracker;
        if (screenTracker3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenTracker");
        }
        screenTracker3.getInit().started();
        super.onCreate(bundle);
        setContentView(com.avito.android.authorization.R.layout.auth);
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        a(intent);
        if (bundle == null) {
            Analytics analytics2 = this.analytics;
            if (analytics2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analytics");
            }
            analytics2.track(new AuthOpenEvent(stringExtra));
        }
        ScreenTracker screenTracker4 = this.screenTracker;
        if (screenTracker4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenTracker");
        }
        screenTracker4.resetSession();
        AuthPresenter authPresenter = this.presenter;
        if (authPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        View findViewById = findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(android.R.id.content)");
        authPresenter.attachView(new AuthViewImpl(findViewById));
        ScreenTracker screenTracker5 = this.screenTracker;
        if (screenTracker5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenTracker");
        }
        screenTracker5.getInit().finished();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        ScreenTracker screenTracker2 = this.screenTracker;
        if (screenTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenTracker");
        }
        screenTracker2.stop();
        AuthPresenter authPresenter = this.presenter;
        if (authPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        authPresenter.detachView();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        setIntent(intent);
        a(intent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        AuthPresenter authPresenter = this.presenter;
        if (authPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Bundle putKundle = Bundles.putKundle(bundle, "presenterState", authPresenter.onSaveState());
        SmartLockLoader smartLockLoader = this.smartLock;
        if (smartLockLoader == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smartLock");
        }
        Bundles.putKundle(putKundle, "smart_lock", smartLockLoader.onSaveState());
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        AuthPresenter authPresenter = this.presenter;
        if (authPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        authPresenter.attachRouter(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        AuthPresenter authPresenter = this.presenter;
        if (authPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        authPresenter.detachRouter();
        super.onStop();
    }

    @Override // com.avito.android.authorization.auth.AuthPresenter.Router
    public void openLogin(boolean z) {
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        startActivityForResult(AuthIntentFactory.DefaultImpls.loginIntent$default(activityIntentFactory, intent, null, null, false, null, z, 30, null), 1);
    }

    @Override // com.avito.android.authorization.auth.AuthPresenter.Router
    public void openRegistration() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        analytics2.track(new RegistrationOpenedEvent());
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        startActivityForResult(activityIntentFactory.registrationActivityIntent(intent), 3);
    }

    @Override // com.avito.android.authorization.auth.AuthPresenter.Router
    public void openSocialLogin(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "socialType");
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        startActivityForResult(activityIntentFactory.createSocialLoginIntent(str), 2);
    }

    @Override // com.avito.android.authorization.auth.AuthPresenter.Router
    public void openSocialRegistrationSuggestsScreen(@NotNull String str, @NotNull String str2, @NotNull List<RegisteredProfile> list, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "suggestKey");
        Intrinsics.checkNotNullParameter(list, "profiles");
        Intrinsics.checkNotNullParameter(str3, "socialType");
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        try {
            startActivity(com.avito.android.util.IntentsKt.makeSafeForExternalApps(activityIntentFactory.socialRegistrationSuggestsIntent(intent, str, str2, list, str3)));
        } catch (Exception unused) {
            ToastsKt.showToast$default(this, R.string.no_application_installed_to_perform_this_action, 0, 2, (Object) null);
        }
    }

    @Override // com.avito.android.authorization.auth.AuthPresenter.Router
    public void openSuggests() {
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        startActivityForResult(activityIntentFactory.loginSuggests(), 5);
    }

    @Override // com.avito.android.authorization.auth.AuthPresenter.Router
    public void resolveResult(@NotNull ResolvableResult resolvableResult) {
        Intrinsics.checkNotNullParameter(resolvableResult, "result");
        resolvableResult.resolve(this, 4);
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    public final void setPresenter(@NotNull AuthPresenter authPresenter) {
        Intrinsics.checkNotNullParameter(authPresenter, "<set-?>");
        this.presenter = authPresenter;
    }

    public final void setScreenTracker(@NotNull ScreenTracker screenTracker2) {
        Intrinsics.checkNotNullParameter(screenTracker2, "<set-?>");
        this.screenTracker = screenTracker2;
    }

    public final void setSmartLock(@NotNull SmartLockLoader smartLockLoader) {
        Intrinsics.checkNotNullParameter(smartLockLoader, "<set-?>");
        this.smartLock = smartLockLoader;
    }

    public final void setSocialTypeToStringMapper(@NotNull SocialTypeToStringMapper socialTypeToStringMapper2) {
        Intrinsics.checkNotNullParameter(socialTypeToStringMapper2, "<set-?>");
        this.socialTypeToStringMapper = socialTypeToStringMapper2;
    }

    @Override // com.avito.android.authorization.auth.AuthPresenter.Router
    public void openLogin(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "login");
        Intrinsics.checkNotNullParameter(str2, Preference.PASSWORD);
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        startActivityForResult(com.avito.android.util.IntentsKt.withClearTopFlags(AuthIntentFactory.DefaultImpls.loginIntent$default(activityIntentFactory, intent, str, str2, false, null, false, 56, null)), 1);
    }
}
