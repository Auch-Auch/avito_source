package com.avito.android.item_report;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ItemReportIntentFactoryImpl_Factory implements Factory<ItemReportIntentFactoryImpl> {
    public final Provider<Context> a;

    public ItemReportIntentFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static ItemReportIntentFactoryImpl_Factory create(Provider<Context> provider) {
        return new ItemReportIntentFactoryImpl_Factory(provider);
    }

    public static ItemReportIntentFactoryImpl newInstance(Context context) {
        return new ItemReportIntentFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public ItemReportIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
