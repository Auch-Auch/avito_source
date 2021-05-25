package com.avito.android.verification.verifications_list;

import dagger.internal.Factory;
public final class VerificationOptionsListConverterImpl_Factory implements Factory<VerificationOptionsListConverterImpl> {

    public static final class a {
        public static final VerificationOptionsListConverterImpl_Factory a = new VerificationOptionsListConverterImpl_Factory();
    }

    public static VerificationOptionsListConverterImpl_Factory create() {
        return a.a;
    }

    public static VerificationOptionsListConverterImpl newInstance() {
        return new VerificationOptionsListConverterImpl();
    }

    @Override // javax.inject.Provider
    public VerificationOptionsListConverterImpl get() {
        return newInstance();
    }
}
