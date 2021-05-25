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
import com.avito.android.serp.adapter.rich_snippets.RichSnippetsResourceProvider;
import com.avito.android.util.Kundle;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertXlRichItemPresenterImpl_Factory implements Factory<AdvertXlRichItemPresenterImpl> {
    public final Provider<AdvertRichItemListener> a;
    public final Provider<DateTimeFormatter> b;
    public final Provider<RichSnippetsResourceProvider> c;
    public final Provider<Analytics> d;
    public final Provider<AdvertSellerConverter> e;
    public final Provider<AsyncPhonePresenter> f;
    public final Provider<Features> g;
    public final Provider<SerpOnboardingHandler> h;
    public final Provider<SingleManuallyExposedAbTestGroup<SellerInfoInRichSnippetTestGroup>> i;
    public final Provider<Kundle> j;

    public AdvertXlRichItemPresenterImpl_Factory(Provider<AdvertRichItemListener> provider, Provider<DateTimeFormatter> provider2, Provider<RichSnippetsResourceProvider> provider3, Provider<Analytics> provider4, Provider<AdvertSellerConverter> provider5, Provider<AsyncPhonePresenter> provider6, Provider<Features> provider7, Provider<SerpOnboardingHandler> provider8, Provider<SingleManuallyExposedAbTestGroup<SellerInfoInRichSnippetTestGroup>> provider9, Provider<Kundle> provider10) {
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
    }

    public static AdvertXlRichItemPresenterImpl_Factory create(Provider<AdvertRichItemListener> provider, Provider<DateTimeFormatter> provider2, Provider<RichSnippetsResourceProvider> provider3, Provider<Analytics> provider4, Provider<AdvertSellerConverter> provider5, Provider<AsyncPhonePresenter> provider6, Provider<Features> provider7, Provider<SerpOnboardingHandler> provider8, Provider<SingleManuallyExposedAbTestGroup<SellerInfoInRichSnippetTestGroup>> provider9, Provider<Kundle> provider10) {
        return new AdvertXlRichItemPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static AdvertXlRichItemPresenterImpl newInstance(Lazy<AdvertRichItemListener> lazy, DateTimeFormatter dateTimeFormatter, RichSnippetsResourceProvider richSnippetsResourceProvider, Analytics analytics, AdvertSellerConverter advertSellerConverter, AsyncPhonePresenter asyncPhonePresenter, Features features, SerpOnboardingHandler serpOnboardingHandler, SingleManuallyExposedAbTestGroup<SellerInfoInRichSnippetTestGroup> singleManuallyExposedAbTestGroup, Kundle kundle) {
        return new AdvertXlRichItemPresenterImpl(lazy, dateTimeFormatter, richSnippetsResourceProvider, analytics, advertSellerConverter, asyncPhonePresenter, features, serpOnboardingHandler, singleManuallyExposedAbTestGroup, kundle);
    }

    @Override // javax.inject.Provider
    public AdvertXlRichItemPresenterImpl get() {
        return newInstance(DoubleCheck.lazy(this.a), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get());
    }
}
