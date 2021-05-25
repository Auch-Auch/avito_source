package com.avito.android.advert.item.consultation;

import dagger.internal.Factory;
public final class AdvertDetailsConsultationPresenterImpl_Factory implements Factory<AdvertDetailsConsultationPresenterImpl> {

    public static final class a {
        public static final AdvertDetailsConsultationPresenterImpl_Factory a = new AdvertDetailsConsultationPresenterImpl_Factory();
    }

    public static AdvertDetailsConsultationPresenterImpl_Factory create() {
        return a.a;
    }

    public static AdvertDetailsConsultationPresenterImpl newInstance() {
        return new AdvertDetailsConsultationPresenterImpl();
    }

    @Override // javax.inject.Provider
    public AdvertDetailsConsultationPresenterImpl get() {
        return newInstance();
    }
}
