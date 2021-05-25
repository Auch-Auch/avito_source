package com.avito.android.serp.adapter.rich_snippets.job;

import com.avito.android.analytics.Analytics;
import com.avito.android.async_phone.AsyncPhonePresenter;
import com.avito.android.date_time_formatter.DateTimeFormatter;
import com.avito.android.serp.adapter.rich_snippets.AdvertRichItemListener;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertRichJobItemPresenterImpl_Factory implements Factory<AdvertRichJobItemPresenterImpl> {
    public final Provider<AdvertRichItemListener> a;
    public final Provider<DateTimeFormatter> b;
    public final Provider<AsyncPhonePresenter> c;
    public final Provider<Analytics> d;

    public AdvertRichJobItemPresenterImpl_Factory(Provider<AdvertRichItemListener> provider, Provider<DateTimeFormatter> provider2, Provider<AsyncPhonePresenter> provider3, Provider<Analytics> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static AdvertRichJobItemPresenterImpl_Factory create(Provider<AdvertRichItemListener> provider, Provider<DateTimeFormatter> provider2, Provider<AsyncPhonePresenter> provider3, Provider<Analytics> provider4) {
        return new AdvertRichJobItemPresenterImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static AdvertRichJobItemPresenterImpl newInstance(Lazy<AdvertRichItemListener> lazy, DateTimeFormatter dateTimeFormatter, AsyncPhonePresenter asyncPhonePresenter, Analytics analytics) {
        return new AdvertRichJobItemPresenterImpl(lazy, dateTimeFormatter, asyncPhonePresenter, analytics);
    }

    @Override // javax.inject.Provider
    public AdvertRichJobItemPresenterImpl get() {
        return newInstance(DoubleCheck.lazy(this.a), this.b.get(), this.c.get(), this.d.get());
    }
}
