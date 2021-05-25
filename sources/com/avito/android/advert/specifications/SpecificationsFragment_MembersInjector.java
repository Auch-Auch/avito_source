package com.avito.android.advert.specifications;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class SpecificationsFragment_MembersInjector implements MembersInjector<SpecificationsFragment> {
    public final Provider<SpecificationsPresenter> a;

    public SpecificationsFragment_MembersInjector(Provider<SpecificationsPresenter> provider) {
        this.a = provider;
    }

    public static MembersInjector<SpecificationsFragment> create(Provider<SpecificationsPresenter> provider) {
        return new SpecificationsFragment_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.advert.specifications.SpecificationsFragment.presenter")
    public static void injectPresenter(SpecificationsFragment specificationsFragment, SpecificationsPresenter specificationsPresenter) {
        specificationsFragment.presenter = specificationsPresenter;
    }

    public void injectMembers(SpecificationsFragment specificationsFragment) {
        injectPresenter(specificationsFragment, this.a.get());
    }
}
