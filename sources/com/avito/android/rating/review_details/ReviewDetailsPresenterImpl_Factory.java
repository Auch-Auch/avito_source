package com.avito.android.rating.review_details;

import com.avito.android.analytics.Analytics;
import com.avito.android.dialog.DialogPresenter;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.rating.review_details.upload.ReplyUploadPresenter;
import com.avito.android.rating.review_details.upload.ReviewReplyProvider;
import com.avito.android.ratings.ReviewData;
import com.avito.android.tns_gallery.TnsGalleryItemClickAction;
import com.avito.android.util.Kundle;
import dagger.internal.Factory;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Provider;
public final class ReviewDetailsPresenterImpl_Factory implements Factory<ReviewDetailsPresenterImpl> {
    public final Provider<ReviewData> a;
    public final Provider<ReplyUploadPresenter> b;
    public final Provider<ReviewReplyProvider> c;
    public final Provider<Observable<TnsGalleryItemClickAction>> d;
    public final Provider<DialogPresenter> e;
    public final Provider<ErrorHelper> f;
    public final Provider<Analytics> g;
    public final Provider<Kundle> h;

    public ReviewDetailsPresenterImpl_Factory(Provider<ReviewData> provider, Provider<ReplyUploadPresenter> provider2, Provider<ReviewReplyProvider> provider3, Provider<Observable<TnsGalleryItemClickAction>> provider4, Provider<DialogPresenter> provider5, Provider<ErrorHelper> provider6, Provider<Analytics> provider7, Provider<Kundle> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static ReviewDetailsPresenterImpl_Factory create(Provider<ReviewData> provider, Provider<ReplyUploadPresenter> provider2, Provider<ReviewReplyProvider> provider3, Provider<Observable<TnsGalleryItemClickAction>> provider4, Provider<DialogPresenter> provider5, Provider<ErrorHelper> provider6, Provider<Analytics> provider7, Provider<Kundle> provider8) {
        return new ReviewDetailsPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static ReviewDetailsPresenterImpl newInstance(ReviewData reviewData, ReplyUploadPresenter replyUploadPresenter, ReviewReplyProvider reviewReplyProvider, Observable<TnsGalleryItemClickAction> observable, DialogPresenter dialogPresenter, ErrorHelper errorHelper, Analytics analytics, Kundle kundle) {
        return new ReviewDetailsPresenterImpl(reviewData, replyUploadPresenter, reviewReplyProvider, observable, dialogPresenter, errorHelper, analytics, kundle);
    }

    @Override // javax.inject.Provider
    public ReviewDetailsPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
