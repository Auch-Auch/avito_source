package com.avito.android.profile_phones.phone_action;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.profile_phones.phone_action.view_model.PhoneActionViewModelFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class PhoneActionFragment_MembersInjector implements MembersInjector<PhoneActionFragment> {
    public final Provider<PhoneActionViewModelFactory> a;
    public final Provider<ActivityIntentFactory> b;

    public PhoneActionFragment_MembersInjector(Provider<PhoneActionViewModelFactory> provider, Provider<ActivityIntentFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MembersInjector<PhoneActionFragment> create(Provider<PhoneActionViewModelFactory> provider, Provider<ActivityIntentFactory> provider2) {
        return new PhoneActionFragment_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.avito.android.profile_phones.phone_action.PhoneActionFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(PhoneActionFragment phoneActionFragment, ActivityIntentFactory activityIntentFactory) {
        phoneActionFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.profile_phones.phone_action.PhoneActionFragment.viewModelFactory")
    public static void injectViewModelFactory(PhoneActionFragment phoneActionFragment, PhoneActionViewModelFactory phoneActionViewModelFactory) {
        phoneActionFragment.viewModelFactory = phoneActionViewModelFactory;
    }

    public void injectMembers(PhoneActionFragment phoneActionFragment) {
        injectViewModelFactory(phoneActionFragment, this.a.get());
        injectActivityIntentFactory(phoneActionFragment, this.b.get());
    }
}
