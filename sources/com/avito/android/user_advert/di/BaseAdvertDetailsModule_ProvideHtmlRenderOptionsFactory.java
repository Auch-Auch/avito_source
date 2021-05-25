package com.avito.android.user_advert.di;

import android.content.res.Resources;
import com.avito.android.html_formatter.HtmlRenderOptions;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class BaseAdvertDetailsModule_ProvideHtmlRenderOptionsFactory implements Factory<HtmlRenderOptions> {
    public final Provider<Resources> a;

    public BaseAdvertDetailsModule_ProvideHtmlRenderOptionsFactory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static BaseAdvertDetailsModule_ProvideHtmlRenderOptionsFactory create(Provider<Resources> provider) {
        return new BaseAdvertDetailsModule_ProvideHtmlRenderOptionsFactory(provider);
    }

    public static HtmlRenderOptions provideHtmlRenderOptions(Resources resources) {
        return (HtmlRenderOptions) Preconditions.checkNotNullFromProvides(BaseAdvertDetailsModule.INSTANCE.provideHtmlRenderOptions(resources));
    }

    @Override // javax.inject.Provider
    public HtmlRenderOptions get() {
        return provideHtmlRenderOptions(this.a.get());
    }
}
