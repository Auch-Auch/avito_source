package com.avito.android.brandspace.items.text_with_image;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class TextWithImageBlueprint_Factory implements Factory<TextWithImageBlueprint> {
    public final Provider<TextWithImagePresenter> a;

    public TextWithImageBlueprint_Factory(Provider<TextWithImagePresenter> provider) {
        this.a = provider;
    }

    public static TextWithImageBlueprint_Factory create(Provider<TextWithImagePresenter> provider) {
        return new TextWithImageBlueprint_Factory(provider);
    }

    public static TextWithImageBlueprint newInstance(TextWithImagePresenter textWithImagePresenter) {
        return new TextWithImageBlueprint(textWithImagePresenter);
    }

    @Override // javax.inject.Provider
    public TextWithImageBlueprint get() {
        return newInstance(this.a.get());
    }
}
