package com.avito.android.vas_discount;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class VasDiscountActivity_MembersInjector implements MembersInjector<VasDiscountActivity> {
    public final Provider<DiscountActivityViewModelFactory> a;

    public VasDiscountActivity_MembersInjector(Provider<DiscountActivityViewModelFactory> provider) {
        this.a = provider;
    }

    public static MembersInjector<VasDiscountActivity> create(Provider<DiscountActivityViewModelFactory> provider) {
        return new VasDiscountActivity_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.vas_discount.VasDiscountActivity.factory")
    public static void injectFactory(VasDiscountActivity vasDiscountActivity, DiscountActivityViewModelFactory discountActivityViewModelFactory) {
        vasDiscountActivity.factory = discountActivityViewModelFactory;
    }

    public void injectMembers(VasDiscountActivity vasDiscountActivity) {
        injectFactory(vasDiscountActivity, this.a.get());
    }
}
