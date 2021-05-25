package com.avito.android.di.module;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.serp.adapter.AdvertItemListener;
import com.avito.android.serp.adapter.AdvertListItemPresenter;
import com.avito.android.serp.adapter.onboarding.SerpOnboardingHandler;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AdvertItemPresenterModule_ProvideAdvertListItemPresenterFactory implements Factory<AdvertListItemPresenter> {
    public final Provider<AdvertItemListener> a;
    public final Provider<Analytics> b;
    public final Provider<Features> c;
    public final Provider<SerpOnboardingHandler> d;

    public AdvertItemPresenterModule_ProvideAdvertListItemPresenterFactory(Provider<AdvertItemListener> provider, Provider<Analytics> provider2, Provider<Features> provider3, Provider<SerpOnboardingHandler> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static AdvertItemPresenterModule_ProvideAdvertListItemPresenterFactory create(Provider<AdvertItemListener> provider, Provider<Analytics> provider2, Provider<Features> provider3, Provider<SerpOnboardingHandler> provider4) {
        return new AdvertItemPresenterModule_ProvideAdvertListItemPresenterFactory(provider, provider2, provider3, provider4);
    }

    public static AdvertListItemPresenter provideAdvertListItemPresenter(Lazy<AdvertItemListener> lazy, Analytics analytics, Features features, SerpOnboardingHandler serpOnboardingHandler) {
        return (AdvertListItemPresenter) Preconditions.checkNotNullFromProvides(AdvertItemPresenterModule.provideAdvertListItemPresenter(lazy, analytics, features, serpOnboardingHandler));
    }

    @Override // javax.inject.Provider
    public AdvertListItemPresenter get() {
        return provideAdvertListItemPresenter(DoubleCheck.lazy(this.a), this.b.get(), this.c.get(), this.d.get());
    }
}
