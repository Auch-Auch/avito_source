package com.avito.android.authorization.select_profile.adapter.text.di;

import com.avito.android.authorization.select_profile.adapter.text.TextItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class TextItemModule_ProvidePresenter$authorization_releaseFactory implements Factory<TextItemPresenter> {
    public final TextItemModule a;

    public TextItemModule_ProvidePresenter$authorization_releaseFactory(TextItemModule textItemModule) {
        this.a = textItemModule;
    }

    public static TextItemModule_ProvidePresenter$authorization_releaseFactory create(TextItemModule textItemModule) {
        return new TextItemModule_ProvidePresenter$authorization_releaseFactory(textItemModule);
    }

    public static TextItemPresenter providePresenter$authorization_release(TextItemModule textItemModule) {
        return (TextItemPresenter) Preconditions.checkNotNullFromProvides(textItemModule.providePresenter$authorization_release());
    }

    @Override // javax.inject.Provider
    public TextItemPresenter get() {
        return providePresenter$authorization_release(this.a);
    }
}
