package com.avito.android.tariff.edit_info.item.manager_call;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ManagerCallBlueprint_Factory implements Factory<ManagerCallBlueprint> {
    public final Provider<ManagerCallPresenter> a;

    public ManagerCallBlueprint_Factory(Provider<ManagerCallPresenter> provider) {
        this.a = provider;
    }

    public static ManagerCallBlueprint_Factory create(Provider<ManagerCallPresenter> provider) {
        return new ManagerCallBlueprint_Factory(provider);
    }

    public static ManagerCallBlueprint newInstance(ManagerCallPresenter managerCallPresenter) {
        return new ManagerCallBlueprint(managerCallPresenter);
    }

    @Override // javax.inject.Provider
    public ManagerCallBlueprint get() {
        return newInstance(this.a.get());
    }
}
