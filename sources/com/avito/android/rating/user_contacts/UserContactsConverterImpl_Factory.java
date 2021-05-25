package com.avito.android.rating.user_contacts;

import dagger.internal.Factory;
public final class UserContactsConverterImpl_Factory implements Factory<UserContactsConverterImpl> {

    public static final class a {
        public static final UserContactsConverterImpl_Factory a = new UserContactsConverterImpl_Factory();
    }

    public static UserContactsConverterImpl_Factory create() {
        return a.a;
    }

    public static UserContactsConverterImpl newInstance() {
        return new UserContactsConverterImpl();
    }

    @Override // javax.inject.Provider
    public UserContactsConverterImpl get() {
        return newInstance();
    }
}
