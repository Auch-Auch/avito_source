package com.avito.android.short_term_rent.hotels.dialogs.location;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class HotelsLocationDialog_MembersInjector implements MembersInjector<HotelsLocationDialog> {
    public final Provider<HotelsLocationViewModel> a;

    public HotelsLocationDialog_MembersInjector(Provider<HotelsLocationViewModel> provider) {
        this.a = provider;
    }

    public static MembersInjector<HotelsLocationDialog> create(Provider<HotelsLocationViewModel> provider) {
        return new HotelsLocationDialog_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.short_term_rent.hotels.dialogs.location.HotelsLocationDialog.viewModel")
    public static void injectViewModel(HotelsLocationDialog hotelsLocationDialog, HotelsLocationViewModel hotelsLocationViewModel) {
        hotelsLocationDialog.viewModel = hotelsLocationViewModel;
    }

    public void injectMembers(HotelsLocationDialog hotelsLocationDialog) {
        injectViewModel(hotelsLocationDialog, this.a.get());
    }
}
