package com.avito.android.messenger.conversation.mvi.deeplinks.review;

import dagger.internal.Factory;
public final class RequestReviewLinkProcessorListenerImpl_Factory implements Factory<RequestReviewLinkProcessorListenerImpl> {

    public static final class a {
        public static final RequestReviewLinkProcessorListenerImpl_Factory a = new RequestReviewLinkProcessorListenerImpl_Factory();
    }

    public static RequestReviewLinkProcessorListenerImpl_Factory create() {
        return a.a;
    }

    public static RequestReviewLinkProcessorListenerImpl newInstance() {
        return new RequestReviewLinkProcessorListenerImpl();
    }

    @Override // javax.inject.Provider
    public RequestReviewLinkProcessorListenerImpl get() {
        return newInstance();
    }
}
