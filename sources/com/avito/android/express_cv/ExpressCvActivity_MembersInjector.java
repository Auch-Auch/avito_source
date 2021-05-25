package com.avito.android.express_cv;

import com.avito.android.analytics.Analytics;
import com.avito.android.express_cv.tabs.CvTabItem;
import com.avito.android.express_cv.tabs.CvTabLayoutAdapter;
import com.avito.android.express_cv.tabs.TabPagerAdapter;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.avito.android.util.DialogRouter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class ExpressCvActivity_MembersInjector implements MembersInjector<ExpressCvActivity> {
    public final Provider<ExpressCvViewModel> a;
    public final Provider<Analytics> b;
    public final Provider<TabsDataProvider<CvTabItem>> c;
    public final Provider<CvTabLayoutAdapter> d;
    public final Provider<TabPagerAdapter> e;
    public final Provider<DialogRouter> f;

    public ExpressCvActivity_MembersInjector(Provider<ExpressCvViewModel> provider, Provider<Analytics> provider2, Provider<TabsDataProvider<CvTabItem>> provider3, Provider<CvTabLayoutAdapter> provider4, Provider<TabPagerAdapter> provider5, Provider<DialogRouter> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static MembersInjector<ExpressCvActivity> create(Provider<ExpressCvViewModel> provider, Provider<Analytics> provider2, Provider<TabsDataProvider<CvTabItem>> provider3, Provider<CvTabLayoutAdapter> provider4, Provider<TabPagerAdapter> provider5, Provider<DialogRouter> provider6) {
        return new ExpressCvActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @InjectedFieldSignature("com.avito.android.express_cv.ExpressCvActivity.analytics")
    public static void injectAnalytics(ExpressCvActivity expressCvActivity, Analytics analytics) {
        expressCvActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.express_cv.ExpressCvActivity.dialogRouter")
    public static void injectDialogRouter(ExpressCvActivity expressCvActivity, DialogRouter dialogRouter) {
        expressCvActivity.dialogRouter = dialogRouter;
    }

    @InjectedFieldSignature("com.avito.android.express_cv.ExpressCvActivity.layoutAdapter")
    public static void injectLayoutAdapter(ExpressCvActivity expressCvActivity, CvTabLayoutAdapter cvTabLayoutAdapter) {
        expressCvActivity.layoutAdapter = cvTabLayoutAdapter;
    }

    @InjectedFieldSignature("com.avito.android.express_cv.ExpressCvActivity.pagerAdapter")
    public static void injectPagerAdapter(ExpressCvActivity expressCvActivity, TabPagerAdapter tabPagerAdapter) {
        expressCvActivity.pagerAdapter = tabPagerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.express_cv.ExpressCvActivity.tabsDataProvider")
    public static void injectTabsDataProvider(ExpressCvActivity expressCvActivity, TabsDataProvider<CvTabItem> tabsDataProvider) {
        expressCvActivity.tabsDataProvider = tabsDataProvider;
    }

    @InjectedFieldSignature("com.avito.android.express_cv.ExpressCvActivity.viewModel")
    public static void injectViewModel(ExpressCvActivity expressCvActivity, ExpressCvViewModel expressCvViewModel) {
        expressCvActivity.viewModel = expressCvViewModel;
    }

    public void injectMembers(ExpressCvActivity expressCvActivity) {
        injectViewModel(expressCvActivity, this.a.get());
        injectAnalytics(expressCvActivity, this.b.get());
        injectTabsDataProvider(expressCvActivity, this.c.get());
        injectLayoutAdapter(expressCvActivity, this.d.get());
        injectPagerAdapter(expressCvActivity, this.e.get());
        injectDialogRouter(expressCvActivity, this.f.get());
    }
}
