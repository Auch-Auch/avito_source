package com.avito.android.tariff.edit_info.ui;

import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;
public final class EditInfoViewTypeProviderImpl_Factory implements Factory<EditInfoViewTypeProviderImpl> {
    public final Provider<Set<ItemBlueprint<?, ?>>> a;

    public EditInfoViewTypeProviderImpl_Factory(Provider<Set<ItemBlueprint<?, ?>>> provider) {
        this.a = provider;
    }

    public static EditInfoViewTypeProviderImpl_Factory create(Provider<Set<ItemBlueprint<?, ?>>> provider) {
        return new EditInfoViewTypeProviderImpl_Factory(provider);
    }

    public static EditInfoViewTypeProviderImpl newInstance(Set<ItemBlueprint<?, ?>> set) {
        return new EditInfoViewTypeProviderImpl(set);
    }

    @Override // javax.inject.Provider
    public EditInfoViewTypeProviderImpl get() {
        return newInstance(this.a.get());
    }
}
