package com.avito.android.delivery.order_cancellation.details.konveyor.input;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class InputItemBlueprint_Factory implements Factory<InputItemBlueprint> {
    public final Provider<InputItemPresenter> a;

    public InputItemBlueprint_Factory(Provider<InputItemPresenter> provider) {
        this.a = provider;
    }

    public static InputItemBlueprint_Factory create(Provider<InputItemPresenter> provider) {
        return new InputItemBlueprint_Factory(provider);
    }

    public static InputItemBlueprint newInstance(InputItemPresenter inputItemPresenter) {
        return new InputItemBlueprint(inputItemPresenter);
    }

    @Override // javax.inject.Provider
    public InputItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
