package com.avito.android.safedeal.profile_settings.konveyor.switcher;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SwitcherItemBlueprint_Factory implements Factory<SwitcherItemBlueprint> {
    public final Provider<SwitcherItemPresenter> a;

    public SwitcherItemBlueprint_Factory(Provider<SwitcherItemPresenter> provider) {
        this.a = provider;
    }

    public static SwitcherItemBlueprint_Factory create(Provider<SwitcherItemPresenter> provider) {
        return new SwitcherItemBlueprint_Factory(provider);
    }

    public static SwitcherItemBlueprint newInstance(SwitcherItemPresenter switcherItemPresenter) {
        return new SwitcherItemBlueprint(switcherItemPresenter);
    }

    @Override // javax.inject.Provider
    public SwitcherItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
