package com.avito.android.notification_center.push;

import dagger.internal.Factory;
public final class NcPushClicksImpl_Factory implements Factory<NcPushClicksImpl> {

    public static final class a {
        public static final NcPushClicksImpl_Factory a = new NcPushClicksImpl_Factory();
    }

    public static NcPushClicksImpl_Factory create() {
        return a.a;
    }

    public static NcPushClicksImpl newInstance() {
        return new NcPushClicksImpl();
    }

    @Override // javax.inject.Provider
    public NcPushClicksImpl get() {
        return newInstance();
    }
}
