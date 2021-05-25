package com.avito.android.advert;

import android.content.res.Resources;
import com.avito.android.date_time_formatter.DateTimeFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsResourcesProviderImpl_Factory implements Factory<AdvertDetailsResourcesProviderImpl> {
    public final Provider<DateTimeFormatter> a;
    public final Provider<Resources> b;

    public AdvertDetailsResourcesProviderImpl_Factory(Provider<DateTimeFormatter> provider, Provider<Resources> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AdvertDetailsResourcesProviderImpl_Factory create(Provider<DateTimeFormatter> provider, Provider<Resources> provider2) {
        return new AdvertDetailsResourcesProviderImpl_Factory(provider, provider2);
    }

    public static AdvertDetailsResourcesProviderImpl newInstance(DateTimeFormatter dateTimeFormatter, Resources resources) {
        return new AdvertDetailsResourcesProviderImpl(dateTimeFormatter, resources);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsResourcesProviderImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
