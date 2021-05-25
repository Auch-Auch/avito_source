package com.avito.android.profile.sessions.social_logout;

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
import com.avito.android.analytics.event.SessionsSocialLogoutScreenEvent;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.profile.R;
import com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutPresenter;
import com.avito.android.profile.sessions.social_logout.di.DaggerSessionsSocialLogoutComponent;
import com.avito.android.profile.sessions.social_logout.di.SessionsSocialLogoutComponent;
import com.avito.android.profile.sessions.social_logout.di.SessionsSocialLogoutDependencies;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.Constants;
import com.sumsub.sns.core.common.SNSConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 62\u00020\u00012\u00020\u0002:\u00016B\u0007¢\u0006\u0004\b5\u0010\u0011J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0019\u0010\u0011J\u000f\u0010\u001a\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001a\u0010\u0011J\u000f\u0010\u001b\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001b\u0010\u0011J\u000f\u0010\u001c\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001c\u0010\u0011R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\"\u0010!\u001a\u00020 8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010(\u001a\u00020'8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010/\u001a\u00020.8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u00067"}, d2 = {"Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutPresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "", "onDestroyView", "()V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "closeScreen", "openInfoScreen", "openAuthScreen", "openHomeScreen", "c", "Landroid/content/Intent;", "upIntent", "Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutPresenter;", "presenter", "Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutPresenter;", "getPresenter", "()Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutPresenter;", "setPresenter", "(Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutPresenter;)V", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "<init>", "Companion", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class SessionsSocialLogoutFragment extends BaseFragment implements SessionsSocialLogoutPresenter.Router {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public Analytics analytics;
    public Intent c;
    @Inject
    public SessionsSocialLogoutPresenter presenter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJG\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutFragment$Companion;", "", "", "source", ChannelContext.Item.USER_ID, "loginType", "sessionIdHash", "deviceId", "Landroid/content/Intent;", "upIntent", "Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutFragment;", "newInstance", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutFragment;", "<init>", "()V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final SessionsSocialLogoutFragment newInstance(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NotNull String str5, @Nullable Intent intent) {
            Intrinsics.checkNotNullParameter(str5, "deviceId");
            SessionsSocialLogoutFragment sessionsSocialLogoutFragment = new SessionsSocialLogoutFragment();
            Bundle bundle = new Bundle();
            bundle.putString("source", str);
            bundle.putString("user_id", str2);
            bundle.putString("login_type", str3);
            bundle.putString("session_id_hash", str4);
            bundle.putString(SNSConstants.Preference.KEY_DEVICE_ID, str5);
            bundle.putParcelable(Constants.UP_INTENT, intent);
            Unit unit = Unit.INSTANCE;
            sessionsSocialLogoutFragment.setArguments(bundle);
            return sessionsSocialLogoutFragment;
        }

        public Companion(j jVar) {
        }
    }

    @Override // com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutPresenter.Router
    public void closeScreen() {
        Intent intent = this.c;
        if (intent != null) {
            startActivity(intent);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
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
    public final SessionsSocialLogoutPresenter getPresenter() {
        SessionsSocialLogoutPresenter sessionsSocialLogoutPresenter = this.presenter;
        if (sessionsSocialLogoutPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return sessionsSocialLogoutPresenter;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            SessionsSocialLogoutPresenter sessionsSocialLogoutPresenter = this.presenter;
            if (sessionsSocialLogoutPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            sessionsSocialLogoutPresenter.onAuthResult(i2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.sessions_social_logout_fragment, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        SessionsSocialLogoutViewImpl sessionsSocialLogoutViewImpl = new SessionsSocialLogoutViewImpl(inflate);
        SessionsSocialLogoutPresenter sessionsSocialLogoutPresenter = this.presenter;
        if (sessionsSocialLogoutPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        sessionsSocialLogoutPresenter.attachRouter(this);
        SessionsSocialLogoutPresenter sessionsSocialLogoutPresenter2 = this.presenter;
        if (sessionsSocialLogoutPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        sessionsSocialLogoutPresenter2.attachView(sessionsSocialLogoutViewImpl);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        SessionsSocialLogoutPresenter sessionsSocialLogoutPresenter = this.presenter;
        if (sessionsSocialLogoutPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        sessionsSocialLogoutPresenter.detachView();
        SessionsSocialLogoutPresenter sessionsSocialLogoutPresenter2 = this.presenter;
        if (sessionsSocialLogoutPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        sessionsSocialLogoutPresenter2.detachRouter();
    }

    @Override // com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutPresenter.Router
    public void openAuthScreen() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivityForResult(AuthIntentFactory.DefaultImpls.authIntent$default(activityIntentFactory2, null, AuthSource.SESSIONS_LIST, null, 5, null), 1);
    }

    @Override // com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutPresenter.Router
    public void openHomeScreen() {
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

    @Override // com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutPresenter.Router
    public void openInfoScreen() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivity(activityIntentFactory2.sessionsInfoIntent(false));
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setPresenter(@NotNull SessionsSocialLogoutPresenter sessionsSocialLogoutPresenter) {
        Intrinsics.checkNotNullParameter(sessionsSocialLogoutPresenter, "<set-?>");
        this.presenter = sessionsSocialLogoutPresenter;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        String str = null;
        this.c = arguments != null ? (Intent) arguments.getParcelable(Constants.UP_INTENT) : null;
        Bundle arguments2 = getArguments();
        String string = arguments2 != null ? arguments2.getString("user_id") : null;
        Bundle arguments3 = getArguments();
        String string2 = arguments3 != null ? arguments3.getString(SNSConstants.Preference.KEY_DEVICE_ID) : null;
        Bundle arguments4 = getArguments();
        String string3 = arguments4 != null ? arguments4.getString("session_id_hash") : null;
        Bundle arguments5 = getArguments();
        String string4 = arguments5 != null ? arguments5.getString("login_type") : null;
        Bundle arguments6 = getArguments();
        if (arguments6 != null) {
            str = arguments6.getString("source");
        }
        SessionsSocialLogoutPresenter.SessionParams sessionParams = new SessionsSocialLogoutPresenter.SessionParams(string, string2, string3, string4, str);
        SessionsSocialLogoutComponent.Factory factory = DaggerSessionsSocialLogoutComponent.factory();
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        factory.create(resources, sessionParams, (SessionsSocialLogoutDependencies) ComponentDependenciesKt.getDependencies(SessionsSocialLogoutDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).inject(this);
        if (bundle != null) {
            return true;
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        analytics2.track(new SessionsSocialLogoutScreenEvent());
        return true;
    }
}
