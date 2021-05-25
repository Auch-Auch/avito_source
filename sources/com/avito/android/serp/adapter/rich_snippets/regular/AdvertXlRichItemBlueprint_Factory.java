package com.avito.android.serp.adapter.rich_snippets.regular;

import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.Features;
import com.avito.android.ab_tests.configs.SerpItemsPrefetchTestGroup;
import com.avito.android.serp.adapter.rich_snippets.SellerInfoParamsFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertXlRichItemBlueprint_Factory implements Factory<AdvertXlRichItemBlueprint> {
    public final Provider<AdvertXlRichItemPresenter> a;
    public final Provider<RecyclerView.RecycledViewPool> b;
    public final Provider<Features> c;
    public final Provider<SellerInfoParamsFactory> d;
    public final Provider<SerpItemsPrefetchTestGroup> e;

    public AdvertXlRichItemBlueprint_Factory(Provider<AdvertXlRichItemPresenter> provider, Provider<RecyclerView.RecycledViewPool> provider2, Provider<Features> provider3, Provider<SellerInfoParamsFactory> provider4, Provider<SerpItemsPrefetchTestGroup> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static AdvertXlRichItemBlueprint_Factory create(Provider<AdvertXlRichItemPresenter> provider, Provider<RecyclerView.RecycledViewPool> provider2, Provider<Features> provider3, Provider<SellerInfoParamsFactory> provider4, Provider<SerpItemsPrefetchTestGroup> provider5) {
        return new AdvertXlRichItemBlueprint_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static AdvertXlRichItemBlueprint newInstance(AdvertXlRichItemPresenter advertXlRichItemPresenter, RecyclerView.RecycledViewPool recycledViewPool, Features features, SellerInfoParamsFactory sellerInfoParamsFactory, SerpItemsPrefetchTestGroup serpItemsPrefetchTestGroup) {
        return new AdvertXlRichItemBlueprint(advertXlRichItemPresenter, recycledViewPool, features, sellerInfoParamsFactory, serpItemsPrefetchTestGroup);
    }

    @Override // javax.inject.Provider
    public AdvertXlRichItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
