package com.avito.android.feedback_adverts;

import arrow.core.Option;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FeedbackAdvertsPresenterImpl_Factory implements Factory<FeedbackAdvertsPresenterImpl> {
    public final Provider<FeedbackAdvertsInteractor> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<AdapterPresenter> c;
    public final Provider<Option<String>> d;
    public final Provider<String> e;
    public final Provider<FeedbackAdvertsPresenterState> f;

    public FeedbackAdvertsPresenterImpl_Factory(Provider<FeedbackAdvertsInteractor> provider, Provider<SchedulersFactory> provider2, Provider<AdapterPresenter> provider3, Provider<Option<String>> provider4, Provider<String> provider5, Provider<FeedbackAdvertsPresenterState> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static FeedbackAdvertsPresenterImpl_Factory create(Provider<FeedbackAdvertsInteractor> provider, Provider<SchedulersFactory> provider2, Provider<AdapterPresenter> provider3, Provider<Option<String>> provider4, Provider<String> provider5, Provider<FeedbackAdvertsPresenterState> provider6) {
        return new FeedbackAdvertsPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static FeedbackAdvertsPresenterImpl newInstance(FeedbackAdvertsInteractor feedbackAdvertsInteractor, SchedulersFactory schedulersFactory, AdapterPresenter adapterPresenter, Option<String> option, String str, FeedbackAdvertsPresenterState feedbackAdvertsPresenterState) {
        return new FeedbackAdvertsPresenterImpl(feedbackAdvertsInteractor, schedulersFactory, adapterPresenter, option, str, feedbackAdvertsPresenterState);
    }

    @Override // javax.inject.Provider
    public FeedbackAdvertsPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
