package com.avito.android.messenger.conversation.mvi.deeplinks.review;

import com.avito.android.analytics.Analytics;
import com.avito.android.util.Formatter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class RequestReviewLinkProcessorImpl_Factory implements Factory<RequestReviewLinkProcessorImpl> {
    public final Provider<RequestReviewInteractor> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<Analytics> c;
    public final Provider<Formatter<Throwable>> d;

    public RequestReviewLinkProcessorImpl_Factory(Provider<RequestReviewInteractor> provider, Provider<SchedulersFactory> provider2, Provider<Analytics> provider3, Provider<Formatter<Throwable>> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static RequestReviewLinkProcessorImpl_Factory create(Provider<RequestReviewInteractor> provider, Provider<SchedulersFactory> provider2, Provider<Analytics> provider3, Provider<Formatter<Throwable>> provider4) {
        return new RequestReviewLinkProcessorImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static RequestReviewLinkProcessorImpl newInstance(RequestReviewInteractor requestReviewInteractor, SchedulersFactory schedulersFactory, Analytics analytics, Formatter<Throwable> formatter) {
        return new RequestReviewLinkProcessorImpl(requestReviewInteractor, schedulersFactory, analytics, formatter);
    }

    @Override // javax.inject.Provider
    public RequestReviewLinkProcessorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
