package com.avito.android.publish.drafts.di;

import com.avito.android.remote.model.category_parameters.CategoryParametersConverter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class PublishDraftsModule_ProvideCategoryParametersConverterFactory implements Factory<CategoryParametersConverter> {

    public static final class a {
        public static final PublishDraftsModule_ProvideCategoryParametersConverterFactory a = new PublishDraftsModule_ProvideCategoryParametersConverterFactory();
    }

    public static PublishDraftsModule_ProvideCategoryParametersConverterFactory create() {
        return a.a;
    }

    public static CategoryParametersConverter provideCategoryParametersConverter() {
        return (CategoryParametersConverter) Preconditions.checkNotNullFromProvides(PublishDraftsModule.provideCategoryParametersConverter());
    }

    @Override // javax.inject.Provider
    public CategoryParametersConverter get() {
        return provideCategoryParametersConverter();
    }
}
