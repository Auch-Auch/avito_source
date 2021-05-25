package com.avito.android.call_feedback.list.title;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class CallFeedbackListTitleBlueprint_Factory implements Factory<CallFeedbackListTitleBlueprint> {
    public final Provider<CallFeedbackListTitlePresenter> a;

    public CallFeedbackListTitleBlueprint_Factory(Provider<CallFeedbackListTitlePresenter> provider) {
        this.a = provider;
    }

    public static CallFeedbackListTitleBlueprint_Factory create(Provider<CallFeedbackListTitlePresenter> provider) {
        return new CallFeedbackListTitleBlueprint_Factory(provider);
    }

    public static CallFeedbackListTitleBlueprint newInstance(CallFeedbackListTitlePresenter callFeedbackListTitlePresenter) {
        return new CallFeedbackListTitleBlueprint(callFeedbackListTitlePresenter);
    }

    @Override // javax.inject.Provider
    public CallFeedbackListTitleBlueprint get() {
        return newInstance(this.a.get());
    }
}
