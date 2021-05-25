package com.avito.android.profile.password_change;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AuthIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.ChangePasswordScreenEvent;
import com.avito.android.authorization.smart_lock.ResolvableResult;
import com.avito.android.authorization.smart_lock.SmartLockLoader;
import com.avito.android.authorization.smart_lock.SmartLockSaver;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.profile.ProfileConstants;
import com.avito.android.profile.R;
import com.avito.android.profile.password_change.PasswordChangePresenter;
import com.avito.android.profile.password_change.di.DaggerPasswordChangeComponent;
import com.avito.android.profile.password_change.di.PasswordChangeComponent;
import com.avito.android.profile.password_change.di.PasswordChangeDependencies;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.Bundles;
import com.avito.android.util.Constants;
import com.avito.android.util.Kundle;
import com.sumsub.sns.core.common.SNSConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 _2\u00020\u00012\u00020\u0002:\u0001_B\u0007¢\u0006\u0004\b^\u0010\u0011J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0017\u0010\u0011J\u000f\u0010\u0018\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0018\u0010\u0011J\u0017\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001d\u0010\u0011J\u000f\u0010\u001e\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001e\u0010\u0011J)\u0010$\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b.\u0010-J\u0019\u00100\u001a\u00020\u000f2\b\u0010/\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b0\u0010\u001cR\"\u00102\u001a\u0002018\u0006@\u0006X.¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u00109\u001a\u0002088\u0006@\u0006X.¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010@\u001a\u00020?8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010G\u001a\u00020F8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0018\u0010O\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\"\u0010Q\u001a\u00020P8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\"\u0010X\u001a\u00020W8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]¨\u0006`"}, d2 = {"Lcom/avito/android/profile/password_change/PasswordChangeFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Lcom/avito/android/profile/password_change/PasswordChangePresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "", "onResume", "()V", "onPause", "onDestroyView", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "leaveScreen", "navigateToAuth", "", "message", "leaveWithSuccessMessage", "(Ljava/lang/String;)V", "navigateToInfoScreen", "navigateToHomeScreen", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", "followDeeplink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Lcom/avito/android/authorization/smart_lock/ResolvableResult;", "result", "resolveLoadingResult", "(Lcom/avito/android/authorization/smart_lock/ResolvableResult;)V", "resolveSaveResult", "login", "openPasswordRecovery", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/authorization/smart_lock/SmartLockLoader;", "smartLockLoader", "Lcom/avito/android/authorization/smart_lock/SmartLockLoader;", "getSmartLockLoader", "()Lcom/avito/android/authorization/smart_lock/SmartLockLoader;", "setSmartLockLoader", "(Lcom/avito/android/authorization/smart_lock/SmartLockLoader;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "c", "Landroid/content/Intent;", "upIntent", "Lcom/avito/android/profile/password_change/PasswordChangePresenter;", "presenter", "Lcom/avito/android/profile/password_change/PasswordChangePresenter;", "getPresenter", "()Lcom/avito/android/profile/password_change/PasswordChangePresenter;", "setPresenter", "(Lcom/avito/android/profile/password_change/PasswordChangePresenter;)V", "Lcom/avito/android/authorization/smart_lock/SmartLockSaver;", "smartLockSaver", "Lcom/avito/android/authorization/smart_lock/SmartLockSaver;", "getSmartLockSaver", "()Lcom/avito/android/authorization/smart_lock/SmartLockSaver;", "setSmartLockSaver", "(Lcom/avito/android/authorization/smart_lock/SmartLockSaver;)V", "<init>", "Companion", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class PasswordChangeFragment extends BaseFragment implements PasswordChangePresenter.Router {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public Analytics analytics;
    public Intent c;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public PasswordChangePresenter presenter;
    @Inject
    public SmartLockLoader smartLockLoader;
    @Inject
    public SmartLockSaver smartLockSaver;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011Jc\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/profile/password_change/PasswordChangeFragment$Companion;", "", "", "isSessionsFlow", "", "source", "login", "loginType", "sessionIdHash", "deviceId", ChannelContext.Item.USER_ID, "Landroid/content/Intent;", "upIntent", "Lcom/avito/android/profile/password_change/PasswordChangeFragment;", "newInstance", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)Lcom/avito/android/profile/password_change/PasswordChangeFragment;", "<init>", "()V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public static /* synthetic */ PasswordChangeFragment newInstance$default(Companion companion, boolean z, String str, String str2, String str3, String str4, String str5, String str6, Intent intent, int i, Object obj) {
            return companion.newInstance(z, str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, str6, intent);
        }

        @NotNull
        public final PasswordChangeFragment newInstance(boolean z, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable Intent intent) {
            PasswordChangeFragment passwordChangeFragment = new PasswordChangeFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("sessions_flow", z);
            bundle.putString("source", str);
            bundle.putString("login", str2);
            bundle.putString("login_type", str3);
            bundle.putString("session_id_hash", str4);
            bundle.putString(SNSConstants.Preference.KEY_DEVICE_ID, str5);
            bundle.putString("user_id", str6);
            bundle.putParcelable(Constants.UP_INTENT, intent);
            Unit unit = Unit.INSTANCE;
            passwordChangeFragment.setArguments(bundle);
            return passwordChangeFragment;
        }

        public Companion(j jVar) {
        }
    }

    @Override // com.avito.android.profile.password_change.PasswordChangePresenter.Router
    public void followDeeplink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deeplink");
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
    public final PasswordChangePresenter getPresenter() {
        PasswordChangePresenter passwordChangePresenter = this.presenter;
        if (passwordChangePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return passwordChangePresenter;
    }

    @NotNull
    public final SmartLockLoader getSmartLockLoader() {
        SmartLockLoader smartLockLoader2 = this.smartLockLoader;
        if (smartLockLoader2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smartLockLoader");
        }
        return smartLockLoader2;
    }

    @NotNull
    public final SmartLockSaver getSmartLockSaver() {
        SmartLockSaver smartLockSaver2 = this.smartLockSaver;
        if (smartLockSaver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smartLockSaver");
        }
        return smartLockSaver2;
    }

    @Override // com.avito.android.profile.password_change.PasswordChangePresenter.Router
    public void leaveScreen() {
        Intent intent = this.c;
        if (intent != null) {
            startActivity(intent);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.avito.android.profile.password_change.PasswordChangePresenter.Router
    public void leaveWithSuccessMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Intent intent = new Intent();
            intent.putExtra(ProfileConstants.PASSWORD_CHANGE_RESULT, str);
            activity.setResult(-1, intent);
            activity.finish();
        }
    }

    @Override // com.avito.android.profile.password_change.PasswordChangePresenter.Router
    public void navigateToAuth() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivityForResult(AuthIntentFactory.DefaultImpls.authIntent$default(activityIntentFactory2, null, AuthSource.PASSWORD_CHANGE, null, 5, null), 1604);
    }

    @Override // com.avito.android.profile.password_change.PasswordChangePresenter.Router
    public void navigateToHomeScreen() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivity(activityIntentFactory2.homeIntent());
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.avito.android.profile.password_change.PasswordChangePresenter.Router
    public void navigateToInfoScreen() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivity(activityIntentFactory2.sessionsInfoIntent(true));
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1604) {
            PasswordChangePresenter passwordChangePresenter = this.presenter;
            if (passwordChangePresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            passwordChangePresenter.onAuthResult(i2);
        } else if (i == 1704) {
            SmartLockLoader smartLockLoader2 = this.smartLockLoader;
            if (smartLockLoader2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("smartLockLoader");
            }
            smartLockLoader2.handleResult(i2, intent);
        } else if (i == 2004) {
            SmartLockSaver smartLockSaver2 = this.smartLockSaver;
            if (smartLockSaver2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("smartLockSaver");
            }
            smartLockSaver2.handleResult(i2, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.password_change_fragment, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        PasswordChangeViewImpl passwordChangeViewImpl = new PasswordChangeViewImpl(inflate, requireActivity);
        PasswordChangePresenter passwordChangePresenter = this.presenter;
        if (passwordChangePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        passwordChangePresenter.attachRouter(this);
        PasswordChangePresenter passwordChangePresenter2 = this.presenter;
        if (passwordChangePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        passwordChangePresenter2.attachView(passwordChangeViewImpl);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        PasswordChangePresenter passwordChangePresenter = this.presenter;
        if (passwordChangePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        passwordChangePresenter.detachView();
        PasswordChangePresenter passwordChangePresenter2 = this.presenter;
        if (passwordChangePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        passwordChangePresenter2.detachRouter();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        PasswordChangePresenter passwordChangePresenter = this.presenter;
        if (passwordChangePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        passwordChangePresenter.onVisibilityChange(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        PasswordChangePresenter passwordChangePresenter = this.presenter;
        if (passwordChangePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        passwordChangePresenter.onVisibilityChange(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        PasswordChangePresenter passwordChangePresenter = this.presenter;
        if (passwordChangePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Bundle putKundle = Bundles.putKundle(bundle, "presenter_state", passwordChangePresenter.onSaveState());
        SmartLockLoader smartLockLoader2 = this.smartLockLoader;
        if (smartLockLoader2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smartLockLoader");
        }
        Bundle putKundle2 = Bundles.putKundle(putKundle, "smart_lock_loader_state", smartLockLoader2.onSaveState());
        SmartLockSaver smartLockSaver2 = this.smartLockSaver;
        if (smartLockSaver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smartLockSaver");
        }
        Bundles.putKundle(putKundle2, "smart_lock_saver_state", smartLockSaver2.onSaveState());
    }

    @Override // com.avito.android.profile.password_change.PasswordChangePresenter.Router
    public void openPasswordRecovery(@Nullable String str) {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivity(AuthIntentFactory.DefaultImpls.resetPasswordIntent$default(activityIntentFactory2, str, false, null, 6, null));
    }

    @Override // com.avito.android.profile.password_change.PasswordChangePresenter.Router
    public void resolveLoadingResult(@NotNull ResolvableResult resolvableResult) {
        Intrinsics.checkNotNullParameter(resolvableResult, "result");
        resolvableResult.resolve(this, 1704);
    }

    @Override // com.avito.android.profile.password_change.PasswordChangePresenter.Router
    public void resolveSaveResult(@NotNull ResolvableResult resolvableResult) {
        Intrinsics.checkNotNullParameter(resolvableResult, "result");
        resolvableResult.resolve(this, 2004);
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

    public final void setPresenter(@NotNull PasswordChangePresenter passwordChangePresenter) {
        Intrinsics.checkNotNullParameter(passwordChangePresenter, "<set-?>");
        this.presenter = passwordChangePresenter;
    }

    public final void setSmartLockLoader(@NotNull SmartLockLoader smartLockLoader2) {
        Intrinsics.checkNotNullParameter(smartLockLoader2, "<set-?>");
        this.smartLockLoader = smartLockLoader2;
    }

    public final void setSmartLockSaver(@NotNull SmartLockSaver smartLockSaver2) {
        Intrinsics.checkNotNullParameter(smartLockSaver2, "<set-?>");
        this.smartLockSaver = smartLockSaver2;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        String source;
        Bundle arguments = getArguments();
        Kundle kundle = null;
        this.c = arguments != null ? (Intent) arguments.getParcelable(Constants.UP_INTENT) : null;
        Bundle arguments2 = getArguments();
        boolean z = arguments2 != null ? arguments2.getBoolean("sessions_flow") : false;
        Bundle arguments3 = getArguments();
        String string = arguments3 != null ? arguments3.getString("source") : null;
        Bundle arguments4 = getArguments();
        String string2 = arguments4 != null ? arguments4.getString("login") : null;
        Bundle arguments5 = getArguments();
        String string3 = arguments5 != null ? arguments5.getString("login_type") : null;
        Bundle arguments6 = getArguments();
        String string4 = arguments6 != null ? arguments6.getString("session_id_hash") : null;
        Bundle arguments7 = getArguments();
        String string5 = arguments7 != null ? arguments7.getString(SNSConstants.Preference.KEY_DEVICE_ID) : null;
        Bundle arguments8 = getArguments();
        PasswordChangePresenter.Mode mode = new PasswordChangePresenter.Mode(z, string, string2, string3, string4, string5, arguments8 != null ? arguments8.getString("user_id") : null);
        PasswordChangeComponent.Factory factory = DaggerPasswordChangeComponent.factory();
        PasswordChangeDependencies passwordChangeDependencies = (PasswordChangeDependencies) ComponentDependenciesKt.getDependencies(PasswordChangeDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this));
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        Kundle kundle2 = bundle != null ? Bundles.getKundle(bundle, "presenter_state") : null;
        Kundle kundle3 = bundle != null ? Bundles.getKundle(bundle, "smart_lock_saver_state") : null;
        if (bundle != null) {
            kundle = Bundles.getKundle(bundle, "smart_lock_loader_state");
        }
        factory.create(passwordChangeDependencies, requireActivity, resources, kundle2, kundle3, kundle, mode).inject(this);
        if (!mode.isSessionsFlow() || bundle != null || (source = mode.getSource()) == null) {
            return true;
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        analytics2.track(new ChangePasswordScreenEvent(source));
        return true;
    }
}
