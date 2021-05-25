package com.avito.android.rating.publish.radio_select.adapter.radio_select;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class RadioSelectItemBlueprint_Factory implements Factory<RadioSelectItemBlueprint> {
    public final Provider<RadioSelectItemPresenter> a;

    public RadioSelectItemBlueprint_Factory(Provider<RadioSelectItemPresenter> provider) {
        this.a = provider;
    }

    public static RadioSelectItemBlueprint_Factory create(Provider<RadioSelectItemPresenter> provider) {
        return new RadioSelectItemBlueprint_Factory(provider);
    }

    public static RadioSelectItemBlueprint newInstance(RadioSelectItemPresenter radioSelectItemPresenter) {
        return new RadioSelectItemBlueprint(radioSelectItemPresenter);
    }

    @Override // javax.inject.Provider
    public RadioSelectItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
