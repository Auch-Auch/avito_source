package com.avito.android.social;

import dagger.internal.Factory;
public final class MailSocialManagerImpl_Factory implements Factory<MailSocialManagerImpl> {

    public static final class a {
        public static final MailSocialManagerImpl_Factory a = new MailSocialManagerImpl_Factory();
    }

    public static MailSocialManagerImpl_Factory create() {
        return a.a;
    }

    public static MailSocialManagerImpl newInstance() {
        return new MailSocialManagerImpl();
    }

    @Override // javax.inject.Provider
    public MailSocialManagerImpl get() {
        return newInstance();
    }
}
