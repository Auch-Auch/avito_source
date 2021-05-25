package com.avito.android.remote.social;

import dagger.internal.Factory;
public final class AvitoSocialTypeToStringMapper_Factory implements Factory<AvitoSocialTypeToStringMapper> {

    public static final class a {
        public static final AvitoSocialTypeToStringMapper_Factory a = new AvitoSocialTypeToStringMapper_Factory();
    }

    public static AvitoSocialTypeToStringMapper_Factory create() {
        return a.a;
    }

    public static AvitoSocialTypeToStringMapper newInstance() {
        return new AvitoSocialTypeToStringMapper();
    }

    @Override // javax.inject.Provider
    public AvitoSocialTypeToStringMapper get() {
        return newInstance();
    }
}
