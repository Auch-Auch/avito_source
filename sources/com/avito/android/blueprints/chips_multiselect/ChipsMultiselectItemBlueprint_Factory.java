package com.avito.android.blueprints.chips_multiselect;

import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ChipsMultiselectItemBlueprint_Factory implements Factory<ChipsMultiselectItemBlueprint> {
    public final Provider<ChipsMultiselectItemPresenter> a;
    public final Provider<AttributedTextFormatter> b;

    public ChipsMultiselectItemBlueprint_Factory(Provider<ChipsMultiselectItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ChipsMultiselectItemBlueprint_Factory create(Provider<ChipsMultiselectItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        return new ChipsMultiselectItemBlueprint_Factory(provider, provider2);
    }

    public static ChipsMultiselectItemBlueprint newInstance(ChipsMultiselectItemPresenter chipsMultiselectItemPresenter, AttributedTextFormatter attributedTextFormatter) {
        return new ChipsMultiselectItemBlueprint(chipsMultiselectItemPresenter, attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public ChipsMultiselectItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
