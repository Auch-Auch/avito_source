package com.avito.android.user_adverts.tab_screens;

import a2.b.a.a.a;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.bottom_navigation.ui.fragment.ScrollToUpHandler;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.InfoBannerCloseLink;
import com.avito.android.deep_linking.links.MyAdvertDetailsLink;
import com.avito.android.deep_linking.links.MyDraftAdvertDetailsLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.floating_views.FloatingViewsPresenter;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.user_adverts.R;
import com.avito.android.user_adverts.di.DaggerUserAdvertsListComponent;
import com.avito.android.user_adverts.di.UserAdvertsListComponent;
import com.avito.android.user_adverts.di.UserAdvertsListComponentDependencies;
import com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsListHost;
import com.avito.android.user_adverts.tab_screens.UserAdvertsListPresenter;
import com.avito.android.user_adverts.tab_screens.UserAdvertsListView;
import com.avito.android.user_adverts.tab_screens.advert_list.UserAdvertItemAction;
import com.avito.android.user_adverts.tab_screens.advert_list.UserAdvertsListAdapterModule;
import com.avito.android.user_adverts.tracker.UserAdvertsListTracker;
import com.avito.android.util.CompressedParcelable;
import com.avito.android.util.Constants;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.Kundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.jakewharton.rxrelay2.PublishRelay;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001uB\u0007¢\u0006\u0004\bt\u0010\u0019J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ-\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0012H\u0016¢\u0006\u0004\b$\u0010\u0019J\u0017\u0010'\u001a\u00020\u00122\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u00122\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b)\u0010(R\"\u0010+\u001a\u00020*8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00102\u001a\u0002018\u0006@\u0006X.¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u00109\u001a\u0002088\u0006@\u0006X.¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010@\u001a\u00020?8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010G\u001a\u00020F8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010N\u001a\u00020M8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010U\u001a\u00020T8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u0016\u0010^\u001a\u00020[8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\\\u0010]R\"\u0010`\u001a\u00020_8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\"\u0010g\u001a\u00020f8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\"\u0010n\u001a\u00020m8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bn\u0010o\u001a\u0004\bp\u0010q\"\u0004\br\u0010s¨\u0006v"}, d2 = {"Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListPresenter$Router;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsListHost;", "Lcom/avito/android/bottom_navigation/ui/fragment/ScrollToUpHandler;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "outState", "", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "()V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "invalidate", "refresh", "(Z)V", "scrollToUp", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "showInfoBannerScreen", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "followDeepLink", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/floating_views/FloatingViewsPresenter;", "floatingViewsPresenter", "Lcom/avito/android/floating_views/FloatingViewsPresenter;", "getFloatingViewsPresenter", "()Lcom/avito/android/floating_views/FloatingViewsPresenter;", "setFloatingViewsPresenter", "(Lcom/avito/android/floating_views/FloatingViewsPresenter;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "viewHolderBuilder", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "getViewHolderBuilder", "()Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "setViewHolderBuilder", "(Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;)V", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListPresenter;", "presenter", "Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListPresenter;", "getPresenter", "()Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListPresenter;", "setPresenter", "(Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListPresenter;)V", "Lcom/avito/android/user_adverts/tracker/UserAdvertsListTracker;", "tracker", "Lcom/avito/android/user_adverts/tracker/UserAdvertsListTracker;", "getTracker", "()Lcom/avito/android/user_adverts/tracker/UserAdvertsListTracker;", "setTracker", "(Lcom/avito/android/user_adverts/tracker/UserAdvertsListTracker;)V", "Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListView;", "c", "Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListView;", "advertsView", "Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListInteractor;", "interactor", "Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListInteractor;", "getInteractor", "()Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListInteractor;", "setInteractor", "(Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListInteractor;)V", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "adapterPresenter", "Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;)V", "<init>", "Factory", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class UserAdvertsListFragment extends BaseFragment implements UserAdvertsListPresenter.Router, UserAdvertsListHost, ScrollToUpHandler {
    @Inject
    public ResponsiveAdapterPresenter adapterPresenter;
    @Inject
    public Analytics analytics;
    public UserAdvertsListView c;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public Features features;
    @Inject
    public FloatingViewsPresenter floatingViewsPresenter;
    @Inject
    public ActivityIntentFactory intentFactory;
    @Inject
    public UserAdvertsListInteractor interactor;
    @Inject
    public UserAdvertsListPresenter presenter;
    @Inject
    public UserAdvertsListTracker tracker;
    @Inject
    public DestroyableViewHolderBuilder viewHolderBuilder;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListFragment$Factory;", "", "", "shortcut", "", FirebaseAnalytics.Param.INDEX, "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "", "isSubComponent", "Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListFragment;", "create", "(Ljava/lang/String;ILcom/avito/android/analytics/screens/Screen;Z)Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListFragment;", "<init>", "()V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory {

        public static final class a extends Lambda implements Function1<Bundle, Unit> {
            public final /* synthetic */ String a;
            public final /* synthetic */ int b;
            public final /* synthetic */ Screen c;
            public final /* synthetic */ boolean d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str, int i, Screen screen, boolean z) {
                super(1);
                this.a = str;
                this.b = i;
                this.c = screen;
                this.d = z;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Bundle bundle) {
                Bundle bundle2 = bundle;
                Intrinsics.checkNotNullParameter(bundle2, "$receiver");
                bundle2.putString("shortcut", this.a);
                bundle2.putInt(FirebaseAnalytics.Param.INDEX, this.b);
                bundle2.putParcelable(InternalConstsKt.SCREEN, this.c);
                bundle2.putBoolean("is_sub_component", this.d);
                return Unit.INSTANCE;
            }
        }

        @NotNull
        public final UserAdvertsListFragment create(@NotNull String str, int i, @NotNull Screen screen, boolean z) {
            Intrinsics.checkNotNullParameter(str, "shortcut");
            Intrinsics.checkNotNullParameter(screen, InternalConstsKt.SCREEN);
            return (UserAdvertsListFragment) FragmentsKt.arguments(new UserAdvertsListFragment(), 4, new a(str, i, screen, z));
        }
    }

    @Override // com.avito.android.user_adverts.tab_screens.UserAdvertsListPresenter.Router
    public void followDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent == null) {
            return;
        }
        if (!(deepLink instanceof MyDraftAdvertDetailsLink) && !(deepLink instanceof MyAdvertDetailsLink)) {
            startActivity(intent);
            return;
        }
        intent.removeExtra(Constants.UP_INTENT);
        startActivityForResult(intent, 3);
    }

    @NotNull
    public final ResponsiveAdapterPresenter getAdapterPresenter() {
        ResponsiveAdapterPresenter responsiveAdapterPresenter = this.adapterPresenter;
        if (responsiveAdapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return responsiveAdapterPresenter;
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
    public final FloatingViewsPresenter getFloatingViewsPresenter() {
        FloatingViewsPresenter floatingViewsPresenter2 = this.floatingViewsPresenter;
        if (floatingViewsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingViewsPresenter");
        }
        return floatingViewsPresenter2;
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
    public final UserAdvertsListInteractor getInteractor() {
        UserAdvertsListInteractor userAdvertsListInteractor = this.interactor;
        if (userAdvertsListInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        return userAdvertsListInteractor;
    }

    @NotNull
    public final UserAdvertsListPresenter getPresenter() {
        UserAdvertsListPresenter userAdvertsListPresenter = this.presenter;
        if (userAdvertsListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return userAdvertsListPresenter;
    }

    @NotNull
    public final UserAdvertsListTracker getTracker() {
        UserAdvertsListTracker userAdvertsListTracker = this.tracker;
        if (userAdvertsListTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        return userAdvertsListTracker;
    }

    @NotNull
    public final DestroyableViewHolderBuilder getViewHolderBuilder() {
        DestroyableViewHolderBuilder destroyableViewHolderBuilder = this.viewHolderBuilder;
        if (destroyableViewHolderBuilder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewHolderBuilder");
        }
        return destroyableViewHolderBuilder;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 3) {
            UserAdvertsListPresenter userAdvertsListPresenter = this.presenter;
            if (userAdvertsListPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            userAdvertsListPresenter.onAdvertDetailsResult(i2, intent);
        } else if (i == 4) {
            DeepLink deepLink = intent != null ? (DeepLink) intent.getParcelableExtra("deep_link") : null;
            if (deepLink instanceof InfoBannerCloseLink) {
                UserAdvertsListPresenter userAdvertsListPresenter2 = this.presenter;
                if (userAdvertsListPresenter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                userAdvertsListPresenter2.closeUserAdvertsBanner(((InfoBannerCloseLink) deepLink).getBannerId());
            }
            UserAdvertsListPresenter userAdvertsListPresenter3 = this.presenter;
            if (userAdvertsListPresenter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            UserAdvertsListPresenter.DefaultImpls.onRefresh$default(userAdvertsListPresenter3, true, false, 2, null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        UserAdvertsListTracker userAdvertsListTracker = this.tracker;
        if (userAdvertsListTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        userAdvertsListTracker.startInit();
        return layoutInflater.inflate(R.layout.user_adverts_list, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        UserAdvertsListPresenter userAdvertsListPresenter = this.presenter;
        if (userAdvertsListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        userAdvertsListPresenter.detachView();
        UserAdvertsListPresenter userAdvertsListPresenter2 = this.presenter;
        if (userAdvertsListPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        userAdvertsListPresenter2.detachRouter();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        UserAdvertsListPresenter userAdvertsListPresenter = this.presenter;
        if (userAdvertsListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        bundle.putParcelable("presenter_state", new CompressedParcelable(userAdvertsListPresenter.onSaveState()));
        UserAdvertsListInteractor userAdvertsListInteractor = this.interactor;
        if (userAdvertsListInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        bundle.putBundle("interactor_state", userAdvertsListInteractor.onSaveState());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        UserAdvertsListFragment$onViewCreated$router$1 userAdvertsListFragment$onViewCreated$router$1 = new UserAdvertsListView.Router(this) { // from class: com.avito.android.user_adverts.tab_screens.UserAdvertsListFragment$onViewCreated$router$1
            public final /* synthetic */ UserAdvertsListFragment a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // com.avito.android.user_adverts.tab_screens.UserAdvertsListView.Router
            public void onRefresh() {
                this.a.getPresenter().onRefresh(true, true);
            }

            @Override // com.avito.android.user_adverts.tab_screens.UserAdvertsListView.Router
            public void onRetryClick() {
                UserAdvertsListPresenter.DefaultImpls.onRefresh$default(this.a.getPresenter(), true, false, 2, null);
            }
        };
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        Integer valueOf = features2.getCartFloatingActionButton().invoke().booleanValue() ? Integer.valueOf(getResources().getDimensionPixelSize(com.avito.android.cart_fab.R.dimen.cart_bottom_space_for_list)) : null;
        int i = R.id.user_adverts_list_screen_root;
        ResponsiveAdapterPresenter responsiveAdapterPresenter = this.adapterPresenter;
        if (responsiveAdapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        DestroyableViewHolderBuilder destroyableViewHolderBuilder = this.viewHolderBuilder;
        if (destroyableViewHolderBuilder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewHolderBuilder");
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        FloatingViewsPresenter floatingViewsPresenter2 = this.floatingViewsPresenter;
        if (floatingViewsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingViewsPresenter");
        }
        this.c = new UserAdvertsListViewImpl(view, i, userAdvertsListFragment$onViewCreated$router$1, responsiveAdapterPresenter, destroyableViewHolderBuilder, analytics2, floatingViewsPresenter2, valueOf);
        UserAdvertsListPresenter userAdvertsListPresenter = this.presenter;
        if (userAdvertsListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        UserAdvertsListView userAdvertsListView = this.c;
        if (userAdvertsListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertsView");
        }
        userAdvertsListPresenter.attachView(userAdvertsListView);
        UserAdvertsListPresenter userAdvertsListPresenter2 = this.presenter;
        if (userAdvertsListPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        userAdvertsListPresenter2.attachRouter(this);
        UserAdvertsListTracker userAdvertsListTracker = this.tracker;
        if (userAdvertsListTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        userAdvertsListTracker.trackInit();
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsListHost
    public void refresh(boolean z) {
        UserAdvertsListPresenter userAdvertsListPresenter = this.presenter;
        if (userAdvertsListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        UserAdvertsListPresenter.DefaultImpls.onRefresh$default(userAdvertsListPresenter, z, false, 2, null);
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.ScrollToUpHandler
    public void scrollToUp() {
        UserAdvertsListView userAdvertsListView = this.c;
        if (userAdvertsListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertsView");
        }
        userAdvertsListView.scrollToTop();
    }

    public final void setAdapterPresenter(@NotNull ResponsiveAdapterPresenter responsiveAdapterPresenter) {
        Intrinsics.checkNotNullParameter(responsiveAdapterPresenter, "<set-?>");
        this.adapterPresenter = responsiveAdapterPresenter;
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

    public final void setFloatingViewsPresenter(@NotNull FloatingViewsPresenter floatingViewsPresenter2) {
        Intrinsics.checkNotNullParameter(floatingViewsPresenter2, "<set-?>");
        this.floatingViewsPresenter = floatingViewsPresenter2;
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    public final void setInteractor(@NotNull UserAdvertsListInteractor userAdvertsListInteractor) {
        Intrinsics.checkNotNullParameter(userAdvertsListInteractor, "<set-?>");
        this.interactor = userAdvertsListInteractor;
    }

    public final void setPresenter(@NotNull UserAdvertsListPresenter userAdvertsListPresenter) {
        Intrinsics.checkNotNullParameter(userAdvertsListPresenter, "<set-?>");
        this.presenter = userAdvertsListPresenter;
    }

    public final void setTracker(@NotNull UserAdvertsListTracker userAdvertsListTracker) {
        Intrinsics.checkNotNullParameter(userAdvertsListTracker, "<set-?>");
        this.tracker = userAdvertsListTracker;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        String string;
        Screen screen;
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("shortcut")) == null) {
            throw new IllegalArgumentException("Shortcut key is required to use UserAdvertsListFragment");
        }
        Intrinsics.checkNotNullExpressionValue(string, "arguments?.getString(KEY…UserAdvertsListFragment\")");
        Bundle arguments2 = getArguments();
        int i = -1;
        if (arguments2 != null) {
            i = arguments2.getInt(FirebaseAnalytics.Param.INDEX, -1);
        }
        Bundle arguments3 = getArguments();
        if (arguments3 == null || (screen = (Screen) arguments3.getParcelable(InternalConstsKt.SCREEN)) == null) {
            throw new IllegalArgumentException("screen key is required to use UserAdvertsListFragment");
        }
        Intrinsics.checkNotNullExpressionValue(screen, "arguments?.getParcelable…UserAdvertsListFragment\")");
        Bundle arguments4 = getArguments();
        if (arguments4 != null) {
            boolean z = false;
            boolean z2 = arguments4.getBoolean("is_sub_component", false);
            Kundle kundle = null;
            CompressedParcelable compressedParcelable = bundle != null ? (CompressedParcelable) bundle.getParcelable("presenter_state") : null;
            Bundle bundle2 = bundle != null ? bundle.getBundle("interactor_state") : null;
            if (compressedParcelable != null) {
                kundle = (Kundle) compressedParcelable.restore(Kundle.class);
            }
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            UserAdvertsListAdapterModule userAdvertsListAdapterModule = new UserAdvertsListAdapterModule(requireActivity, resources);
            Timer B1 = a.B1();
            UserAdvertsListComponent.Builder presenterState = DaggerUserAdvertsListComponent.builder().userAdvertsListAdapterModule(userAdvertsListAdapterModule).interactorState(bundle2).presenterState(kundle);
            FragmentActivity requireActivity2 = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
            UserAdvertsListComponent.Builder isSubComponent = presenterState.context(requireActivity2).shortcut(string).screenName(screen).isSubComponent(z2);
            Resources resources2 = getResources();
            Intrinsics.checkNotNullExpressionValue(resources2, "resources");
            UserAdvertsListComponent.Builder resources3 = isSubComponent.resources(resources2);
            if (i == 0) {
                z = true;
            }
            UserAdvertsListComponent.Builder userAdvertsListComponentDependencies = resources3.isFirstTab(z).userAdvertsListComponentDependencies((UserAdvertsListComponentDependencies) ComponentDependenciesKt.getDependencies(UserAdvertsListComponentDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this)));
            PublishRelay<UserAdvertItemAction> create = PublishRelay.create();
            Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create<UserAdvertItemAction>()");
            userAdvertsListComponentDependencies.with(create).build().inject(this);
            UserAdvertsListTracker userAdvertsListTracker = this.tracker;
            if (userAdvertsListTracker == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tracker");
            }
            userAdvertsListTracker.trackDiInject(B1.elapsed());
            return true;
        }
        throw new IllegalArgumentException("is_sub_component key is required to use UserAdvertsListFragment");
    }

    public final void setViewHolderBuilder(@NotNull DestroyableViewHolderBuilder destroyableViewHolderBuilder) {
        Intrinsics.checkNotNullParameter(destroyableViewHolderBuilder, "<set-?>");
        this.viewHolderBuilder = destroyableViewHolderBuilder;
    }

    @Override // com.avito.android.user_adverts.tab_screens.UserAdvertsListPresenter.Router
    public void showInfoBannerScreen(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent != null) {
            startActivityForResult(intent, 4);
        }
    }
}
