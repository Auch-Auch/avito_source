package com.avito.android.serp.adapter.rich_snippets.job;

import com.avito.android.analytics.Analytics;
import com.avito.android.async_phone.AsyncPhonePresenter;
import com.avito.android.date_time_formatter.DateTimeFormatter;
import com.avito.android.serp.adapter.rich_snippets.AdvertRichItemListener;
import com.avito.android.util.Kundle;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertXlRichJobItemPresenterImpl_Factory implements Factory<AdvertXlRichJobItemPresenterImpl> {
    public final Provider<AdvertRichItemListener> a;
    public final Provider<DateTimeFormatter> b;
    public final Provider<AsyncPhonePresenter> c;
    public final Provider<Analytics> d;
    public final Provider<Kundle> e;

    public AdvertXlRichJobItemPresenterImpl_Factory(Provider<AdvertRichItemListener> provider, Provider<DateTimeFormatter> provider2, Provider<AsyncPhonePresenter> provider3, Provider<Analytics> provider4, Provider<Kundle> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static AdvertXlRichJobItemPresenterImpl_Factory create(Provider<AdvertRichItemListener> provider, Provider<DateTimeFormatter> provider2, Provider<AsyncPhonePresenter> provider3, Provider<Analytics> provider4, Provider<Kundle> provider5) {
        return new AdvertXlRichJobItemPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static AdvertXlRichJobItemPresenterImpl newInstance(Lazy<AdvertRichItemListener> lazy, DateTimeFormatter dateTimeFormatter, AsyncPhonePresenter asyncPhonePresenter, Analytics analytics, Kundle kundle) {
        return new AdvertXlRichJobItemPresenterImpl(lazy, dateTimeFormatter, asyncPhonePresenter, analytics, kundle);
    }

    @Override // javax.inject.Provider
    public AdvertXlRichJobItemPresenterImpl get() {
        return newInstance(DoubleCheck.lazy(this.a), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
