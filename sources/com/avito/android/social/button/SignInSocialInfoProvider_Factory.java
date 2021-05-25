package com.avito.android.social.button;

import dagger.internal.Factory;
public final class SignInSocialInfoProvider_Factory implements Factory<SignInSocialInfoProvider> {

    public static final class a {
        public static final SignInSocialInfoProvider_Factory a = new SignInSocialInfoProvider_Factory();
    }

    public static SignInSocialInfoProvider_Factory create() {
        return a.a;
    }

    public static SignInSocialInfoProvider newInstance() {
        return new SignInSocialInfoProvider();
    }

    @Override // javax.inject.Provider
    public SignInSocialInfoProvider get() {
        return newInstance();
    }
}
