package com.avito.android.blueprints.input;

import com.avito.android.blueprints.publish.html_editor.HtmlEditorViewModel;
import com.avito.android.html_formatter.HtmlRenderOptions;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MultiStateInputItemPresenterImpl_Factory implements Factory<MultiStateInputItemPresenterImpl> {
    public final Provider<AttributedTextFormatter> a;
    public final Provider<HtmlRenderOptions> b;
    public final Provider<HtmlEditorViewModel> c;

    public MultiStateInputItemPresenterImpl_Factory(Provider<AttributedTextFormatter> provider, Provider<HtmlRenderOptions> provider2, Provider<HtmlEditorViewModel> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MultiStateInputItemPresenterImpl_Factory create(Provider<AttributedTextFormatter> provider, Provider<HtmlRenderOptions> provider2, Provider<HtmlEditorViewModel> provider3) {
        return new MultiStateInputItemPresenterImpl_Factory(provider, provider2, provider3);
    }

    public static MultiStateInputItemPresenterImpl newInstance(AttributedTextFormatter attributedTextFormatter, HtmlRenderOptions htmlRenderOptions, HtmlEditorViewModel htmlEditorViewModel) {
        return new MultiStateInputItemPresenterImpl(attributedTextFormatter, htmlRenderOptions, htmlEditorViewModel);
    }

    @Override // javax.inject.Provider
    public MultiStateInputItemPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
