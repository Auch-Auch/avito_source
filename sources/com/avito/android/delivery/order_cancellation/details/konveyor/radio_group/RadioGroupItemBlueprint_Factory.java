package com.avito.android.delivery.order_cancellation.details.konveyor.radio_group;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class RadioGroupItemBlueprint_Factory implements Factory<RadioGroupItemBlueprint> {
    public final Provider<RadioGroupItemPresenter> a;

    public RadioGroupItemBlueprint_Factory(Provider<RadioGroupItemPresenter> provider) {
        this.a = provider;
    }

    public static RadioGroupItemBlueprint_Factory create(Provider<RadioGroupItemPresenter> provider) {
        return new RadioGroupItemBlueprint_Factory(provider);
    }

    public static RadioGroupItemBlueprint newInstance(RadioGroupItemPresenter radioGroupItemPresenter) {
        return new RadioGroupItemBlueprint(radioGroupItemPresenter);
    }

    @Override // javax.inject.Provider
    public RadioGroupItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
