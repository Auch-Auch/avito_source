package com.avito.android.di.module;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.serp.adapter.AdvertGridItemPresenter;
import com.avito.android.serp.adapter.AdvertItemListener;
import com.avito.android.serp.adapter.onboarding.SerpOnboardingHandler;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AdvertItemPresenterModule_ProvideAdvertGridItemPresenterFactory implements Factory<AdvertGridItemPresenter> {
    public final Provider<AdvertItemListener> a;
    public final Provider<Analytics> b;
    public final Provider<Features> c;
    public final Provider<SerpOnboardingHandler> d;

    public AdvertItemPresenterModule_ProvideAdvertGridItemPresenterFactory(Provider<AdvertItemListener> provider, Provider<Analytics> provider2, Provider<Features> provider3, Provider<SerpOnboardingHandler> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static AdvertItemPresenterModule_ProvideAdvertGridItemPresenterFactory create(Provider<AdvertItemListener> provider, Provider<Analytics> provider2, Provider<Features> provider3, Provider<SerpOnboardingHandler> provider4) {
        return new AdvertItemPresenterModule_ProvideAdvertGridItemPresenterFactory(provider, provider2, provider3, provider4);
    }

    public static AdvertGridItemPresenter provideAdvertGridItemPresenter(Lazy<AdvertItemListener> lazy, Analytics analytics, Features features, SerpOnboardingHandler serpOnboardingHandler) {
        return (AdvertGridItemPresenter) Preconditions.checkNotNullFromProvides(AdvertItemPresenterModule.provideAdvertGridItemPresenter(lazy, analytics, features, serpOnboardingHandler));
    }

    @Override // javax.inject.Provider
    public AdvertGridItemPresenter get() {
        return provideAdvertGridItemPresenter(DoubleCheck.lazy(this.a), this.b.get(), this.c.get(), this.d.get());
    }
}
