package com.avito.android.notification_center.list.item;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ErrorSnippetItemBlueprint_Factory implements Factory<ErrorSnippetItemBlueprint> {
    public final Provider<ErrorSnippetItemPresenter> a;

    public ErrorSnippetItemBlueprint_Factory(Provider<ErrorSnippetItemPresenter> provider) {
        this.a = provider;
    }

    public static ErrorSnippetItemBlueprint_Factory create(Provider<ErrorSnippetItemPresenter> provider) {
        return new ErrorSnippetItemBlueprint_Factory(provider);
    }

    public static ErrorSnippetItemBlueprint newInstance(ErrorSnippetItemPresenter errorSnippetItemPresenter) {
        return new ErrorSnippetItemBlueprint(errorSnippetItemPresenter);
    }

    @Override // javax.inject.Provider
    public ErrorSnippetItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
