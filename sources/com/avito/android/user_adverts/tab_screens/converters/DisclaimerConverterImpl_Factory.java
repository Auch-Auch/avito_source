package com.avito.android.user_adverts.tab_screens.converters;

import dagger.internal.Factory;
public final class DisclaimerConverterImpl_Factory implements Factory<DisclaimerConverterImpl> {

    public static final class a {
        public static final DisclaimerConverterImpl_Factory a = new DisclaimerConverterImpl_Factory();
    }

    public static DisclaimerConverterImpl_Factory create() {
        return a.a;
    }

    public static DisclaimerConverterImpl newInstance() {
        return new DisclaimerConverterImpl();
    }

    @Override // javax.inject.Provider
    public DisclaimerConverterImpl get() {
        return newInstance();
    }
}
