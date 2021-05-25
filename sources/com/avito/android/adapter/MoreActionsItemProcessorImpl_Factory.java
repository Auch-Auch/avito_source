package com.avito.android.adapter;

import com.avito.android.advert.actions.HiddenAdvertsInteractor;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MoreActionsItemProcessorImpl_Factory implements Factory<MoreActionsItemProcessorImpl> {
    public final Provider<HiddenAdvertsInteractor> a;

    public MoreActionsItemProcessorImpl_Factory(Provider<HiddenAdvertsInteractor> provider) {
        this.a = provider;
    }

    public static MoreActionsItemProcessorImpl_Factory create(Provider<HiddenAdvertsInteractor> provider) {
        return new MoreActionsItemProcessorImpl_Factory(provider);
    }

    public static MoreActionsItemProcessorImpl newInstance(HiddenAdvertsInteractor hiddenAdvertsInteractor) {
        return new MoreActionsItemProcessorImpl(hiddenAdvertsInteractor);
    }

    @Override // javax.inject.Provider
    public MoreActionsItemProcessorImpl get() {
        return newInstance(this.a.get());
    }
}
