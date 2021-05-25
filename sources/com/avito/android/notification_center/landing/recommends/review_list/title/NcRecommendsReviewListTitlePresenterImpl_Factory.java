package com.avito.android.notification_center.landing.recommends.review_list.title;

import dagger.internal.Factory;
public final class NcRecommendsReviewListTitlePresenterImpl_Factory implements Factory<NcRecommendsReviewListTitlePresenterImpl> {

    public static final class a {
        public static final NcRecommendsReviewListTitlePresenterImpl_Factory a = new NcRecommendsReviewListTitlePresenterImpl_Factory();
    }

    public static NcRecommendsReviewListTitlePresenterImpl_Factory create() {
        return a.a;
    }

    public static NcRecommendsReviewListTitlePresenterImpl newInstance() {
        return new NcRecommendsReviewListTitlePresenterImpl();
    }

    @Override // javax.inject.Provider
    public NcRecommendsReviewListTitlePresenterImpl get() {
        return newInstance();
    }
}
