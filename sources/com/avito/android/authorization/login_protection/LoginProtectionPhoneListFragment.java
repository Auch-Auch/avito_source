package com.avito.android.authorization.login_protection;

import a2.b.a.a.a;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.R;
import com.avito.android.authorization.event.AntihackEventSource;
import com.avito.android.authorization.event.AntihackPhoneListOpenEvent;
import com.avito.android.authorization.login_protection.LoginProtectionPhoneListPresenter;
import com.avito.android.authorization.login_protection.di.DaggerLoginProtectionPhoneListComponent;
import com.avito.android.authorization.login_protection.di.LoginProtectionPhoneListComponent;
import com.avito.android.authorization.login_protection.di.LoginProtectionPhoneListDependencies;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.IntentsKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 J2\u00020\u00012\u00020\u0002:\u0001JB\u0007¢\u0006\u0004\bI\u0010\u0011J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010#\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005H\u0016¢\u0006\u0004\b#\u0010$J7\u0010+\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u00192\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u0012H\u0016¢\u0006\u0004\b+\u0010,R&\u0010.\u001a\u0006\u0012\u0002\b\u00030-8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00105\u001a\u0002048\u0006@\u0006X.¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010<\u001a\u00020;8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010C\u001a\u00020B8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H¨\u0006K"}, d2 = {"Lcom/avito/android/authorization/login_protection/LoginProtectionPhoneListFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Lcom/avito/android/authorization/login_protection/LoginProtectionPhoneListPresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "", "onDestroyView", "()V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "", "challengeId", "phonePart", "openPhoneProving", "(Ljava/lang/String;Ljava/lang/String;)V", "url", "openHelpCenter", "(Ljava/lang/String;)V", "isSuccessful", "isAntihackMode", "leaveScreen", "(ZZ)V", "login", "phone", "text", "", "codeTimeout", "codeLength", "openTfaCodeConfirmation", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JI)V", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapterPresenter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "getAdapterPresenter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setAdapterPresenter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/authorization/login_protection/LoginProtectionPhoneListPresenter;", "presenter", "Lcom/avito/android/authorization/login_protection/LoginProtectionPhoneListPresenter;", "getPresenter", "()Lcom/avito/android/authorization/login_protection/LoginProtectionPhoneListPresenter;", "setPresenter", "(Lcom/avito/android/authorization/login_protection/LoginProtectionPhoneListPresenter;)V", "<init>", "Companion", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class LoginProtectionPhoneListFragment extends BaseFragment implements LoginProtectionPhoneListPresenter.Router {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public RecyclerView.Adapter<?> adapterPresenter;
    @Inject
    public Analytics analytics;
    @Inject
    public LoginProtectionPhoneListPresenter presenter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ5\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/authorization/login_protection/LoginProtectionPhoneListFragment$Companion;", "", "", "", "phones", "login", "challengeId", "", "isAntihackMode", "Lcom/avito/android/authorization/login_protection/LoginProtectionPhoneListFragment;", "newInstance", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Z)Lcom/avito/android/authorization/login_protection/LoginProtectionPhoneListFragment;", "<init>", "()V", "authorization_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final LoginProtectionPhoneListFragment newInstance(@NotNull List<String> list, @Nullable String str, @NotNull String str2, boolean z) {
            Intrinsics.checkNotNullParameter(list, "phones");
            Intrinsics.checkNotNullParameter(str2, "challengeId");
            LoginProtectionPhoneListFragment loginProtectionPhoneListFragment = new LoginProtectionPhoneListFragment();
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("phones", new ArrayList<>(list));
            bundle.putString("challenge_id", str2);
            bundle.putBoolean(LoginProtectionPhoneListActivityKt.EXTRA_IS_ANTIHACK_MODE, z);
            if (str != null) {
                bundle.putString("login", str);
            }
            Unit unit = Unit.INSTANCE;
            loginProtectionPhoneListFragment.setArguments(bundle);
            return loginProtectionPhoneListFragment;
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
    public final RecyclerView.Adapter<?> getAdapterPresenter() {
        RecyclerView.Adapter<?> adapter = this.adapterPresenter;
        if (adapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return adapter;
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
    public final LoginProtectionPhoneListPresenter getPresenter() {
        LoginProtectionPhoneListPresenter loginProtectionPhoneListPresenter = this.presenter;
        if (loginProtectionPhoneListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return loginProtectionPhoneListPresenter;
    }

    @Override // com.avito.android.authorization.login_protection.LoginProtectionPhoneListPresenter.Router
    public void leaveScreen(boolean z, boolean z2) {
        int i = z ? -1 : 0;
        Intent intent = new Intent();
        intent.putExtra(LoginProtectionPhoneListActivityKt.EXTRA_IS_ANTIHACK_MODE, z2);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(i, intent);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            return;
        }
        if (i == 11) {
            LoginProtectionPhoneListPresenter loginProtectionPhoneListPresenter = this.presenter;
            if (loginProtectionPhoneListPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            loginProtectionPhoneListPresenter.onPhoneProved();
        } else if (i == 12) {
            LoginProtectionPhoneListPresenter loginProtectionPhoneListPresenter2 = this.presenter;
            if (loginProtectionPhoneListPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            loginProtectionPhoneListPresenter2.onTfaSuccess();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.antihack_phone_list_fragment, viewGroup, false);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup2 = (ViewGroup) inflate;
        RecyclerView.Adapter<?> adapter = this.adapterPresenter;
        if (adapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        LoginProtectionPhoneListViewImpl loginProtectionPhoneListViewImpl = new LoginProtectionPhoneListViewImpl(viewGroup2, adapter);
        LoginProtectionPhoneListPresenter loginProtectionPhoneListPresenter = this.presenter;
        if (loginProtectionPhoneListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        loginProtectionPhoneListPresenter.attachView(loginProtectionPhoneListViewImpl);
        LoginProtectionPhoneListPresenter loginProtectionPhoneListPresenter2 = this.presenter;
        if (loginProtectionPhoneListPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        loginProtectionPhoneListPresenter2.attachRouter(this);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        LoginProtectionPhoneListPresenter loginProtectionPhoneListPresenter = this.presenter;
        if (loginProtectionPhoneListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        loginProtectionPhoneListPresenter.detachView();
        LoginProtectionPhoneListPresenter loginProtectionPhoneListPresenter2 = this.presenter;
        if (loginProtectionPhoneListPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        loginProtectionPhoneListPresenter2.detachRouter();
        super.onDestroyView();
    }

    @Override // com.avito.android.authorization.login_protection.LoginProtectionPhoneListPresenter.Router
    public void openHelpCenter(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivity(activityIntentFactory2.helpCenterIntent(str));
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(0);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    @Override // com.avito.android.authorization.login_protection.LoginProtectionPhoneListPresenter.Router
    public void openPhoneProving(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "challengeId");
        Intrinsics.checkNotNullParameter(str2, "phonePart");
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivityForResult(IntentsKt.withClearTopFlags(activityIntentFactory2.phoneProvingIntent(str, str2, null, true)), 11);
    }

    @Override // com.avito.android.authorization.login_protection.LoginProtectionPhoneListPresenter.Router
    public void openTfaCodeConfirmation(@NotNull String str, @NotNull String str2, @NotNull String str3, long j, int i) {
        a.Z0(str, "login", str2, "phone", str3, "text");
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivityForResult(IntentsKt.withClearTopFlags(activityIntentFactory2.codeConfirmationIntent(str, str2, str3, j, i, "login")), 12);
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAdapterPresenter(@NotNull RecyclerView.Adapter<?> adapter) {
        Intrinsics.checkNotNullParameter(adapter, "<set-?>");
        this.adapterPresenter = adapter;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setPresenter(@NotNull LoginProtectionPhoneListPresenter loginProtectionPhoneListPresenter) {
        Intrinsics.checkNotNullParameter(loginProtectionPhoneListPresenter, "<set-?>");
        this.presenter = loginProtectionPhoneListPresenter;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        String str;
        LoginProtectionPhoneListComponent.Factory factory = DaggerLoginProtectionPhoneListComponent.factory();
        Bundle arguments = getArguments();
        String str2 = null;
        List<String> stringArrayList = arguments != null ? arguments.getStringArrayList("phones") : null;
        if (stringArrayList == null) {
            stringArrayList = CollectionsKt__CollectionsKt.emptyList();
        }
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (str = arguments2.getString("challenge_id")) == null) {
            str = "";
        }
        Intrinsics.checkNotNullExpressionValue(str, "arguments?.getString(KEY_CHALLENGE_ID) ?: \"\"");
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            str2 = arguments3.getString("login");
        }
        Bundle arguments4 = getArguments();
        boolean z = arguments4 != null ? arguments4.getBoolean(LoginProtectionPhoneListActivityKt.EXTRA_IS_ANTIHACK_MODE) : true;
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        factory.create(stringArrayList, str, str2, resources, z, (LoginProtectionPhoneListDependencies) ComponentDependenciesKt.getDependencies(LoginProtectionPhoneListDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).inject(this);
        if (bundle == null) {
            Analytics analytics2 = this.analytics;
            if (analytics2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analytics");
            }
            analytics2.track(new AntihackPhoneListOpenEvent(AntihackEventSource.ANTIHACK));
        }
        return true;
    }
}
