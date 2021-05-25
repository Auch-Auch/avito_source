package com.avito.android.rating.user_review_details;

import com.avito.android.analytics.Analytics;
import com.avito.android.dialog.DialogPresenter;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.tns_gallery.TnsGalleryItemClickAction;
import com.avito.android.user_review.UserReviewData;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Provider;
public final class UserReviewDetailsPresenterImpl_Factory implements Factory<UserReviewDetailsPresenterImpl> {
    public final Provider<UserReviewData> a;
    public final Provider<UserReviewDetailsInteractor> b;
    public final Provider<Observable<TnsGalleryItemClickAction>> c;
    public final Provider<DialogPresenter> d;
    public final Provider<ErrorHelper> e;
    public final Provider<SchedulersFactory3> f;
    public final Provider<Analytics> g;
    public final Provider<Kundle> h;

    public UserReviewDetailsPresenterImpl_Factory(Provider<UserReviewData> provider, Provider<UserReviewDetailsInteractor> provider2, Provider<Observable<TnsGalleryItemClickAction>> provider3, Provider<DialogPresenter> provider4, Provider<ErrorHelper> provider5, Provider<SchedulersFactory3> provider6, Provider<Analytics> provider7, Provider<Kundle> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static UserReviewDetailsPresenterImpl_Factory create(Provider<UserReviewData> provider, Provider<UserReviewDetailsInteractor> provider2, Provider<Observable<TnsGalleryItemClickAction>> provider3, Provider<DialogPresenter> provider4, Provider<ErrorHelper> provider5, Provider<SchedulersFactory3> provider6, Provider<Analytics> provider7, Provider<Kundle> provider8) {
        return new UserReviewDetailsPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static UserReviewDetailsPresenterImpl newInstance(UserReviewData userReviewData, UserReviewDetailsInteractor userReviewDetailsInteractor, Observable<TnsGalleryItemClickAction> observable, DialogPresenter dialogPresenter, ErrorHelper errorHelper, SchedulersFactory3 schedulersFactory3, Analytics analytics, Kundle kundle) {
        return new UserReviewDetailsPresenterImpl(userReviewData, userReviewDetailsInteractor, observable, dialogPresenter, errorHelper, schedulersFactory3, analytics, kundle);
    }

    @Override // javax.inject.Provider
    public UserReviewDetailsPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
