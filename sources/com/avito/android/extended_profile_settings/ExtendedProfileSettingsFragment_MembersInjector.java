package com.avito.android.extended_profile_settings;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class ExtendedProfileSettingsFragment_MembersInjector implements MembersInjector<ExtendedProfileSettingsFragment> {
    public final Provider<ExtendedProfileSettingsViewModel> a;

    public ExtendedProfileSettingsFragment_MembersInjector(Provider<ExtendedProfileSettingsViewModel> provider) {
        this.a = provider;
    }

    public static MembersInjector<ExtendedProfileSettingsFragment> create(Provider<ExtendedProfileSettingsViewModel> provider) {
        return new ExtendedProfileSettingsFragment_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.extended_profile_settings.ExtendedProfileSettingsFragment.viewModel")
    public static void injectViewModel(ExtendedProfileSettingsFragment extendedProfileSettingsFragment, ExtendedProfileSettingsViewModel extendedProfileSettingsViewModel) {
        extendedProfileSettingsFragment.viewModel = extendedProfileSettingsViewModel;
    }

    public void injectMembers(ExtendedProfileSettingsFragment extendedProfileSettingsFragment) {
        injectViewModel(extendedProfileSettingsFragment, this.a.get());
    }
}
