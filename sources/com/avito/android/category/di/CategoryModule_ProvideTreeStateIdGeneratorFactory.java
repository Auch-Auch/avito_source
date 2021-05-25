package com.avito.android.category.di;

import com.avito.android.analytics.provider.TreeStateIdGenerator;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class CategoryModule_ProvideTreeStateIdGeneratorFactory implements Factory<TreeStateIdGenerator> {

    public static final class a {
        public static final CategoryModule_ProvideTreeStateIdGeneratorFactory a = new CategoryModule_ProvideTreeStateIdGeneratorFactory();
    }

    public static CategoryModule_ProvideTreeStateIdGeneratorFactory create() {
        return a.a;
    }

    public static TreeStateIdGenerator provideTreeStateIdGenerator() {
        return (TreeStateIdGenerator) Preconditions.checkNotNullFromProvides(CategoryModule.provideTreeStateIdGenerator());
    }

    @Override // javax.inject.Provider
    public TreeStateIdGenerator get() {
        return provideTreeStateIdGenerator();
    }
}
