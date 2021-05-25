package com.avito.android.social_management;

import com.avito.android.analytics.Analytics;
import com.avito.android.dialog.DialogPresenter;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.social.SignInManager;
import com.avito.android.social.SocialTypeToStringMapper;
import com.avito.android.social_management.adapter.SocialItem;
import com.avito.android.social_management.adapter.notification.SocialNotificationAction;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.internal.Factory;
import java.util.List;
import javax.inject.Provider;
public final class SocialManagementPresenterImpl_Factory implements Factory<SocialManagementPresenterImpl> {
    public final Provider<SocialManagementInteractor> a;
    public final Provider<List<SignInManager>> b;
    public final Provider<DataAwareAdapterPresenter> c;
    public final Provider<PublishRelay<SocialItem>> d;
    public final Provider<PublishRelay<SocialNotificationAction>> e;
    public final Provider<ErrorHelper> f;
    public final Provider<DialogPresenter> g;
    public final Provider<SocialManagementResourceProvider> h;
    public final Provider<Analytics> i;
    public final Provider<SchedulersFactory> j;
    public final Provider<SocialTypeToStringMapper> k;
    public final Provider<Kundle> l;

    public SocialManagementPresenterImpl_Factory(Provider<SocialManagementInteractor> provider, Provider<List<SignInManager>> provider2, Provider<DataAwareAdapterPresenter> provider3, Provider<PublishRelay<SocialItem>> provider4, Provider<PublishRelay<SocialNotificationAction>> provider5, Provider<ErrorHelper> provider6, Provider<DialogPresenter> provider7, Provider<SocialManagementResourceProvider> provider8, Provider<Analytics> provider9, Provider<SchedulersFactory> provider10, Provider<SocialTypeToStringMapper> provider11, Provider<Kundle> provider12) {
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
    }

    public static SocialManagementPresenterImpl_Factory create(Provider<SocialManagementInteractor> provider, Provider<List<SignInManager>> provider2, Provider<DataAwareAdapterPresenter> provider3, Provider<PublishRelay<SocialItem>> provider4, Provider<PublishRelay<SocialNotificationAction>> provider5, Provider<ErrorHelper> provider6, Provider<DialogPresenter> provider7, Provider<SocialManagementResourceProvider> provider8, Provider<Analytics> provider9, Provider<SchedulersFactory> provider10, Provider<SocialTypeToStringMapper> provider11, Provider<Kundle> provider12) {
        return new SocialManagementPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12);
    }

    public static SocialManagementPresenterImpl newInstance(SocialManagementInteractor socialManagementInteractor, List<SignInManager> list, DataAwareAdapterPresenter dataAwareAdapterPresenter, PublishRelay<SocialItem> publishRelay, PublishRelay<SocialNotificationAction> publishRelay2, ErrorHelper errorHelper, DialogPresenter dialogPresenter, SocialManagementResourceProvider socialManagementResourceProvider, Analytics analytics, SchedulersFactory schedulersFactory, SocialTypeToStringMapper socialTypeToStringMapper, Kundle kundle) {
        return new SocialManagementPresenterImpl(socialManagementInteractor, list, dataAwareAdapterPresenter, publishRelay, publishRelay2, errorHelper, dialogPresenter, socialManagementResourceProvider, analytics, schedulersFactory, socialTypeToStringMapper, kundle);
    }

    @Override // javax.inject.Provider
    public SocialManagementPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get());
    }
}
