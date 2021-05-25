package com.avito.android.rating.details;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.dialog.DialogPresenter;
import com.avito.android.rating.details.adapter.RatingDetailsItem;
import com.avito.android.rating.details.adapter.loading.LoadingItemNextPageAction;
import com.avito.android.rating.review_details.upload.ReviewReplyProvider;
import com.avito.android.tns_gallery.TnsGalleryItemClickAction;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.Factory;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Provider;
public final class RatingDetailsPresenterImpl_Factory implements Factory<RatingDetailsPresenterImpl> {
    public final Provider<RatingDetailsInteractor> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<SchedulersFactory3> c;
    public final Provider<PublishRelay<RatingDetailsItem>> d;
    public final Provider<Observable<TnsGalleryItemClickAction>> e;
    public final Provider<ErrorFormatter> f;
    public final Provider<RatingDetailsConverter> g;
    public final Provider<DialogPresenter> h;
    public final Provider<ReviewReplyProvider> i;
    public final Provider<Features> j;
    public final Provider<Analytics> k;
    public final Provider<Observable<LoadingItemNextPageAction>> l;
    public final Provider<Kundle> m;

    public RatingDetailsPresenterImpl_Factory(Provider<RatingDetailsInteractor> provider, Provider<AdapterPresenter> provider2, Provider<SchedulersFactory3> provider3, Provider<PublishRelay<RatingDetailsItem>> provider4, Provider<Observable<TnsGalleryItemClickAction>> provider5, Provider<ErrorFormatter> provider6, Provider<RatingDetailsConverter> provider7, Provider<DialogPresenter> provider8, Provider<ReviewReplyProvider> provider9, Provider<Features> provider10, Provider<Analytics> provider11, Provider<Observable<LoadingItemNextPageAction>> provider12, Provider<Kundle> provider13) {
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
        this.l = provider12;
        this.m = provider13;
    }

    public static RatingDetailsPresenterImpl_Factory create(Provider<RatingDetailsInteractor> provider, Provider<AdapterPresenter> provider2, Provider<SchedulersFactory3> provider3, Provider<PublishRelay<RatingDetailsItem>> provider4, Provider<Observable<TnsGalleryItemClickAction>> provider5, Provider<ErrorFormatter> provider6, Provider<RatingDetailsConverter> provider7, Provider<DialogPresenter> provider8, Provider<ReviewReplyProvider> provider9, Provider<Features> provider10, Provider<Analytics> provider11, Provider<Observable<LoadingItemNextPageAction>> provider12, Provider<Kundle> provider13) {
        return new RatingDetailsPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13);
    }

    public static RatingDetailsPresenterImpl newInstance(RatingDetailsInteractor ratingDetailsInteractor, AdapterPresenter adapterPresenter, SchedulersFactory3 schedulersFactory3, PublishRelay<RatingDetailsItem> publishRelay, Observable<TnsGalleryItemClickAction> observable, ErrorFormatter errorFormatter, RatingDetailsConverter ratingDetailsConverter, DialogPresenter dialogPresenter, ReviewReplyProvider reviewReplyProvider, Features features, Analytics analytics, Observable<LoadingItemNextPageAction> observable2, Kundle kundle) {
        return new RatingDetailsPresenterImpl(ratingDetailsInteractor, adapterPresenter, schedulersFactory3, publishRelay, observable, errorFormatter, ratingDetailsConverter, dialogPresenter, reviewReplyProvider, features, analytics, observable2, kundle);
    }

    @Override // javax.inject.Provider
    public RatingDetailsPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get(), this.m.get());
    }
}
