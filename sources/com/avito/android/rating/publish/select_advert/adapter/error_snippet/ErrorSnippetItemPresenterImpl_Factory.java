package com.avito.android.rating.publish.select_advert.adapter.error_snippet;

import com.avito.android.rating.publish.select_advert.adapter.SelectAdvertAction;
import dagger.internal.Factory;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
public final class ErrorSnippetItemPresenterImpl_Factory implements Factory<ErrorSnippetItemPresenterImpl> {
    public final Provider<Consumer<SelectAdvertAction>> a;

    public ErrorSnippetItemPresenterImpl_Factory(Provider<Consumer<SelectAdvertAction>> provider) {
        this.a = provider;
    }

    public static ErrorSnippetItemPresenterImpl_Factory create(Provider<Consumer<SelectAdvertAction>> provider) {
        return new ErrorSnippetItemPresenterImpl_Factory(provider);
    }

    public static ErrorSnippetItemPresenterImpl newInstance(Consumer<SelectAdvertAction> consumer) {
        return new ErrorSnippetItemPresenterImpl(consumer);
    }

    @Override // javax.inject.Provider
    public ErrorSnippetItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
