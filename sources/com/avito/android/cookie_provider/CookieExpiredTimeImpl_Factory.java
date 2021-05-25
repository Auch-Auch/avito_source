package com.avito.android.cookie_provider;

import com.avito.android.server_time.ServerTimeSource;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CookieExpiredTimeImpl_Factory implements Factory<CookieExpiredTimeImpl> {
    public final Provider<ServerTimeSource> a;

    public CookieExpiredTimeImpl_Factory(Provider<ServerTimeSource> provider) {
        this.a = provider;
    }

    public static CookieExpiredTimeImpl_Factory create(Provider<ServerTimeSource> provider) {
        return new CookieExpiredTimeImpl_Factory(provider);
    }

    public static CookieExpiredTimeImpl newInstance(ServerTimeSource serverTimeSource) {
        return new CookieExpiredTimeImpl(serverTimeSource);
    }

    @Override // javax.inject.Provider
    public CookieExpiredTimeImpl get() {
        return newInstance(this.a.get());
    }
}
