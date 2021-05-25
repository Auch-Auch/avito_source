package com.avito.android.delivery.summary.konveyor.input;

import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class InputItemBlueprint_Factory implements Factory<InputItemBlueprint> {
    public final Provider<InputItemPresenter> a;
    public final Provider<AttributedTextFormatter> b;

    public InputItemBlueprint_Factory(Provider<InputItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static InputItemBlueprint_Factory create(Provider<InputItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        return new InputItemBlueprint_Factory(provider, provider2);
    }

    public static InputItemBlueprint newInstance(InputItemPresenter inputItemPresenter, AttributedTextFormatter attributedTextFormatter) {
        return new InputItemBlueprint(inputItemPresenter, attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public InputItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
