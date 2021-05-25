package com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.multiple_services;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class CourierServicesRadioGroupItemBlueprint_Factory implements Factory<CourierServicesRadioGroupItemBlueprint> {
    public final Provider<RadioGroupItemPresenter> a;

    public CourierServicesRadioGroupItemBlueprint_Factory(Provider<RadioGroupItemPresenter> provider) {
        this.a = provider;
    }

    public static CourierServicesRadioGroupItemBlueprint_Factory create(Provider<RadioGroupItemPresenter> provider) {
        return new CourierServicesRadioGroupItemBlueprint_Factory(provider);
    }

    public static CourierServicesRadioGroupItemBlueprint newInstance(RadioGroupItemPresenter radioGroupItemPresenter) {
        return new CourierServicesRadioGroupItemBlueprint(radioGroupItemPresenter);
    }

    @Override // javax.inject.Provider
    public CourierServicesRadioGroupItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
