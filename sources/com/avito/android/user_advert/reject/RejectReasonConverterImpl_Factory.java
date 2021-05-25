package com.avito.android.user_advert.reject;

import dagger.internal.Factory;
public final class RejectReasonConverterImpl_Factory implements Factory<RejectReasonConverterImpl> {

    public static final class a {
        public static final RejectReasonConverterImpl_Factory a = new RejectReasonConverterImpl_Factory();
    }

    public static RejectReasonConverterImpl_Factory create() {
        return a.a;
    }

    public static RejectReasonConverterImpl newInstance() {
        return new RejectReasonConverterImpl();
    }

    @Override // javax.inject.Provider
    public RejectReasonConverterImpl get() {
        return newInstance();
    }
}
