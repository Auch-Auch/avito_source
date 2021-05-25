package com.avito.android.cart.summary.konveyor.price;

import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PriceItemBlueprint_Factory implements Factory<PriceItemBlueprint> {
    public final Provider<PriceItemPresenter> a;
    public final Provider<AttributedTextFormatter> b;

    public PriceItemBlueprint_Factory(Provider<PriceItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static PriceItemBlueprint_Factory create(Provider<PriceItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        return new PriceItemBlueprint_Factory(provider, provider2);
    }

    public static PriceItemBlueprint newInstance(PriceItemPresenter priceItemPresenter, AttributedTextFormatter attributedTextFormatter) {
        return new PriceItemBlueprint(priceItemPresenter, attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public PriceItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
