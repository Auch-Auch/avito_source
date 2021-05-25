package com.avito.android.public_profile.ui;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.public_profile.remote.model.DefaultPublicUserProfile;
import com.avito.android.public_profile.remote.model.ProfileAdvertsResult;
import com.avito.android.public_profile.tracker.PublicProfileTracker;
import com.avito.android.ui.adapter.tab.BaseTabItem;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.Factory;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
import kotlin.Unit;
public final class PublicProfilePresenterImpl_Factory implements Factory<PublicProfilePresenterImpl> {
    public final Provider<String> a;
    public final Provider<String> b;
    public final Provider<DefaultPublicUserProfile> c;
    public final Provider<PublicProfileInteractor> d;
    public final Provider<SchedulersFactory3> e;
    public final Provider<TabsDataProvider<BaseTabItem>> f;
    public final Provider<ErrorHelper> g;
    public final Provider<Analytics> h;
    public final Provider<PublicProfileResourceProvider> i;
    public final Provider<Kundle> j;
    public final Provider<PublicProfileTracker> k;
    public final Provider<TreeClickStreamParent> l;
    public final Provider<SubscriptionsPresenter> m;
    public final Provider<CompositeSnackbarPresenter> n;
    public final Provider<Features> o;
    public final Provider<PublishRelay<ProfileAdvertsResult>> p;
    public final Provider<Consumer<Unit>> q;

    public PublicProfilePresenterImpl_Factory(Provider<String> provider, Provider<String> provider2, Provider<DefaultPublicUserProfile> provider3, Provider<PublicProfileInteractor> provider4, Provider<SchedulersFactory3> provider5, Provider<TabsDataProvider<BaseTabItem>> provider6, Provider<ErrorHelper> provider7, Provider<Analytics> provider8, Provider<PublicProfileResourceProvider> provider9, Provider<Kundle> provider10, Provider<PublicProfileTracker> provider11, Provider<TreeClickStreamParent> provider12, Provider<SubscriptionsPresenter> provider13, Provider<CompositeSnackbarPresenter> provider14, Provider<Features> provider15, Provider<PublishRelay<ProfileAdvertsResult>> provider16, Provider<Consumer<Unit>> provider17) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
        this.k = provider11;
        this.l = provider12;
        this.m = provider13;
        this.n = provider14;
        this.o = provider15;
        this.p = provider16;
        this.q = provider17;
    }

    public static PublicProfilePresenterImpl_Factory create(Provider<String> provider, Provider<String> provider2, Provider<DefaultPublicUserProfile> provider3, Provider<PublicProfileInteractor> provider4, Provider<SchedulersFactory3> provider5, Provider<TabsDataProvider<BaseTabItem>> provider6, Provider<ErrorHelper> provider7, Provider<Analytics> provider8, Provider<PublicProfileResourceProvider> provider9, Provider<Kundle> provider10, Provider<PublicProfileTracker> provider11, Provider<TreeClickStreamParent> provider12, Provider<SubscriptionsPresenter> provider13, Provider<CompositeSnackbarPresenter> provider14, Provider<Features> provider15, Provider<PublishRelay<ProfileAdvertsResult>> provider16, Provider<Consumer<Unit>> provider17) {
        return new PublicProfilePresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17);
    }

    public static PublicProfilePresenterImpl newInstance(String str, String str2, DefaultPublicUserProfile defaultPublicUserProfile, PublicProfileInteractor publicProfileInteractor, SchedulersFactory3 schedulersFactory3, TabsDataProvider<BaseTabItem> tabsDataProvider, ErrorHelper errorHelper, Analytics analytics, PublicProfileResourceProvider publicProfileResourceProvider, Kundle kundle, PublicProfileTracker publicProfileTracker, TreeClickStreamParent treeClickStreamParent, SubscriptionsPresenter subscriptionsPresenter, CompositeSnackbarPresenter compositeSnackbarPresenter, Features features, PublishRelay<ProfileAdvertsResult> publishRelay, Consumer<Unit> consumer) {
        return new PublicProfilePresenterImpl(str, str2, defaultPublicUserProfile, publicProfileInteractor, schedulersFactory3, tabsDataProvider, errorHelper, analytics, publicProfileResourceProvider, kundle, publicProfileTracker, treeClickStreamParent, subscriptionsPresenter, compositeSnackbarPresenter, features, publishRelay, consumer);
    }

    @Override // javax.inject.Provider
    public PublicProfilePresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get(), this.m.get(), this.n.get(), this.o.get(), this.p.get(), this.q.get());
    }
}
