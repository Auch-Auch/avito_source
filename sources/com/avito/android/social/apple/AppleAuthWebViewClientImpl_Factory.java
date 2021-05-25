package com.avito.android.social.apple;

import dagger.internal.Factory;
public final class AppleAuthWebViewClientImpl_Factory implements Factory<AppleAuthWebViewClientImpl> {

    public static final class a {
        public static final AppleAuthWebViewClientImpl_Factory a = new AppleAuthWebViewClientImpl_Factory();
    }

    public static AppleAuthWebViewClientImpl_Factory create() {
        return a.a;
    }

    public static AppleAuthWebViewClientImpl newInstance() {
        return new AppleAuthWebViewClientImpl();
    }

    @Override // javax.inject.Provider
    public AppleAuthWebViewClientImpl get() {
        return newInstance();
    }
}
