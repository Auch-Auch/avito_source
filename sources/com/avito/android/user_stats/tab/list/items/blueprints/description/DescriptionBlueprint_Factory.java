package com.avito.android.user_stats.tab.list.items.blueprints.description;

import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DescriptionBlueprint_Factory implements Factory<DescriptionBlueprint> {
    public final Provider<DescriptionItemPresenter> a;
    public final Provider<AttributedTextFormatter> b;

    public DescriptionBlueprint_Factory(Provider<DescriptionItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static DescriptionBlueprint_Factory create(Provider<DescriptionItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        return new DescriptionBlueprint_Factory(provider, provider2);
    }

    public static DescriptionBlueprint newInstance(DescriptionItemPresenter descriptionItemPresenter, AttributedTextFormatter attributedTextFormatter) {
        return new DescriptionBlueprint(descriptionItemPresenter, attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public DescriptionBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
