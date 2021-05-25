package com.avito.android.profile_phones.landline_verification;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class LandlinePhoneVerificationFragment_MembersInjector implements MembersInjector<LandlinePhoneVerificationFragment> {
    public final Provider<LandlinePhoneVerificationVMFactory> a;
    public final Provider<ActivityIntentFactory> b;
    public final Provider<AttributedTextFormatter> c;
    public final Provider<Analytics> d;

    public LandlinePhoneVerificationFragment_MembersInjector(Provider<LandlinePhoneVerificationVMFactory> provider, Provider<ActivityIntentFactory> provider2, Provider<AttributedTextFormatter> provider3, Provider<Analytics> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<LandlinePhoneVerificationFragment> create(Provider<LandlinePhoneVerificationVMFactory> provider, Provider<ActivityIntentFactory> provider2, Provider<AttributedTextFormatter> provider3, Provider<Analytics> provider4) {
        return new LandlinePhoneVerificationFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.profile_phones.landline_verification.LandlinePhoneVerificationFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(LandlinePhoneVerificationFragment landlinePhoneVerificationFragment, ActivityIntentFactory activityIntentFactory) {
        landlinePhoneVerificationFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.profile_phones.landline_verification.LandlinePhoneVerificationFragment.analytics")
    public static void injectAnalytics(LandlinePhoneVerificationFragment landlinePhoneVerificationFragment, Analytics analytics) {
        landlinePhoneVerificationFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.profile_phones.landline_verification.LandlinePhoneVerificationFragment.attributedTextFormatter")
    public static void injectAttributedTextFormatter(LandlinePhoneVerificationFragment landlinePhoneVerificationFragment, AttributedTextFormatter attributedTextFormatter) {
        landlinePhoneVerificationFragment.attributedTextFormatter = attributedTextFormatter;
    }

    @InjectedFieldSignature("com.avito.android.profile_phones.landline_verification.LandlinePhoneVerificationFragment.viewModelFactory")
    public static void injectViewModelFactory(LandlinePhoneVerificationFragment landlinePhoneVerificationFragment, LandlinePhoneVerificationVMFactory landlinePhoneVerificationVMFactory) {
        landlinePhoneVerificationFragment.viewModelFactory = landlinePhoneVerificationVMFactory;
    }

    public void injectMembers(LandlinePhoneVerificationFragment landlinePhoneVerificationFragment) {
        injectViewModelFactory(landlinePhoneVerificationFragment, this.a.get());
        injectActivityIntentFactory(landlinePhoneVerificationFragment, this.b.get());
        injectAttributedTextFormatter(landlinePhoneVerificationFragment, this.c.get());
        injectAnalytics(landlinePhoneVerificationFragment, this.d.get());
    }
}
