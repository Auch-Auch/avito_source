package com.avito.android.profile_phones.add_phone;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class AddPhoneFragment_MembersInjector implements MembersInjector<AddPhoneFragment> {
    public final Provider<AddPhoneViewModelFactory> a;
    public final Provider<ActivityIntentFactory> b;
    public final Provider<DeepLinkIntentFactory> c;
    public final Provider<Analytics> d;

    public AddPhoneFragment_MembersInjector(Provider<AddPhoneViewModelFactory> provider, Provider<ActivityIntentFactory> provider2, Provider<DeepLinkIntentFactory> provider3, Provider<Analytics> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<AddPhoneFragment> create(Provider<AddPhoneViewModelFactory> provider, Provider<ActivityIntentFactory> provider2, Provider<DeepLinkIntentFactory> provider3, Provider<Analytics> provider4) {
        return new AddPhoneFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.profile_phones.add_phone.AddPhoneFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(AddPhoneFragment addPhoneFragment, ActivityIntentFactory activityIntentFactory) {
        addPhoneFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.profile_phones.add_phone.AddPhoneFragment.analytics")
    public static void injectAnalytics(AddPhoneFragment addPhoneFragment, Analytics analytics) {
        addPhoneFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.profile_phones.add_phone.AddPhoneFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(AddPhoneFragment addPhoneFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        addPhoneFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.profile_phones.add_phone.AddPhoneFragment.viewModelFactory")
    public static void injectViewModelFactory(AddPhoneFragment addPhoneFragment, AddPhoneViewModelFactory addPhoneViewModelFactory) {
        addPhoneFragment.viewModelFactory = addPhoneViewModelFactory;
    }

    public void injectMembers(AddPhoneFragment addPhoneFragment) {
        injectViewModelFactory(addPhoneFragment, this.a.get());
        injectActivityIntentFactory(addPhoneFragment, this.b.get());
        injectDeepLinkIntentFactory(addPhoneFragment, this.c.get());
        injectAnalytics(addPhoneFragment, this.d.get());
    }
}
