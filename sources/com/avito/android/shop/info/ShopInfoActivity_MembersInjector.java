package com.avito.android.shop.info;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class ShopInfoActivity_MembersInjector implements MembersInjector<ShopInfoActivity> {
    public final Provider<ShopInfoPresenter> a;
    public final Provider<Analytics> b;
    public final Provider<ShopInfoInteractor> c;
    public final Provider<ActivityIntentFactory> d;

    public ShopInfoActivity_MembersInjector(Provider<ShopInfoPresenter> provider, Provider<Analytics> provider2, Provider<ShopInfoInteractor> provider3, Provider<ActivityIntentFactory> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<ShopInfoActivity> create(Provider<ShopInfoPresenter> provider, Provider<Analytics> provider2, Provider<ShopInfoInteractor> provider3, Provider<ActivityIntentFactory> provider4) {
        return new ShopInfoActivity_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.shop.info.ShopInfoActivity.activityIntentFactory")
    public static void injectActivityIntentFactory(ShopInfoActivity shopInfoActivity, ActivityIntentFactory activityIntentFactory) {
        shopInfoActivity.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.shop.info.ShopInfoActivity.analytics")
    public static void injectAnalytics(ShopInfoActivity shopInfoActivity, Analytics analytics) {
        shopInfoActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.shop.info.ShopInfoActivity.interactor")
    public static void injectInteractor(ShopInfoActivity shopInfoActivity, ShopInfoInteractor shopInfoInteractor) {
        shopInfoActivity.interactor = shopInfoInteractor;
    }

    @InjectedFieldSignature("com.avito.android.shop.info.ShopInfoActivity.presenter")
    public static void injectPresenter(ShopInfoActivity shopInfoActivity, ShopInfoPresenter shopInfoPresenter) {
        shopInfoActivity.presenter = shopInfoPresenter;
    }

    public void injectMembers(ShopInfoActivity shopInfoActivity) {
        injectPresenter(shopInfoActivity, this.a.get());
        injectAnalytics(shopInfoActivity, this.b.get());
        injectInteractor(shopInfoActivity, this.c.get());
        injectActivityIntentFactory(shopInfoActivity, this.d.get());
    }
}
