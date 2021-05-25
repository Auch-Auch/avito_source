package com.avito.android.tariff.edit_info.ui;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class EditInfoPaddingDecoration_Factory implements Factory<EditInfoPaddingDecoration> {
    public final Provider<EditInfoViewTypeProvider> a;

    public EditInfoPaddingDecoration_Factory(Provider<EditInfoViewTypeProvider> provider) {
        this.a = provider;
    }

    public static EditInfoPaddingDecoration_Factory create(Provider<EditInfoViewTypeProvider> provider) {
        return new EditInfoPaddingDecoration_Factory(provider);
    }

    public static EditInfoPaddingDecoration newInstance(EditInfoViewTypeProvider editInfoViewTypeProvider) {
        return new EditInfoPaddingDecoration(editInfoViewTypeProvider);
    }

    @Override // javax.inject.Provider
    public EditInfoPaddingDecoration get() {
        return newInstance(this.a.get());
    }
}
