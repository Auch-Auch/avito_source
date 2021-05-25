package com.avito.android.serp.adapter.rich_snippets.regular;

import com.avito.android.Features;
import com.avito.android.ab_tests.configs.SellerInfoInRichSnippetTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.async_phone.AsyncPhonePresenter;
import com.avito.android.date_time_formatter.DateTimeFormatter;
import com.avito.android.serp.adapter.onboarding.SerpOnboardingHandler;
import com.avito.android.serp.adapter.rich_snippets.AdvertRichItemListener;
import com.avito.android.serp.adapter.rich_snippets.AdvertSellerConverter;
import com.avito.android.util.Kundle;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertRichItemPresenterImpl_Factory implements Factory<AdvertRichItemPresenterImpl> {
    public final Provider<AdvertRichItemListener> a;
    public final Provider<DateTimeFormatter> b;
    public final Provider<Analytics> c;
    public final Provider<Kundle> d;
    public final Provider<AdvertSellerConverter> e;
    public final Provider<AsyncPhonePresenter> f;
    public final Provider<SingleManuallyExposedAbTestGroup<SellerInfoInRichSnippetTestGroup>> g;
    public final Provider<Features> h;
    public final Provider<SerpOnboardingHandler> i;

    public AdvertRichItemPresenterImpl_Factory(Provider<AdvertRichItemListener> provider, Provider<DateTimeFormatter> provider2, Provider<Analytics> provider3, Provider<Kundle> provider4, Provider<AdvertSellerConverter> provider5, Provider<AsyncPhonePresenter> provider6, Provider<SingleManuallyExposedAbTestGroup<SellerInfoInRichSnippetTestGroup>> provider7, Provider<Features> provider8, Provider<SerpOnboardingHandler> provider9) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
    }

    public static AdvertRichItemPresenterImpl_Factory create(Provider<AdvertRichItemListener> provider, Provider<DateTimeFormatter> provider2, Provider<Analytics> provider3, Provider<Kundle> provider4, Provider<AdvertSellerConverter> provider5, Provider<AsyncPhonePresenter> provider6, Provider<SingleManuallyExposedAbTestGroup<SellerInfoInRichSnippetTestGroup>> provider7, Provider<Features> provider8, Provider<SerpOnboardingHandler> provider9) {
        return new AdvertRichItemPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static AdvertRichItemPresenterImpl newInstance(Lazy<AdvertRichItemListener> lazy, DateTimeFormatter dateTimeFormatter, Analytics analytics, Kundle kundle, AdvertSellerConverter advertSellerConverter, AsyncPhonePresenter asyncPhonePresenter, SingleManuallyExposedAbTestGroup<SellerInfoInRichSnippetTestGroup> singleManuallyExposedAbTestGroup, Features features, SerpOnboardingHandler serpOnboardingHandler) {
        return new AdvertRichItemPresenterImpl(lazy, dateTimeFormatter, analytics, kundle, advertSellerConverter, asyncPhonePresenter, singleManuallyExposedAbTestGroup, features, serpOnboardingHandler);
    }

    @Override // javax.inject.Provider
    public AdvertRichItemPresenterImpl get() {
        return newInstance(DoubleCheck.lazy(this.a), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get());
    }
}
