package com.avito.android.short_term_rent.confirm_booking.utils;

import dagger.internal.Factory;
public final class StrContactsTreeConverterImpl_Factory implements Factory<StrContactsTreeConverterImpl> {

    public static final class a {
        public static final StrContactsTreeConverterImpl_Factory a = new StrContactsTreeConverterImpl_Factory();
    }

    public static StrContactsTreeConverterImpl_Factory create() {
        return a.a;
    }

    public static StrContactsTreeConverterImpl newInstance() {
        return new StrContactsTreeConverterImpl();
    }

    @Override // javax.inject.Provider
    public StrContactsTreeConverterImpl get() {
        return newInstance();
    }
}
