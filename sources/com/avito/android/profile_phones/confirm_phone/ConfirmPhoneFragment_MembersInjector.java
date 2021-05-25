package com.avito.android.profile_phones.confirm_phone;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class ConfirmPhoneFragment_MembersInjector implements MembersInjector<ConfirmPhoneFragment> {
    public final Provider<ConfirmPhoneViewModelFactory> a;

    public ConfirmPhoneFragment_MembersInjector(Provider<ConfirmPhoneViewModelFactory> provider) {
        this.a = provider;
    }

    public static MembersInjector<ConfirmPhoneFragment> create(Provider<ConfirmPhoneViewModelFactory> provider) {
        return new ConfirmPhoneFragment_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.profile_phones.confirm_phone.ConfirmPhoneFragment.viewModelFactory")
    public static void injectViewModelFactory(ConfirmPhoneFragment confirmPhoneFragment, ConfirmPhoneViewModelFactory confirmPhoneViewModelFactory) {
        confirmPhoneFragment.viewModelFactory = confirmPhoneViewModelFactory;
    }

    public void injectMembers(ConfirmPhoneFragment confirmPhoneFragment) {
        injectViewModelFactory(confirmPhoneFragment, this.a.get());
    }
}
