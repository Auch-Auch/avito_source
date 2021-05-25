package com.avito.android.rating.user_reviews;

import com.avito.android.analytics.Analytics;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.rating.details.adapter.RatingDetailsItem;
import com.avito.android.rating.details.adapter.loading.LoadingItemNextPageAction;
import com.avito.android.tns_gallery.TnsGalleryItemClickAction;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.Factory;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Provider;
public final class UserReviewsPresenterImpl_Factory implements Factory<UserReviewsPresenterImpl> {
    public final Provider<UserReviewsInteractor> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<PublishRelay<RatingDetailsItem>> c;
    public final Provider<Observable<TnsGalleryItemClickAction>> d;
    public final Provider<ReviewItemConverter> e;
    public final Provider<SchedulersFactory3> f;
    public final Provider<ErrorHelper> g;
    public final Provider<ItemToReviewDataConverter> h;
    public final Provider<Analytics> i;
    public final Provider<Observable<LoadingItemNextPageAction>> j;
    public final Provider<Kundle> k;

    public UserReviewsPresenterImpl_Factory(Provider<UserReviewsInteractor> provider, Provider<AdapterPresenter> provider2, Provider<PublishRelay<RatingDetailsItem>> provider3, Provider<Observable<TnsGalleryItemClickAction>> provider4, Provider<ReviewItemConverter> provider5, Provider<SchedulersFactory3> provider6, Provider<ErrorHelper> provider7, Provider<ItemToReviewDataConverter> provider8, Provider<Analytics> provider9, Provider<Observable<LoadingItemNextPageAction>> provider10, Provider<Kundle> provider11) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
        this.k = provider11;
    }

    public static UserReviewsPresenterImpl_Factory create(Provider<UserReviewsInteractor> provider, Provider<AdapterPresenter> provider2, Provider<PublishRelay<RatingDetailsItem>> provider3, Provider<Observable<TnsGalleryItemClickAction>> provider4, Provider<ReviewItemConverter> provider5, Provider<SchedulersFactory3> provider6, Provider<ErrorHelper> provider7, Provider<ItemToReviewDataConverter> provider8, Provider<Analytics> provider9, Provider<Observable<LoadingItemNextPageAction>> provider10, Provider<Kundle> provider11) {
        return new UserReviewsPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    public static UserReviewsPresenterImpl newInstance(UserReviewsInteractor userReviewsInteractor, AdapterPresenter adapterPresenter, PublishRelay<RatingDetailsItem> publishRelay, Observable<TnsGalleryItemClickAction> observable, ReviewItemConverter reviewItemConverter, SchedulersFactory3 schedulersFactory3, ErrorHelper errorHelper, ItemToReviewDataConverter itemToReviewDataConverter, Analytics analytics, Observable<LoadingItemNextPageAction> observable2, Kundle kundle) {
        return new UserReviewsPresenterImpl(userReviewsInteractor, adapterPresenter, publishRelay, observable, reviewItemConverter, schedulersFactory3, errorHelper, itemToReviewDataConverter, analytics, observable2, kundle);
    }

    @Override // javax.inject.Provider
    public UserReviewsPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get());
    }
}
