package com.avito.android.notification_center.landing.recommends.review;

import com.avito.android.util.DialogRouter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class NcRecommendsReviewFragment_MembersInjector implements MembersInjector<NcRecommendsReviewFragment> {
    public final Provider<DialogRouter> a;
    public final Provider<NcRecommendsReviewPresenter> b;

    public NcRecommendsReviewFragment_MembersInjector(Provider<DialogRouter> provider, Provider<NcRecommendsReviewPresenter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MembersInjector<NcRecommendsReviewFragment> create(Provider<DialogRouter> provider, Provider<NcRecommendsReviewPresenter> provider2) {
        return new NcRecommendsReviewFragment_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.avito.android.notification_center.landing.recommends.review.NcRecommendsReviewFragment.dialogRouter")
    public static void injectDialogRouter(NcRecommendsReviewFragment ncRecommendsReviewFragment, DialogRouter dialogRouter) {
        ncRecommendsReviewFragment.dialogRouter = dialogRouter;
    }

    @InjectedFieldSignature("com.avito.android.notification_center.landing.recommends.review.NcRecommendsReviewFragment.presenter")
    public static void injectPresenter(NcRecommendsReviewFragment ncRecommendsReviewFragment, NcRecommendsReviewPresenter ncRecommendsReviewPresenter) {
        ncRecommendsReviewFragment.presenter = ncRecommendsReviewPresenter;
    }

    public void injectMembers(NcRecommendsReviewFragment ncRecommendsReviewFragment) {
        injectDialogRouter(ncRecommendsReviewFragment, this.a.get());
        injectPresenter(ncRecommendsReviewFragment, this.b.get());
    }
}
