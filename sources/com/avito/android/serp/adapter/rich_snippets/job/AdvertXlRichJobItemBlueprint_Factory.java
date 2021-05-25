package com.avito.android.serp.adapter.rich_snippets.job;

import androidx.recyclerview.widget.RecyclerView;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertXlRichJobItemBlueprint_Factory implements Factory<AdvertXlRichJobItemBlueprint> {
    public final Provider<AdvertXlRichJobItemPresenter> a;
    public final Provider<RecyclerView.RecycledViewPool> b;

    public AdvertXlRichJobItemBlueprint_Factory(Provider<AdvertXlRichJobItemPresenter> provider, Provider<RecyclerView.RecycledViewPool> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AdvertXlRichJobItemBlueprint_Factory create(Provider<AdvertXlRichJobItemPresenter> provider, Provider<RecyclerView.RecycledViewPool> provider2) {
        return new AdvertXlRichJobItemBlueprint_Factory(provider, provider2);
    }

    public static AdvertXlRichJobItemBlueprint newInstance(AdvertXlRichJobItemPresenter advertXlRichJobItemPresenter, RecyclerView.RecycledViewPool recycledViewPool) {
        return new AdvertXlRichJobItemBlueprint(advertXlRichJobItemPresenter, recycledViewPool);
    }

    @Override // javax.inject.Provider
    public AdvertXlRichJobItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
