package com.avito.android.developments_catalog.items.consultation;

import dagger.internal.Factory;
public final class ConsultationPresenterImpl_Factory implements Factory<ConsultationPresenterImpl> {

    public static final class a {
        public static final ConsultationPresenterImpl_Factory a = new ConsultationPresenterImpl_Factory();
    }

    public static ConsultationPresenterImpl_Factory create() {
        return a.a;
    }

    public static ConsultationPresenterImpl newInstance() {
        return new ConsultationPresenterImpl();
    }

    @Override // javax.inject.Provider
    public ConsultationPresenterImpl get() {
        return newInstance();
    }
}
