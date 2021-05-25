package com.avito.android.tariff.edit_info.viewmodel;

import com.avito.android.tariff.view.TariffBarConverter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class EditInfoConverterImpl_Factory implements Factory<EditInfoConverterImpl> {
    public final Provider<TariffBarConverter> a;

    public EditInfoConverterImpl_Factory(Provider<TariffBarConverter> provider) {
        this.a = provider;
    }

    public static EditInfoConverterImpl_Factory create(Provider<TariffBarConverter> provider) {
        return new EditInfoConverterImpl_Factory(provider);
    }

    public static EditInfoConverterImpl newInstance(TariffBarConverter tariffBarConverter) {
        return new EditInfoConverterImpl(tariffBarConverter);
    }

    @Override // javax.inject.Provider
    public EditInfoConverterImpl get() {
        return newInstance(this.a.get());
    }
}
