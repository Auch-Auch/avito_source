package com.avito.android.delivery.summary.konveyor.link;

import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class LinkItemBlueprint_Factory implements Factory<LinkItemBlueprint> {
    public final Provider<LinkItemPresenter> a;
    public final Provider<AttributedTextFormatter> b;

    public LinkItemBlueprint_Factory(Provider<LinkItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static LinkItemBlueprint_Factory create(Provider<LinkItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        return new LinkItemBlueprint_Factory(provider, provider2);
    }

    public static LinkItemBlueprint newInstance(LinkItemPresenter linkItemPresenter, AttributedTextFormatter attributedTextFormatter) {
        return new LinkItemBlueprint(linkItemPresenter, attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public LinkItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
