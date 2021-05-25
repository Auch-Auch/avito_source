package com.avito.android.validation;

import com.avito.android.blueprints.input.MultiStateInputItemPresenter;
import com.avito.android.blueprints.publish.html_editor.HtmlEditorViewModel;
import com.avito.android.html_formatter.HtmlRenderOptions;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ParametersListModule_ProvideInputItemPresenterFactory implements Factory<MultiStateInputItemPresenter> {
    public final ParametersListModule a;
    public final Provider<AttributedTextFormatter> b;
    public final Provider<HtmlRenderOptions> c;
    public final Provider<HtmlEditorViewModel> d;

    public ParametersListModule_ProvideInputItemPresenterFactory(ParametersListModule parametersListModule, Provider<AttributedTextFormatter> provider, Provider<HtmlRenderOptions> provider2, Provider<HtmlEditorViewModel> provider3) {
        this.a = parametersListModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static ParametersListModule_ProvideInputItemPresenterFactory create(ParametersListModule parametersListModule, Provider<AttributedTextFormatter> provider, Provider<HtmlRenderOptions> provider2, Provider<HtmlEditorViewModel> provider3) {
        return new ParametersListModule_ProvideInputItemPresenterFactory(parametersListModule, provider, provider2, provider3);
    }

    public static MultiStateInputItemPresenter provideInputItemPresenter(ParametersListModule parametersListModule, AttributedTextFormatter attributedTextFormatter, HtmlRenderOptions htmlRenderOptions, HtmlEditorViewModel htmlEditorViewModel) {
        return (MultiStateInputItemPresenter) Preconditions.checkNotNullFromProvides(parametersListModule.provideInputItemPresenter(attributedTextFormatter, htmlRenderOptions, htmlEditorViewModel));
    }

    @Override // javax.inject.Provider
    public MultiStateInputItemPresenter get() {
        return provideInputItemPresenter(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
