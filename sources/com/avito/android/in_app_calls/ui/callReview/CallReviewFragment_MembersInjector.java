package com.avito.android.in_app_calls.ui.callReview;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class CallReviewFragment_MembersInjector implements MembersInjector<CallReviewFragment> {
    public final Provider<CallReviewPresenter> a;

    public CallReviewFragment_MembersInjector(Provider<CallReviewPresenter> provider) {
        this.a = provider;
    }

    public static MembersInjector<CallReviewFragment> create(Provider<CallReviewPresenter> provider) {
        return new CallReviewFragment_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.in_app_calls.ui.callReview.CallReviewFragment.presenter")
    public static void injectPresenter(CallReviewFragment callReviewFragment, CallReviewPresenter callReviewPresenter) {
        callReviewFragment.presenter = callReviewPresenter;
    }

    public void injectMembers(CallReviewFragment callReviewFragment) {
        injectPresenter(callReviewFragment, this.a.get());
    }
}
