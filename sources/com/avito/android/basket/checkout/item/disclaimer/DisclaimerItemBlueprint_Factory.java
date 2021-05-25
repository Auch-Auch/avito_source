package com.avito.android.basket.checkout.item.disclaimer;

import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DisclaimerItemBlueprint_Factory implements Factory<DisclaimerItemBlueprint> {
    public final Provider<CheckoutDisclaimerItemPresenter> a;
    public final Provider<AttributedTextFormatter> b;

    public DisclaimerItemBlueprint_Factory(Provider<CheckoutDisclaimerItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static DisclaimerItemBlueprint_Factory create(Provider<CheckoutDisclaimerItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        return new DisclaimerItemBlueprint_Factory(provider, provider2);
    }

    public static DisclaimerItemBlueprint newInstance(CheckoutDisclaimerItemPresenter checkoutDisclaimerItemPresenter, AttributedTextFormatter attributedTextFormatter) {
        return new DisclaimerItemBlueprint(checkoutDisclaimerItemPresenter, attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public DisclaimerItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
