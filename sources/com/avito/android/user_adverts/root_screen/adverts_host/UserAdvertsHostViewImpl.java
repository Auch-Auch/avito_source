package com.avito.android.user_adverts.root_screen.adverts_host;

import a2.g.r.g;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.avito.android.ab_tests.configs.UserAdvertsTabTestGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.app_rater.events.AppRaterEventSourcePage;
import com.avito.android.app_rater.fragment.AppRaterDialogFragment;
import com.avito.android.bottom_navigation.ui.fragment.ScrollToUpHandler;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DetailsSheetLink;
import com.avito.android.lib.design.button.Button;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.adapter.tab.TabAdapter;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.avito.android.user_adverts.R;
import com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostView;
import com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsListHost;
import com.avito.android.user_adverts.root_screen.adverts_host.publish_button.PublishFab;
import com.avito.android.util.ActionBarUtils;
import com.avito.android.util.AnimationUtils;
import com.avito.android.util.TabLayoutsKt;
import com.avito.android.util.Views;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002Bg\u0012\u0007\u0010\u0001\u001a\u00020P\u0012\u0006\u0010f\u001a\u00020c\u0012\u0006\u0010<\u001a\u000209\u0012\u000e\u0010O\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030L\u0012\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020~0}\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0006\u0010[\u001a\u00020X\u0012\b\u0010b\u001a\u0004\u0018\u00010_\u0012\b\u0010\u0001\u001a\u00030\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u0005J\u0017\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0005J\u0017\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u0005J\u0017\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0013J\u0017\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001a\u0010\u0005J\u000f\u0010\u001b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001b\u0010\u0005J\u000f\u0010\u001c\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001c\u0010\u0005J\u000f\u0010\u001d\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001d\u0010\u0005J\u0017\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u001eH\u0016¢\u0006\u0004\b#\u0010!J\u000f\u0010$\u001a\u00020\u0003H\u0016¢\u0006\u0004\b$\u0010\u0005J\u0017\u0010&\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u001eH\u0016¢\u0006\u0004\b&\u0010!J'\u0010+\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u001eH\u0016¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u001eH\u0016¢\u0006\u0004\b-\u0010!J\u001f\u0010/\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u0010H\u0002¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0003H\u0002¢\u0006\u0004\b1\u0010\u0005J\u000f\u00102\u001a\u00020\u0003H\u0002¢\u0006\u0004\b2\u0010\u0005J\u0019\u00104\u001a\u00020\u00032\b\b\u0001\u00103\u001a\u00020\u001eH\u0002¢\u0006\u0004\b4\u0010!R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010K\u001a\u00020I8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u0010JR\u001e\u0010O\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030L8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010W\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010^\u001a\u00020\\8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u0010]R\u0018\u0010b\u001a\u0004\u0018\u00010_8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010f\u001a\u00020c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010i\u001a\u00020\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010l\u001a\u00020j8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u0010kR\u0018\u0010n\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bm\u0010RR\u0016\u0010r\u001a\u00020o8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010v\u001a\u00020s8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bt\u0010uR\u0018\u0010x\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bw\u0010RR\u0016\u0010|\u001a\u00020y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bz\u0010{R\u001e\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020~0}8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0010\u0001R\u001a\u0010\u0001\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010RR\u001a\u0010\u0001\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010RR\u0018\u0010\u0001\u001a\u00020\u001e8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010hR\u0018\u0010\u0001\u001a\u00020P8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010RR\u0019\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b/\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostViewImpl;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostView;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "", "removeListeners", "()V", "showProgress", "showError", "showEmpty", "showContent", "showLogout", "Lcom/avito/android/deep_linking/links/DetailsSheetLink;", "deepLink", "showSafetyInfoBanner", "(Lcom/avito/android/deep_linking/links/DetailsSheetLink;)V", "showPublishButtonIfNeeded", "", "animate", "showFloatingViews", "(Z)V", "showAppRater", "hideFloatingViews", "", "message", "showSnackBar", "(Ljava/lang/String;)V", "scrollToUp", "scrollToHeader", "onTabsInvalidated", "onTabsChanged", "", "activeTab", "setActiveTab", "(I)V", "tabIndex", "onRefreshTab", "refreshActiveTab", "state", "onPageScrollStateChanged", VKApiConst.POSITION, "", "positionOffset", "positionOffsetPixels", "onPageScrolled", "(IFI)V", "onPageSelected", "visible", AuthSource.SEND_ABUSE, "(ZZ)V", AuthSource.BOOKING_ORDER, "d", "topMargin", "c", "Lcom/google/android/material/tabs/TabLayout;", "i", "Lcom/google/android/material/tabs/TabLayout;", "tabLayout", "Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostView$Presenter;", VKApiConst.VERSION, "Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostView$Presenter;", "presenter", "Lcom/google/android/material/appbar/AppBarLayout;", "f", "Lcom/google/android/material/appbar/AppBarLayout;", "appbarLayout", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "e", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Landroidx/viewpager/widget/ViewPager;", "j", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "Landroid/content/res/Resources;", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/ui/adapter/tab/TabAdapter;", "w", "Lcom/avito/android/ui/adapter/tab/TabAdapter;", "tabsAdapter", "Landroid/view/View;", "k", "Landroid/view/View;", "emptyView", "Lcom/avito/android/lib/design/button/Button;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/lib/design/button/Button;", "addButtonView", "Lcom/avito/android/ab_tests/configs/UserAdvertsTabTestGroup;", "z", "Lcom/avito/android/ab_tests/configs/UserAdvertsTabTestGroup;", "tabTestGroup", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "contentHolder", "Lcom/avito/android/user_adverts/root_screen/adverts_host/publish_button/PublishFab;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/user_adverts/root_screen/adverts_host/publish_button/PublishFab;", "publishFabView", "Landroidx/fragment/app/FragmentManager;", "u", "Landroidx/fragment/app/FragmentManager;", "supportFragmentManager", "l", "I", "actionBarSize", "Lcom/avito/android/user_adverts/root_screen/adverts_host/TabPagerAdapter;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/TabPagerAdapter;", "pagerAdapter", "h", "shadow", "Ljava/lang/Runnable;", "r", "Ljava/lang/Runnable;", "tabLayoutUpdateRunnable", "Lio/reactivex/disposables/CompositeDisposable;", "s", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "o", "loginButton", "Landroidx/appcompat/widget/Toolbar;", g.a, "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/TabItem;", "x", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "tabsDataProvider", "p", "advertsTitle", "n", "logoutLayout", VKApiConst.Q, "paddingTop", "t", "view", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "y", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Landroid/view/View;Landroidx/fragment/app/FragmentManager;Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostView$Presenter;Lcom/avito/android/ui/adapter/tab/TabAdapter;Lcom/avito/android/ui/adapter/tab/TabsDataProvider;Lcom/avito/android/deep_linking/DeepLinkIntentFactory;Lcom/avito/android/ab_tests/configs/UserAdvertsTabTestGroup;Lcom/avito/android/user_adverts/root_screen/adverts_host/publish_button/PublishFab;Lcom/avito/android/analytics/Analytics;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class UserAdvertsHostViewImpl implements UserAdvertsHostView, ViewPager.OnPageChangeListener {
    public final PublishFab A;
    public final Context a;
    public final Resources b;
    public final CoordinatorLayout c;
    public TabPagerAdapter d;
    public ProgressOverlay e;
    public final AppBarLayout f;
    public final Toolbar g;
    public final View h;
    public final TabLayout i;
    public final ViewPager j;
    public final View k;
    public int l;
    public final Button m;
    public final View n;
    public final View o;
    public final View p;
    public int q;
    public final Runnable r = new c(this);
    public final CompositeDisposable s = new CompositeDisposable();
    public final View t;
    public final FragmentManager u;
    public final UserAdvertsHostView.Presenter v;
    public final TabAdapter<?, ?> w;
    public TabsDataProvider<TabItem> x;
    public DeepLinkIntentFactory y;
    public final UserAdvertsTabTestGroup z;

    /* compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.a;
            if (i == 0) {
                ((UserAdvertsHostViewImpl) this.b).v.onAddAdvertClicked();
            } else if (i == 1) {
                ((UserAdvertsHostViewImpl) this.b).v.onLoginClick();
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ UserAdvertsHostViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(UserAdvertsHostViewImpl userAdvertsHostViewImpl) {
            super(0);
            this.a = userAdvertsHostViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.v.onRetryClicked();
            return Unit.INSTANCE;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ UserAdvertsHostViewImpl a;

        public c(UserAdvertsHostViewImpl userAdvertsHostViewImpl) {
            this.a = userAdvertsHostViewImpl;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.i.setScrollPosition(this.a.i.getSelectedTabPosition(), 0.0f, true);
        }
    }

    public UserAdvertsHostViewImpl(@NotNull View view, @NotNull FragmentManager fragmentManager, @NotNull UserAdvertsHostView.Presenter presenter, @NotNull TabAdapter<?, ?> tabAdapter, @NotNull TabsDataProvider<TabItem> tabsDataProvider, @NotNull DeepLinkIntentFactory deepLinkIntentFactory, @NotNull UserAdvertsTabTestGroup userAdvertsTabTestGroup, @Nullable PublishFab publishFab, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(fragmentManager, "supportFragmentManager");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        Intrinsics.checkNotNullParameter(tabAdapter, "tabsAdapter");
        Intrinsics.checkNotNullParameter(tabsDataProvider, "tabsDataProvider");
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "deepLinkIntentFactory");
        Intrinsics.checkNotNullParameter(userAdvertsTabTestGroup, "tabTestGroup");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.t = view;
        this.u = fragmentManager;
        this.v = presenter;
        this.w = tabAdapter;
        this.x = tabsDataProvider;
        this.y = deepLinkIntentFactory;
        this.z = userAdvertsTabTestGroup;
        this.A = publishFab;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        this.a = context;
        Resources resources = view.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "view.resources");
        this.b = resources;
        View findViewById = view.findViewById(R.id.content_holder);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout");
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById;
        this.c = coordinatorLayout;
        this.d = new TabPagerAdapter(fragmentManager, this.x);
        int i2 = R.id.pager;
        this.e = new ProgressOverlay(coordinatorLayout, i2, analytics, false, 0, 24, null);
        View findViewById2 = view.findViewById(R.id.app_bar);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout");
        this.f = (AppBarLayout) findViewById2;
        View findViewById3 = view.findViewById(com.avito.android.deprecated_design.R.id.toolbar);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        Toolbar toolbar = (Toolbar) findViewById3;
        this.g = toolbar;
        this.h = view.findViewById(com.avito.android.ui_components.R.id.shadow);
        View findViewById4 = view.findViewById(R.id.tabs);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type com.google.android.material.tabs.TabLayout");
        TabLayout tabLayout = (TabLayout) findViewById4;
        this.i = tabLayout;
        View findViewById5 = view.findViewById(i2);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type androidx.viewpager.widget.ViewPager");
        ViewPager viewPager = (ViewPager) findViewById5;
        this.j = viewPager;
        View findViewById6 = view.findViewById(16908292);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.view.View");
        this.k = findViewById6;
        this.l = ActionBarUtils.INSTANCE.getActionBarSize(context);
        Button button = (Button) view.findViewById(R.id.add_advert);
        this.m = button;
        this.n = view.findViewById(R.id.logout_layout);
        View findViewById7 = view.findViewById(R.id.login_button);
        this.o = findViewById7;
        this.p = view.findViewById(R.id.adverts_title);
        toolbar.setTitle(com.avito.android.app.core.R.string.my_adverts);
        toolbar.setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_back_24_blue);
        this.q = resources.getDimensionPixelSize(com.avito.android.ui_components.R.dimen.tab_layout_height) + this.l;
        this.e.setOnRefreshListener(new b(this));
        this.e.setToolbarPadding();
        TabLayoutsKt.setAdapter(tabLayout, tabAdapter);
        viewPager.setAdapter(this.d);
        viewPager.addOnPageChangeListener(this);
        tabLayout.setupWithViewPager(viewPager);
        if (button != null) {
            button.setOnClickListener(new a(0, this));
        }
        if (findViewById7 != null) {
            findViewById7.setOnClickListener(new a(1, this));
        }
    }

    public final void a(boolean z2, boolean z3) {
        int i2 = -this.l;
        if (z3) {
            i2 = 0;
        }
        long j2 = z2 ? 150 : 0;
        AnimationUtils animationUtils = AnimationUtils.INSTANCE;
        animationUtils.animateTranslation(this.g, i2, j2);
        animationUtils.animateTranslation(this.i, i2, j2);
        View view = this.h;
        if (view != null) {
            animationUtils.animateTranslation(view, i2, j2);
        }
    }

    public final void b() {
        Views.hide(this.j);
        Views.hide(this.i);
        c(this.l);
        Views.hide(this.p);
    }

    public final void c(@Px int i2) {
        View view = this.h;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = i2;
            this.h.requestLayout();
        }
    }

    public final void d() {
        Views.show(this.j);
        Views.show(this.i);
        c(this.q);
        if (this.z.isTest()) {
            Views.hide(this.p);
        } else {
            Views.show(this.p);
        }
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostView
    public void hideFloatingViews(boolean z2) {
        a(z2, false);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        this.v.onActiveTabChanged(i2);
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostView
    public void onRefreshTab(int i2) {
        TabPagerAdapter tabPagerAdapter = this.d;
        ViewPager viewPager = this.j;
        Object instantiateItem = tabPagerAdapter.instantiateItem((ViewGroup) viewPager, viewPager.getCurrentItem());
        Objects.requireNonNull(instantiateItem, "null cannot be cast to non-null type com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsListHost");
        this.d.finishUpdate((ViewGroup) this.j);
        UserAdvertsListHost.DefaultImpls.refresh$default((UserAdvertsListHost) instantiateItem, false, 1, null);
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostView
    public void onTabsChanged() {
        this.d.notifyDataSetChanged();
        this.w.notifyDataSetChanged();
        c(this.q);
        this.i.post(this.r);
        Views.hide(this.k);
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostView
    public void onTabsInvalidated() {
        TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(this.u, this.x);
        this.d = tabPagerAdapter;
        this.j.setAdapter(tabPagerAdapter);
        this.w.notifyDataSetInvalidated();
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostView
    public void refreshActiveTab() {
        if (this.x.getCount() > 0) {
            TabPagerAdapter tabPagerAdapter = this.d;
            ViewPager viewPager = this.j;
            Object instantiateItem = tabPagerAdapter.instantiateItem((ViewGroup) viewPager, viewPager.getCurrentItem());
            Objects.requireNonNull(instantiateItem, "null cannot be cast to non-null type com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsListHost");
            this.d.finishUpdate((ViewGroup) this.j);
            ((UserAdvertsListHost) instantiateItem).refresh(true);
        }
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostView
    public void removeListeners() {
        TabAdapter<?, ?> adapter = TabLayoutsKt.getAdapter(this.i);
        if (adapter != null) {
            adapter.unregisterAllObservers();
        }
        this.i.removeCallbacks(this.r);
        this.j.clearOnPageChangeListeners();
        this.s.clear();
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostView
    public void scrollToHeader() {
        scrollToUp();
        this.f.setExpanded(true);
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostView
    public void scrollToUp() {
        Fragment primaryItem = this.d.getPrimaryItem();
        if (!(primaryItem instanceof ScrollToUpHandler)) {
            primaryItem = null;
        }
        ScrollToUpHandler scrollToUpHandler = (ScrollToUpHandler) primaryItem;
        if (scrollToUpHandler != null) {
            scrollToUpHandler.scrollToUp();
        }
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostView
    public void setActiveTab(int i2) {
        this.j.setCurrentItem(i2, false);
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostView
    public void showAppRater() {
        AppRaterDialogFragment.Companion.getInstance(AppRaterEventSourcePage.SOLD_ON_AVITO).show(this.u, "app_rater_dialog");
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostView
    public void showContent() {
        Views.hide(this.k);
        View view = this.n;
        if (view != null) {
            Views.hide(view);
        }
        d();
        this.e.showContent();
        Views.show(this.c);
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostView
    public void showEmpty() {
        this.e.showContent();
        this.j.setAdapter(null);
        this.i.removeAllTabs();
        b();
        Views.show(this.c);
        View view = this.n;
        if (view != null) {
            Views.hide(view);
        }
        Views.show(this.k);
        c(this.q);
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostView
    public void showError() {
        Views.hide(this.k);
        View view = this.n;
        if (view != null) {
            Views.hide(view);
        }
        b();
        Views.show(this.c);
        LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.e, null, 1, null);
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostView
    public void showFloatingViews(boolean z2) {
        a(z2, true);
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostView
    public void showLogout() {
        Views.hide(this.k);
        b();
        Views.hide(this.c);
        View view = this.n;
        if (view != null) {
            Views.show(view);
        }
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostView
    public void showProgress() {
        Views.hide(this.k);
        View view = this.n;
        if (view != null) {
            Views.hide(view);
        }
        d();
        Views.show(this.c);
        this.e.showLoading();
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostView
    public void showPublishButtonIfNeeded() {
        PublishFab publishFab = this.A;
        if (publishFab != null) {
            publishFab.show();
        }
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostView
    public void showSafetyInfoBanner(@NotNull DetailsSheetLink detailsSheetLink) {
        Intrinsics.checkNotNullParameter(detailsSheetLink, "deepLink");
        Intent intent = this.y.getIntent(detailsSheetLink);
        if (intent != null) {
            this.a.startActivity(intent);
        }
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostView
    public void showSnackBar(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        View findViewById = this.t.findViewById(R.id.user_adverts_container);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        Views.showSnackBar$default(findViewById, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }
}
