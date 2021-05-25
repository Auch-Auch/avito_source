package com.avito.android.delivery.summary.konveyor.shipment;

import dagger.internal.Factory;
public final class ShipmentItemPresenter_Factory implements Factory<ShipmentItemPresenter> {

    public static final class a {
        public static final ShipmentItemPresenter_Factory a = new ShipmentItemPresenter_Factory();
    }

    public static ShipmentItemPresenter_Factory create() {
        return a.a;
    }

    public static ShipmentItemPresenter newInstance() {
        return new ShipmentItemPresenter();
    }

    @Override // javax.inject.Provider
    public ShipmentItemPresenter get() {
        return newInstance();
    }
}
