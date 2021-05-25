package com.avito.android.di.module;

import com.avito.android.serp.adapter.title.GroupTitleItemConverter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class SerpItemConverterModule_ProvideGroupTitleItemConverterFactory implements Factory<GroupTitleItemConverter> {

    public static final class a {
        public static final SerpItemConverterModule_ProvideGroupTitleItemConverterFactory a = new SerpItemConverterModule_ProvideGroupTitleItemConverterFactory();
    }

    public static SerpItemConverterModule_ProvideGroupTitleItemConverterFactory create() {
        return a.a;
    }

    public static GroupTitleItemConverter provideGroupTitleItemConverter() {
        return (GroupTitleItemConverter) Preconditions.checkNotNullFromProvides(SerpItemConverterModule.provideGroupTitleItemConverter());
    }

    @Override // javax.inject.Provider
    public GroupTitleItemConverter get() {
        return provideGroupTitleItemConverter();
    }
}
