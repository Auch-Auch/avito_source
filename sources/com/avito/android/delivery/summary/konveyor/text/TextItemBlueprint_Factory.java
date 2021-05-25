package com.avito.android.delivery.summary.konveyor.text;

import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class TextItemBlueprint_Factory implements Factory<TextItemBlueprint> {
    public final Provider<TextItemPresenter> a;
    public final Provider<AttributedTextFormatter> b;

    public TextItemBlueprint_Factory(Provider<TextItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static TextItemBlueprint_Factory create(Provider<TextItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        return new TextItemBlueprint_Factory(provider, provider2);
    }

    public static TextItemBlueprint newInstance(TextItemPresenter textItemPresenter, AttributedTextFormatter attributedTextFormatter) {
        return new TextItemBlueprint(textItemPresenter, attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public TextItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
