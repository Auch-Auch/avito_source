package com.avito.android.brandspace.items.button;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ButtonBlueprint_Factory implements Factory<ButtonBlueprint> {
    public final Provider<ButtonPresenter> a;

    public ButtonBlueprint_Factory(Provider<ButtonPresenter> provider) {
        this.a = provider;
    }

    public static ButtonBlueprint_Factory create(Provider<ButtonPresenter> provider) {
        return new ButtonBlueprint_Factory(provider);
    }

    public static ButtonBlueprint newInstance(ButtonPresenter buttonPresenter) {
        return new ButtonBlueprint(buttonPresenter);
    }

    @Override // javax.inject.Provider
    public ButtonBlueprint get() {
        return newInstance(this.a.get());
    }
}
