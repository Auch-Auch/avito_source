package com.avito.android.publish.details.di;

import com.avito.android.blueprints.publish.html_editor.HtmlEditorViewModel;
import com.avito.android.blueprints.publish.html_editor.HtmlEditorViewModelFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishDetailsModule_ProvideHtmlEditorViewModelFactory implements Factory<HtmlEditorViewModel> {
    public final PublishDetailsModule a;
    public final Provider<HtmlEditorViewModelFactory> b;

    public PublishDetailsModule_ProvideHtmlEditorViewModelFactory(PublishDetailsModule publishDetailsModule, Provider<HtmlEditorViewModelFactory> provider) {
        this.a = publishDetailsModule;
        this.b = provider;
    }

    public static PublishDetailsModule_ProvideHtmlEditorViewModelFactory create(PublishDetailsModule publishDetailsModule, Provider<HtmlEditorViewModelFactory> provider) {
        return new PublishDetailsModule_ProvideHtmlEditorViewModelFactory(publishDetailsModule, provider);
    }

    public static HtmlEditorViewModel provideHtmlEditorViewModel(PublishDetailsModule publishDetailsModule, HtmlEditorViewModelFactory htmlEditorViewModelFactory) {
        return (HtmlEditorViewModel) Preconditions.checkNotNullFromProvides(publishDetailsModule.provideHtmlEditorViewModel(htmlEditorViewModelFactory));
    }

    @Override // javax.inject.Provider
    public HtmlEditorViewModel get() {
        return provideHtmlEditorViewModel(this.a, this.b.get());
    }
}
