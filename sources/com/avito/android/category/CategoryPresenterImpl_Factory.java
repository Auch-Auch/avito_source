package com.avito.android.category;

import android.content.res.Resources;
import com.avito.android.category.analytics.CategoryAnalyticsInteractor;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CategoryPresenterImpl_Factory implements Factory<CategoryPresenterImpl> {
    public final Provider<CategoryArguments> a;
    public final Provider<Resources> b;
    public final Provider<CategoryInteractor> c;
    public final Provider<CategoryAnalyticsInteractor> d;
    public final Provider<SchedulersFactory3> e;
    public final Provider<CategoryPresenterState> f;

    public CategoryPresenterImpl_Factory(Provider<CategoryArguments> provider, Provider<Resources> provider2, Provider<CategoryInteractor> provider3, Provider<CategoryAnalyticsInteractor> provider4, Provider<SchedulersFactory3> provider5, Provider<CategoryPresenterState> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static CategoryPresenterImpl_Factory create(Provider<CategoryArguments> provider, Provider<Resources> provider2, Provider<CategoryInteractor> provider3, Provider<CategoryAnalyticsInteractor> provider4, Provider<SchedulersFactory3> provider5, Provider<CategoryPresenterState> provider6) {
        return new CategoryPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static CategoryPresenterImpl newInstance(CategoryArguments categoryArguments, Resources resources, CategoryInteractor categoryInteractor, CategoryAnalyticsInteractor categoryAnalyticsInteractor, SchedulersFactory3 schedulersFactory3, CategoryPresenterState categoryPresenterState) {
        return new CategoryPresenterImpl(categoryArguments, resources, categoryInteractor, categoryAnalyticsInteractor, schedulersFactory3, categoryPresenterState);
    }

    @Override // javax.inject.Provider
    public CategoryPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
