package com.avito.android.vas_performance.ui.items.button;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ButtonItemBlueprint_Factory implements Factory<ButtonItemBlueprint> {
    public final Provider<ButtonItemPresenter> a;

    public ButtonItemBlueprint_Factory(Provider<ButtonItemPresenter> provider) {
        this.a = provider;
    }

    public static ButtonItemBlueprint_Factory create(Provider<ButtonItemPresenter> provider) {
        return new ButtonItemBlueprint_Factory(provider);
    }

    public static ButtonItemBlueprint newInstance(ButtonItemPresenter buttonItemPresenter) {
        return new ButtonItemBlueprint(buttonItemPresenter);
    }

    @Override // javax.inject.Provider
    public ButtonItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
