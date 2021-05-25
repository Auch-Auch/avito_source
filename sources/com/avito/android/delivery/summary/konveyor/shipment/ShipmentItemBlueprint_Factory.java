package com.avito.android.delivery.summary.konveyor.shipment;

import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShipmentItemBlueprint_Factory implements Factory<ShipmentItemBlueprint> {
    public final Provider<ShipmentItemPresenter> a;
    public final Provider<AttributedTextFormatter> b;

    public ShipmentItemBlueprint_Factory(Provider<ShipmentItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ShipmentItemBlueprint_Factory create(Provider<ShipmentItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        return new ShipmentItemBlueprint_Factory(provider, provider2);
    }

    public static ShipmentItemBlueprint newInstance(ShipmentItemPresenter shipmentItemPresenter, AttributedTextFormatter attributedTextFormatter) {
        return new ShipmentItemBlueprint(shipmentItemPresenter, attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public ShipmentItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
