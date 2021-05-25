package com.avito.android.rating.details.adapter.error_snippet.di;

import com.avito.android.rating.details.adapter.error_snippet.ErrorSnippetItemPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ErrorSnippetItemModule_ProvideBlueprint$rating_releaseFactory implements Factory<ItemBlueprint<?, ?>> {
    public final Provider<ErrorSnippetItemPresenter> a;

    public ErrorSnippetItemModule_ProvideBlueprint$rating_releaseFactory(Provider<ErrorSnippetItemPresenter> provider) {
        this.a = provider;
    }

    public static ErrorSnippetItemModule_ProvideBlueprint$rating_releaseFactory create(Provider<ErrorSnippetItemPresenter> provider) {
        return new ErrorSnippetItemModule_ProvideBlueprint$rating_releaseFactory(provider);
    }

    public static ItemBlueprint<?, ?> provideBlueprint$rating_release(ErrorSnippetItemPresenter errorSnippetItemPresenter) {
        return (ItemBlueprint) Preconditions.checkNotNullFromProvides(ErrorSnippetItemModule.provideBlueprint$rating_release(errorSnippetItemPresenter));
    }

    @Override // javax.inject.Provider
    public ItemBlueprint<?, ?> get() {
        return provideBlueprint$rating_release(this.a.get());
    }
}
