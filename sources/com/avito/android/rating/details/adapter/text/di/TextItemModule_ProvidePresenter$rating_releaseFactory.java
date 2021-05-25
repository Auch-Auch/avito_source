package com.avito.android.rating.details.adapter.text.di;

import com.avito.android.rating.details.adapter.text.TextItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class TextItemModule_ProvidePresenter$rating_releaseFactory implements Factory<TextItemPresenter> {

    public static final class a {
        public static final TextItemModule_ProvidePresenter$rating_releaseFactory a = new TextItemModule_ProvidePresenter$rating_releaseFactory();
    }

    public static TextItemModule_ProvidePresenter$rating_releaseFactory create() {
        return a.a;
    }

    public static TextItemPresenter providePresenter$rating_release() {
        return (TextItemPresenter) Preconditions.checkNotNullFromProvides(TextItemModule.providePresenter$rating_release());
    }

    @Override // javax.inject.Provider
    public TextItemPresenter get() {
        return providePresenter$rating_release();
    }
}
