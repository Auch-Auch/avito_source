package com.avito.android.feedback_adverts;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class FeedbackAdvertsItemBluePrint_Factory implements Factory<FeedbackAdvertsItemBluePrint> {
    public final Provider<FeedbackAdvertsItemPresenter> a;

    public FeedbackAdvertsItemBluePrint_Factory(Provider<FeedbackAdvertsItemPresenter> provider) {
        this.a = provider;
    }

    public static FeedbackAdvertsItemBluePrint_Factory create(Provider<FeedbackAdvertsItemPresenter> provider) {
        return new FeedbackAdvertsItemBluePrint_Factory(provider);
    }

    public static FeedbackAdvertsItemBluePrint newInstance(FeedbackAdvertsItemPresenter feedbackAdvertsItemPresenter) {
        return new FeedbackAdvertsItemBluePrint(feedbackAdvertsItemPresenter);
    }

    @Override // javax.inject.Provider
    public FeedbackAdvertsItemBluePrint get() {
        return newInstance(this.a.get());
    }
}
