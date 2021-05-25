package com.avito.android.vas_discount.di;

import com.avito.android.conveyor_shared_item.bottom_sheet.title.TitlePresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class PickerModule_ProvideTitlePresenterFactory implements Factory<TitlePresenter> {
    public final PickerModule a;

    public PickerModule_ProvideTitlePresenterFactory(PickerModule pickerModule) {
        this.a = pickerModule;
    }

    public static PickerModule_ProvideTitlePresenterFactory create(PickerModule pickerModule) {
        return new PickerModule_ProvideTitlePresenterFactory(pickerModule);
    }

    public static TitlePresenter provideTitlePresenter(PickerModule pickerModule) {
        return (TitlePresenter) Preconditions.checkNotNullFromProvides(pickerModule.provideTitlePresenter());
    }

    @Override // javax.inject.Provider
    public TitlePresenter get() {
        return provideTitlePresenter(this.a);
    }
}
