package com.avito.android.serp.adapter.advert_xl;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.async_phone.AsyncPhonePresenter;
import com.avito.android.date_time_formatter.DateTimeFormatter;
import com.avito.android.serp.adapter.onboarding.SerpOnboardingHandler;
import com.avito.android.util.Kundle;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertXlItemPresenterImpl_Factory implements Factory<AdvertXlItemPresenterImpl> {
    public final Provider<AdvertXlItemListener> a;
    public final Provider<DateTimeFormatter> b;
    public final Provider<AdvertXlDimensionsProvider> c;
    public final Provider<AsyncPhonePresenter> d;
    public final Provider<Analytics> e;
    public final Provider<Features> f;
    public final Provider<SerpOnboardingHandler> g;
    public final Provider<Kundle> h;

    public AdvertXlItemPresenterImpl_Factory(Provider<AdvertXlItemListener> provider, Provider<DateTimeFormatter> provider2, Provider<AdvertXlDimensionsProvider> provider3, Provider<AsyncPhonePresenter> provider4, Provider<Analytics> provider5, Provider<Features> provider6, Provider<SerpOnboardingHandler> provider7, Provider<Kundle> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static AdvertXlItemPresenterImpl_Factory create(Provider<AdvertXlItemListener> provider, Provider<DateTimeFormatter> provider2, Provider<AdvertXlDimensionsProvider> provider3, Provider<AsyncPhonePresenter> provider4, Provider<Analytics> provider5, Provider<Features> provider6, Provider<SerpOnboardingHandler> provider7, Provider<Kundle> provider8) {
        return new AdvertXlItemPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static AdvertXlItemPresenterImpl newInstance(Lazy<AdvertXlItemListener> lazy, DateTimeFormatter dateTimeFormatter, AdvertXlDimensionsProvider advertXlDimensionsProvider, AsyncPhonePresenter asyncPhonePresenter, Analytics analytics, Features features, SerpOnboardingHandler serpOnboardingHandler, Kundle kundle) {
        return new AdvertXlItemPresenterImpl(lazy, dateTimeFormatter, advertXlDimensionsProvider, asyncPhonePresenter, analytics, features, serpOnboardingHandler, kundle);
    }

    @Override // javax.inject.Provider
    public AdvertXlItemPresenterImpl get() {
        return newInstance(DoubleCheck.lazy(this.a), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
