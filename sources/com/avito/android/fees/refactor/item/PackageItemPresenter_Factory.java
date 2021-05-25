package com.avito.android.fees.refactor.item;

import com.avito.android.fees.refactor.PackageClickListener;
import com.avito.android.fees.refactor.PackageSelectionListener;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PackageItemPresenter_Factory implements Factory<PackageItemPresenter> {
    public final Provider<PackageClickListener> a;
    public final Provider<PackageSelectionListener> b;

    public PackageItemPresenter_Factory(Provider<PackageClickListener> provider, Provider<PackageSelectionListener> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static PackageItemPresenter_Factory create(Provider<PackageClickListener> provider, Provider<PackageSelectionListener> provider2) {
        return new PackageItemPresenter_Factory(provider, provider2);
    }

    public static PackageItemPresenter newInstance(PackageClickListener packageClickListener, PackageSelectionListener packageSelectionListener) {
        return new PackageItemPresenter(packageClickListener, packageSelectionListener);
    }

    @Override // javax.inject.Provider
    public PackageItemPresenter get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
