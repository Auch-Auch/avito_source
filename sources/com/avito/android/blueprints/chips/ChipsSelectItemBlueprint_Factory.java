package com.avito.android.blueprints.chips;

import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ChipsSelectItemBlueprint_Factory implements Factory<ChipsSelectItemBlueprint> {
    public final Provider<ChipsSelectItemPresenter> a;
    public final Provider<AttributedTextFormatter> b;

    public ChipsSelectItemBlueprint_Factory(Provider<ChipsSelectItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ChipsSelectItemBlueprint_Factory create(Provider<ChipsSelectItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        return new ChipsSelectItemBlueprint_Factory(provider, provider2);
    }

    public static ChipsSelectItemBlueprint newInstance(ChipsSelectItemPresenter chipsSelectItemPresenter, AttributedTextFormatter attributedTextFormatter) {
        return new ChipsSelectItemBlueprint(chipsSelectItemPresenter, attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public ChipsSelectItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
