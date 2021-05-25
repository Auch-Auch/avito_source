package com.avito.android.authorization.select_profile.adapter.text.di;

import com.avito.android.authorization.select_profile.adapter.text.TextItemPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class TextItemModule_ProvideBlueprint$authorization_releaseFactory implements Factory<ItemBlueprint<?, ?>> {
    public final TextItemModule a;
    public final Provider<TextItemPresenter> b;

    public TextItemModule_ProvideBlueprint$authorization_releaseFactory(TextItemModule textItemModule, Provider<TextItemPresenter> provider) {
        this.a = textItemModule;
        this.b = provider;
    }

    public static TextItemModule_ProvideBlueprint$authorization_releaseFactory create(TextItemModule textItemModule, Provider<TextItemPresenter> provider) {
        return new TextItemModule_ProvideBlueprint$authorization_releaseFactory(textItemModule, provider);
    }

    public static ItemBlueprint<?, ?> provideBlueprint$authorization_release(TextItemModule textItemModule, TextItemPresenter textItemPresenter) {
        return (ItemBlueprint) Preconditions.checkNotNullFromProvides(textItemModule.provideBlueprint$authorization_release(textItemPresenter));
    }

    @Override // javax.inject.Provider
    public ItemBlueprint<?, ?> get() {
        return provideBlueprint$authorization_release(this.a, this.b.get());
    }
}
