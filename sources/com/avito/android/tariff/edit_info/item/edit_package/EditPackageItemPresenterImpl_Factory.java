package com.avito.android.tariff.edit_info.item.edit_package;

import dagger.internal.Factory;
public final class EditPackageItemPresenterImpl_Factory implements Factory<EditPackageItemPresenterImpl> {

    public static final class a {
        public static final EditPackageItemPresenterImpl_Factory a = new EditPackageItemPresenterImpl_Factory();
    }

    public static EditPackageItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static EditPackageItemPresenterImpl newInstance() {
        return new EditPackageItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public EditPackageItemPresenterImpl get() {
        return newInstance();
    }
}
