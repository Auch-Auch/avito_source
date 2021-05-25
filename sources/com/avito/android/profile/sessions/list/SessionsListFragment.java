package com.avito.android.profile.sessions.list;

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
import com.avito.android.analytics.Analytics;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.profile.R;
import com.avito.android.profile.sessions.list.SessionsListPresenter;
import com.avito.android.profile.sessions.list.di.DaggerSessionsListComponent;
import com.avito.android.profile.sessions.list.di.SessionsListComponent;
import com.avito.android.profile.sessions.list.di.SessionsListDependencies;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.CompressedParcelable;
import com.avito.android.util.Constants;
import com.avito.android.util.Kundle;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.appbar.AppBarImpl;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 Z2\u00020\u00012\u00020\u0002:\u0001ZB\u0007¢\u0006\u0004\bY\u0010\u0011J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0014JS\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJA\u0010\u001f\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u000fH\u0016¢\u0006\u0004\b!\u0010\u0011J)\u0010'\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u000fH\u0016¢\u0006\u0004\b)\u0010\u0011J\r\u0010*\u001a\u00020\u000f¢\u0006\u0004\b*\u0010\u0011R\"\u0010,\u001a\u00020+8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00103\u001a\u0002028\u0006@\u0006X.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010:\u001a\u0002098\u0006@\u0006X.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010A\u001a\u00020@8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010H\u001a\u00020G8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010O\u001a\u00020N8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u0016\u0010X\u001a\u00020U8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bV\u0010W¨\u0006["}, d2 = {"Lcom/avito/android/profile/sessions/list/SessionsListFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Lcom/avito/android/profile/sessions/list/SessionsListPresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "", "onDestroyView", "()V", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "isSessionsFlow", "", "source", "login", "loginType", "sessionIdHash", "deviceId", ChannelContext.Item.USER_ID, "openChangePasswordScreen", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "openSocialLogoutScreen", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "openAuthScreen", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "closeScreen", "loadData", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "snackbarPresenter", "Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "getSnackbarPresenter", "()Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "setSnackbarPresenter", "(Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;)V", "Lcom/avito/android/profile/sessions/list/SessionsListPresenter;", "presenter", "Lcom/avito/android/profile/sessions/list/SessionsListPresenter;", "getPresenter", "()Lcom/avito/android/profile/sessions/list/SessionsListPresenter;", "setPresenter", "(Lcom/avito/android/profile/sessions/list/SessionsListPresenter;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/profile/sessions/list/SessionsListView;", "c", "Lcom/avito/android/profile/sessions/list/SessionsListView;", "sessionsListView", "<init>", "Companion", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class SessionsListFragment extends BaseFragment implements SessionsListPresenter.Router {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public Analytics analytics;
    public SessionsListView c;
    @Inject
    public ItemBinder itemBinder;
    @Inject
    public SessionsListPresenter presenter;
    @Inject
    public CompositeSnackbarPresenter snackbarPresenter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/profile/sessions/list/SessionsListFragment$Companion;", "", "", "source", "Lcom/avito/android/profile/sessions/list/SessionsListFragment;", "newInstance", "(Ljava/lang/String;)Lcom/avito/android/profile/sessions/list/SessionsListFragment;", "<init>", "()V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final SessionsListFragment newInstance(@Nullable String str) {
            SessionsListFragment sessionsListFragment = new SessionsListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("source", str);
            sessionsListFragment.setArguments(bundle);
            return sessionsListFragment;
        }

        public Companion(j jVar) {
        }
    }

    @Override // com.avito.android.profile.sessions.list.SessionsListPresenter.Router
    public void closeScreen() {
        FragmentActivity activity = getActivity();
        if (activity != null && activity.isTaskRoot()) {
            ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
            if (activityIntentFactory2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
            }
            startActivity(activityIntentFactory2.homeIntent());
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
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
    public final AdapterPresenter getAdapterPresenter() {
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return adapterPresenter2;
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
    public final ItemBinder getItemBinder() {
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        return itemBinder2;
    }

    @NotNull
    public final SessionsListPresenter getPresenter() {
        SessionsListPresenter sessionsListPresenter = this.presenter;
        if (sessionsListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return sessionsListPresenter;
    }

    @NotNull
    public final CompositeSnackbarPresenter getSnackbarPresenter() {
        CompositeSnackbarPresenter compositeSnackbarPresenter = this.snackbarPresenter;
        if (compositeSnackbarPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("snackbarPresenter");
        }
        return compositeSnackbarPresenter;
    }

    public final void loadData() {
        SessionsListPresenter sessionsListPresenter = this.presenter;
        if (sessionsListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        SessionsListPresenter.DefaultImpls.load$default(sessionsListPresenter, false, 1, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            SessionsListPresenter sessionsListPresenter = this.presenter;
            if (sessionsListPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            sessionsListPresenter.onAuthResult(i2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.sessions_list_fragment, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        View findViewById = inflate.findViewById(R.id.recycler_view);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        AppBarImpl appBarImpl = new AppBarImpl(inflate, findViewById, true);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        SessionsMenuViewImpl sessionsMenuViewImpl = new SessionsMenuViewImpl(requireContext);
        Context requireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
        SessionLogoutConfirmationViewImpl sessionLogoutConfirmationViewImpl = new SessionLogoutConfirmationViewImpl(requireContext2);
        ViewGroup viewGroup2 = (ViewGroup) inflate;
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        this.c = new SessionsListViewImpl(viewGroup2, adapterPresenter2, itemBinder2, appBarImpl, sessionsMenuViewImpl, sessionLogoutConfirmationViewImpl, analytics2);
        SessionsListPresenter sessionsListPresenter = this.presenter;
        if (sessionsListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        SessionsListView sessionsListView = this.c;
        if (sessionsListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionsListView");
        }
        sessionsListPresenter.attachView(sessionsListView);
        SessionsListPresenter sessionsListPresenter2 = this.presenter;
        if (sessionsListPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        sessionsListPresenter2.attachRouter(this);
        CompositeSnackbarPresenter compositeSnackbarPresenter = this.snackbarPresenter;
        if (compositeSnackbarPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("snackbarPresenter");
        }
        SessionsListView sessionsListView2 = this.c;
        if (sessionsListView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionsListView");
        }
        compositeSnackbarPresenter.setDefaultElement(sessionsListView2);
        CompositeSnackbarPresenter compositeSnackbarPresenter2 = this.snackbarPresenter;
        if (compositeSnackbarPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("snackbarPresenter");
        }
        compositeSnackbarPresenter2.addOptionalElement(sessionsMenuViewImpl);
        CompositeSnackbarPresenter compositeSnackbarPresenter3 = this.snackbarPresenter;
        if (compositeSnackbarPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("snackbarPresenter");
        }
        compositeSnackbarPresenter3.addOptionalElement(sessionLogoutConfirmationViewImpl);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        SessionsListPresenter sessionsListPresenter = this.presenter;
        if (sessionsListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        sessionsListPresenter.detachView();
        SessionsListPresenter sessionsListPresenter2 = this.presenter;
        if (sessionsListPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        sessionsListPresenter2.detachRouter();
        CompositeSnackbarPresenter compositeSnackbarPresenter = this.snackbarPresenter;
        if (compositeSnackbarPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("snackbarPresenter");
        }
        compositeSnackbarPresenter.clear();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        SessionsListPresenter sessionsListPresenter = this.presenter;
        if (sessionsListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        bundle.putParcelable("presenter_state", new CompressedParcelable(sessionsListPresenter.onSaveState()));
    }

    @Override // com.avito.android.profile.sessions.list.SessionsListPresenter.Router
    public void openAuthScreen() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivityForResult(AuthIntentFactory.DefaultImpls.authIntent$default(activityIntentFactory2, null, AuthSource.SESSIONS_LIST, null, 5, null), 1);
    }

    @Override // com.avito.android.profile.sessions.list.SessionsListPresenter.Router
    public void openChangePasswordScreen(boolean z, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivity(activityIntentFactory2.createPasswordChangeIntent(z, str, str2, str3, str4, str5, str6));
    }

    @Override // com.avito.android.profile.sessions.list.SessionsListPresenter.Router
    public void openSocialLogoutScreen(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivity(activityIntentFactory2.sessionsSocialLogoutIntent(str, str2, str3, str4, str5));
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    public final void setPresenter(@NotNull SessionsListPresenter sessionsListPresenter) {
        Intrinsics.checkNotNullParameter(sessionsListPresenter, "<set-?>");
        this.presenter = sessionsListPresenter;
    }

    public final void setSnackbarPresenter(@NotNull CompositeSnackbarPresenter compositeSnackbarPresenter) {
        Intrinsics.checkNotNullParameter(compositeSnackbarPresenter, "<set-?>");
        this.snackbarPresenter = compositeSnackbarPresenter;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            Intent intent = (Intent) arguments.getParcelable(Constants.UP_INTENT);
        }
        String str = null;
        CompressedParcelable compressedParcelable = bundle != null ? (CompressedParcelable) bundle.getParcelable("presenter_state") : null;
        Kundle kundle = compressedParcelable != null ? (Kundle) compressedParcelable.restore(Kundle.class) : null;
        SessionsListComponent.Factory factory = DaggerSessionsListComponent.factory();
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            str = arguments2.getString("source");
        }
        factory.create(resources, kundle, str, (SessionsListDependencies) ComponentDependenciesKt.getDependencies(SessionsListDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).inject(this);
        return true;
    }
}
