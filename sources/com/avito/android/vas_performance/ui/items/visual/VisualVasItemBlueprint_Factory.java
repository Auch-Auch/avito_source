package com.avito.android.vas_performance.ui.items.visual;

import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class VisualVasItemBlueprint_Factory implements Factory<VisualVasItemBlueprint> {
    public final Provider<VisualVasItemPresenter> a;
    public final Provider<AttributedTextFormatter> b;

    public VisualVasItemBlueprint_Factory(Provider<VisualVasItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static VisualVasItemBlueprint_Factory create(Provider<VisualVasItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        return new VisualVasItemBlueprint_Factory(provider, provider2);
    }

    public static VisualVasItemBlueprint newInstance(VisualVasItemPresenter visualVasItemPresenter, AttributedTextFormatter attributedTextFormatter) {
        return new VisualVasItemBlueprint(visualVasItemPresenter, attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public VisualVasItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
