package com.avito.android.publish.slots.infomation.item;

import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DisclaimerBlueprint_Factory implements Factory<DisclaimerBlueprint> {
    public final Provider<DisclaimerItemPresenter> a;
    public final Provider<AttributedTextFormatter> b;

    public DisclaimerBlueprint_Factory(Provider<DisclaimerItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static DisclaimerBlueprint_Factory create(Provider<DisclaimerItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        return new DisclaimerBlueprint_Factory(provider, provider2);
    }

    public static DisclaimerBlueprint newInstance(DisclaimerItemPresenter disclaimerItemPresenter, AttributedTextFormatter attributedTextFormatter) {
        return new DisclaimerBlueprint(disclaimerItemPresenter, attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public DisclaimerBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
