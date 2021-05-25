package com.avito.android.feedback_adverts;

import com.avito.android.feedback_adverts.FeedbackAdvertsItemPresenter;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FeedbackAdvertsItemPresenterImpl_Factory implements Factory<FeedbackAdvertsItemPresenterImpl> {
    public final Provider<FeedbackAdvertsItemPresenter.Listener> a;
    public final Provider<String> b;

    public FeedbackAdvertsItemPresenterImpl_Factory(Provider<FeedbackAdvertsItemPresenter.Listener> provider, Provider<String> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static FeedbackAdvertsItemPresenterImpl_Factory create(Provider<FeedbackAdvertsItemPresenter.Listener> provider, Provider<String> provider2) {
        return new FeedbackAdvertsItemPresenterImpl_Factory(provider, provider2);
    }

    public static FeedbackAdvertsItemPresenterImpl newInstance(Lazy<FeedbackAdvertsItemPresenter.Listener> lazy, String str) {
        return new FeedbackAdvertsItemPresenterImpl(lazy, str);
    }

    @Override // javax.inject.Provider
    public FeedbackAdvertsItemPresenterImpl get() {
        return newInstance(DoubleCheck.lazy(this.a), this.b.get());
    }
}
