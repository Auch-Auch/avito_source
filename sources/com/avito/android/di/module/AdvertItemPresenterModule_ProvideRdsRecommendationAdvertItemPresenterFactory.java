package com.avito.android.di.module;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.serp.adapter.AdvertItemListener;
import com.avito.android.serp.adapter.RdsAdvertItemPresenter;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AdvertItemPresenterModule_ProvideRdsRecommendationAdvertItemPresenterFactory implements Factory<RdsAdvertItemPresenter> {
    public final Provider<AdvertItemListener> a;
    public final Provider<Analytics> b;
    public final Provider<Features> c;

    public AdvertItemPresenterModule_ProvideRdsRecommendationAdvertItemPresenterFactory(Provider<AdvertItemListener> provider, Provider<Analytics> provider2, Provider<Features> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static AdvertItemPresenterModule_ProvideRdsRecommendationAdvertItemPresenterFactory create(Provider<AdvertItemListener> provider, Provider<Analytics> provider2, Provider<Features> provider3) {
        return new AdvertItemPresenterModule_ProvideRdsRecommendationAdvertItemPresenterFactory(provider, provider2, provider3);
    }

    public static RdsAdvertItemPresenter provideRdsRecommendationAdvertItemPresenter(Lazy<AdvertItemListener> lazy, Analytics analytics, Features features) {
        return (RdsAdvertItemPresenter) Preconditions.checkNotNullFromProvides(AdvertItemPresenterModule.provideRdsRecommendationAdvertItemPresenter(lazy, analytics, features));
    }

    @Override // javax.inject.Provider
    public RdsAdvertItemPresenter get() {
        return provideRdsRecommendationAdvertItemPresenter(DoubleCheck.lazy(this.a), this.b.get(), this.c.get());
    }
}
