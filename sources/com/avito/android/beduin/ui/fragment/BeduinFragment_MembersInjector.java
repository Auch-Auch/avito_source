package com.avito.android.beduin.ui.fragment;

import com.avito.android.beduin.ui.adapter.BeduinAdapter;
import com.avito.android.beduin.ui.viewmodel.BeduinViewModel;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class BeduinFragment_MembersInjector implements MembersInjector<BeduinFragment> {
    public final Provider<BeduinViewModel> a;
    public final Provider<BeduinAdapter> b;

    public BeduinFragment_MembersInjector(Provider<BeduinViewModel> provider, Provider<BeduinAdapter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MembersInjector<BeduinFragment> create(Provider<BeduinViewModel> provider, Provider<BeduinAdapter> provider2) {
        return new BeduinFragment_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.avito.android.beduin.ui.fragment.BeduinFragment.beduinAdapter")
    public static void injectBeduinAdapter(BeduinFragment beduinFragment, BeduinAdapter beduinAdapter) {
        beduinFragment.beduinAdapter = beduinAdapter;
    }

    @InjectedFieldSignature("com.avito.android.beduin.ui.fragment.BeduinFragment.beduinViewModel")
    public static void injectBeduinViewModel(BeduinFragment beduinFragment, BeduinViewModel beduinViewModel) {
        beduinFragment.beduinViewModel = beduinViewModel;
    }

    public void injectMembers(BeduinFragment beduinFragment) {
        injectBeduinViewModel(beduinFragment, this.a.get());
        injectBeduinAdapter(beduinFragment, this.b.get());
    }
}
