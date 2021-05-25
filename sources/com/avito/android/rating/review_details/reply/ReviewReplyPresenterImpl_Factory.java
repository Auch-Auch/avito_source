package com.avito.android.rating.review_details.reply;

import com.avito.android.dialog.DialogPresenter;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.rating.review_details.upload.ReplyUploadPresenter;
import com.avito.android.rating.review_details.upload.ReviewReplyProvider;
import com.avito.android.ratings.ReviewData;
import com.avito.android.util.Kundle;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ReviewReplyPresenterImpl_Factory implements Factory<ReviewReplyPresenterImpl> {
    public final Provider<ReviewData> a;
    public final Provider<ReplyUploadPresenter> b;
    public final Provider<ReviewReplyProvider> c;
    public final Provider<DialogPresenter> d;
    public final Provider<ErrorHelper> e;
    public final Provider<Kundle> f;

    public ReviewReplyPresenterImpl_Factory(Provider<ReviewData> provider, Provider<ReplyUploadPresenter> provider2, Provider<ReviewReplyProvider> provider3, Provider<DialogPresenter> provider4, Provider<ErrorHelper> provider5, Provider<Kundle> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static ReviewReplyPresenterImpl_Factory create(Provider<ReviewData> provider, Provider<ReplyUploadPresenter> provider2, Provider<ReviewReplyProvider> provider3, Provider<DialogPresenter> provider4, Provider<ErrorHelper> provider5, Provider<Kundle> provider6) {
        return new ReviewReplyPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static ReviewReplyPresenterImpl newInstance(ReviewData reviewData, ReplyUploadPresenter replyUploadPresenter, ReviewReplyProvider reviewReplyProvider, DialogPresenter dialogPresenter, ErrorHelper errorHelper, Kundle kundle) {
        return new ReviewReplyPresenterImpl(reviewData, replyUploadPresenter, reviewReplyProvider, dialogPresenter, errorHelper, kundle);
    }

    @Override // javax.inject.Provider
    public ReviewReplyPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
