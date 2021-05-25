package com.avito.android.basket_legacy.item.disclaimer;

import com.avito.android.component.disclaimer.DisclaimerItemPresenter;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DisclaimerItemBlueprint_Factory implements Factory<DisclaimerItemBlueprint> {
    public final Provider<DisclaimerItemPresenter> a;
    public final Provider<AttributedTextFormatter> b;

    public DisclaimerItemBlueprint_Factory(Provider<DisclaimerItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static DisclaimerItemBlueprint_Factory create(Provider<DisclaimerItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        return new DisclaimerItemBlueprint_Factory(provider, provider2);
    }

    public static DisclaimerItemBlueprint newInstance(DisclaimerItemPresenter disclaimerItemPresenter, AttributedTextFormatter attributedTextFormatter) {
        return new DisclaimerItemBlueprint(disclaimerItemPresenter, attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public DisclaimerItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
