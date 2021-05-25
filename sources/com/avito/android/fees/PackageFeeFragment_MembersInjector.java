package com.avito.android.fees;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class PackageFeeFragment_MembersInjector implements MembersInjector<PackageFeeFragment> {
    public final Provider<PackageFeePresenter> a;

    public PackageFeeFragment_MembersInjector(Provider<PackageFeePresenter> provider) {
        this.a = provider;
    }

    public static MembersInjector<PackageFeeFragment> create(Provider<PackageFeePresenter> provider) {
        return new PackageFeeFragment_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.fees.PackageFeeFragment.packageFeePresenter")
    public static void injectPackageFeePresenter(PackageFeeFragment packageFeeFragment, PackageFeePresenter packageFeePresenter) {
        packageFeeFragment.packageFeePresenter = packageFeePresenter;
    }

    public void injectMembers(PackageFeeFragment packageFeeFragment) {
        injectPackageFeePresenter(packageFeeFragment, this.a.get());
    }
}
