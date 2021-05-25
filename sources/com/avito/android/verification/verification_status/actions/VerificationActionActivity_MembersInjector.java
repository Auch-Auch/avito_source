package com.avito.android.verification.verification_status.actions;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class VerificationActionActivity_MembersInjector implements MembersInjector<VerificationActionActivity> {
    public final Provider<VerificationActionViewModel> a;

    public VerificationActionActivity_MembersInjector(Provider<VerificationActionViewModel> provider) {
        this.a = provider;
    }

    public static MembersInjector<VerificationActionActivity> create(Provider<VerificationActionViewModel> provider) {
        return new VerificationActionActivity_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.verification.verification_status.actions.VerificationActionActivity.viewModel")
    public static void injectViewModel(VerificationActionActivity verificationActionActivity, VerificationActionViewModel verificationActionViewModel) {
        verificationActionActivity.viewModel = verificationActionViewModel;
    }

    public void injectMembers(VerificationActionActivity verificationActionActivity) {
        injectViewModel(verificationActionActivity, this.a.get());
    }
}
