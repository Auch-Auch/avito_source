package com.avito.android.category.di;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.category.CategoryArguments;
import com.avito.android.category.analytics.CategoryAnalyticsInteractor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CategoryModule_ProvideCategoryAnalyticsInteractorFactory implements Factory<CategoryAnalyticsInteractor> {
    public final Provider<Analytics> a;
    public final Provider<TreeStateIdGenerator> b;
    public final Provider<CategoryArguments> c;

    public CategoryModule_ProvideCategoryAnalyticsInteractorFactory(Provider<Analytics> provider, Provider<TreeStateIdGenerator> provider2, Provider<CategoryArguments> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static CategoryModule_ProvideCategoryAnalyticsInteractorFactory create(Provider<Analytics> provider, Provider<TreeStateIdGenerator> provider2, Provider<CategoryArguments> provider3) {
        return new CategoryModule_ProvideCategoryAnalyticsInteractorFactory(provider, provider2, provider3);
    }

    public static CategoryAnalyticsInteractor provideCategoryAnalyticsInteractor(Analytics analytics, TreeStateIdGenerator treeStateIdGenerator, CategoryArguments categoryArguments) {
        return (CategoryAnalyticsInteractor) Preconditions.checkNotNullFromProvides(CategoryModule.provideCategoryAnalyticsInteractor(analytics, treeStateIdGenerator, categoryArguments));
    }

    @Override // javax.inject.Provider
    public CategoryAnalyticsInteractor get() {
        return provideCategoryAnalyticsInteractor(this.a.get(), this.b.get(), this.c.get());
    }
}
