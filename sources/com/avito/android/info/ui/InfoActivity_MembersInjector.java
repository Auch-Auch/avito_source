package com.avito.android.info.ui;

import com.avito.android.analytics.Analytics;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class InfoActivity_MembersInjector implements MembersInjector<InfoActivity> {
    public final Provider<InfoPresenter> a;
    public final Provider<Analytics> b;

    public InfoActivity_MembersInjector(Provider<InfoPresenter> provider, Provider<Analytics> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MembersInjector<InfoActivity> create(Provider<InfoPresenter> provider, Provider<Analytics> provider2) {
        return new InfoActivity_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.avito.android.info.ui.InfoActivity.analytics")
    public static void injectAnalytics(InfoActivity infoActivity, Analytics analytics) {
        infoActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.info.ui.InfoActivity.infoPresenter")
    public static void injectInfoPresenter(InfoActivity infoActivity, InfoPresenter infoPresenter) {
        infoActivity.infoPresenter = infoPresenter;
    }

    public void injectMembers(InfoActivity infoActivity) {
        injectInfoPresenter(infoActivity, this.a.get());
        injectAnalytics(infoActivity, this.b.get());
    }
}
