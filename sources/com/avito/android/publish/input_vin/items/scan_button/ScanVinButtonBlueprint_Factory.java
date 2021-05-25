package com.avito.android.publish.input_vin.items.scan_button;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ScanVinButtonBlueprint_Factory implements Factory<ScanVinButtonBlueprint> {
    public final Provider<ScanVinButtonItemPresenter> a;

    public ScanVinButtonBlueprint_Factory(Provider<ScanVinButtonItemPresenter> provider) {
        this.a = provider;
    }

    public static ScanVinButtonBlueprint_Factory create(Provider<ScanVinButtonItemPresenter> provider) {
        return new ScanVinButtonBlueprint_Factory(provider);
    }

    public static ScanVinButtonBlueprint newInstance(ScanVinButtonItemPresenter scanVinButtonItemPresenter) {
        return new ScanVinButtonBlueprint(scanVinButtonItemPresenter);
    }

    @Override // javax.inject.Provider
    public ScanVinButtonBlueprint get() {
        return newInstance(this.a.get());
    }
}
