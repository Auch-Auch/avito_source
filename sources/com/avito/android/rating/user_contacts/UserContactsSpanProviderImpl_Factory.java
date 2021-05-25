package com.avito.android.rating.user_contacts;

import dagger.internal.Factory;
public final class UserContactsSpanProviderImpl_Factory implements Factory<UserContactsSpanProviderImpl> {

    public static final class a {
        public static final UserContactsSpanProviderImpl_Factory a = new UserContactsSpanProviderImpl_Factory();
    }

    public static UserContactsSpanProviderImpl_Factory create() {
        return a.a;
    }

    public static UserContactsSpanProviderImpl newInstance() {
        return new UserContactsSpanProviderImpl();
    }

    @Override // javax.inject.Provider
    public UserContactsSpanProviderImpl get() {
        return newInstance();
    }
}
