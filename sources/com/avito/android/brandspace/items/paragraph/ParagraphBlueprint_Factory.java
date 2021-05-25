package com.avito.android.brandspace.items.paragraph;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ParagraphBlueprint_Factory implements Factory<ParagraphBlueprint> {
    public final Provider<ParagraphItemPresenter> a;

    public ParagraphBlueprint_Factory(Provider<ParagraphItemPresenter> provider) {
        this.a = provider;
    }

    public static ParagraphBlueprint_Factory create(Provider<ParagraphItemPresenter> provider) {
        return new ParagraphBlueprint_Factory(provider);
    }

    public static ParagraphBlueprint newInstance(ParagraphItemPresenter paragraphItemPresenter) {
        return new ParagraphBlueprint(paragraphItemPresenter);
    }

    @Override // javax.inject.Provider
    public ParagraphBlueprint get() {
        return newInstance(this.a.get());
    }
}
