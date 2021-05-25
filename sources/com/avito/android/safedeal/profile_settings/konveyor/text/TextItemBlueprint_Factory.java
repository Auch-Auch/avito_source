package com.avito.android.safedeal.profile_settings.konveyor.text;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class TextItemBlueprint_Factory implements Factory<TextItemBlueprint> {
    public final Provider<TextItemPresenter> a;

    public TextItemBlueprint_Factory(Provider<TextItemPresenter> provider) {
        this.a = provider;
    }

    public static TextItemBlueprint_Factory create(Provider<TextItemPresenter> provider) {
        return new TextItemBlueprint_Factory(provider);
    }

    public static TextItemBlueprint newInstance(TextItemPresenter textItemPresenter) {
        return new TextItemBlueprint(textItemPresenter);
    }

    @Override // javax.inject.Provider
    public TextItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
