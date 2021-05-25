package com.avito.android.vas_discount.di;

import com.avito.android.component.user_advert.UserAdvertItemPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PickerModule_ProvideUserAdvertItemListBlueprintFactory implements Factory<ItemBlueprint<?, ?>> {
    public final PickerModule a;
    public final Provider<UserAdvertItemPresenter> b;

    public PickerModule_ProvideUserAdvertItemListBlueprintFactory(PickerModule pickerModule, Provider<UserAdvertItemPresenter> provider) {
        this.a = pickerModule;
        this.b = provider;
    }

    public static PickerModule_ProvideUserAdvertItemListBlueprintFactory create(PickerModule pickerModule, Provider<UserAdvertItemPresenter> provider) {
        return new PickerModule_ProvideUserAdvertItemListBlueprintFactory(pickerModule, provider);
    }

    public static ItemBlueprint<?, ?> provideUserAdvertItemListBlueprint(PickerModule pickerModule, UserAdvertItemPresenter userAdvertItemPresenter) {
        return (ItemBlueprint) Preconditions.checkNotNullFromProvides(pickerModule.provideUserAdvertItemListBlueprint(userAdvertItemPresenter));
    }

    @Override // javax.inject.Provider
    public ItemBlueprint<?, ?> get() {
        return provideUserAdvertItemListBlueprint(this.a, this.b.get());
    }
}
