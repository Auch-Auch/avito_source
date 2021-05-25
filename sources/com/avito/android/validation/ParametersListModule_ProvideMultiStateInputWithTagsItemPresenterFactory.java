package com.avito.android.validation;

import com.avito.android.blueprints.publish.html_editor.HtmlEditorViewModel;
import com.avito.android.blueprints.publish.tagged_input.MultiStateInputWithTagsItemPresenter;
import com.avito.android.html_formatter.HtmlRenderOptions;
import com.avito.android.ui.widget.tagged_input.TagsViewModel;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ParametersListModule_ProvideMultiStateInputWithTagsItemPresenterFactory implements Factory<MultiStateInputWithTagsItemPresenter> {
    public final ParametersListModule a;
    public final Provider<TagsViewModel> b;
    public final Provider<AttributedTextFormatter> c;
    public final Provider<HtmlRenderOptions> d;
    public final Provider<HtmlEditorViewModel> e;

    public ParametersListModule_ProvideMultiStateInputWithTagsItemPresenterFactory(ParametersListModule parametersListModule, Provider<TagsViewModel> provider, Provider<AttributedTextFormatter> provider2, Provider<HtmlRenderOptions> provider3, Provider<HtmlEditorViewModel> provider4) {
        this.a = parametersListModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
    }

    public static ParametersListModule_ProvideMultiStateInputWithTagsItemPresenterFactory create(ParametersListModule parametersListModule, Provider<TagsViewModel> provider, Provider<AttributedTextFormatter> provider2, Provider<HtmlRenderOptions> provider3, Provider<HtmlEditorViewModel> provider4) {
        return new ParametersListModule_ProvideMultiStateInputWithTagsItemPresenterFactory(parametersListModule, provider, provider2, provider3, provider4);
    }

    public static MultiStateInputWithTagsItemPresenter provideMultiStateInputWithTagsItemPresenter(ParametersListModule parametersListModule, TagsViewModel tagsViewModel, AttributedTextFormatter attributedTextFormatter, HtmlRenderOptions htmlRenderOptions, HtmlEditorViewModel htmlEditorViewModel) {
        return (MultiStateInputWithTagsItemPresenter) Preconditions.checkNotNullFromProvides(parametersListModule.provideMultiStateInputWithTagsItemPresenter(tagsViewModel, attributedTextFormatter, htmlRenderOptions, htmlEditorViewModel));
    }

    @Override // javax.inject.Provider
    public MultiStateInputWithTagsItemPresenter get() {
        return provideMultiStateInputWithTagsItemPresenter(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
