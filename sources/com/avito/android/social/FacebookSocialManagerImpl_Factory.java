package com.avito.android.social;

import dagger.internal.Factory;
public final class FacebookSocialManagerImpl_Factory implements Factory<FacebookSocialManagerImpl> {

    public static final class a {
        public static final FacebookSocialManagerImpl_Factory a = new FacebookSocialManagerImpl_Factory();
    }

    public static FacebookSocialManagerImpl_Factory create() {
        return a.a;
    }

    public static FacebookSocialManagerImpl newInstance() {
        return new FacebookSocialManagerImpl();
    }

    @Override // javax.inject.Provider
    public FacebookSocialManagerImpl get() {
        return newInstance();
    }
}
