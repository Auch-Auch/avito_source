package com.avito.android.authorization.select_profile.social_login;

import com.avito.android.ActivityIntentFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class SocialRegistrationSuggestsFragment_MembersInjector implements MembersInjector<SocialRegistrationSuggestsFragment> {
    public final Provider<SocialRegistrationSuggestsPresenter> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<ItemBinder> c;
    public final Provider<ActivityIntentFactory> d;

    public SocialRegistrationSuggestsFragment_MembersInjector(Provider<SocialRegistrationSuggestsPresenter> provider, Provider<AdapterPresenter> provider2, Provider<ItemBinder> provider3, Provider<ActivityIntentFactory> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<SocialRegistrationSuggestsFragment> create(Provider<SocialRegistrationSuggestsPresenter> provider, Provider<AdapterPresenter> provider2, Provider<ItemBinder> provider3, Provider<ActivityIntentFactory> provider4) {
        return new SocialRegistrationSuggestsFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.authorization.select_profile.social_login.SocialRegistrationSuggestsFragment.adapterPresenter")
    public static void injectAdapterPresenter(SocialRegistrationSuggestsFragment socialRegistrationSuggestsFragment, AdapterPresenter adapterPresenter) {
        socialRegistrationSuggestsFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.authorization.select_profile.social_login.SocialRegistrationSuggestsFragment.intentFactory")
    public static void injectIntentFactory(SocialRegistrationSuggestsFragment socialRegistrationSuggestsFragment, ActivityIntentFactory activityIntentFactory) {
        socialRegistrationSuggestsFragment.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.authorization.select_profile.social_login.SocialRegistrationSuggestsFragment.itemBinder")
    public static void injectItemBinder(SocialRegistrationSuggestsFragment socialRegistrationSuggestsFragment, ItemBinder itemBinder) {
        socialRegistrationSuggestsFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.authorization.select_profile.social_login.SocialRegistrationSuggestsFragment.presenter")
    public static void injectPresenter(SocialRegistrationSuggestsFragment socialRegistrationSuggestsFragment, SocialRegistrationSuggestsPresenter socialRegistrationSuggestsPresenter) {
        socialRegistrationSuggestsFragment.presenter = socialRegistrationSuggestsPresenter;
    }

    public void injectMembers(SocialRegistrationSuggestsFragment socialRegistrationSuggestsFragment) {
        injectPresenter(socialRegistrationSuggestsFragment, this.a.get());
        injectAdapterPresenter(socialRegistrationSuggestsFragment, this.b.get());
        injectItemBinder(socialRegistrationSuggestsFragment, this.c.get());
        injectIntentFactory(socialRegistrationSuggestsFragment, this.d.get());
    }
}
