package com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.single_service;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SingleCourierServiceBlueprint_Factory implements Factory<SingleCourierServiceBlueprint> {
    public final Provider<SingleCourierServiceItemPresenter> a;

    public SingleCourierServiceBlueprint_Factory(Provider<SingleCourierServiceItemPresenter> provider) {
        this.a = provider;
    }

    public static SingleCourierServiceBlueprint_Factory create(Provider<SingleCourierServiceItemPresenter> provider) {
        return new SingleCourierServiceBlueprint_Factory(provider);
    }

    public static SingleCourierServiceBlueprint newInstance(SingleCourierServiceItemPresenter singleCourierServiceItemPresenter) {
        return new SingleCourierServiceBlueprint(singleCourierServiceItemPresenter);
    }

    @Override // javax.inject.Provider
    public SingleCourierServiceBlueprint get() {
        return newInstance(this.a.get());
    }
}
