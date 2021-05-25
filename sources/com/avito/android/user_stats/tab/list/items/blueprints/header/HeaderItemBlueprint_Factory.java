package com.avito.android.user_stats.tab.list.items.blueprints.header;

import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class HeaderItemBlueprint_Factory implements Factory<HeaderItemBlueprint> {
    public final Provider<HeaderItemPresenter> a;
    public final Provider<AttributedTextFormatter> b;

    public HeaderItemBlueprint_Factory(Provider<HeaderItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static HeaderItemBlueprint_Factory create(Provider<HeaderItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        return new HeaderItemBlueprint_Factory(provider, provider2);
    }

    public static HeaderItemBlueprint newInstance(HeaderItemPresenter headerItemPresenter, AttributedTextFormatter attributedTextFormatter) {
        return new HeaderItemBlueprint(headerItemPresenter, attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public HeaderItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
