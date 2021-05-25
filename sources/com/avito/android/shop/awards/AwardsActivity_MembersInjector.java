package com.avito.android.shop.awards;

import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class AwardsActivity_MembersInjector implements MembersInjector<AwardsActivity> {
    public final Provider<AwardsPresenter> a;
    public final Provider<Analytics> b;
    public final Provider<AwardsInteractor> c;
    public final Provider<SimpleRecyclerAdapter> d;
    public final Provider<DeepLinkIntentFactory> e;

    public AwardsActivity_MembersInjector(Provider<AwardsPresenter> provider, Provider<Analytics> provider2, Provider<AwardsInteractor> provider3, Provider<SimpleRecyclerAdapter> provider4, Provider<DeepLinkIntentFactory> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static MembersInjector<AwardsActivity> create(Provider<AwardsPresenter> provider, Provider<Analytics> provider2, Provider<AwardsInteractor> provider3, Provider<SimpleRecyclerAdapter> provider4, Provider<DeepLinkIntentFactory> provider5) {
        return new AwardsActivity_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @InjectedFieldSignature("com.avito.android.shop.awards.AwardsActivity.adapter")
    public static void injectAdapter(AwardsActivity awardsActivity, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        awardsActivity.adapter = simpleRecyclerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.shop.awards.AwardsActivity.analytics")
    public static void injectAnalytics(AwardsActivity awardsActivity, Analytics analytics) {
        awardsActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.shop.awards.AwardsActivity.intentFactory")
    public static void injectIntentFactory(AwardsActivity awardsActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        awardsActivity.intentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.shop.awards.AwardsActivity.interactor")
    public static void injectInteractor(AwardsActivity awardsActivity, AwardsInteractor awardsInteractor) {
        awardsActivity.interactor = awardsInteractor;
    }

    @InjectedFieldSignature("com.avito.android.shop.awards.AwardsActivity.presenter")
    public static void injectPresenter(AwardsActivity awardsActivity, AwardsPresenter awardsPresenter) {
        awardsActivity.presenter = awardsPresenter;
    }

    public void injectMembers(AwardsActivity awardsActivity) {
        injectPresenter(awardsActivity, this.a.get());
        injectAnalytics(awardsActivity, this.b.get());
        injectInteractor(awardsActivity, this.c.get());
        injectAdapter(awardsActivity, this.d.get());
        injectIntentFactory(awardsActivity, this.e.get());
    }
}
