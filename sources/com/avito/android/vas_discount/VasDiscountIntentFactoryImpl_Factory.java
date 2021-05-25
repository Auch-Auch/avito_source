package com.avito.android.vas_discount;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class VasDiscountIntentFactoryImpl_Factory implements Factory<VasDiscountIntentFactoryImpl> {
    public final Provider<Context> a;

    public VasDiscountIntentFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static VasDiscountIntentFactoryImpl_Factory create(Provider<Context> provider) {
        return new VasDiscountIntentFactoryImpl_Factory(provider);
    }

    public static VasDiscountIntentFactoryImpl newInstance(Context context) {
        return new VasDiscountIntentFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public VasDiscountIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
