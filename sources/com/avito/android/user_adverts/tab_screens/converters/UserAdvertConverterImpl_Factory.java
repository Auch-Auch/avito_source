package com.avito.android.user_adverts.tab_screens.converters;

import dagger.internal.Factory;
public final class UserAdvertConverterImpl_Factory implements Factory<UserAdvertConverterImpl> {

    public static final class a {
        public static final UserAdvertConverterImpl_Factory a = new UserAdvertConverterImpl_Factory();
    }

    public static UserAdvertConverterImpl_Factory create() {
        return a.a;
    }

    public static UserAdvertConverterImpl newInstance() {
        return new UserAdvertConverterImpl();
    }

    @Override // javax.inject.Provider
    public UserAdvertConverterImpl get() {
        return newInstance();
    }
}
