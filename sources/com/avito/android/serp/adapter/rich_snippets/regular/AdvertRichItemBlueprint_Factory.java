package com.avito.android.serp.adapter.rich_snippets.regular;

import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.Features;
import com.avito.android.ab_tests.configs.SerpItemsPrefetchTestGroup;
import com.avito.android.serp.adapter.rich_snippets.SellerInfoParamsFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertRichItemBlueprint_Factory implements Factory<AdvertRichItemBlueprint> {
    public final Provider<AdvertRichItemPresenter> a;
    public final Provider<RecyclerView.RecycledViewPool> b;
    public final Provider<Features> c;
    public final Provider<SellerInfoParamsFactory> d;
    public final Provider<SerpItemsPrefetchTestGroup> e;

    public AdvertRichItemBlueprint_Factory(Provider<AdvertRichItemPresenter> provider, Provider<RecyclerView.RecycledViewPool> provider2, Provider<Features> provider3, Provider<SellerInfoParamsFactory> provider4, Provider<SerpItemsPrefetchTestGroup> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static AdvertRichItemBlueprint_Factory create(Provider<AdvertRichItemPresenter> provider, Provider<RecyclerView.RecycledViewPool> provider2, Provider<Features> provider3, Provider<SellerInfoParamsFactory> provider4, Provider<SerpItemsPrefetchTestGroup> provider5) {
        return new AdvertRichItemBlueprint_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static AdvertRichItemBlueprint newInstance(AdvertRichItemPresenter advertRichItemPresenter, RecyclerView.RecycledViewPool recycledViewPool, Features features, SellerInfoParamsFactory sellerInfoParamsFactory, SerpItemsPrefetchTestGroup serpItemsPrefetchTestGroup) {
        return new AdvertRichItemBlueprint(advertRichItemPresenter, recycledViewPool, features, sellerInfoParamsFactory, serpItemsPrefetchTestGroup);
    }

    @Override // javax.inject.Provider
    public AdvertRichItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
