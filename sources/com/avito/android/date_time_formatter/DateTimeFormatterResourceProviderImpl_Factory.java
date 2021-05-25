package com.avito.android.date_time_formatter;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DateTimeFormatterResourceProviderImpl_Factory implements Factory<DateTimeFormatterResourceProviderImpl> {
    public final Provider<Resources> a;

    public DateTimeFormatterResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static DateTimeFormatterResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new DateTimeFormatterResourceProviderImpl_Factory(provider);
    }

    public static DateTimeFormatterResourceProviderImpl newInstance(Resources resources) {
        return new DateTimeFormatterResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public DateTimeFormatterResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
