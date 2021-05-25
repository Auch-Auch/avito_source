package com.avito.android.rating.publish.radio_select;

import com.avito.android.rating.publish.RatingPublishViewData;
import com.avito.android.rating.publish.StepListener;
import com.avito.android.rating.publish.radio_select.adapter.radio_select.RadioSelectItem;
import com.avito.android.ratings.RatingPublishData;
import com.avito.android.remote.model.publish.NextStagePayload;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Provider;
public final class RadioSelectPresenterImpl_Factory implements Factory<RadioSelectPresenterImpl> {
    public final Provider<StepListener> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<Observable<RadioSelectItem>> c;
    public final Provider<SchedulersFactory3> d;
    public final Provider<RatingPublishData> e;
    public final Provider<RatingPublishViewData> f;
    public final Provider<NextStagePayload> g;
    public final Provider<Kundle> h;

    public RadioSelectPresenterImpl_Factory(Provider<StepListener> provider, Provider<AdapterPresenter> provider2, Provider<Observable<RadioSelectItem>> provider3, Provider<SchedulersFactory3> provider4, Provider<RatingPublishData> provider5, Provider<RatingPublishViewData> provider6, Provider<NextStagePayload> provider7, Provider<Kundle> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static RadioSelectPresenterImpl_Factory create(Provider<StepListener> provider, Provider<AdapterPresenter> provider2, Provider<Observable<RadioSelectItem>> provider3, Provider<SchedulersFactory3> provider4, Provider<RatingPublishData> provider5, Provider<RatingPublishViewData> provider6, Provider<NextStagePayload> provider7, Provider<Kundle> provider8) {
        return new RadioSelectPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static RadioSelectPresenterImpl newInstance(StepListener stepListener, AdapterPresenter adapterPresenter, Observable<RadioSelectItem> observable, SchedulersFactory3 schedulersFactory3, RatingPublishData ratingPublishData, RatingPublishViewData ratingPublishViewData, NextStagePayload nextStagePayload, Kundle kundle) {
        return new RadioSelectPresenterImpl(stepListener, adapterPresenter, observable, schedulersFactory3, ratingPublishData, ratingPublishViewData, nextStagePayload, kundle);
    }

    @Override // javax.inject.Provider
    public RadioSelectPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
