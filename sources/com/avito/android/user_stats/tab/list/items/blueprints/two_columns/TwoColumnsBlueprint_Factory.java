package com.avito.android.user_stats.tab.list.items.blueprints.two_columns;

import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class TwoColumnsBlueprint_Factory implements Factory<TwoColumnsBlueprint> {
    public final Provider<TwoColumnsItemPresenter> a;
    public final Provider<AttributedTextFormatter> b;

    public TwoColumnsBlueprint_Factory(Provider<TwoColumnsItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static TwoColumnsBlueprint_Factory create(Provider<TwoColumnsItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        return new TwoColumnsBlueprint_Factory(provider, provider2);
    }

    public static TwoColumnsBlueprint newInstance(TwoColumnsItemPresenter twoColumnsItemPresenter, AttributedTextFormatter attributedTextFormatter) {
        return new TwoColumnsBlueprint(twoColumnsItemPresenter, attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public TwoColumnsBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
