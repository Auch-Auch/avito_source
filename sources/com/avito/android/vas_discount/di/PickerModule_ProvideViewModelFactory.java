package com.avito.android.vas_discount.di;

import androidx.lifecycle.ViewModelProvider;
import com.avito.android.vas_discount.ui.dialog.DiscountPickerViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PickerModule_ProvideViewModelFactory implements Factory<DiscountPickerViewModel> {
    public final PickerModule a;
    public final Provider<ViewModelProvider.Factory> b;

    public PickerModule_ProvideViewModelFactory(PickerModule pickerModule, Provider<ViewModelProvider.Factory> provider) {
        this.a = pickerModule;
        this.b = provider;
    }

    public static PickerModule_ProvideViewModelFactory create(PickerModule pickerModule, Provider<ViewModelProvider.Factory> provider) {
        return new PickerModule_ProvideViewModelFactory(pickerModule, provider);
    }

    public static DiscountPickerViewModel provideViewModel(PickerModule pickerModule, ViewModelProvider.Factory factory) {
        return (DiscountPickerViewModel) Preconditions.checkNotNullFromProvides(pickerModule.provideViewModel(factory));
    }

    @Override // javax.inject.Provider
    public DiscountPickerViewModel get() {
        return provideViewModel(this.a, this.b.get());
    }
}
