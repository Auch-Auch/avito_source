package com.avito.android.help_center;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class HelpCenterIntentFactoryImpl_Factory implements Factory<HelpCenterIntentFactoryImpl> {
    public final Provider<Context> a;

    public HelpCenterIntentFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static HelpCenterIntentFactoryImpl_Factory create(Provider<Context> provider) {
        return new HelpCenterIntentFactoryImpl_Factory(provider);
    }

    public static HelpCenterIntentFactoryImpl newInstance(Context context) {
        return new HelpCenterIntentFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public HelpCenterIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
