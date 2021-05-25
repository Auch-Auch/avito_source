package com.avito.android.job.cv_packages.item;

import dagger.internal.Factory;
public final class PackagePresenter_Factory implements Factory<PackagePresenter> {

    public static final class a {
        public static final PackagePresenter_Factory a = new PackagePresenter_Factory();
    }

    public static PackagePresenter_Factory create() {
        return a.a;
    }

    public static PackagePresenter newInstance() {
        return new PackagePresenter();
    }

    @Override // javax.inject.Provider
    public PackagePresenter get() {
        return newInstance();
    }
}
