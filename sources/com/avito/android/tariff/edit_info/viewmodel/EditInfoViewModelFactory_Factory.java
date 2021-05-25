package com.avito.android.tariff.edit_info.viewmodel;

import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class EditInfoViewModelFactory_Factory implements Factory<EditInfoViewModelFactory> {
    public final Provider<String> a;
    public final Provider<EditInfoRepository> b;
    public final Provider<EditInfoConverter> c;
    public final Provider<SchedulersFactory> d;

    public EditInfoViewModelFactory_Factory(Provider<String> provider, Provider<EditInfoRepository> provider2, Provider<EditInfoConverter> provider3, Provider<SchedulersFactory> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static EditInfoViewModelFactory_Factory create(Provider<String> provider, Provider<EditInfoRepository> provider2, Provider<EditInfoConverter> provider3, Provider<SchedulersFactory> provider4) {
        return new EditInfoViewModelFactory_Factory(provider, provider2, provider3, provider4);
    }

    public static EditInfoViewModelFactory newInstance(String str, EditInfoRepository editInfoRepository, EditInfoConverter editInfoConverter, SchedulersFactory schedulersFactory) {
        return new EditInfoViewModelFactory(str, editInfoRepository, editInfoConverter, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public EditInfoViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
