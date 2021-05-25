package com.avito.android.notification_center.landing.recommends.review_list.item;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class NcRecommendsReviewListItemBlueprint_Factory implements Factory<NcRecommendsReviewListItemBlueprint> {
    public final Provider<NcRecommendsReviewListItemPresenter> a;

    public NcRecommendsReviewListItemBlueprint_Factory(Provider<NcRecommendsReviewListItemPresenter> provider) {
        this.a = provider;
    }

    public static NcRecommendsReviewListItemBlueprint_Factory create(Provider<NcRecommendsReviewListItemPresenter> provider) {
        return new NcRecommendsReviewListItemBlueprint_Factory(provider);
    }

    public static NcRecommendsReviewListItemBlueprint newInstance(NcRecommendsReviewListItemPresenter ncRecommendsReviewListItemPresenter) {
        return new NcRecommendsReviewListItemBlueprint(ncRecommendsReviewListItemPresenter);
    }

    @Override // javax.inject.Provider
    public NcRecommendsReviewListItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
