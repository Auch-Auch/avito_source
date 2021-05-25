package com.avito.android.blueprints.radiogroup;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class RadioGroupSelectItemBlueprint_Factory implements Factory<RadioGroupSelectItemBlueprint> {
    public final Provider<RadioGroupSelectItemPresenter> a;

    public RadioGroupSelectItemBlueprint_Factory(Provider<RadioGroupSelectItemPresenter> provider) {
        this.a = provider;
    }

    public static RadioGroupSelectItemBlueprint_Factory create(Provider<RadioGroupSelectItemPresenter> provider) {
        return new RadioGroupSelectItemBlueprint_Factory(provider);
    }

    public static RadioGroupSelectItemBlueprint newInstance(RadioGroupSelectItemPresenter radioGroupSelectItemPresenter) {
        return new RadioGroupSelectItemBlueprint(radioGroupSelectItemPresenter);
    }

    @Override // javax.inject.Provider
    public RadioGroupSelectItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
