package com.avito.android.publish.input_vin.items.scan_button;

import dagger.internal.Factory;
public final class ScanVinButtonItemPresenterImpl_Factory implements Factory<ScanVinButtonItemPresenterImpl> {

    public static final class a {
        public static final ScanVinButtonItemPresenterImpl_Factory a = new ScanVinButtonItemPresenterImpl_Factory();
    }

    public static ScanVinButtonItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static ScanVinButtonItemPresenterImpl newInstance() {
        return new ScanVinButtonItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public ScanVinButtonItemPresenterImpl get() {
        return newInstance();
    }
}
