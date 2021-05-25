package com.avito.android.brandspace.items.text_with_video;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class TextWithVideoBlueprint_Factory implements Factory<TextWithVideoBlueprint> {
    public final Provider<TextWithVideoPresenter> a;

    public TextWithVideoBlueprint_Factory(Provider<TextWithVideoPresenter> provider) {
        this.a = provider;
    }

    public static TextWithVideoBlueprint_Factory create(Provider<TextWithVideoPresenter> provider) {
        return new TextWithVideoBlueprint_Factory(provider);
    }

    public static TextWithVideoBlueprint newInstance(TextWithVideoPresenter textWithVideoPresenter) {
        return new TextWithVideoBlueprint(textWithVideoPresenter);
    }

    @Override // javax.inject.Provider
    public TextWithVideoBlueprint get() {
        return newInstance(this.a.get());
    }
}
