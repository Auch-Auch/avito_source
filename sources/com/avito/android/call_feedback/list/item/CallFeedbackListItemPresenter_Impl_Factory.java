package com.avito.android.call_feedback.list.item;

import com.avito.android.call_feedback.list.item.CallFeedbackListItemPresenter;
import com.jakewharton.rxrelay2.Relay;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CallFeedbackListItemPresenter_Impl_Factory implements Factory<CallFeedbackListItemPresenter.Impl> {
    public final Provider<Relay<String>> a;

    public CallFeedbackListItemPresenter_Impl_Factory(Provider<Relay<String>> provider) {
        this.a = provider;
    }

    public static CallFeedbackListItemPresenter_Impl_Factory create(Provider<Relay<String>> provider) {
        return new CallFeedbackListItemPresenter_Impl_Factory(provider);
    }

    public static CallFeedbackListItemPresenter.Impl newInstance(Relay<String> relay) {
        return new CallFeedbackListItemPresenter.Impl(relay);
    }

    @Override // javax.inject.Provider
    public CallFeedbackListItemPresenter.Impl get() {
        return newInstance(this.a.get());
    }
}
