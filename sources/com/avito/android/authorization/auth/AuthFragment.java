package com.avito.android.authorization.auth;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AuthIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.authorization.AuthParamsKt;
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
import com.avito.android.remote.model.registration.RegisteredProfile;
import com.avito.android.social.SocialActivity;
import com.avito.android.social.SocialType;
import com.avito.android.social.SocialTypeToStringMapper;
import com.avito.android.ui.fragments.OnBackPressedListener;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.ui_components.R;
import com.avito.android.util.Bundles;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.IntentsKt;
import com.avito.android.util.Keyboards;
import com.avito.android.util.Kundle;
import com.avito.android.util.ToastsKt;
import com.avito.android.util.preferences.Preference;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0001B\b¢\u0006\u0005\b\u0001\u0010\u001fJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00152\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u000eH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\tH\u0016¢\u0006\u0004\b\"\u0010\u001fJ\u000f\u0010#\u001a\u00020\tH\u0016¢\u0006\u0004\b#\u0010\u001fJ\u000f\u0010$\u001a\u00020\tH\u0016¢\u0006\u0004\b$\u0010\u001fJ\u0017\u0010&\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u000eH\u0016¢\u0006\u0004\b&\u0010'J\u001f\u0010&\u001a\u00020\t2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020(H\u0016¢\u0006\u0004\b&\u0010+J\u000f\u0010,\u001a\u00020\tH\u0016¢\u0006\u0004\b,\u0010\u001fJ\u0017\u0010/\u001a\u00020\t2\u0006\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u00020\t2\u0006\u00101\u001a\u00020(H\u0016¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\tH\u0016¢\u0006\u0004\b4\u0010\u001fJ)\u00109\u001a\u00020\t2\u0006\u00106\u001a\u0002052\u0006\u00107\u001a\u0002052\b\u00108\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\tH\u0016¢\u0006\u0004\b;\u0010\u001fJ\u0017\u0010>\u001a\u00020\t2\u0006\u0010=\u001a\u00020<H\u0016¢\u0006\u0004\b>\u0010?J5\u0010E\u001a\u00020\t2\u0006\u0010@\u001a\u00020(2\u0006\u0010A\u001a\u00020(2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020C0B2\u0006\u00101\u001a\u00020(H\u0016¢\u0006\u0004\bE\u0010FJ\u001f\u0010H\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010G\u001a\u00020\u000e¢\u0006\u0004\bH\u0010IR\"\u0010K\u001a\u00020J8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\"\u0010R\u001a\u00020Q8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\"\u0010Y\u001a\u00020X8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\"\u0010`\u001a\u00020_8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\"\u0010g\u001a\u00020f8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\"\u0010n\u001a\u00020m8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bn\u0010o\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\"\u0010u\u001a\u00020t8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bu\u0010v\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR$\u0010|\u001a\u00020{8\u0006@\u0006X.¢\u0006\u0014\n\u0004\b|\u0010}\u001a\u0004\b~\u0010\"\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/authorization/auth/AuthFragment;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "Lcom/avito/android/authorization/auth/AuthPresenter$Router;", "Lcom/avito/android/ui/fragments/OnBackPressedListener;", "Lcom/avito/android/authorization/auth/AuthArguments;", "d", "()Lcom/avito/android/authorization/auth/AuthArguments;", "Landroid/content/Intent;", "intent", "", "c", "(Landroid/content/Intent;)V", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "onStart", "()V", "onBackPressed", "()Z", "onStop", "onDestroy", "openRegistration", "skipSavedLogin", "openLogin", "(Z)V", "", "login", Preference.PASSWORD, "(Ljava/lang/String;Ljava/lang/String;)V", "cancel", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "socialType", "openSocialLogin", "(Ljava/lang/String;)V", "openSuggests", "", "requestCode", "resultCode", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "finishAuth", "Lcom/avito/android/authorization/smart_lock/ResolvableResult;", "result", "resolveResult", "(Lcom/avito/android/authorization/smart_lock/ResolvableResult;)V", "title", "suggestKey", "", "Lcom/avito/android/remote/model/registration/RegisteredProfile;", "profiles", "openSocialRegistrationSuggestsScreen", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "resultOk", "handleIntent", "(Landroid/content/Intent;Z)V", "Lcom/avito/android/authorization/smart_lock/SmartLockLoader;", "smartLock", "Lcom/avito/android/authorization/smart_lock/SmartLockLoader;", "getSmartLock", "()Lcom/avito/android/authorization/smart_lock/SmartLockLoader;", "setSmartLock", "(Lcom/avito/android/authorization/smart_lock/SmartLockLoader;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/social/SocialTypeToStringMapper;", "socialTypeToStringMapper", "Lcom/avito/android/social/SocialTypeToStringMapper;", "getSocialTypeToStringMapper", "()Lcom/avito/android/social/SocialTypeToStringMapper;", "setSocialTypeToStringMapper", "(Lcom/avito/android/social/SocialTypeToStringMapper;)V", "Lcom/avito/android/performance/ScreenTracker;", "screenTracker", "Lcom/avito/android/performance/ScreenTracker;", "getScreenTracker", "()Lcom/avito/android/performance/ScreenTracker;", "setScreenTracker", "(Lcom/avito/android/performance/ScreenTracker;)V", "Lcom/avito/android/authorization/auth/AuthPresenter;", "presenter", "Lcom/avito/android/authorization/auth/AuthPresenter;", "getPresenter", "()Lcom/avito/android/authorization/auth/AuthPresenter;", "setPresenter", "(Lcom/avito/android/authorization/auth/AuthPresenter;)V", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "<init>", "Companion", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class AuthFragment extends TabBaseFragment implements AuthPresenter.Router, OnBackPressedListener {
    @NotNull
    public static final Companion Companion = new Companion(null);
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/authorization/auth/AuthFragment$Companion;", "", "Lcom/avito/android/authorization/auth/AuthArguments;", "arguments", "Lcom/avito/android/authorization/auth/AuthFragment;", "newInstance", "(Lcom/avito/android/authorization/auth/AuthArguments;)Lcom/avito/android/authorization/auth/AuthFragment;", "<init>", "()V", "authorization_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        public static final class a extends Lambda implements Function1<Bundle, Unit> {
            public final /* synthetic */ AuthArguments a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(AuthArguments authArguments) {
                super(1);
                this.a = authArguments;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Bundle bundle) {
                Bundle bundle2 = bundle;
                Intrinsics.checkNotNullParameter(bundle2, "$receiver");
                bundle2.putParcelable("key_arguments", this.a);
                return Unit.INSTANCE;
            }
        }

        public Companion() {
        }

        @NotNull
        public final AuthFragment newInstance(@NotNull AuthArguments authArguments) {
            Intrinsics.checkNotNullParameter(authArguments, "arguments");
            return (AuthFragment) FragmentsKt.arguments$default(new AuthFragment(), 0, new a(authArguments), 1, null);
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Exception, Unit> {
        public final /* synthetic */ AuthFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AuthFragment authFragment) {
            super(1);
            this.a = authFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Exception exc) {
            Intrinsics.checkNotNullParameter(exc, "it");
            AuthFragment authFragment = this.a;
            int i = R.string.no_application_installed_to_perform_this_action;
            Context context = authFragment.getContext();
            if (context != null) {
                ToastsKt.showToast(context, i, 0);
            }
            return Unit.INSTANCE;
        }
    }

    public final void c(Intent intent) {
        Keyboards.hideKeyboard(this);
        if (intent != null) {
            startActivity(intent);
        }
        FragmentActivity requireActivity = requireActivity();
        FragmentActivity requireActivity2 = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
        requireActivity.setResult(-1, AuthParamsKt.getSuccessAuthResultData(requireActivity2));
        requireActivity().finish();
    }

    @Override // com.avito.android.authorization.auth.AuthPresenter.Router
    public void cancel() {
        requireActivity().finish();
    }

    public final AuthArguments d() {
        Bundle arguments = getArguments();
        AuthArguments authArguments = arguments != null ? (AuthArguments) arguments.getParcelable("key_arguments") : null;
        Objects.requireNonNull(authArguments, "null cannot be cast to non-null type com.avito.android.authorization.auth.AuthArguments");
        return authArguments;
    }

    @Override // com.avito.android.authorization.auth.AuthPresenter.Router
    public void finishAuth() {
        c(d().getIntent());
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
            FragmentsKt.startActivitySafely(this, intent, new a(this));
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

    public final void handleIntent(@Nullable Intent intent, boolean z) {
        Bundle arguments = getArguments();
        AuthArguments authArguments = arguments != null ? (AuthArguments) arguments.getParcelable("key_arguments") : null;
        Objects.requireNonNull(authArguments, "null cannot be cast to non-null type com.avito.android.authorization.auth.AuthArguments");
        AuthArguments copy$default = AuthArguments.copy$default(authArguments, null, intent, z, 1, null);
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            arguments2.putParcelable("key_arguments", copy$default);
        }
        AuthArguments d = d();
        if (d.getResultOk()) {
            c(d.getIntent());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        String socialId;
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
                if (!(intent == null || (socialId = AuthParamsKt.getSocialId(intent)) == null)) {
                    AuthPresenter authPresenter5 = this.presenter;
                    if (authPresenter5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                    }
                    authPresenter5.saveSocialId(socialId);
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
                    AuthPresenter authPresenter6 = this.presenter;
                    if (authPresenter6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                    }
                    authPresenter6.show();
                } else {
                    AuthPresenter authPresenter7 = this.presenter;
                    if (authPresenter7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                    }
                    authPresenter7.setSkipSavedLogin(true);
                    AuthPresenter authPresenter8 = this.presenter;
                    if (authPresenter8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                    }
                    authPresenter8.show();
                }
            } else if (i2 == 0) {
                cancel();
            }
        } else if (i2 == -1) {
            finishAuth();
        }
    }

    @Override // com.avito.android.ui.fragments.OnBackPressedListener
    public boolean onBackPressed() {
        AuthPresenter authPresenter = this.presenter;
        if (authPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        authPresenter.onBackPressed();
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ScreenTracker screenTracker2 = this.screenTracker;
        if (screenTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenTracker");
        }
        screenTracker2.getInit().started();
        return layoutInflater.inflate(com.avito.android.authorization.R.layout.auth, viewGroup, false);
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, androidx.fragment.app.Fragment
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

    @Override // com.avito.android.ui.fragments.TabBaseFragment, androidx.fragment.app.Fragment
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

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        AuthPresenter authPresenter = this.presenter;
        if (authPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        authPresenter.attachRouter(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        AuthPresenter authPresenter = this.presenter;
        if (authPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        authPresenter.detachRouter();
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        AuthArguments d = d();
        if (d.getResultOk()) {
            c(d.getIntent());
        }
        if (bundle == null) {
            Bundle arguments = getArguments();
            String str = null;
            AuthArguments authArguments = arguments != null ? (AuthArguments) arguments.getParcelable("key_arguments") : null;
            Analytics analytics2 = this.analytics;
            if (analytics2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analytics");
            }
            if (authArguments != null) {
                str = authArguments.getSrc();
            }
            analytics2.track(new AuthOpenEvent(str));
        }
        ScreenTracker screenTracker2 = this.screenTracker;
        if (screenTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenTracker");
        }
        screenTracker2.resetSession();
        AuthPresenter authPresenter = this.presenter;
        if (authPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        authPresenter.attachView(new AuthViewImpl(view));
        ScreenTracker screenTracker3 = this.screenTracker;
        if (screenTracker3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenTracker");
        }
        screenTracker3.getInit().finished();
    }

    @Override // com.avito.android.authorization.auth.AuthPresenter.Router
    public void openLogin(boolean z) {
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        Intent intent = requireActivity.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "requireActivity().intent");
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
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        Intent intent = requireActivity.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "requireActivity().intent");
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
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        Intent intent = requireActivity.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "requireActivity().intent");
        startActivity(activityIntentFactory.socialRegistrationSuggestsIntent(intent, str, str2, list, str3));
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

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        AuthArguments authArguments;
        Timer started = DiInjectTracker.Companion.started();
        Bundle arguments = getArguments();
        if (arguments == null || (authArguments = (AuthArguments) arguments.getParcelable("key_arguments")) == null) {
            throw new IllegalArgumentException("AuthArguments must be specified");
        }
        AuthComponent.Builder dependentOn = DaggerAuthComponent.builder().dependentOn((AuthDependencies) ComponentDependenciesKt.getDependencies(AuthDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this)));
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        AuthComponent.Builder withActivity = dependentOn.withActivity(requireActivity);
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        AuthComponent.Builder withResources = withActivity.withResources(resources);
        Kundle kundle = null;
        AuthComponent.Builder withPresenterState = withResources.withPresenterState(bundle != null ? Bundles.getKundle(bundle, "presenterState") : null);
        if (bundle != null) {
            kundle = Bundles.getKundle(bundle, "smart_lock");
        }
        withPresenterState.withSmartLockState(kundle).withSrc(authArguments.getSrc()).build().inject(this);
        ScreenTracker screenTracker2 = this.screenTracker;
        if (screenTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenTracker");
        }
        screenTracker2.getDiInject().finished(started);
        return true;
    }

    @Override // com.avito.android.authorization.auth.AuthPresenter.Router
    public void openLogin(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "login");
        Intrinsics.checkNotNullParameter(str2, Preference.PASSWORD);
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        Intent intent = requireActivity.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "requireActivity().intent");
        startActivityForResult(IntentsKt.withClearTopFlags(AuthIntentFactory.DefaultImpls.loginIntent$default(activityIntentFactory, intent, str, str2, false, null, false, 56, null)), 1);
    }
}
