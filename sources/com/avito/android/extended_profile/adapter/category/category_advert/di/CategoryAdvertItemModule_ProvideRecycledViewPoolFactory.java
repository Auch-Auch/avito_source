package com.avito.android.extended_profile.adapter.category.category_advert.di;

import androidx.recyclerview.widget.RecyclerView;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class CategoryAdvertItemModule_ProvideRecycledViewPoolFactory implements Factory<RecyclerView.RecycledViewPool> {

    public static final class a {
        public static final CategoryAdvertItemModule_ProvideRecycledViewPoolFactory a = new CategoryAdvertItemModule_ProvideRecycledViewPoolFactory();
    }

    public static CategoryAdvertItemModule_ProvideRecycledViewPoolFactory create() {
        return a.a;
    }

    public static RecyclerView.RecycledViewPool provideRecycledViewPool() {
        return (RecyclerView.RecycledViewPool) Preconditions.checkNotNullFromProvides(CategoryAdvertItemModule.INSTANCE.provideRecycledViewPool());
    }

    @Override // javax.inject.Provider
    public RecyclerView.RecycledViewPool get() {
        return provideRecycledViewPool();
    }
}
