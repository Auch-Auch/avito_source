package com.avito.android.call_feedback.list.item;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class CallFeedbackListItemBlueprint_Factory implements Factory<CallFeedbackListItemBlueprint> {
    public final Provider<CallFeedbackListItemPresenter> a;

    public CallFeedbackListItemBlueprint_Factory(Provider<CallFeedbackListItemPresenter> provider) {
        this.a = provider;
    }

    public static CallFeedbackListItemBlueprint_Factory create(Provider<CallFeedbackListItemPresenter> provider) {
        return new CallFeedbackListItemBlueprint_Factory(provider);
    }

    public static CallFeedbackListItemBlueprint newInstance(CallFeedbackListItemPresenter callFeedbackListItemPresenter) {
        return new CallFeedbackListItemBlueprint(callFeedbackListItemPresenter);
    }

    @Override // javax.inject.Provider
    public CallFeedbackListItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
