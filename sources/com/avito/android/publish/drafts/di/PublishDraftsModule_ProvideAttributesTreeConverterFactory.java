package com.avito.android.publish.drafts.di;

import com.avito.android.remote.model.category_parameters.AttributesTreeConverter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class PublishDraftsModule_ProvideAttributesTreeConverterFactory implements Factory<AttributesTreeConverter> {

    public static final class a {
        public static final PublishDraftsModule_ProvideAttributesTreeConverterFactory a = new PublishDraftsModule_ProvideAttributesTreeConverterFactory();
    }

    public static PublishDraftsModule_ProvideAttributesTreeConverterFactory create() {
        return a.a;
    }

    public static AttributesTreeConverter provideAttributesTreeConverter() {
        return (AttributesTreeConverter) Preconditions.checkNotNullFromProvides(PublishDraftsModule.provideAttributesTreeConverter());
    }

    @Override // javax.inject.Provider
    public AttributesTreeConverter get() {
        return provideAttributesTreeConverter();
    }
}
