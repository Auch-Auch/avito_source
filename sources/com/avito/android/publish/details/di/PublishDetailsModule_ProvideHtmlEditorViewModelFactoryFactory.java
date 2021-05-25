package com.avito.android.publish.details.di;

import com.avito.android.blueprints.publish.html_editor.HtmlEditorViewModelFactory;
import com.avito.android.html_editor.EditorHistoryProvider;
import com.avito.android.html_formatter.HtmlNodeFactory;
import com.avito.android.html_formatter.HtmlRenderOptions;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishDetailsModule_ProvideHtmlEditorViewModelFactoryFactory implements Factory<HtmlEditorViewModelFactory> {
    public final PublishDetailsModule a;
    public final Provider<EditorHistoryProvider> b;
    public final Provider<HtmlNodeFactory> c;
    public final Provider<HtmlRenderOptions> d;

    public PublishDetailsModule_ProvideHtmlEditorViewModelFactoryFactory(PublishDetailsModule publishDetailsModule, Provider<EditorHistoryProvider> provider, Provider<HtmlNodeFactory> provider2, Provider<HtmlRenderOptions> provider3) {
        this.a = publishDetailsModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static PublishDetailsModule_ProvideHtmlEditorViewModelFactoryFactory create(PublishDetailsModule publishDetailsModule, Provider<EditorHistoryProvider> provider, Provider<HtmlNodeFactory> provider2, Provider<HtmlRenderOptions> provider3) {
        return new PublishDetailsModule_ProvideHtmlEditorViewModelFactoryFactory(publishDetailsModule, provider, provider2, provider3);
    }

    public static HtmlEditorViewModelFactory provideHtmlEditorViewModelFactory(PublishDetailsModule publishDetailsModule, EditorHistoryProvider editorHistoryProvider, HtmlNodeFactory htmlNodeFactory, HtmlRenderOptions htmlRenderOptions) {
        return (HtmlEditorViewModelFactory) Preconditions.checkNotNullFromProvides(publishDetailsModule.provideHtmlEditorViewModelFactory(editorHistoryProvider, htmlNodeFactory, htmlRenderOptions));
    }

    @Override // javax.inject.Provider
    public HtmlEditorViewModelFactory get() {
        return provideHtmlEditorViewModelFactory(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
