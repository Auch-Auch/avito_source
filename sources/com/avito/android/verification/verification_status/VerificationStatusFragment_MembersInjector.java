package com.avito.android.verification.verification_status;

import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class VerificationStatusFragment_MembersInjector implements MembersInjector<VerificationStatusFragment> {
    public final Provider<VerificationStatusViewModel> a;
    public final Provider<AttributedTextFormatter> b;
    public final Provider<Analytics> c;
    public final Provider<DeepLinkIntentFactory> d;
    public final Provider<ImplicitIntentFactory> e;

    public VerificationStatusFragment_MembersInjector(Provider<VerificationStatusViewModel> provider, Provider<AttributedTextFormatter> provider2, Provider<Analytics> provider3, Provider<DeepLinkIntentFactory> provider4, Provider<ImplicitIntentFactory> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static MembersInjector<VerificationStatusFragment> create(Provider<VerificationStatusViewModel> provider, Provider<AttributedTextFormatter> provider2, Provider<Analytics> provider3, Provider<DeepLinkIntentFactory> provider4, Provider<ImplicitIntentFactory> provider5) {
        return new VerificationStatusFragment_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @InjectedFieldSignature("com.avito.android.verification.verification_status.VerificationStatusFragment.analytics")
    public static void injectAnalytics(VerificationStatusFragment verificationStatusFragment, Analytics analytics) {
        verificationStatusFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.verification.verification_status.VerificationStatusFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(VerificationStatusFragment verificationStatusFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        verificationStatusFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.verification.verification_status.VerificationStatusFragment.implicitIntentFactory")
    public static void injectImplicitIntentFactory(VerificationStatusFragment verificationStatusFragment, ImplicitIntentFactory implicitIntentFactory) {
        verificationStatusFragment.implicitIntentFactory = implicitIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.verification.verification_status.VerificationStatusFragment.textFormatter")
    public static void injectTextFormatter(VerificationStatusFragment verificationStatusFragment, AttributedTextFormatter attributedTextFormatter) {
        verificationStatusFragment.textFormatter = attributedTextFormatter;
    }

    @InjectedFieldSignature("com.avito.android.verification.verification_status.VerificationStatusFragment.viewModel")
    public static void injectViewModel(VerificationStatusFragment verificationStatusFragment, VerificationStatusViewModel verificationStatusViewModel) {
        verificationStatusFragment.viewModel = verificationStatusViewModel;
    }

    public void injectMembers(VerificationStatusFragment verificationStatusFragment) {
        injectViewModel(verificationStatusFragment, this.a.get());
        injectTextFormatter(verificationStatusFragment, this.b.get());
        injectAnalytics(verificationStatusFragment, this.c.get());
        injectDeepLinkIntentFactory(verificationStatusFragment, this.d.get());
        injectImplicitIntentFactory(verificationStatusFragment, this.e.get());
    }
}
