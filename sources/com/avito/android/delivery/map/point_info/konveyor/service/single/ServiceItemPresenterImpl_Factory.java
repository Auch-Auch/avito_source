package com.avito.android.delivery.map.point_info.konveyor.service.single;

import dagger.internal.Factory;
public final class ServiceItemPresenterImpl_Factory implements Factory<ServiceItemPresenterImpl> {

    public static final class a {
        public static final ServiceItemPresenterImpl_Factory a = new ServiceItemPresenterImpl_Factory();
    }

    public static ServiceItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static ServiceItemPresenterImpl newInstance() {
        return new ServiceItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public ServiceItemPresenterImpl get() {
        return newInstance();
    }
}
