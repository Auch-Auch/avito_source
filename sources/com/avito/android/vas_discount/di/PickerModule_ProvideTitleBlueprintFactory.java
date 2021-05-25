package com.avito.android.vas_discount.di;

import com.avito.android.conveyor_shared_item.bottom_sheet.title.TitlePresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PickerModule_ProvideTitleBlueprintFactory implements Factory<ItemBlueprint<?, ?>> {
    public final PickerModule a;
    public final Provider<TitlePresenter> b;

    public PickerModule_ProvideTitleBlueprintFactory(PickerModule pickerModule, Provider<TitlePresenter> provider) {
        this.a = pickerModule;
        this.b = provider;
    }

    public static PickerModule_ProvideTitleBlueprintFactory create(PickerModule pickerModule, Provider<TitlePresenter> provider) {
        return new PickerModule_ProvideTitleBlueprintFactory(pickerModule, provider);
    }

    public static ItemBlueprint<?, ?> provideTitleBlueprint(PickerModule pickerModule, TitlePresenter titlePresenter) {
        return (ItemBlueprint) Preconditions.checkNotNullFromProvides(pickerModule.provideTitleBlueprint(titlePresenter));
    }

    @Override // javax.inject.Provider
    public ItemBlueprint<?, ?> get() {
        return provideTitleBlueprint(this.a, this.b.get());
    }
}
