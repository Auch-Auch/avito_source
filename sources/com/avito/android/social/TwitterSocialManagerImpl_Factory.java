package com.avito.android.social;

import dagger.internal.Factory;
public final class TwitterSocialManagerImpl_Factory implements Factory<TwitterSocialManagerImpl> {

    public static final class a {
        public static final TwitterSocialManagerImpl_Factory a = new TwitterSocialManagerImpl_Factory();
    }

    public static TwitterSocialManagerImpl_Factory create() {
        return a.a;
    }

    public static TwitterSocialManagerImpl newInstance() {
        return new TwitterSocialManagerImpl();
    }

    @Override // javax.inject.Provider
    public TwitterSocialManagerImpl get() {
        return newInstance();
    }
}
