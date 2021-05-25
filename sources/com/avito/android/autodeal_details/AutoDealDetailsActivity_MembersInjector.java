package com.avito.android.autodeal_details;

import com.avito.android.analytics.Analytics;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.SchedulersFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class AutoDealDetailsActivity_MembersInjector implements MembersInjector<AutoDealDetailsActivity> {
    public final Provider<AutoDealDetailsViewModel> a;
    public final Provider<Analytics> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<AutoDealDetailsJSInterface> d;
    public final Provider<AutoDealDetailsInterceptor> e;
    public final Provider<ImplicitIntentFactory> f;

    public AutoDealDetailsActivity_MembersInjector(Provider<AutoDealDetailsViewModel> provider, Provider<Analytics> provider2, Provider<SchedulersFactory> provider3, Provider<AutoDealDetailsJSInterface> provider4, Provider<AutoDealDetailsInterceptor> provider5, Provider<ImplicitIntentFactory> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static MembersInjector<AutoDealDetailsActivity> create(Provider<AutoDealDetailsViewModel> provider, Provider<Analytics> provider2, Provider<SchedulersFactory> provider3, Provider<AutoDealDetailsJSInterface> provider4, Provider<AutoDealDetailsInterceptor> provider5, Provider<ImplicitIntentFactory> provider6) {
        return new AutoDealDetailsActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @InjectedFieldSignature("com.avito.android.autodeal_details.AutoDealDetailsActivity.analytics")
    public static void injectAnalytics(AutoDealDetailsActivity autoDealDetailsActivity, Analytics analytics) {
        autoDealDetailsActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.autodeal_details.AutoDealDetailsActivity.autoDealDetailsInterceptor")
    public static void injectAutoDealDetailsInterceptor(AutoDealDetailsActivity autoDealDetailsActivity, AutoDealDetailsInterceptor autoDealDetailsInterceptor) {
        autoDealDetailsActivity.autoDealDetailsInterceptor = autoDealDetailsInterceptor;
    }

    @InjectedFieldSignature("com.avito.android.autodeal_details.AutoDealDetailsActivity.implicitIntentFactory")
    public static void injectImplicitIntentFactory(AutoDealDetailsActivity autoDealDetailsActivity, ImplicitIntentFactory implicitIntentFactory) {
        autoDealDetailsActivity.implicitIntentFactory = implicitIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.autodeal_details.AutoDealDetailsActivity.jsInterface")
    public static void injectJsInterface(AutoDealDetailsActivity autoDealDetailsActivity, AutoDealDetailsJSInterface autoDealDetailsJSInterface) {
        autoDealDetailsActivity.jsInterface = autoDealDetailsJSInterface;
    }

    @InjectedFieldSignature("com.avito.android.autodeal_details.AutoDealDetailsActivity.schedulers")
    public static void injectSchedulers(AutoDealDetailsActivity autoDealDetailsActivity, SchedulersFactory schedulersFactory) {
        autoDealDetailsActivity.schedulers = schedulersFactory;
    }

    @InjectedFieldSignature("com.avito.android.autodeal_details.AutoDealDetailsActivity.viewModel")
    public static void injectViewModel(AutoDealDetailsActivity autoDealDetailsActivity, AutoDealDetailsViewModel autoDealDetailsViewModel) {
        autoDealDetailsActivity.viewModel = autoDealDetailsViewModel;
    }

    public void injectMembers(AutoDealDetailsActivity autoDealDetailsActivity) {
        injectViewModel(autoDealDetailsActivity, this.a.get());
        injectAnalytics(autoDealDetailsActivity, this.b.get());
        injectSchedulers(autoDealDetailsActivity, this.c.get());
        injectJsInterface(autoDealDetailsActivity, this.d.get());
        injectAutoDealDetailsInterceptor(autoDealDetailsActivity, this.e.get());
        injectImplicitIntentFactory(autoDealDetailsActivity, this.f.get());
    }
}
