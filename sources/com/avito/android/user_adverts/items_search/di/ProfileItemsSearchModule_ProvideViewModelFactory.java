package com.avito.android.user_adverts.items_search.di;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.user_adverts.items_search.ProfileItemsSearchViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ProfileItemsSearchModule_ProvideViewModelFactory implements Factory<ProfileItemsSearchViewModel> {
    public final Provider<Fragment> a;
    public final Provider<ViewModelProvider.Factory> b;

    public ProfileItemsSearchModule_ProvideViewModelFactory(Provider<Fragment> provider, Provider<ViewModelProvider.Factory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ProfileItemsSearchModule_ProvideViewModelFactory create(Provider<Fragment> provider, Provider<ViewModelProvider.Factory> provider2) {
        return new ProfileItemsSearchModule_ProvideViewModelFactory(provider, provider2);
    }

    public static ProfileItemsSearchViewModel provideViewModel(Fragment fragment, ViewModelProvider.Factory factory) {
        return (ProfileItemsSearchViewModel) Preconditions.checkNotNullFromProvides(ProfileItemsSearchModule.INSTANCE.provideViewModel(fragment, factory));
    }

    @Override // javax.inject.Provider
    public ProfileItemsSearchViewModel get() {
        return provideViewModel(this.a.get(), this.b.get());
    }
}
