package com.avito.android.advert.item.description.di;

import android.content.res.Resources;
import com.avito.android.html_formatter.HtmlRenderOptions;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AdvertDetailsHtmlDescriptionModule_ProvideHtmlRenderOptionsFactory implements Factory<HtmlRenderOptions> {
    public final Provider<Resources> a;

    public AdvertDetailsHtmlDescriptionModule_ProvideHtmlRenderOptionsFactory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static AdvertDetailsHtmlDescriptionModule_ProvideHtmlRenderOptionsFactory create(Provider<Resources> provider) {
        return new AdvertDetailsHtmlDescriptionModule_ProvideHtmlRenderOptionsFactory(provider);
    }

    public static HtmlRenderOptions provideHtmlRenderOptions(Resources resources) {
        return (HtmlRenderOptions) Preconditions.checkNotNullFromProvides(AdvertDetailsHtmlDescriptionModule.INSTANCE.provideHtmlRenderOptions(resources));
    }

    @Override // javax.inject.Provider
    public HtmlRenderOptions get() {
        return provideHtmlRenderOptions(this.a.get());
    }
}
