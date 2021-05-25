package com.avito.android.brandspace.items.text;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class TextBlueprint_Factory implements Factory<TextBlueprint> {
    public final Provider<TextPresenter> a;

    public TextBlueprint_Factory(Provider<TextPresenter> provider) {
        this.a = provider;
    }

    public static TextBlueprint_Factory create(Provider<TextPresenter> provider) {
        return new TextBlueprint_Factory(provider);
    }

    public static TextBlueprint newInstance(TextPresenter textPresenter) {
        return new TextBlueprint(textPresenter);
    }

    @Override // javax.inject.Provider
    public TextBlueprint get() {
        return newInstance(this.a.get());
    }
}
