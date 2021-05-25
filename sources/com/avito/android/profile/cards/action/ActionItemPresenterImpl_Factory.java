package com.avito.android.profile.cards.action;

import com.avito.android.deep_linking.links.DeepLink;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ActionItemPresenterImpl_Factory implements Factory<ActionItemPresenterImpl> {
    public final Provider<PublishRelay<DeepLink>> a;

    public ActionItemPresenterImpl_Factory(Provider<PublishRelay<DeepLink>> provider) {
        this.a = provider;
    }

    public static ActionItemPresenterImpl_Factory create(Provider<PublishRelay<DeepLink>> provider) {
        return new ActionItemPresenterImpl_Factory(provider);
    }

    public static ActionItemPresenterImpl newInstance(PublishRelay<DeepLink> publishRelay) {
        return new ActionItemPresenterImpl(publishRelay);
    }

    @Override // javax.inject.Provider
    public ActionItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
