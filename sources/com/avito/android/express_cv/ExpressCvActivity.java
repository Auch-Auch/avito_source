package com.avito.android.express_cv;

import a2.a.a.p0.e;
import a2.a.a.p0.f;
import a2.a.a.p0.g;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;
import com.avito.android.ComponentProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.links.PhoneLink;
import com.avito.android.deprecated_design.R;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.express_cv.di.DaggerExpressCvComponent;
import com.avito.android.express_cv.di.ExpressCvComponent;
import com.avito.android.express_cv.di.ExpressCvDependencies;
import com.avito.android.express_cv.di.ExpressCvModule;
import com.avito.android.express_cv.events.CvDialogEvent;
import com.avito.android.express_cv.events.DialogParams;
import com.avito.android.express_cv.events.PhoneCallEvent;
import com.avito.android.express_cv.tabs.CvTabItem;
import com.avito.android.express_cv.tabs.CvTabLayoutAdapter;
import com.avito.android.express_cv.tabs.TabPagerAdapter;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.TabLayoutsKt;
import com.avito.android.util.architecture_components.IntentDataHolder;
import com.avito.android.util.architecture_components.IntentForResultDataHolder;
import com.avito.android.util.architecture_components.StartActivityEvent;
import com.avito.android.util.architecture_components.StartActivityForResultEvent;
import com.google.android.material.tabs.TabLayout;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 k2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001kB\u0007¢\u0006\u0004\bj\u0010\nJ\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000b\u0010\nJ)\u0010\u0011\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020&0%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\"\u0010+\u001a\u00020*8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R(\u00103\u001a\b\u0012\u0004\u0012\u000202018\u0006@\u0006X.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001c\u0010;\u001a\b\u0012\u0004\u0012\u0002090%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010(R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b=\u0010>R\"\u0010@\u001a\u00020\u00038\u0016@\u0016X.¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0016\u0010I\u001a\u00020F8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bK\u0010LR\"\u0010O\u001a\u00020N8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001c\u0010W\u001a\b\u0012\u0004\u0012\u00020U0%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010(R\"\u0010Y\u001a\u00020X8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u0016\u0010b\u001a\u00020_8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b`\u0010aR\u001c\u0010e\u001a\b\u0012\u0004\u0012\u00020c0%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bd\u0010(R\u0016\u0010i\u001a\u00020f8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bg\u0010h¨\u0006l"}, d2 = {"Lcom/avito/android/express_cv/ExpressCvActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/ComponentProvider;", "Lcom/avito/android/express_cv/di/ExpressCvComponent;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Landroidx/viewpager/widget/ViewPager;", "o", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "Lcom/avito/android/express_cv/ExpressCvViewModel;", "viewModel", "Lcom/avito/android/express_cv/ExpressCvViewModel;", "getViewModel", "()Lcom/avito/android/express_cv/ExpressCvViewModel;", "setViewModel", "(Lcom/avito/android/express_cv/ExpressCvViewModel;)V", "Lcom/avito/android/express_cv/tabs/CvTabLayoutAdapter;", "layoutAdapter", "Lcom/avito/android/express_cv/tabs/CvTabLayoutAdapter;", "getLayoutAdapter", "()Lcom/avito/android/express_cv/tabs/CvTabLayoutAdapter;", "setLayoutAdapter", "(Lcom/avito/android/express_cv/tabs/CvTabLayoutAdapter;)V", "Landroidx/lifecycle/Observer;", "Lcom/avito/android/express_cv/events/PhoneCallEvent;", "r", "Landroidx/lifecycle/Observer;", "startPhoneActivityObserver", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Lcom/avito/android/util/DialogRouter;", "getDialogRouter", "()Lcom/avito/android/util/DialogRouter;", "setDialogRouter", "(Lcom/avito/android/util/DialogRouter;)V", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "Lcom/avito/android/express_cv/tabs/CvTabItem;", "tabsDataProvider", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "getTabsDataProvider", "()Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "setTabsDataProvider", "(Lcom/avito/android/ui/adapter/tab/TabsDataProvider;)V", "Lcom/avito/android/express_cv/events/CvDialogEvent;", "t", "dialogObserver", "Landroidx/appcompat/widget/Toolbar;", "k", "Landroidx/appcompat/widget/Toolbar;", "exToolbar", "component", "Lcom/avito/android/express_cv/di/ExpressCvComponent;", "getComponent", "()Lcom/avito/android/express_cv/di/ExpressCvComponent;", "setComponent", "(Lcom/avito/android/express_cv/di/ExpressCvComponent;)V", "Lcom/google/android/material/tabs/TabLayout;", "n", "Lcom/google/android/material/tabs/TabLayout;", "tabLayout", "", "p", "Ljava/lang/String;", "context", "Lcom/avito/android/express_cv/tabs/TabPagerAdapter;", "pagerAdapter", "Lcom/avito/android/express_cv/tabs/TabPagerAdapter;", "getPagerAdapter", "()Lcom/avito/android/express_cv/tabs/TabPagerAdapter;", "setPagerAdapter", "(Lcom/avito/android/express_cv/tabs/TabPagerAdapter;)V", "Lcom/avito/android/util/architecture_components/StartActivityEvent;", VKApiConst.Q, "startActivityObserver", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/progress_overlay/ProgressOverlay;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Lcom/avito/android/util/architecture_components/StartActivityForResultEvent;", "s", "startActivityForResultObserver", "Landroid/view/View;", "l", "Landroid/view/View;", "progressBar", "<init>", "Companion", "express-cv_release"}, k = 1, mv = {1, 4, 2})
public final class ExpressCvActivity extends BaseActivity implements ComponentProvider<ExpressCvComponent> {
    @NotNull
    public static final String CONTEXT = "context";
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public Analytics analytics;
    public ExpressCvComponent component;
    @Inject
    public DialogRouter dialogRouter;
    public Toolbar k;
    public View l;
    @Inject
    public CvTabLayoutAdapter layoutAdapter;
    public ProgressOverlay m;
    public TabLayout n;
    public ViewPager o;
    public String p;
    @Inject
    public TabPagerAdapter pagerAdapter;
    public final Observer<StartActivityEvent> q = new c(this);
    public final Observer<PhoneCallEvent> r = new d(this);
    public final Observer<StartActivityForResultEvent> s = new b(this);
    public final Observer<CvDialogEvent> t = new a(this);
    @Inject
    public TabsDataProvider<CvTabItem> tabsDataProvider;
    @Inject
    public ExpressCvViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/express_cv/ExpressCvActivity$Companion;", "", "", "CONTEXT", "Ljava/lang/String;", "<init>", "()V", "express-cv_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a<T> implements Observer<CvDialogEvent> {
        public final /* synthetic */ ExpressCvActivity a;

        public a(ExpressCvActivity expressCvActivity) {
            this.a = expressCvActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(CvDialogEvent cvDialogEvent) {
            CvDialogEvent cvDialogEvent2 = cvDialogEvent;
            if (cvDialogEvent2 != null) {
                ExpressCvActivity.access$showNotification(this.a, (DialogParams) cvDialogEvent2.peekContent());
            }
        }
    }

    public static final class b<T> implements Observer<StartActivityForResultEvent> {
        public final /* synthetic */ ExpressCvActivity a;

        public b(ExpressCvActivity expressCvActivity) {
            this.a = expressCvActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(StartActivityForResultEvent startActivityForResultEvent) {
            IntentForResultDataHolder intentForResultDataHolder;
            StartActivityForResultEvent startActivityForResultEvent2 = startActivityForResultEvent;
            if (startActivityForResultEvent2 != null && (intentForResultDataHolder = (IntentForResultDataHolder) startActivityForResultEvent2.getContentIfNotHandled()) != null) {
                this.a.startActivityForResult(intentForResultDataHolder.getIntent(), intentForResultDataHolder.getRequestCode());
            }
        }
    }

    public static final class c<T> implements Observer<StartActivityEvent> {
        public final /* synthetic */ ExpressCvActivity a;

        public c(ExpressCvActivity expressCvActivity) {
            this.a = expressCvActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(StartActivityEvent startActivityEvent) {
            IntentDataHolder intentDataHolder;
            StartActivityEvent startActivityEvent2 = startActivityEvent;
            if (startActivityEvent2 != null && (intentDataHolder = (IntentDataHolder) startActivityEvent2.getContentIfNotHandled()) != null) {
                this.a.startActivity(intentDataHolder.getIntent());
                if (intentDataHolder.getShouldFinish()) {
                    this.a.finish();
                }
            }
        }
    }

    public static final class d<T> implements Observer<PhoneCallEvent> {
        public final /* synthetic */ ExpressCvActivity a;

        public d(ExpressCvActivity expressCvActivity) {
            this.a = expressCvActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(PhoneCallEvent phoneCallEvent) {
            PhoneLink.Call call;
            PhoneCallEvent phoneCallEvent2 = phoneCallEvent;
            if (phoneCallEvent2 != null && (call = (PhoneLink.Call) phoneCallEvent2.getContentIfNotHandled()) != null) {
                this.a.setResult(-1, new Intent().putExtra(ExpressCvConstants.EXPRESS_CV_LINK_EXTRA, call));
                this.a.finish();
            }
        }
    }

    public static final /* synthetic */ View access$getProgressBar$p(ExpressCvActivity expressCvActivity) {
        View view = expressCvActivity.l;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        }
        return view;
    }

    public static final /* synthetic */ ProgressOverlay access$getProgressOverlay$p(ExpressCvActivity expressCvActivity) {
        ProgressOverlay progressOverlay = expressCvActivity.m;
        if (progressOverlay == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressOverlay");
        }
        return progressOverlay;
    }

    public static final /* synthetic */ TabLayout access$getTabLayout$p(ExpressCvActivity expressCvActivity) {
        TabLayout tabLayout = expressCvActivity.n;
        if (tabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        return tabLayout;
    }

    public static final /* synthetic */ ViewPager access$getViewPager$p(ExpressCvActivity expressCvActivity) {
        ViewPager viewPager = expressCvActivity.o;
        if (viewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        return viewPager;
    }

    public static final void access$showNotification(ExpressCvActivity expressCvActivity, DialogParams dialogParams) {
        DialogRouter dialogRouter2 = expressCvActivity.dialogRouter;
        if (dialogRouter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogRouter");
        }
        dialogRouter2.showSimpleNotifyingDismissDialog(dialogParams.getTitle(), dialogParams.getDescription(), new g(expressCvActivity, dialogParams));
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
    public final DialogRouter getDialogRouter() {
        DialogRouter dialogRouter2 = this.dialogRouter;
        if (dialogRouter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogRouter");
        }
        return dialogRouter2;
    }

    @NotNull
    public final CvTabLayoutAdapter getLayoutAdapter() {
        CvTabLayoutAdapter cvTabLayoutAdapter = this.layoutAdapter;
        if (cvTabLayoutAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutAdapter");
        }
        return cvTabLayoutAdapter;
    }

    @NotNull
    public final TabPagerAdapter getPagerAdapter() {
        TabPagerAdapter tabPagerAdapter = this.pagerAdapter;
        if (tabPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        }
        return tabPagerAdapter;
    }

    @NotNull
    public final TabsDataProvider<CvTabItem> getTabsDataProvider() {
        TabsDataProvider<CvTabItem> tabsDataProvider2 = this.tabsDataProvider;
        if (tabsDataProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabsDataProvider");
        }
        return tabsDataProvider2;
    }

    @NotNull
    public final ExpressCvViewModel getViewModel() {
        ExpressCvViewModel expressCvViewModel = this.viewModel;
        if (expressCvViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return expressCvViewModel;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        ExpressCvViewModel expressCvViewModel = this.viewModel;
        if (expressCvViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        expressCvViewModel.onActivityResult(i, i2, intent);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.express_cv_activity);
        String stringExtra = getIntent().getStringExtra("context");
        Intrinsics.checkNotNullExpressionValue(stringExtra, "intent.getStringExtra(CONTEXT)");
        this.p = stringExtra;
        ExpressCvComponent.Builder dependencies = DaggerExpressCvComponent.builder().dependencies((ExpressCvDependencies) ComponentDependenciesKt.getDependencies(ExpressCvDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this)));
        String str = this.p;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
        }
        setComponent(dependencies.expressCvModule(new ExpressCvModule(str)).withActivity(this).build());
        getComponent().inject(this);
        setResult(0);
        View findViewById = findViewById(R.id.toolbar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(deprecated_R.id.toolbar)");
        Toolbar toolbar = (Toolbar) findViewById;
        this.k = toolbar;
        if (toolbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("exToolbar");
        }
        toolbar.setTitle(R.string.express_cv_toolbar_title);
        View findViewById2 = findViewById(R.id.tab_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tab_layout)");
        this.n = (TabLayout) findViewById2;
        View findViewById3 = findViewById(R.id.cv_pager);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.cv_pager)");
        this.o = (ViewPager) findViewById3;
        View findViewById4 = findViewById(R.id.progress_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.progress_bar)");
        this.l = findViewById4;
        View findViewById5 = findViewById(R.id.content_holder);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.content_holder)");
        ViewGroup viewGroup = (ViewGroup) findViewById5;
        int i = R.id.content;
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        ProgressOverlay progressOverlay = new ProgressOverlay(viewGroup, i, analytics2, false, 0, 24, null);
        this.m = progressOverlay;
        progressOverlay.setOnRefreshListener(new e(this));
        Toolbar toolbar2 = this.k;
        if (toolbar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("exToolbar");
        }
        toolbar2.setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_back_24_blue);
        Toolbar toolbar3 = this.k;
        if (toolbar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("exToolbar");
        }
        toolbar3.setNavigationOnClickListener(new f(this));
        TabLayout tabLayout = this.n;
        if (tabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        CvTabLayoutAdapter cvTabLayoutAdapter = this.layoutAdapter;
        if (cvTabLayoutAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutAdapter");
        }
        TabLayoutsKt.setAdapter(tabLayout, cvTabLayoutAdapter);
        ViewPager viewPager = this.o;
        if (viewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        TabPagerAdapter tabPagerAdapter = this.pagerAdapter;
        if (tabPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        }
        viewPager.setAdapter(tabPagerAdapter);
        ViewPager viewPager2 = this.o;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        TabLayout tabLayout2 = this.n;
        if (tabLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        viewPager2.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout2));
        TabLayout tabLayout3 = this.n;
        if (tabLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        ViewPager viewPager3 = this.o;
        if (viewPager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        tabLayout3.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new TabLayout.ViewPagerOnTabSelectedListener(viewPager3));
        ExpressCvViewModel expressCvViewModel = this.viewModel;
        if (expressCvViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        expressCvViewModel.getProgressChanges().observe(this, new h0(0, this));
        ExpressCvViewModel expressCvViewModel2 = this.viewModel;
        if (expressCvViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        expressCvViewModel2.getCvSuccessfullyPostedEvents().observe(this, new a2.a.a.p0.a(this));
        ExpressCvViewModel expressCvViewModel3 = this.viewModel;
        if (expressCvViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        expressCvViewModel3.getMessageEvents().observe(this, new a2.a.a.p0.b(this));
        ExpressCvViewModel expressCvViewModel4 = this.viewModel;
        if (expressCvViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        expressCvViewModel4.getActivateProgressChanges().observe(this, new h0(1, this));
        ExpressCvViewModel expressCvViewModel5 = this.viewModel;
        if (expressCvViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        expressCvViewModel5.getTabsVisibilityChanges().observe(this, new a2.a.a.p0.c(this));
        ExpressCvViewModel expressCvViewModel6 = this.viewModel;
        if (expressCvViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        expressCvViewModel6.getDataChanges().observe(this, new a2.a.a.p0.d(this));
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        ExpressCvViewModel expressCvViewModel = this.viewModel;
        if (expressCvViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        expressCvViewModel.getStartActivityEvents().observe(this, this.q);
        ExpressCvViewModel expressCvViewModel2 = this.viewModel;
        if (expressCvViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        expressCvViewModel2.getStartActivityForResultEvents().observe(this, this.s);
        ExpressCvViewModel expressCvViewModel3 = this.viewModel;
        if (expressCvViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        expressCvViewModel3.getPhoneCallEvents().observe(this, this.r);
        ExpressCvViewModel expressCvViewModel4 = this.viewModel;
        if (expressCvViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        expressCvViewModel4.getShowDialogEvents().observe(this, this.t);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        ExpressCvViewModel expressCvViewModel = this.viewModel;
        if (expressCvViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        expressCvViewModel.getStartActivityEvents().removeObserver(this.q);
        ExpressCvViewModel expressCvViewModel2 = this.viewModel;
        if (expressCvViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        expressCvViewModel2.getStartActivityForResultEvents().removeObserver(this.s);
        ExpressCvViewModel expressCvViewModel3 = this.viewModel;
        if (expressCvViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        expressCvViewModel3.getPhoneCallEvents().removeObserver(this.r);
        ExpressCvViewModel expressCvViewModel4 = this.viewModel;
        if (expressCvViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        expressCvViewModel4.getShowDialogEvents().removeObserver(this.t);
        super.onStop();
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public void setComponent(@NotNull ExpressCvComponent expressCvComponent) {
        Intrinsics.checkNotNullParameter(expressCvComponent, "<set-?>");
        this.component = expressCvComponent;
    }

    public final void setDialogRouter(@NotNull DialogRouter dialogRouter2) {
        Intrinsics.checkNotNullParameter(dialogRouter2, "<set-?>");
        this.dialogRouter = dialogRouter2;
    }

    public final void setLayoutAdapter(@NotNull CvTabLayoutAdapter cvTabLayoutAdapter) {
        Intrinsics.checkNotNullParameter(cvTabLayoutAdapter, "<set-?>");
        this.layoutAdapter = cvTabLayoutAdapter;
    }

    public final void setPagerAdapter(@NotNull TabPagerAdapter tabPagerAdapter) {
        Intrinsics.checkNotNullParameter(tabPagerAdapter, "<set-?>");
        this.pagerAdapter = tabPagerAdapter;
    }

    public final void setTabsDataProvider(@NotNull TabsDataProvider<CvTabItem> tabsDataProvider2) {
        Intrinsics.checkNotNullParameter(tabsDataProvider2, "<set-?>");
        this.tabsDataProvider = tabsDataProvider2;
    }

    public final void setViewModel(@NotNull ExpressCvViewModel expressCvViewModel) {
        Intrinsics.checkNotNullParameter(expressCvViewModel, "<set-?>");
        this.viewModel = expressCvViewModel;
    }

    @Override // com.avito.android.ComponentProvider
    @NotNull
    public ExpressCvComponent getComponent() {
        ExpressCvComponent expressCvComponent = this.component;
        if (expressCvComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("component");
        }
        return expressCvComponent;
    }
}
