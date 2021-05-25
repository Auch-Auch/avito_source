package com.avito.android.notification_center.landing.recommends.review_list.di;

import com.avito.android.notification_center.landing.recommends.review_list.item.NcRecommendsReviewListItemBlueprint;
import com.avito.android.notification_center.landing.recommends.review_list.title.NcRecommendsReviewListTitleBlueprint;
import com.avito.konveyor.ItemBinder;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class NcRecommendsReviewListModule_ProvideItemBinderFactory implements Factory<ItemBinder> {
    public final Provider<NcRecommendsReviewListItemBlueprint> a;
    public final Provider<NcRecommendsReviewListTitleBlueprint> b;

    public NcRecommendsReviewListModule_ProvideItemBinderFactory(Provider<NcRecommendsReviewListItemBlueprint> provider, Provider<NcRecommendsReviewListTitleBlueprint> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static NcRecommendsReviewListModule_ProvideItemBinderFactory create(Provider<NcRecommendsReviewListItemBlueprint> provider, Provider<NcRecommendsReviewListTitleBlueprint> provider2) {
        return new NcRecommendsReviewListModule_ProvideItemBinderFactory(provider, provider2);
    }

    public static ItemBinder provideItemBinder(NcRecommendsReviewListItemBlueprint ncRecommendsReviewListItemBlueprint, NcRecommendsReviewListTitleBlueprint ncRecommendsReviewListTitleBlueprint) {
        return (ItemBinder) Preconditions.checkNotNullFromProvides(NcRecommendsReviewListModule.provideItemBinder(ncRecommendsReviewListItemBlueprint, ncRecommendsReviewListTitleBlueprint));
    }

    @Override // javax.inject.Provider
    public ItemBinder get() {
        return provideItemBinder(this.a.get(), this.b.get());
    }
}
