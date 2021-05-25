package com.avito.android.rating.publish.deal_stage;

import com.avito.android.dialog.DialogPresenter;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.rating.publish.RatingPublishViewData;
import com.avito.android.rating.publish.StepListener;
import com.avito.android.rating.publish.deal_stage.adapter.DealStageItem;
import com.avito.android.ratings.RatingPublishData;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Provider;
public final class DealStagePresenterImpl_Factory implements Factory<DealStagePresenterImpl> {
    public final Provider<StepListener> a;
    public final Provider<DealStageInteractor> b;
    public final Provider<AdapterPresenter> c;
    public final Provider<Observable<DealStageItem>> d;
    public final Provider<SchedulersFactory3> e;
    public final Provider<DialogPresenter> f;
    public final Provider<ErrorHelper> g;
    public final Provider<RatingPublishData> h;
    public final Provider<RatingPublishViewData> i;
    public final Provider<Kundle> j;

    public DealStagePresenterImpl_Factory(Provider<StepListener> provider, Provider<DealStageInteractor> provider2, Provider<AdapterPresenter> provider3, Provider<Observable<DealStageItem>> provider4, Provider<SchedulersFactory3> provider5, Provider<DialogPresenter> provider6, Provider<ErrorHelper> provider7, Provider<RatingPublishData> provider8, Provider<RatingPublishViewData> provider9, Provider<Kundle> provider10) {
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
    }

    public static DealStagePresenterImpl_Factory create(Provider<StepListener> provider, Provider<DealStageInteractor> provider2, Provider<AdapterPresenter> provider3, Provider<Observable<DealStageItem>> provider4, Provider<SchedulersFactory3> provider5, Provider<DialogPresenter> provider6, Provider<ErrorHelper> provider7, Provider<RatingPublishData> provider8, Provider<RatingPublishViewData> provider9, Provider<Kundle> provider10) {
        return new DealStagePresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static DealStagePresenterImpl newInstance(StepListener stepListener, DealStageInteractor dealStageInteractor, AdapterPresenter adapterPresenter, Observable<DealStageItem> observable, SchedulersFactory3 schedulersFactory3, DialogPresenter dialogPresenter, ErrorHelper errorHelper, RatingPublishData ratingPublishData, RatingPublishViewData ratingPublishViewData, Kundle kundle) {
        return new DealStagePresenterImpl(stepListener, dealStageInteractor, adapterPresenter, observable, schedulersFactory3, dialogPresenter, errorHelper, ratingPublishData, ratingPublishViewData, kundle);
    }

    @Override // javax.inject.Provider
    public DealStagePresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get());
    }
}
