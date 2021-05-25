package com.avito.android.profile.sessions.info;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.profile.R;
import com.avito.android.profile.sessions.info.SessionsInfoPresenter;
import com.avito.android.ui.fragments.BaseFragment;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B\u0007¢\u0006\u0004\b,\u0010\u0011J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0016\u0010\u0011R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010&\u001a\u00020%8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006."}, d2 = {"Lcom/avito/android/profile/sessions/info/SessionsInfoFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Lcom/avito/android/profile/sessions/info/SessionsInfoPresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "", "onDestroyView", "()V", "", "url", "openHelpCenter", "(Ljava/lang/String;)V", "navigateToSessionsList", "Lcom/avito/android/profile/sessions/info/SessionsInfoPresenter;", "presenter", "Lcom/avito/android/profile/sessions/info/SessionsInfoPresenter;", "getPresenter", "()Lcom/avito/android/profile/sessions/info/SessionsInfoPresenter;", "setPresenter", "(Lcom/avito/android/profile/sessions/info/SessionsInfoPresenter;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "<init>", "Companion", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class SessionsInfoFragment extends BaseFragment implements SessionsInfoPresenter.Router {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public Analytics analytics;
    @Inject
    public SessionsInfoPresenter presenter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/avito/android/profile/sessions/info/SessionsInfoFragment$Companion;", "", "Lcom/avito/android/profile/sessions/info/SessionsInfoFragment;", "newInstanceForLogout", "()Lcom/avito/android/profile/sessions/info/SessionsInfoFragment;", "newInstanceForPasswordChange", "<init>", "()V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final SessionsInfoFragment newInstanceForLogout() {
            SessionsInfoFragment sessionsInfoFragment = new SessionsInfoFragment();
            Bundle bundle = new Bundle();
            bundle.putString("argument_mode", SessionsInfoPresenter.Mode.LOGOUT.name());
            Unit unit = Unit.INSTANCE;
            sessionsInfoFragment.setArguments(bundle);
            return sessionsInfoFragment;
        }

        @NotNull
        public final SessionsInfoFragment newInstanceForPasswordChange() {
            SessionsInfoFragment sessionsInfoFragment = new SessionsInfoFragment();
            Bundle bundle = new Bundle();
            bundle.putString("argument_mode", SessionsInfoPresenter.Mode.PASSWORD_CHANGE.name());
            Unit unit = Unit.INSTANCE;
            sessionsInfoFragment.setArguments(bundle);
            return sessionsInfoFragment;
        }

        public Companion(j jVar) {
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
    public final SessionsInfoPresenter getPresenter() {
        SessionsInfoPresenter sessionsInfoPresenter = this.presenter;
        if (sessionsInfoPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return sessionsInfoPresenter;
    }

    @Override // com.avito.android.profile.sessions.info.SessionsInfoPresenter.Router
    public void navigateToSessionsList() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivity(activityIntentFactory2.sessionsListIntent(null));
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.sessions_result_fragment, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        SessionsInfoViewImpl sessionsInfoViewImpl = new SessionsInfoViewImpl(inflate);
        SessionsInfoPresenter sessionsInfoPresenter = this.presenter;
        if (sessionsInfoPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        sessionsInfoPresenter.attachView(sessionsInfoViewImpl);
        SessionsInfoPresenter sessionsInfoPresenter2 = this.presenter;
        if (sessionsInfoPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        sessionsInfoPresenter2.attachRouter(this);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        SessionsInfoPresenter sessionsInfoPresenter = this.presenter;
        if (sessionsInfoPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        sessionsInfoPresenter.detachView();
        SessionsInfoPresenter sessionsInfoPresenter2 = this.presenter;
        if (sessionsInfoPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        sessionsInfoPresenter2.detachRouter();
    }

    @Override // com.avito.android.profile.sessions.info.SessionsInfoPresenter.Router
    public void openHelpCenter(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivity(activityIntentFactory2.helpCenterIntent(str));
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setPresenter(@NotNull SessionsInfoPresenter sessionsInfoPresenter) {
        Intrinsics.checkNotNullParameter(sessionsInfoPresenter, "<set-?>");
        this.presenter = sessionsInfoPresenter;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0017, code lost:
        if (r0 != null) goto L_0x001c;
     */
    @Override // com.avito.android.ui.fragments.BaseFragment
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean setUpFragmentComponent(@org.jetbrains.annotations.Nullable android.os.Bundle r5) {
        /*
            r4 = this;
            android.os.Bundle r0 = r4.getArguments()
            if (r0 == 0) goto L_0x001a
            java.lang.String r1 = "argument_mode"
            java.lang.String r0 = r0.getString(r1)
            if (r0 == 0) goto L_0x001a
            java.lang.String r1 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            com.avito.android.profile.sessions.info.SessionsInfoPresenter$Mode r0 = com.avito.android.profile.sessions.info.SessionsInfoPresenter.Mode.valueOf(r0)
            if (r0 == 0) goto L_0x001a
            goto L_0x001c
        L_0x001a:
            com.avito.android.profile.sessions.info.SessionsInfoPresenter$Mode r0 = com.avito.android.profile.sessions.info.SessionsInfoPresenter.Mode.LOGOUT
        L_0x001c:
            com.avito.android.profile.sessions.info.di.SessionsInfoComponent$Factory r1 = com.avito.android.profile.sessions.info.di.DaggerSessionsInfoComponent.factory()
            java.lang.Class<com.avito.android.di.CoreComponentDependencies> r2 = com.avito.android.di.CoreComponentDependencies.class
            com.avito.android.di.HasComponentDependencies r3 = com.avito.android.di.ComponentDependenciesKt.findComponentDependenciesHolder(r4)
            com.avito.android.di.ComponentDependencies r2 = com.avito.android.di.ComponentDependenciesKt.getDependencies(r2, r3)
            com.avito.android.di.CoreComponentDependencies r2 = (com.avito.android.di.CoreComponentDependencies) r2
            com.avito.android.profile.sessions.info.di.SessionsInfoComponent r0 = r1.create(r0, r2)
            r0.inject(r4)
            if (r5 != 0) goto L_0x0046
            com.avito.android.analytics.Analytics r5 = r4.analytics
            if (r5 != 0) goto L_0x003e
            java.lang.String r0 = "analytics"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
        L_0x003e:
            com.avito.android.analytics.event.SessionsResultScreenEvent r0 = new com.avito.android.analytics.event.SessionsResultScreenEvent
            r0.<init>()
            r5.track(r0)
        L_0x0046:
            r5 = 1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.profile.sessions.info.SessionsInfoFragment.setUpFragmentComponent(android.os.Bundle):boolean");
    }
}
