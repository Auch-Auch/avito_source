package com.avito.android.validation;

import android.content.res.Resources;
import com.avito.android.html_formatter.HtmlRenderOptions;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ParametersListModule_ProvideHtmlRenderOptionsFactory implements Factory<HtmlRenderOptions> {
    public final ParametersListModule a;
    public final Provider<Resources> b;

    public ParametersListModule_ProvideHtmlRenderOptionsFactory(ParametersListModule parametersListModule, Provider<Resources> provider) {
        this.a = parametersListModule;
        this.b = provider;
    }

    public static ParametersListModule_ProvideHtmlRenderOptionsFactory create(ParametersListModule parametersListModule, Provider<Resources> provider) {
        return new ParametersListModule_ProvideHtmlRenderOptionsFactory(parametersListModule, provider);
    }

    public static HtmlRenderOptions provideHtmlRenderOptions(ParametersListModule parametersListModule, Resources resources) {
        return (HtmlRenderOptions) Preconditions.checkNotNullFromProvides(parametersListModule.provideHtmlRenderOptions(resources));
    }

    @Override // javax.inject.Provider
    public HtmlRenderOptions get() {
        return provideHtmlRenderOptions(this.a, this.b.get());
    }
}
