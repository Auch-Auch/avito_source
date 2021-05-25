package com.avito.android.call_feedback.list.title;

import com.avito.android.call_feedback.list.title.CallFeedbackListTitlePresenter;
import dagger.internal.Factory;
public final class CallFeedbackListTitlePresenter_Impl_Factory implements Factory<CallFeedbackListTitlePresenter.Impl> {

    public static final class a {
        public static final CallFeedbackListTitlePresenter_Impl_Factory a = new CallFeedbackListTitlePresenter_Impl_Factory();
    }

    public static CallFeedbackListTitlePresenter_Impl_Factory create() {
        return a.a;
    }

    public static CallFeedbackListTitlePresenter.Impl newInstance() {
        return new CallFeedbackListTitlePresenter.Impl();
    }

    @Override // javax.inject.Provider
    public CallFeedbackListTitlePresenter.Impl get() {
        return newInstance();
    }
}
