package com.avito.android.vas_discount.di;

import com.avito.android.remote.model.DiscountResponse;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class PickerModule_ProvideDiscountResponseFactory implements Factory<DiscountResponse> {
    public final PickerModule a;

    public PickerModule_ProvideDiscountResponseFactory(PickerModule pickerModule) {
        this.a = pickerModule;
    }

    public static PickerModule_ProvideDiscountResponseFactory create(PickerModule pickerModule) {
        return new PickerModule_ProvideDiscountResponseFactory(pickerModule);
    }

    public static DiscountResponse provideDiscountResponse(PickerModule pickerModule) {
        return (DiscountResponse) Preconditions.checkNotNullFromProvides(pickerModule.provideDiscountResponse());
    }

    @Override // javax.inject.Provider
    public DiscountResponse get() {
        return provideDiscountResponse(this.a);
    }
}
