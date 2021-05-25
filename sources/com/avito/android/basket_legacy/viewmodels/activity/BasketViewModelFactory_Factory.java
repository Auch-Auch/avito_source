package com.avito.android.basket_legacy.viewmodels.activity;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.basket_legacy.fees.BasketInteractor;
import com.avito.android.basket_legacy.utils.VasType;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class BasketViewModelFactory_Factory implements Factory<BasketViewModelFactory> {
    public final Provider<VasType> a;
    public final Provider<BasketInteractor> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<ActivityIntentFactory> d;
    public final Provider<DeepLinkIntentFactory> e;

    public BasketViewModelFactory_Factory(Provider<VasType> provider, Provider<BasketInteractor> provider2, Provider<SchedulersFactory> provider3, Provider<ActivityIntentFactory> provider4, Provider<DeepLinkIntentFactory> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static BasketViewModelFactory_Factory create(Provider<VasType> provider, Provider<BasketInteractor> provider2, Provider<SchedulersFactory> provider3, Provider<ActivityIntentFactory> provider4, Provider<DeepLinkIntentFactory> provider5) {
        return new BasketViewModelFactory_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static BasketViewModelFactory newInstance(VasType vasType, BasketInteractor basketInteractor, SchedulersFactory schedulersFactory, ActivityIntentFactory activityIntentFactory, DeepLinkIntentFactory deepLinkIntentFactory) {
        return new BasketViewModelFactory(vasType, basketInteractor, schedulersFactory, activityIntentFactory, deepLinkIntentFactory);
    }

    @Override // javax.inject.Provider
    public BasketViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
