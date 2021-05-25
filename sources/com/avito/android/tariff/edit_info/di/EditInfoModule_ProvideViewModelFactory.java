package com.avito.android.tariff.edit_info.di;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.tariff.edit_info.viewmodel.EditInfoViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class EditInfoModule_ProvideViewModelFactory implements Factory<EditInfoViewModel> {
    public final Provider<Fragment> a;
    public final Provider<ViewModelProvider.Factory> b;

    public EditInfoModule_ProvideViewModelFactory(Provider<Fragment> provider, Provider<ViewModelProvider.Factory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static EditInfoModule_ProvideViewModelFactory create(Provider<Fragment> provider, Provider<ViewModelProvider.Factory> provider2) {
        return new EditInfoModule_ProvideViewModelFactory(provider, provider2);
    }

    public static EditInfoViewModel provideViewModel(Fragment fragment, ViewModelProvider.Factory factory) {
        return (EditInfoViewModel) Preconditions.checkNotNullFromProvides(EditInfoModule.provideViewModel(fragment, factory));
    }

    @Override // javax.inject.Provider
    public EditInfoViewModel get() {
        return provideViewModel(this.a.get(), this.b.get());
    }
}
