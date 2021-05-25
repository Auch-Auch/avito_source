package com.avito.android.notification_center.landing.recommends.review_list.title;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class NcRecommendsReviewListTitleBlueprint_Factory implements Factory<NcRecommendsReviewListTitleBlueprint> {
    public final Provider<NcRecommendsReviewListTitlePresenter> a;

    public NcRecommendsReviewListTitleBlueprint_Factory(Provider<NcRecommendsReviewListTitlePresenter> provider) {
        this.a = provider;
    }

    public static NcRecommendsReviewListTitleBlueprint_Factory create(Provider<NcRecommendsReviewListTitlePresenter> provider) {
        return new NcRecommendsReviewListTitleBlueprint_Factory(provider);
    }

    public static NcRecommendsReviewListTitleBlueprint newInstance(NcRecommendsReviewListTitlePresenter ncRecommendsReviewListTitlePresenter) {
        return new NcRecommendsReviewListTitleBlueprint(ncRecommendsReviewListTitlePresenter);
    }

    @Override // javax.inject.Provider
    public NcRecommendsReviewListTitleBlueprint get() {
        return newInstance(this.a.get());
    }
}
