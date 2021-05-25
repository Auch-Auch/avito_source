package com.avito.android.social.button;

import dagger.internal.Factory;
public final class ShareSocialInfoProvider_Factory implements Factory<ShareSocialInfoProvider> {

    public static final class a {
        public static final ShareSocialInfoProvider_Factory a = new ShareSocialInfoProvider_Factory();
    }

    public static ShareSocialInfoProvider_Factory create() {
        return a.a;
    }

    public static ShareSocialInfoProvider newInstance() {
        return new ShareSocialInfoProvider();
    }

    @Override // javax.inject.Provider
    public ShareSocialInfoProvider get() {
        return newInstance();
    }
}
